<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge"/>
    <title>韩顺平教育-家居网购</title>
    <!-- 移动端适配 -->
    <base href="<%=request.getContextPath() + "/"%>">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <link rel="stylesheet" href="assets/css/vendor/vendor.min.css"/>
    <link rel="stylesheet" href="assets/css/plugins/plugins.min.css"/>
    <link rel="stylesheet" href="assets/css/style.min.css">
    <script type="text/javascript" src="script/jquery-3.6.0.min.js"></script>
    <script type="text/javascript">

        $(function () {
            $("#sub-btn").click(function () {

                //获取到到输入的用户名 => 自己看前端给的页面
                var nameVal = $("#name").val();
                // alert("usernameVal=" + usernameVal)

                //编写正则表达式来进行验证.
                var namePattern = /[\u4e00-\u9fa5]*/;
                //验证
                if (!namePattern.test(nameVal)) {
                    //展示错误提示, jquery属性过滤器
                    $("span[class='errorMsg']").text("家居名字格式不正确");
                    return false;//不提交 , 返回false
                }

                //一关一个关的通过验证
                //制造商
                var makerVal = $("#maker").val();
                var makerValPattern = /^[\u4e00-\u9fa5]{1,10}$/;
                if (!makerValPattern.test(makerVal)) {
                    //展示密码错误提示-基本过滤器, 希望小伙伴感到知识不是每个都是新
                    //信心-》潜意识我学过.
                    $("span.errorMsg").text("商家格式不对");
                    return false;
                }

                //价格
                var priceVal = $("#price").val();
                var priceValPattern = /[1-9]\d*.\d*|0.\d*[1-9]\d*/;
                if (!priceValPattern.test(priceVal)) {
                    //展示密码错误提示-基本过滤器, 希望小伙伴感到知识不是每个都是新
                    //信心-》潜意识我学过.
                    $("span.errorMsg").text("价格格式不对");
                    return false;
                }

                //销售数量
                var salesVal = $("#sales").val();
                var salesPattern = /[1-9]\d*/
               if (!salesPattern.test(salesVal)){
                   $("span.errorMsg").text("销售数量不对");
                   return false;
               }

                //库存
                var stockVal = $("#stock").val();
                //老师说明 在java中，正则表达式的转义是\\, 在js 正则表达式 转义是\
                //如果你看不懂，回看java正则表达式
                var stockPattern = /[1-9]\d*/ //偷懒->java
                if (!stockPattern.test(stockVal)){
                    $("span.errorMsg").text("库存数量不对");
                    return false;
                }

                //到这里就全部过关. => 我们暂时不提交，显示验证通过信息
                $("span.errorMsg").text("验证通过...");
                //目前我们写了后台，当验证通过时，就提交给后台
                return true;
            })
        })

    </script>
</head>

<body>
<!-- Header Area start  -->
<div class="header section">
    <!-- Header Top  End -->
    <!-- Header Bottom  Start -->
    <div class="header-bottom d-none d-lg-block">
        <div class="container position-relative">
            <div class="row align-self-center">
                <!-- Header Logo Start -->
                <div class="col-auto align-self-center">
                    <div class="header-logo">
                        <a href="index.html"><img src="assets/images/logo/logo.png" alt="Site Logo"/></a>
                    </div>
                </div>
                <!-- Header Logo End -->

                <!-- Header Action Start -->
                <div class="col align-self-center">
                    <div class="header-actions">

                        <!-- Single Wedge Start -->
                        <div class="header-bottom-set dropdown">
                            <a href="#">家居管理</a>
                        </div>
                        <div class="header-bottom-set dropdown">
                            <a href="#">订单管理</a>
                        </div>
                    </div>
                </div>
                <!-- Header Action End -->
            </div>
        </div>
    </div>
    <!-- Header Bottom  End -->
    <!-- Header Bottom  Start 手机端的header -->
    <div class="header-bottom d-lg-none sticky-nav bg-white">
        <div class="container position-relative">
            <div class="row align-self-center">
                <!-- Header Logo Start -->
                <div class="col-auto align-self-center">
                    <div class="header-logo">
                        <a href="index.html"><img width="280px" src="assets/images/logo/logo.png" alt="Site Logo"/></a>
                    </div>
                </div>
                <!-- Header Logo End -->
            </div>
        </div>
    </div>
    <!-- Main Menu Start -->
    <div style="width: 100%;height: 50px;background-color: black"></div>
    <!-- Main Menu End -->
