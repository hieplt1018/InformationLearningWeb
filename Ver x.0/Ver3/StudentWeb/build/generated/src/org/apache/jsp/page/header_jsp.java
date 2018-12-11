package org.apache.jsp.page;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Student;

public final class header_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Header</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        ");

            Student student = null;
            if(session.getAttribute("student") != null) {
                student = (Student) session.getAttribute("student");
            }
        
      out.write("\r\n");
      out.write("        <header id=\"header\">\r\n");
      out.write("            <!-- Nav -->\r\n");
      out.write("            <div id=\"nav\">\r\n");
      out.write("                <!-- Main Nav -->\r\n");
      out.write("                <div id=\"nav-fixed\">\r\n");
      out.write("                    <div class=\"container\">\r\n");
      out.write("                        <!-- logo -->\r\n");
      out.write("                        <div class=\"nav-logo\">\r\n");
      out.write("                            <a href=\"index.jsp\" class=\"logo\"><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/page/img/logo.png\" alt=\"\"></a>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <!-- /logo -->\r\n");
      out.write("\r\n");
      out.write("                        <!-- nav -->\r\n");
      out.write("                        <ul class=\"nav-menu nav navbar-nav\">\r\n");
      out.write("                            <li><a href=\"category.html\">Tin tức</a></li>\r\n");
      out.write("                            <li class=\"cat-1\"><a href=\"page/mark.jsp\">Điểm</a></li>\r\n");
      out.write("                            <li class=\"cat-2\"><a href=\"category.html\">TKB</a></li>\r\n");
      out.write("                            <li class=\"cat-3\"><a href=\"category.html\">Thông tin cá nhân</a></li>\r\n");
      out.write("                            <li class=\"cat-4\"><a href=\"category.html\">Lịch thi</a></li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                        <!-- /nav -->\r\n");
      out.write("\r\n");
      out.write("                        <!-- search & aside toggle -->\r\n");
      out.write("                        <div class=\"nav-btns\">\r\n");
      out.write("                            ");
 if(student != null) { 
      out.write("\r\n");
      out.write("                            <script type=\"text/javascript\">\r\n");
      out.write("                                $(document).ready(function(){\r\n");
      out.write("                                    $('.login').remove();\r\n");
      out.write("                                });\r\n");
      out.write("                            </script>\r\n");
      out.write("                            <span>Welcome ");
      out.print(student.getLastName());
      out.write(' ');
      out.print(student.getFirstName());
      out.write("</span>\r\n");
      out.write("                            ");
 } else { 
      out.write("\r\n");
      out.write("                                <button class=\"primary-button login\" id=\"primary-button\"  onclick=\"location.href = 'login.jsp';\" > Đăng Nhập</button>\r\n");
      out.write("                            ");
 } 
      out.write("\r\n");
      out.write("                            \r\n");
      out.write("                            <button class=\"aside-btn\"><i class=\"fa fa-bars\"></i></button>\r\n");
      out.write("                            <button class=\"search-btn\"><i class=\"fa fa-search\"></i></button>\r\n");
      out.write("                            <div class=\"search-form\">\r\n");
      out.write("                                <input class=\"search-input\" type=\"text\" name=\"search\" placeholder=\"Enter Your Search ...\">\r\n");
      out.write("                                <button class=\"search-close\"><i class=\"fa fa-times\"></i></button>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <!-- /search & aside toggle -->\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <!-- /Main Nav -->\r\n");
      out.write("\r\n");
      out.write("                <!-- Aside Nav -->\r\n");
      out.write("                <div id=\"nav-aside\">\r\n");
      out.write("                    <!-- nav -->\r\n");
      out.write("                    <div class=\"section-row\">\r\n");
      out.write("                        <ul class=\"nav-aside-menu\">\r\n");
      out.write("                            <li><a href=\"./index.jsp\">Trang chủ</a></li>\r\n");
      out.write("                            <li><a href=\"#\">Tin tức</a></li>\r\n");
      out.write("                            <li><a href=\"#\">Thời khóa biểu</a></li>\r\n");
      out.write("                            <li><a href=\"mark.jsp\">Điểm</a></li>\r\n");
      out.write("                            <li><a href=\"#\">Lịch thi</a></li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <!-- /nav -->\r\n");
      out.write("\r\n");
      out.write("                    <!-- widget posts -->\r\n");
      out.write("                    <div class=\"section-row\">\r\n");
      out.write("                        <h3>Recent Posts</h3>\r\n");
      out.write("                        <div class=\"post post-widget\">\r\n");
      out.write("                            <a class=\"post-img\" href=\"blog-post.html\"><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/page/img/widget-2.jpg\" alt=\"\"></a>\r\n");
      out.write("                            <div class=\"post-body\">\r\n");
      out.write("                                <h3 class=\"post-title\"><a href=\"blog-post.html\">Pagedraw UI Builder Turns Your Website Design Mockup Into Code Automatically</a></h3>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"post post-widget\">\r\n");
      out.write("                            <a class=\"post-img\" href=\"blog-post.html\"><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/page/img/widget-3.jpg\" alt=\"\"></a>\r\n");
      out.write("                            <div class=\"post-body\">\r\n");
      out.write("                                <h3 class=\"post-title\"><a href=\"blog-post.html\">Why Node.js Is The Coolest Kid On The Backend Development Block!</a></h3>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"post post-widget\">\r\n");
      out.write("                            <a class=\"post-img\" href=\"blog-post.html\"><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/page/img/widget-4.jpg\" alt=\"\"></a>\r\n");
      out.write("                            <div class=\"post-body\">\r\n");
      out.write("                                <h3 class=\"post-title\"><a href=\"blog-post.html\">Tell-A-Tool: Guide To Web Design And Development Tools</a></h3>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <!-- /widget posts -->\r\n");
      out.write("\r\n");
      out.write("                    <!-- social links -->\r\n");
      out.write("                    <div class=\"section-row\">\r\n");
      out.write("                        <h3>Follow us</h3>\r\n");
      out.write("                        <ul class=\"nav-aside-social\">\r\n");
      out.write("                            <li><a href=\"#\"><i class=\"fa fa-facebook\"></i></a></li>\r\n");
      out.write("                            <li><a href=\"#\"><i class=\"fa fa-twitter\"></i></a></li>\r\n");
      out.write("                            <li><a href=\"#\"><i class=\"fa fa-google-plus\"></i></a></li>\r\n");
      out.write("                            <li><a href=\"#\"><i class=\"fa fa-pinterest\"></i></a></li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <!-- /social links -->\r\n");
      out.write("\r\n");
      out.write("                    <!-- aside nav close -->\r\n");
      out.write("                    <button class=\"nav-aside-close\"><i class=\"fa fa-times\"></i></button>\r\n");
      out.write("                    <!-- /aside nav close -->\r\n");
      out.write("                </div>\r\n");
      out.write("                <!-- Aside Nav -->\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- /Nav -->\r\n");
      out.write("        </header>\r\n");
      out.write("        <!-- /Header -->\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
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
