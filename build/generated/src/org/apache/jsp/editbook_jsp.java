package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class editbook_jsp extends org.apache.jasper.runtime.HttpJspBase
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

String namebook = request.getParameter("namebook") ;
String autorbook = request.getParameter("autorbook") ;
String desbook = request.getParameter("desbook") ;
String pricebook = request.getParameter("pricebook") ;
String catebook = request.getParameter("catebook") ;
String imgbook = request.getParameter("imgbook") ;
String kat = request.getParameter("kat") ;

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

      out.write('\n');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "nav/header.jsp", out, false);
      out.write("    \n");
      out.write("    <div class=\"konten\">    \n");
      out.write("        <h1>Tambah buku</h1>\n");
      out.write("        <form name=\"login\" action=\"edit.jsp\" method=\"post\">\n");
      out.write("            <input type=\"hidden\" name=\"id\" value=\"");
      out.print(id);
      out.write("\">\n");
      out.write("            <input type=\"hidden\" name=\"tabel\" value=\"book\">\n");
      out.write("            <input type=\"hidden\" name=\"catebook\" value=\"");
      out.print(catebook);
      out.write("\">\n");
      out.write("            \n");
      out.write("            <label for=\"fname\">Book name</label>\n");
      out.write("            <input type=\"text\" name=\"namebook\" value=\"");
      out.print(namebook);
      out.write("\">\n");
      out.write("\n");
      out.write("            <label for=\"lname\">Autor name</label>\n");
      out.write("            <input type=\"text\" name=\"autorbook\"value=\"");
      out.print(autorbook);
      out.write("\">\n");
      out.write("\n");
      out.write("            <label for=\"lname\">Description</label>\n");
      out.write("            <input type=\"text\" name=\"desbook\" value=\"");
      out.print(desbook);
      out.write("\">\n");
      out.write("\n");
      out.write("            <label for=\"lname\">Description</label>\n");
      out.write("             <input type=\"text\" name=\"pricebook\" value=\"");
      out.print(pricebook);
      out.write("\">\n");
      out.write("            \n");
      out.write("           \n");
      out.write("            <label for=\"lname\">Categorie</label>\n");
      out.write("            <input type=\"text\" name=\"\" value=\"");
      out.print(kat);
      out.write("\" readonly>\n");
      out.write("            \n");
      out.write("            \n");
      out.write("\n");
      out.write("            <label for=\"lname\">Image</label>\n");
      out.write("            <input type=\"text\" name=\"imgbook\" value=\"");
      out.print(imgbook);
      out.write("\">\n");
      out.write("\n");
      out.write("            <input type=\"submit\" value=\"Submit\" name=\"Submit\">\n");
      out.write("        </form>\n");
      out.write("    </div>    \n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "nav/footer.jsp", out, false);
      out.write("   ");
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