</div>
<!-- Cart Area Start -->
<div class="cart-main-area pt-100px pb-100px">
    <div class="container">
        <h3 class="cart-page-title">家居后台管理-添加家居</h3>
        <%--显示错误信息--%>
        ${requestScope.msg}
        <div class="row">
            <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                <span class="errorMsg"
                      style="float: right; font-weight: bold; font-size: 20pt; margin-left: 10px;"></span>
                <form action="manage/FurnServlet" method="post">
                    <input type="hidden" name="action" value="add">
                    <input type="hidden" name="pageNo" value="${param.pageNo}" />
                    <div class="table-content table-responsive cart-table-content">
                        <table>
                            <thead>
                            <tr>
                                <th>图片</th>
                                <th>家居名</th>
                                <th>商家</th>
                                <th>价格</th>
                                <th>销量</th>
                                <th>库存</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td class="product-thumbnail">
                                    <a href="#"><img class="img-responsive ml-3"
                                                     src="assets/images/product-image/default.jpg"
                                                     alt=""/></a>
                                </td>
                                <td class="product-name"><input name="name" style="width: 60%" type="text"
                                                                id="name" placeholder="家居名"   /></td>
                                <td class="product-name"><input name="maker" style="width: 90%" type="text" id ="maker"
                                                                placeholder="制造商"  /></td>
                                <td class="product-price-cart"><input name="price" style="width: 90%" type="text" id ="price"
                                                                      placeholder="价格"/></td>
                                <td class="product-quantity">
                                    <input name="sales" style="width: 90%" type="text" placeholder="价格" id ="sales"/>
                                </td>
                                <td class="product-quantity">
                                    <input name="stock" style="width: 90%" type="text" placeholder="库存" id="stock"/>
                                </td>
                                <td>
                                    <!--                                    <a href="#"><i class="icon-pencil"></i></a>-->
                                    <!--                                    <a href="#"><i class="icon-close"></i></a>-->
                                    <input type="submit"
                                           style="width: 90%;background-color: silver;border: silver;border-radius: 20%;"
                                           id ="sub-btn" value="添加家居"/>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<!-- Cart Area End -->

<!-- Footer Area Start -->
<div class="footer-area">
    <div class="footer-container">
        <div class="footer-top">
            <div class="container">
                <div class="row">
                    <!-- Start single blog -->
                    <!-- End single blog -->
                    <!-- Start single blog -->
                    <div class="col-md-6 col-sm-6 col-lg-3 mb-md-30px mb-lm-30px" data-aos="fade-up"
                         data-aos-delay="400">
                        <div class="single-wedge">
                            <h4 class="footer-herading">信息</h4>
                            <div class="footer-links">
                                <div class="footer-row">
                                    <ul class="align-items-center">
                                        <li class="li"><a class="single-link" href="about.html">关于我们</a></li>
                                        <li class="li"><a class="single-link" href="#">交货信息</a></li>
                                        <li class="li"><a class="single-link" href="privacy-policy.html">隐私与政策</a></li>
                                        <li class="li"><a class="single-link" href="#">条款和条件</a></li>
                                        <li class="li"><a class="single-link" href="#">制造</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- End single blog -->
                    <!-- Start single blog -->
                    <div class="col-md-6 col-lg-2 col-sm-6 mb-lm-30px" data-aos="fade-up" data-aos-delay="600">
                        <div class="single-wedge">
                            <h4 class="footer-herading">我的账号</h4>
                            <div class="footer-links">
                                <div class="footer-row">
                                    <ul class="align-items-center">
                                        <li class="li"><a class="single-link" href="my-account.html">我的账号</a>
                                        </li>
                                        <li class="li"><a class="single-link" href="cart.html">我的购物车</a></li>
                                        <li class="li"><a class="single-link" href="login.html">登录</a></li>
                                        <li class="li"><a class="single-link" href="wishlist.html">感兴趣的</a></li>
                                        <li class="li"><a class="single-link" href="checkout.html">结账</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- End single blog -->
                    <!-- Start single blog -->
                    <div class="col-md-6 col-lg-3" data-aos="fade-up" data-aos-delay="800">

                    </div>
                    <!-- End single blog -->
                </div>
            </div>
        </div>
        <div class="footer-bottom">
            <div class="container">
                <div class="row flex-sm-row-reverse">
                    <div class="col-md-6 text-right">
                        <div class="payment-link">
                            <img src="#" alt="">
                        </div>
                    </div>
                    <div class="col-md-6 text-left">
                        <p class="copy-text">Copyright &copy; 2021 韩顺平教育~</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Footer Area End -->
<script src="assets/js/vendor/vendor.min.js"></script>
<script src="assets/js/plugins/plugins.min.js"></script>
<!-- Main Js -->
<script src="assets/js/main.js"></script>
</body>
</html>