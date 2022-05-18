package com.hspedu.furns.web; /**
 * @author 金宗文
 * @version 1.0
 */

import com.google.gson.Gson;
import com.hspedu.furns.entity.Cart;
import com.hspedu.furns.entity.CartItem;
import com.hspedu.furns.entity.Furn;
import com.hspedu.furns.service.FurnService;
import com.hspedu.furns.service.impl.FurnServiceImpl;
import com.hspedu.furns.utils.DataUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "CartServlet", value = "/CartServlet")
public class CartServlet extends BasicServlet {
    private FurnService furnService = new FurnServiceImpl();
    //增加一个添加购物车的方法
    public void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        //先得到添加商品的id
        int id = DataUtils.parseInt(req.getParameter("id"), 0);
        req.setAttribute("id", id);
        //获取id对应的Furn对象
        Furn furn = furnService.queryFurnById(id);
        //判断是否为空
        if (furn==null || furn.getStock() == 0) {
            resp.sendRedirect(req.getHeader("Referer"));
            return;
        }
        //先走完正常逻辑
        //根据Furn 构建cartItem
        CartItem item = new CartItem(furn.getId(), furn.getName(), 1, furn.getPrice(), furn.getPrice());
        //从session 获取对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");

        if(null == cart){//当前session没有cart
            cart = new Cart();//创建一个cart对象
            req.getSession().setAttribute("cart",cart);
        }
        cart.addItem(item);

        //添加完毕后需要返回到添加家居的页面
        resp.sendRedirect(req.getHeader("Referer"));
    }

    public void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //1.先得到cart对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        //2.通过前端传入id
        int cartItemId = DataUtils.parseInt(req.getParameter("id"), 0);
        //4.删除
        if (cart != null) {
            cart.delItem(cartItemId);
        }
        //5.转发回购物车页面
        resp.sendRedirect(req.getHeader("Referer"));
    }

    public void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        cart.clear();
        resp.sendRedirect(req.getHeader("Referer"));
    }

    public void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        //得到前端传入的数量
        int newCount = DataUtils.parseInt(req.getParameter("count"), 1);
        //得到前端传入的id
        int id = DataUtils.parseInt(req.getParameter("id"), 0);
        //更新数量和价格
        if (null != cart) {
            cart.updateCount(id, newCount);
        }
        //返回购物车页面
        resp.sendRedirect(req.getHeader("Referer"));
    }


    public void addItemByAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //先得到添加商品的id
        int id = DataUtils.parseInt(req.getParameter("id"), 0);
        req.setAttribute("id", id);
        //获取id对应的Furn对象
        Furn furn = furnService.queryFurnById(id);
        //判断是否为空
        if (furn==null || furn.getStock() == 0) {
            resp.sendRedirect(req.getHeader("Referer"));
            return;
        }
        //先走完正常逻辑
        //根据Furn 构建cartItem
        CartItem item = new CartItem(furn.getId(), furn.getName(), 1, furn.getPrice(), furn.getPrice());
        //从session 获取对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");

        if(null == cart){//当前session没有cart
            cart = new Cart();//创建一个cart对象
            req.getSession().setAttribute("cart",cart);
        }
        cart.addItem(item);

        //添加完毕后返回json数据 给前端
        //前端得到json数据后 进行局部刷新
        //规定 json格式
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("cartTotalCount",cart.getTotalCount());

        //转为json
        Gson gson = new Gson();
        String resultJson = gson.toJson(resultMap);
        //返回
        resp.getWriter().write(resultJson);

    }

}
