package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"utf-8\">\r\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("        <title>Home</title>\r\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css?family=Nunito+Sans:700%7CNunito:300,600\" rel=\"stylesheet\"> \r\n");
      out.write("\r\n");
      out.write("        <!-- Bootstrap -->\r\n");
      out.write("        <link type=\"text/css\" rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/page/css/bootstrap.min.css\"/>\r\n");
      out.write("\r\n");
      out.write("        <!-- Font Awesome Icon -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/page/css/font-awesome.min.css\">\r\n");
      out.write("\r\n");
      out.write("        <!-- Custom stlylesheet -->\r\n");
      out.write("        <link type=\"text/css\" rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/page/css/style.css\"/>\r\n");
      out.write("\r\n");
      out.write("    <c:set var=\"root\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/>\r\n");
      out.write("    <link href=\"../css/mos-style.css\" rel='stylesheet' type='text/css' />\r\n");
      out.write("    <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/admin/css/login.css\" rel='stylesheet' type='text/css' />\r\n");
      out.write("</head>\r\n");
      out.write("<body id=\"LoginForm\">\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <h1 class=\"form-heading\">login Form</h1>\r\n");
      out.write("        <div class=\"login-form\">\r\n");
      out.write("            <div class=\"main-div\">\r\n");
      out.write("                <div class=\"panel\">\r\n");
      out.write("                    <h2>Admin Login</h2>\r\n");
      out.write("                    <p>Please enter your username and password</p>\r\n");
      out.write("                </div>\r\n");
      out.write("                <form id=\"Login\" method=\"POST\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/AdminLoginServlet\">\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"form-group\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                        <input name=\"username\" type=\"text\" class=\"form-control\" id=\"inputEmail\" placeholder=\"Username\">\r\n");
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"form-group\">\r\n");
      out.write("\r\n");
      out.write("                        <input name=\"password\" type=\"password\" class=\"form-control\" id=\"inputPassword\" placeholder=\"Password\">\r\n");
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("                    ");

                        Object error = request.getAttribute("errorMessage");
                        if (error != null) {
                    
      out.write("\r\n");
      out.write("                    <div style=\"color:Tomato;\">\r\n");
      out.write("                        ");
      out.print(error);
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("                    ");
 }
      out.write("\r\n");
      out.write("                    <button type=\"submit\" class=\"btn btn-primary\">Login</button>\r\n");
      out.write("\r\n");
      out.write("                </form>\r\n");
      out.write("            </div>\r\n");
      out.write("            <p class=\"botto-text\"> </p>\r\n");
      out.write("        </div></div></div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("<!--<body>\r\n");
      out.write("\r\n");
      out.write("    <div id=\"header\">\r\n");
      out.write("        <div class=\"inHeaderLogin\"></div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <div id=\"loginForm\">\r\n");
      out.write("        <div class=\"headLoginForm\">\r\n");
      out.write("            Login Administrator\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"fieldLogin\">\r\n");
      out.write("            <form method=\"POST\" action=\"../AdminLoginServlet\">\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <div class=\"col-25\"><label for=\"fname\">Username</label></div>\r\n");
      out.write("                    <div class=\"col-75\"><input type=\"text\" name=\"username\" ></div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <div class=\"col-25\"><label for=\"fname\">Password</label></div>\r\n");
      out.write("                    <div class=\"col-75\"><input type=\"text\" name=\"password\"  ></div>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("<input type=\"submit\" class=\"button\" value=\"Login\">\r\n");
      out.write("</form>\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("--></html>\r\n");
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
