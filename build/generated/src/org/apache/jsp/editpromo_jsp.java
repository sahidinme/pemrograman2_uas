package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class editpromo_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\n');
      tokobuku.tokobuku tokobuku = null;
      synchronized (_jspx_page_context) {
        tokobuku = (tokobuku.tokobuku) _jspx_page_context.getAttribute("tokobuku", PageContext.PAGE_SCOPE);
        if (tokobuku == null){
          tokobuku = new tokobuku.tokobuku();
          _jspx_page_context.setAttribute("tokobuku", tokobuku, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.introspect(_jspx_page_context.findAttribute("tokobuku"), request);
      out.write('\n');
      out.write('\n');

String message = "";
String id = request.getParameter("id") ;
String product = request.getParameter("productid") ;
//jika name, address, company dan email tidak (“”) maka
if(!id.equals("")){
 message="data ditemukan";
}else{
 message="data tidak ditemukan";
}
//lakukan insert data ke database
//jika berhasil message = "Thank you " + name + " for Registering "
;
//jika tidak set message = "Error" ;

      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write(" <meta http-equiv=\"Content-Type\" content=\"text/html;\n");
      out.write(" charset=UTF-8\">\n");
      out.write(" <title>GuestBook</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write(" <h1>Guest Book</h1>\n");
      out.write(" \n");
      out.write(" <form name=\"login\" action=\"edit.jsp\" method=\"post\">\n");
      out.write("    <input type=\"hidden\" name=\"id\" value=\"");
      out.print(id);
      out.write("\">\n");
      out.write("    <input type=\"hidden\" name=\"tabel\" value=\"promotion\">\n");
      out.write("    <table width=\"200\" border=\"1\">\n");
      out.write("    <tr>\n");
      out.write("    <td>Categorie Name</td>\n");
      out.write("    <td><input type=\"text\" name=\"idpromo\" value=\"");
      out.print(product);
      out.write("\"></td>\n");
      out.write("    </tr>\n");
      out.write("    \n");
      out.write("    <tr>\n");
      out.write("    <td colspan=\"2\"><input type=\"submit\" name=\"Submit\" value=\"Submit\"></td>\n");
      out.write("    </tr>\n");
      out.write("    </table>\n");
      out.write("    \n");
      out.write("</form>    \n");
      out.write(" \n");
      out.write(" \n");
      out.write("\n");
      out.write(" <h2><a href=\"categorie.jsp\"> List Categorie </a></h2>\n");
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
