package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class uploadfile_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("<form name=\"login\" action=\"promoprocess.jsp\" method=\"post\">\n");
      out.write("    <label for=\"promo\">Nama Buku</label>\n");

    String dbUrl = "jdbc:mysql://localhost:3306/uas_sahidin";
    String dbUsername = "root";
    String dbPassword = "";

    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;

    try {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        statement = connection.prepareStatement("SELECT product_id, title FROM books WHERE product_id NOT IN (SELECT product_id FROM promotion)");
        resultSet = statement.executeQuery();

        // Tampilkan hasil query dalam elemen <select>
        out.println("<select name=\"idpromo\">");
        while (resultSet.next()) {
            int idBuku = resultSet.getInt("product_id");
            String judulBuku = resultSet.getString("title");

            out.println("<option value=\"" + idBuku + "\">" + judulBuku + "</option>");
        }
        out.println("</select>");
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

      out.write("\n");
      out.write("<input type=\"submit\" name=\"Submit\" value=\"Submit\">\n");
      out.write("</form>");
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
