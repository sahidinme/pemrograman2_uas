package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

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

      out.write('\n');

    
// Memeriksa apakah pengguna sudah login dengan memeriksa atribut session
    String loggedInUser = (String) session.getAttribute("username");
    if (loggedInUser == null) {
        // Jika pengguna belum login, arahkan kembali ke halaman login
        response.sendRedirect("login.jsp");
    }    
    
    
String url = "jdbc:mysql://localhost:3306/uas_sahidin";
String username = "root";
String password = "";

Connection conn = null;
Statement stmt = null;
ResultSet rs = null;

int buku = 0;
int kategori = 0;
int promo = 0;

try {
    Class.forName("com.mysql.jdbc.Driver");
    conn = DriverManager.getConnection(url, username, password);

    // Menghitung total data dari tabel buku
    stmt = conn.createStatement();
    rs = stmt.executeQuery("SELECT COUNT(*) AS total FROM books");
    if (rs.next()) {
        buku = rs.getInt("total");
    }

    // Menghitung total data dari tabel murid
    rs = stmt.executeQuery("SELECT COUNT(*) AS total FROM categories");
    if (rs.next()) {
        kategori = rs.getInt("total");
    }

    // Menghitung total data dari tabel kelas
    rs = stmt.executeQuery("SELECT COUNT(*) AS total FROM promotion");
    if (rs.next()) {
        promo = rs.getInt("total");
    }
} catch (Exception e) {
    e.printStackTrace();
} finally {
    if (rs != null) {
        rs.close();
    }
    if (stmt != null) {
        stmt.close();
    }
    if (conn != null) {
        conn.close();
    }
}

// Menampilkan total data
//out.println("Total data buku: " + buku + "<br>");
//out.println("Total data murid: " + kategori + "<br>");
//out.println("Total data kelas: " + promo + "<br>");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "nav/header.jsp", out, false);
      out.write("\n");
      out.write("    \n");
      out.write("        <div class=\"konten\">\n");
      out.write("            <h1>Hello, ");
      out.print( loggedInUser );
      out.write("! You are now logged in.</h1>\n");
      out.write("\n");
      out.write("            <br><br>\n");
      out.write("            <table id=\"tabel\">\n");
      out.write("            <tr>\n");
      out.write("            <th>Total buku</th>\n");
      out.write("            <th>Total Kategori</th>\n");
      out.write("            <th>Total promo</th>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("            <td>");
      out.print(buku);
      out.write(" buku</td>\n");
      out.write("            <td>");
      out.print(kategori);
      out.write(" Kategori</td>\n");
      out.write("            <td>");
      out.print(promo);
      out.write(" promo</td>\n");
      out.write("            </tr>\n");
      out.write("\n");
      out.write("            </table>\n");
      out.write("\n");
      out.write("\n");
      out.write("            <br>    \n");
      out.write("<!--            <form method=\"post\" action=\"logout.jsp\">\n");
      out.write("            <input type=\"submit\" value=\"Logout\">\n");
      out.write("            </form>-->\n");
      out.write("        </div>\n");
      out.write("    \n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "nav/footer.jsp", out, false);
      out.write("    \n");
      out.write("        \n");
      out.write("        \n");
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
