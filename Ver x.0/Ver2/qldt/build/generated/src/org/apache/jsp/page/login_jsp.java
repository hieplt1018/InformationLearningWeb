package org.apache.jsp.page;

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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("\t<meta charset=\"UTF-8\">\n");
      out.write("\t<title>Login</title>\n");
      out.write("<!--\t<link rel=\"stylesheet\" href=\"./css/bootstrap.min.css\">-->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css\" integrity=\"sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M\" crossorigin=\"anonymous\">\n");
      out.write("\t<link rel=\"stylesheet\" href=\"./css/login.css\">\n");
      out.write("\t<script src=\"js/jquery.min.js\"></script>\n");
      out.write("\t<script src=\"js/popper.min.js\"></script>\n");
      out.write("\t<script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("</head>\n");
      out.write("<body class=\"text-center\">\n");
      out.write("\t<div class=\"container\">\n");
      out.write("\t\t<h1><a class=\"blog-header-logo text-dark\" href=\"index.html\">PTIT</a></h1>\n");
      out.write("                <form action=\"../LoginServlet\" class=\"form-signin\" method=\"post\">\n");
      out.write("\t\t\t<h1 class=\"h3 mb-3 font-weight-normal\">Đăng nhập</h1>\n");
      out.write("\t\t\t<label for=\"inputEmail\" class=\"sr-only\">Username</label>\n");
      out.write("                        <input type=\"text\" id=\"inputEmail\" name=\"username\" class=\"form-control\" placeholder=\"Username\" value=\"B15DCCN660\" required autofocus >\n");
      out.write("\t\t\t<label for=\"inputPassword\" class=\"sr-only\">Password</label>\n");
      out.write("                        <input type=\"password\" id=\"inputPassword\" class=\"form-control\" name=\"password\" placeholder=\"Password\" value=\"vuong19971015\" required>\n");
      out.write("\t\t\t<div class=\"checkbox mb-3\">\n");
      out.write("\t\t\t\t<label>\n");
      out.write("\t\t\t\t\t<input type=\"checkbox\" value=\"remember-me\"> Remember me\n");
      out.write("\t\t\t\t</label>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<button class=\"btn btn-lg btn-outline-primary btn-block return\" type=\"submit\">Đăng nhập</button>\n");
      out.write("\t\t\t<a href=\"index.html\" role=\"button\" class=\"btn btn-lg btn-outline-primary btn-block return\">Quay lại</a>\n");
      out.write("\t\t\t<p class=\"mt-5 mb-3\">&copy; 2017-2018</p>\n");
      out.write("\t\t</form>\n");
      out.write("\t</div>\n");
      out.write("</body>\n");
      out.write("</html>");
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
