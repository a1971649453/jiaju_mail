package com.hspedu.furns.web; /**
 * @author 金宗文
 * @version 1.0
 */

import com.hspedu.furns.entity.Furn;
import com.hspedu.furns.service.AdminService;
import com.hspedu.furns.service.FurnService;
import com.hspedu.furns.service.impl.AdminServiceImpl;
import com.hspedu.furns.service.impl.FurnServiceImpl;
import com.hspedu.furns.utils.DataUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.List;

@WebServlet(name = "FurnServlet", value = "/manage/FurnServlet")
public class FurnServlet extends BasicServlet {
    private FurnService furnService =new FurnServiceImpl();

    /**
     * 模板设计模式 + 反射 + 动态绑定
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Furn> furns = furnService.queryFurns();
        request.setAttribute("furns",furns);
       request.getRequestDispatcher("/views/manage/furn_manage.jsp").forward(request,response);
    }

    /**
     * 处理添加家居的请求
     * @param request
     * @param response
     */
    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取家居信息
//        BigDecimal price = new BigDecimal();
        request.setCharacterEncoding("utf-8");
//        String name = request.getParameter("name");
//        String maker = request.getParameter("maker");
//        String price = request.getParameter("price");
//        String sales = request.getParameter("sales");
//        String stock = request.getParameter("stock");

        //图片使用默认
//        String defaultImgPath = "assets/images/product-image/6.jpg";

//        //对获取到的数据进行正则校验
//        try {
//            int i = Integer.parseInt(sales);
//            int i1 = Integer.parseInt(price);
//
//        }catch (NumberFormatException e){
//            request.setAttribute("msg","销量数据格式不对");
//            //返回到furn_add.jsp
//            request.getRequestDispatcher("/views/manage/furn_add.jsp").forward(request,response);
//            return;
//        }

//        Furn furn = new Furn(null, name, maker, new BigDecimal(price), new Integer(sales), new Integer(stock), defaultImgPath);


        //使用第二种方式 完成将前端提交的数据 自动封装为一个JavaBean
//        Furn furn = new Furn();
//        try {
//            //将 request.getParameterMap 数据自动封装到furn
//            //使用反射进行封装 有一个前提为表单提交的数据需要和JavaBean的属性保持一致
//            BeanUtils.populate(furn,request.getParameterMap());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println(furn);

        //使用工具类 更简洁 将上述代码封装到方法 自动提交 自动封装
        Furn furn =
                DataUtils.copyParamToBean(request.getParameterMap(), new Furn());


//        furn.setImg_path(defaultImgPath);
        furnService.addFurn(furn);

        //解决重复添加问题 使用重定向 重定向本质是两次请求 最后一次请求是显示家居
        response.sendRedirect(request.getContextPath() + "/manage/FurnServlet?action=list");
////        也可以直接在这里try catch 如果出错就返回
//        //后面是SpringMvc 数据校验 注解解决
//        try {
//             furn = new Furn(null, name, maker, new BigDecimal(price), new Integer(sales), new Integer(stock), defaultImgPath);
//        }catch (NumberFormatException e){
//            request.setAttribute("msg","数据转换不对");
//            //返回到furn_add.jsp
//            request.getRequestDispatcher("/views/manage/furn_add.jsp").forward(request,response);
//            return;
//        }
//        furnService.addFurn(furn);
//
//        //解决重复添加问题 使用重定向 重定向本质是两次请求 最后一次请求是显示家居
//        response.sendRedirect(request.getContextPath() + "/manage/FurnServlet?action=list");
//    }
    }

    public void del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //1.得到furn对象的id
        int id = DataUtils.parseInt(request.getParameter("id"), 0);
//        System.out.println(id);
        //2.删除
        if (furnService.deleteFurnById(id) > 0){
            response.sendRedirect(request.getContextPath() + "/manage/FurnServlet?action=list");
        }else{
            //3.重定向到list
            request.setAttribute("msg","删除失败");
        }

    }
}
