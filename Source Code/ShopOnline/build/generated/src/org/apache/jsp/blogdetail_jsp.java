package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class blogdetail_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(3);
    _jspx_dependants.add("/topbar.jsp");
    _jspx_dependants.add("/header.jsp");
    _jspx_dependants.add("/footer.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <title>Shop Online</title>\n");
      out.write("    <!-- Site Icons -->\n");
      out.write("    <link rel=\"shortcut icon\" href=\"images/favicon.ico\" type=\"image/x-icon\">\n");
      out.write("    <link rel=\"apple-touch-icon\" href=\"images/apple-touch-icon.png\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/BlogStyle.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/responsive.css\">\n");
      out.write("    <script src=\"js/fontAwesome.js\"></script>\n");
      out.write("\n");
      out.write("    <!-- Bootstrap 5 -->\n");
      out.write("    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js\"></script>\n");
      out.write("    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor\" crossorigin=\"anonymous\">\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2\" crossorigin=\"anonymous\"></script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    ");
      out.write("\n");
      out.write("<div class=\"main-top\">\n");
      out.write("    <div class=\"container-fluid\">\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"text-center\">\n");
      out.write("                <div class=\"text-slid-box\">\n");
      out.write("                    <div id=\"myCarousel\" class=\"carousel slide\" data-bs-ride=\"carousel\">\n");
      out.write("                        <ul style=\"margin: 0;\" class=\"offer-box carousel-inner\">\n");
      out.write("                            <li class=\"carousel-item active\">\n");
      out.write("                                <i class=\"fab fa-opencart\"></i> Off 10%! Shop Now Man\n");
      out.write("                            </li>\n");
      out.write("                            <li class=\"carousel-item\">\n");
      out.write("                                <i class=\"fab fa-opencart\"></i> 50% - 80% off on Fashion\n");
      out.write("                            </li>\n");
      out.write("                            <li class=\"carousel-item\">\n");
      out.write("                                <i class=\"fab fa-opencart\"></i> 20% off Entire Purchase Promo code: offT20\n");
      out.write("                            </li>\n");
      out.write("                            <li class=\"carousel-item\">\n");
      out.write("                                <i class=\"fab fa-opencart\"></i> Off 50%! Shop Now\n");
      out.write("                            </li>\n");
      out.write("                            <li class=\"carousel-item\">\n");
      out.write("                                <i class=\"fab fa-opencart\"></i> Off 10%! Shop Now Man\n");
      out.write("                            </li>\n");
      out.write("                            <li class=\"carousel-item\">\n");
      out.write("                                <i class=\"fab fa-opencart\"></i> 50% - 80% off on Fashion\n");
      out.write("                            </li>\n");
      out.write("                            <li class=\"carousel-item\">\n");
      out.write("                                <i class=\"fab fa-opencart\"></i> 20% off Entire Purchase Promo code: offT20\n");
      out.write("                            </li>\n");
      out.write("                            <li class=\"carousel-item\">\n");
      out.write("                                <i class=\"fab fa-opencart\"></i> Off 50%! Shop Now\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("    ");
      out.write("\n");
      out.write("<div id=\"header\" class=\"bg-light\">\n");
      out.write("    <header>\n");
      out.write("        <!-- Start Navigation -->\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <nav class=\"navbar navbar-expand-lg navbar-light bootsnav\">\n");
      out.write("                <!-- Start Header Navigation -->\n");
      out.write("                <div class=\"navbar-header\">\n");
      out.write("                    <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbar-menu\" aria-controls=\"navbars-rs-food\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("                        <i class=\"fa fa-bars\"></i>\n");
      out.write("                    </button>\n");
      out.write("                    <a class=\"navbar-brand\" href=\"HomeController\"><img src=\"images/logo.png\" class=\"logo\" alt=\"\"></a>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"collapse navbar-collapse\" id=\"navbar-menu\">\n");
      out.write("                    <!-- Start Top Search -->\n");
      out.write("                    <form action=\"action\">\n");
      out.write("                        <div class=\"top-search\">\n");
      out.write("                            <div class=\"input-group\">\n");
      out.write("                                <span class=\"input-group-text\"><i class=\"fa fa-search\"></i></span>\n");
      out.write("                                <input type=\"search\" class=\"form-control\"  placeholder=\"Search...\">\n");
      out.write("                                <span class=\"input-group-text close-search\"><i class=\"fa fa-times\"></i></span>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </form>\n");
      out.write("                    <!-- End Top Search -->\n");
      out.write("                    <ul id=\"page-header\" class=\"nav navbar-nav ms-auto\">\n");
      out.write("                        <li class=\"nav-item active\"><a class=\"nav-link\" href=\"HomeController\">Home</a></li>\n");
      out.write("                        <li class=\"nav-item\"><a class=\"nav-link\" href=\"blog\">Blogs</a></li>                       \n");
      out.write("                        <li class=\"nav-item\"><a class=\"nav-link\" href=\"ProductController\">Product</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                <div class=\"account-header\">\n");
      out.write("                    <ul class=\"nav navbar-nav\">\n");
      out.write("                        <li class=\"search\">\n");
      out.write("                            <a href=\"#\"><i class=\"fa fa-search\"></i></a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"side-menu\">\n");
      out.write("                            <a href=\"CartController\">\n");
      out.write("                                <i class=\"fa fa-shopping-bag\"></i>\n");
      out.write("                            </a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"account\">\n");
      out.write("                            <a href=\"login\"><i class=\"fa fa-user\"></i></a>\n");
      out.write("                            <!-- <a href=\"profile.jsp\" style=\"border-left: 2px solid #d33b33;\"><i class=\"fa-solid fa-circle-user\"></i> VoAnh</a>\n");
      out.write("                            <a href=\"logout\" style=\"border-left: 2px solid #d33b33;\"><i class=\"fa-solid fa-power-off\"></i></a>\n");
      out.write("                            <a href=\"#\"><i class=\"fa-solid fa-clipboard-list fa-lg\"></i></a> -->\n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </nav>\n");
      out.write("        </div>\n");
      out.write("        <!-- End Navigation -->\n");
      out.write("    </header>\n");
      out.write("</div>\n");
      out.write("<script>\n");
      out.write("    const navMenu = document.getElementById(\"navbar-menu\"),\n");
      out.write("            searchBtn = document.querySelector(\".search\"),\n");
      out.write("            closeBtn = document.querySelector(\".close-search\"),\n");
      out.write("            headSpan = document.getElementById(\"page-header\"),\n");
      out.write("            searchSpan = document.querySelector(\".top-search\");\n");
      out.write("\n");
      out.write("    searchBtn.onclick = function () {\n");
      out.write("        navMenu.removeChild(headSpan);\n");
      out.write("        navMenu.appendChild(searchSpan);\n");
      out.write("        searchSpan.style.display = \"block\";\n");
      out.write("        searchBtn.style.display = \"none\";\n");
      out.write("    };\n");
      out.write("    closeBtn.onclick = function () {\n");
      out.write("        navMenu.appendChild(headSpan);\n");
      out.write("        navMenu.removeChild(searchSpan);\n");
      out.write("        searchBtn.style.display = \"block\";\n");
      out.write("    };\n");
      out.write("\n");
      out.write("    var prevScrollpos = window.pageYOffset;\n");
      out.write("\n");
      out.write("    window.onscroll = function () {\n");
      out.write("        var currentScrollPos = window.pageYOffset;\n");
      out.write("        if (currentScrollPos === 0) {\n");
      out.write("            document.getElementById(\"header\").style.top = \"37px\";\n");
      out.write("        } else if (prevScrollpos > currentScrollPos) {\n");
      out.write("            document.getElementById(\"header\").style.top = \"0px\";\n");
      out.write("        } else {\n");
      out.write("            document.getElementById(\"header\").style.top = \"-60px\";\n");
      out.write("        }\n");
      out.write("        prevScrollpos = currentScrollPos;\n");
      out.write("    };\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    <div class=\"div-content\">\n");
      out.write("        <img class=\"img-fluid\" src=\"https://anhdulichdep.com/wp-content/uploads/2019/01/chon-size-giay-1.jpg\">\n");
      out.write("        <div class=\"div-title\">\n");
      out.write("            <h2>Hướng dẫn chọn size giày và bảng quy đổi size giày</h2>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"main-content\">\n");
      out.write("            <h3 class=\"divider\"></h3>\n");
      out.write("            <h3 class=\"cont\">\n");
      out.write("                <div class=\"date-left\"><span class=\"date\">06.06.2021 |</span> admin</div>\n");
      out.write("                <div class=\"date-right\">\n");
      out.write("                    <a href=\"#\"><i class=\"fa-solid fa-heart\"></i> Like</a>\n");
      out.write("                </div>\n");
      out.write("            </h3>\n");
      out.write("            <h3 class=\"divider-1\"></h3>\n");
      out.write("\n");
      out.write("            <div class=\"detail-cont\">\n");
      out.write("                <div class=\"des\">\n");
      out.write("                    Bạn muốn mua một đôi giày nhưng lại không biết cách đo size giày sao cho chuẩn? Hãy cùng Vina giày tìm hiểu các bước đo zise giày và bảng quy chuẩn size giày theo Việt Nam, US và UK dưới đây nhé\n");
      out.write("                </div>\n");
      out.write("                <h3 class=\"divider-1\"></h3>\n");
      out.write("                <h3>Bước 1: Để bàn chân lên một mặt phẳng sáng màu rồi dùng thước dây cùng 1 chiếc thước kẻ để đo chiều dài, chiều rộng của bàn chân:</h3>\n");
      out.write("\n");
      out.write("                    + Chiều dài: Đo từ ngón chân dài nhất đến gót giày.\n");
      out.write("                    + Chiều rộng: Dùng thước dây để đo một vòng bàn chân. </br></br>\n");
      out.write("\n");
      out.write("                <h3>Bước 2: Ghi lại số đo chính xác gồm chiều dài, chiều rộng của bàn chân<h3>\n");
      out.write("\n");
      out.write("                <h3>Bước 3: Dùng số đo đó để đối chiếu với kích thước trong bảng size giày của Vina-Giầy để chọn đôi giày có size phù hợp.</h3>\n");
      out.write("\n");
      out.write("                Lưu ý:  - Thời gian tốt nhất để bạn đo cỡ giày của mình là vào lúc cuối ngày, khi đôi chân của bạn đã hoàn toàn được thư giãn. - Nếu có sai số giữa hai bàn chân, bạn hãy chọn đôi giày có cỡ bằng với chân lớn hơn của bạn. - Việc chọn đúng size là cực kỳ quan trọng. Một đôi giày phù hợp là một đôi giày ôm chân, không kích đầu mũi. Có thể để thừa đầu 0,5 cm.</br>\n");
      out.write("                </br>\n");
      out.write("                <i>Hãy chọn đúng size giày của mình để có thể trải nghiệm cảm giác tự tin thoải mái nhất với đôi giày mà mình yêu thích bạn nhé.</i>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <h3 class=\"divider-1\"></h3>\n");
      out.write("            <h3 class=\"cont\">\n");
      out.write("                <div class=\"date-left\"><span class=\"date\">06.06.2021 |</span> admin</div>\n");
      out.write("                <div class=\"date-right\">\n");
      out.write("                    <a href=\"#\"><i class=\"fa-solid fa-heart\"></i> Like</a>\n");
      out.write("                </div>\n");
      out.write("            </h3>\n");
      out.write("            <h3 class=\"divider\"></h3>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    <!-- other blogs -->\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"col-lg-12\">\n");
      out.write("                <div class=\"title-all text-center\">\n");
      out.write("                    <h2>BÀI VIẾT KHÁC</h2>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"row\">          \n");
      out.write("            <div class=\"col-md-6 col-lg-4 col-xl-4\">\n");
      out.write("                <div class=\"blog-box\">\n");
      out.write("                    <div class=\"blog-img\">\n");
      out.write("                        <img class=\"img-fluid\" src=\"https://hoc11.vn/wp-content/uploads/2020/12/1BIKIP.jpg\" alt=\"\">\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"blog-content\">\n");
      out.write("                        <div class=\"title-blog\">\n");
      out.write("                            <a href=\"blogdetail?id=1\" class=\"h3\"><b>Bí kíp săn deal 1đ, 1K</b></a>\n");
      out.write("                            <p>Như mình có nói ở phần trước: “Săn sale là một nghệ thuật, người săn sale là một nghệ sĩ”. Để thành nghệ sĩ săn sale thực thụ thì bạn cần nắm vững các bước để săn sale. Sau đó bạn phải luyện tập thật nhiều để nhanh hơn 99% người còn lại và dành chiến thắng trong cuộc chiến săn sale này.</p>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("            <div class=\"col-md-6 col-lg-4 col-xl-4\">\n");
      out.write("                <div class=\"blog-box\">\n");
      out.write("                    <div class=\"blog-img\">\n");
      out.write("                        <img class=\"img-fluid\" src=\"https://anhdulichdep.com/wp-content/uploads/2019/01/chon-size-giay-1.jpg\" alt=\"\">\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"blog-content\">\n");
      out.write("                        <div class=\"title-blog\">\n");
      out.write("                            <a href=\"blogdetail?id=2\" class=\"h3\"><b>Hướng dẫn chọn size giày và bảng quy đổi size giày</b></a>\n");
      out.write("                            <p>Bạn muốn mua một đôi giày nhưng lại không biết cách đo size giày sao cho chuẩn? Hãy cùng Vina giày tìm hiểu các bước đo zise giày và bảng quy chuẩn size giày theo Việt Nam, US và UK dưới đây nhé</p>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("            <div class=\"col-md-6 col-lg-4 col-xl-4\">\n");
      out.write("                <div class=\"blog-box\">\n");
      out.write("                    <div class=\"blog-img\">\n");
      out.write("                        <img class=\"img-fluid\" src=\"https://product.hstatic.net/1000243581/product/upload_6c157bb8acaa44db90d13b4bbaf9c09b_1024x1024.jpg\" alt=\"\">\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"blog-content\">\n");
      out.write("                        <div class=\"title-blog\">\n");
      out.write("                            <a href=\"blogdetail?id=3\" class=\"h3\"><b>Cập Nhật Ngay Top 2 Xu Hướng Giày Sneaker 2021</b></a>\n");
      out.write("                            <p>Bạn là có niềm yêu thích đối với sneaker? Bạn muốn cập nhật nhanh chóng xu hướng giày sneaker 2021 để đón đầu xu thế? Nhưng làm cách nào để cập nhật nhanh chóng thông tin khi có quá nhiều mẫu mã khác nhau trên thị trường. Đừng lo đã có OnlineShop giúp bạn giải quyết nổi lo rồi…</p>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>   \n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <!-- Start Footer  -->\n");
      out.write("    ");
      out.write("\n");
      out.write("<footer>\n");
      out.write("    <div class=\"footer-main\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-lg-4 col-md-12 col-sm-12\">\n");
      out.write("                    <div class=\"footer-widget\">\n");
      out.write("                        <h4>About ThewayShop</h4>\n");
      out.write("                        <p>TheWay shoes were born based on the shop owner's love of Nike shoes, Adidas shoes, Vans shoes... by the enchanting beauty of these trendy shoe models!\n");
      out.write("                        </p>\n");
      out.write("                        <ul>\n");
      out.write("                            <li><a href=\"https://www.facebook.com/bibeoauthentic97\"><i class=\"fa-brands fa-facebook-square\"></i></a></li>\n");
      out.write("                            <li><a href=\"https://www.instagram.com/bibeo.authentic/?fbclid=IwAR2o3TdF84Ha1U-idkHYnu1vte-pbUbaRrSsvjl3ClZBPLqk67Wb19-VZss\"><i class=\"fa-brands fa-instagram\"></i></a></li>\n");
      out.write("\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-lg-4 col-md-12 col-sm-12\">\n");
      out.write("                    <div class=\"footer-link\">\n");
      out.write("                        <h4>The Brand</h4>\n");
      out.write("                        <ul>\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"#\">Nike</a>\n");
      out.write("                            </li>\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"#\">Vans</a>\n");
      out.write("                            </li>\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"#\">Adidas</a>\n");
      out.write("                            </li>\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"#\">New Blance</a>\n");
      out.write("                            </li>                                \n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-lg-4 col-md-12 col-sm-12\">\n");
      out.write("                    <div class=\"footer-link-contact\">\n");
      out.write("                        <h4>Contact Us</h4>\n");
      out.write("                        <ul>\n");
      out.write("                            <li>\n");
      out.write("                                <p><i class=\"fas fa-map-marker-alt\"></i>103 phố Hồ Đắc Di , phường Nam Đồng, <br> quận Đống Đa Hanoi, Vietnam 100000</p>\n");
      out.write("                            </li>\n");
      out.write("                            <li>\n");
      out.write("                                <p><i class=\"fas fa-phone-square\"></i>Phone: <a href=\"tel:+091 978 55 48\">091 978 55 48</a></p>\n");
      out.write("                            </li>\n");
      out.write("                            <li>\n");
      out.write("                                <p><i class=\"fas fa-envelope\"></i>Email: <a href=\"mailto:bi1508.97@gmail.com\">bi1508.97@gmail.com</a></p>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</footer>\n");
      out.write("\n");
      out.write("<button id=\"back-to-top\" title=\"Go to top\"><i class=\"fa-solid fa-angles-up\"></i></button>\n");
      out.write("\n");
      out.write("<script src=\"js/tooltip.js\"></script>\n");
      out.write("<script src=\"js/scrollTop.js\"></script>\n");
      out.write("\n");
      out.write("    <!-- End Footer  -->\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
