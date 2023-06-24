package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class categorie_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

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


// Memeriksa apakah pengguna sudah login dengan memeriksa atribut session
    String loggedInUser = (String) session.getAttribute("username");
    if (loggedInUser == null) {
        // Jika pengguna belum login, arahkan kembali ke halaman login
        response.sendRedirect("login.jsp");
    }     
    
 int mulai=0, jumlah=10;
 Object[][] list= null;
 list=tokobuku.listCate(mulai,jumlah);

      out.write('\n');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "nav/header.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("<div class=\"konten\">\n");
      out.write("    \n");
      out.write("     <h1>Daftar kategori </h1>\n");
      out.write(" \n");
      out.write("     <a href=\"createcategorie.jsp\" id=\"tombol\">Tambahkan Kategori </a><br>\n");
      out.write(" \n");
      out.write(" <table id=\"tabel\">\n");
      out.write("\n");
      out.write("<tr>\n");
      out.write("    <th>No</th>\n");
      out.write("    <th>Categorie Name</th>\n");
      out.write("    <th>Categorie description</th>\n");
      out.write("    <th colspan=\"2\">Action</th>\n");
      out.write("</tr>\n");
      out.write(" ");

 if (list != null){
 for (int i=0; i<list.length; i++){
 int no=i+1;
 String id=list[i][0].toString();
 String nm=list[i][1].toString();
 String dsc=list[i][2].toString();


//out.print("<tr><td>"+no+"</td><td>"+listGuestBook[i][1].toString()+"</td><td>"+listGuestBook[i][2].toString()+"</td><td>"+listGuestBook[i][3].toString()+"</td><td>"+listGuestBook[i][4].toString()+"</td></tr>");
 
      out.write("\n");
      out.write(" <tr>\n");
      out.write(" <td> ");
      out.print(no);
      out.write("</td>\n");
      out.write(" <td> ");
      out.print(nm);
      out.write("</td>\n");
      out.write(" <td> ");
      out.print(dsc);
      out.write("</td>\n");
      out.write("\n");
      out.write(" <td><a href=\"editcategorie.jsp?id=");
      out.print(id);
      out.write("&name=");
      out.print(nm);
      out.write("&desc=");
      out.print(dsc);
      out.write("\" id=\"tombolkuning\">Edit</a></td>\n");
      out.write(" <td> <a href=\"delete.jsp?id=");
      out.print(id);
      out.write("&tabel=categorie\" id=\"tombolmerah\">Delete</a> </td>\n");
      out.write("\n");
      out.write(" </tr>\n");
      out.write(" ");

 }

 }
 
      out.write("\n");
      out.write(" </table>\n");
      out.write(" <p></p>\n");
      out.write("    \n");
      out.write("</div>\n");
      out.write("\n");
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
