package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class categorieprocess_jsp extends org.apache.jasper.runtime.HttpJspBase
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
String caname = request.getParameter("caname") ;
String cadetail = request.getParameter("cadetail") ;
String tabel = "categorie";
String redirectPage = tabel + ".jsp";


//jika name, address, company dan email tidak (“”) maka
if((!caname.equals("")) & (!cadetail.equals("")) ){
    if(tokobuku.categorie()){
        message = "Kategori " + caname + " berhasilkan ditambahkan ";
        
        
      out.write("\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            var alertMessage = \"");
      out.print( message );
      out.write("\"; //menaruh pesan\n");
      out.write("            alert(alertMessage); // menampilkan di alert\n");
      out.write("            window.location.href = \"");
      out.print( redirectPage );
      out.write("\"; // Ganti dengan halaman tujuan yang sesuai\n");
      out.write("        </script>\n");
      out.write("        ");
 
        
    }else{
        message = "Error" ;
    }

}else{
 message="Field tidak boleh kosong";
}
//lakukan insert data ke database
//jika berhasil message = "Thank you " + name + " for Registering ";
//jika tidak set message = "Error" ;

      out.write('\n');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "nav/header.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("<div class=\"konten\" >\n");
      out.write("    \n");
      out.write("    <h2>");
      out.print(message);
      out.write("</h2>\n");
      out.write("    \n");
      out.write("</div>\n");
      out.write("    \n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "nav/footer.jsp", out, false);
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
