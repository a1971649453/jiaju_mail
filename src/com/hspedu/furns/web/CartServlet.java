package com.hspedu.furns.web; /**
 * @author 金宗文
 * @version 1.0
 */

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

@WebServlet(name = "CartServlet", value = "/CartServlet")
public class CartServlet extends BasicServlet {
    private FurnService furnService = new FurnServiceImpl();
    //增加一个添加购物车的方法
    public void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        //先得到添加商品的id
        int id = DataUtils.parseInt(req.getParameter("id"), 0);
        //获取id对应的Furn对象
        Furn furn = furnService.queryFurnById(id);
        //判断是否为空
        // TODO
//        if (furn==null) {
//            return;
//        }
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
        System.out.println("cart: "+ cart);

        //添加完毕后需要返回到添加家居的页面
        resp.sendRedirect(req.getHeader("Referer"));
    }
}
