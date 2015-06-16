package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.RequestDispatcher;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    String AccountOverviewHtml = "";
    if(request.getAttribute("AccountOverviewHtml")!=null){
        AccountOverviewHtml = request.getAttribute("AccountOverviewHtml").toString();
    }else{
        RequestDispatcher dispatcher = getServletContext().
              getRequestDispatcher("/IndexServlet");
        dispatcher.forward(request, response);  
    }

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n");
      out.write("<link rel=\"stylesheet\" href=\"images/default.css\" type=\"text/css\" />\n");
      out.write("\n");
      out.write("<title>");
      out.print( Globals.SiteGlobal.siteName );
      out.write("</title>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("    <div class=\"mainBox\">\n");
      out.write("    \n");
      out.write("        <div class=\"divLoginBox\">");
      out.print( Globals.SiteGlobal.getHeaderLoginStr(session) );
      out.write("</div>\n");
      out.write("    \t<div class=\"header\">\n");
      out.write("            <img src=\"images/logo.png\" height=\"40\" style=\"position:absolute; top:0; left:0;\">\n");
      out.write("            <h1 style=\"display:inline-block; margin:0 0 0 50px\">Money Bucket!</h1>\n");
      out.write("        </div>\n");
      out.write("        <div>\n");
      out.write("            ");
      out.print( Globals.SiteGlobal.headNav );
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"mainBox\">\n");
      out.write("    \t<h2>Account Overview</h2>\n");
      out.write("        <ul class=\"mainUl\">\n");
      out.write("            ");
      out.print( AccountOverviewHtml );
      out.write("\n");
      out.write("        </ul>\n");
      out.write("    </div>\n");
      out.write("    \n");
      out.write("    <div class=\"mainBox\">\n");
      out.write("    \t<div class=\"footer\">Money Bucket @ Eric Shang</div>\n");
      out.write("    </div>\n");
      out.write("    </body>\n");
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
