package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class createbook_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "nav/header.jsp", out, false);
      out.write("    \n");
      out.write("    <div class=\"konten\">    \n");
      out.write("        <h1>Tambah buku</h1>\n");
      out.write("        <form name=\"login\" action=\"bookprocess.jsp\" method=\"post\">\n");
      out.write("            <label for=\"fname\">Book name</label>\n");
      out.write("            <input type=\"text\"  name=\"namebook\" placeholder=\"Book name..\">\n");
      out.write("\n");
      out.write("            <label for=\"lname\">Autor name</label>\n");
      out.write("            <input type=\"text\"  name=\"autorbook\" placeholder=\"Autor name..\">\n");
      out.write("\n");
      out.write("            <label for=\"lname\">Description</label>\n");
      out.write("            <input type=\"text\"  name=\"desbook\" placeholder=\"Description..\">\n");
      out.write("\n");
      out.write("            <label for=\"lname\">Description</label>\n");
      out.write("            <input type=\"text\"  name=\"pricebook\" placeholder=\"Price..\">\n");
      out.write("            \n");
      out.write("           \n");
      out.write("            <label for=\"categori\">Kategori</label>\n");
      out.write("            <select id=\"categori\" name=\"catebook\">\n");
      out.write("            ");

                Connection conn = null;
                Statement stmt = null;
                ResultSet rs = null;

                try {
                    // Konfigurasi koneksi database
                    String url = "jdbc:mysql://localhost:3306/uas_sahidin";
                    String username = "root";
                    String password = "";

                    // Membuat koneksi menggunakan JDBC
                    Class.forName("com.mysql.jdbc.Driver");
                    conn = DriverManager.getConnection(url, username, password);

                    // Membuat pernyataan SQL untuk mengambil seluruh data dari tabel categories
                    String sql = "SELECT * FROM categories";

                    // Mengeksekusi kueri dan mendapatkan hasilnya
                    stmt = conn.createStatement();
                    rs = stmt.executeQuery(sql);

                    // Menampilkan hasil
                    while (rs.next()) {
                        // Mendapatkan nilai dari setiap atribut
                        int categoryId = rs.getInt("category_id");
                        String categoryName = rs.getString("category_name");

                        // Membuat elemen option dengan nilai category_id dan teks category_name
                        out.println("<option value='" + categoryId + "'>" + categoryName + "</option>");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    // Menutup koneksi dan sumber daya
                    if (rs != null) {
                        try {
                            rs.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                    if (stmt != null) {
                        try {
                            stmt.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                    if (conn != null) {
                        try {
                            conn.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }
            
      out.write("\n");
      out.write("            </select>\n");
      out.write("            \n");
      out.write("            \n");
      out.write("\n");
      out.write("            <label for=\"lname\">Image</label>\n");
      out.write("            <input type=\"text\"  name=\"imgbook\" placeholder=\"Image..\">\n");
      out.write("\n");
      out.write("            <input type=\"submit\" value=\"Submit\" name=\"Submit\">\n");
      out.write("        </form>\n");
      out.write("    </div>    \n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "nav/footer.jsp", out, false);
      out.write("    \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
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
