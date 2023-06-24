package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

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
      response.setContentType("text/html; charset=UTF-8");
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

    // Memeriksa apakah pengguna sudah login dengan memeriksa atribut session
    String pesan = "";
    String loggedInUser = (String) session.getAttribute("username");
    if (loggedInUser != null) {
        // Jika pengguna sudah login, arahkan ke halaman index.jsp
        response.sendRedirect("index.jsp");
    }

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <title>Login</title>\n");
      out.write("    <link href=\"asset/css/style.css\" rel=\"stylesheet\">\n");
      out.write("    <style>\n");
      out.write("        .login {\n");
      out.write("            width: 300px;\n");
      out.write("            margin-top: 10px;\n");
      out.write("            margin-bottom: 10px;\n");
      out.write("            margin-left: auto;\n");
      out.write("            margin-right: auto;\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        .logo {\n");
      out.write("            width: 300px;\n");
      out.write("            margin-top: 150px;\n");
      out.write("            margin-bottom: 10px;\n");
      out.write("            margin-left: auto;\n");
      out.write("            margin-right: auto;\n");
      out.write("            text-align: center;\n");
      out.write("            background-color: #04AA6D;\n");
      out.write("            color:white;\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        #loginhijau{\n");
      out.write("            background-color: #04AA6D;\n");
      out.write("            \n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        .copy {\n");
      out.write("            width: 300px;\n");
      out.write("            margin-top: 10px;\n");
      out.write("            margin-bottom: 10px;\n");
      out.write("            margin-left: auto;\n");
      out.write("            margin-right: auto;\n");
      out.write("            text-align: center;\n");
      out.write("            background-color: #333;\n");
      out.write("            color:white;\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        #tombolcustom{\n");
      out.write("            border-radius: 4px;\n");
      out.write("            background-color: #04AA6D;\n");
      out.write("            border: none;\n");
      out.write("            color: white;\n");
      out.write("            padding: 10px 15px;\n");
      out.write("            text-align: center;\n");
      out.write("            text-decoration: none;\n");
      out.write("            display: inline-block;\n");
      out.write("            font-size: 14px;\n");
      out.write("            cursor: pointer;\n");
      out.write("            width: 270px;\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div class=\"logo\">\n");
      out.write("        <h1>tokOBuku</h1>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"login\">\n");
      out.write("        \n");
      out.write("        <form method=\"post\" action=\"login.jsp\">\n");
      out.write("            <label for=\"username\">Username:</label>\n");
      out.write("            <input type=\"text\" id=\"username\" name=\"username\"><br>\n");
      out.write("\n");
      out.write("            <label for=\"password\">Password:</label>\n");
      out.write("            <input type=\"password\" id=\"password\" name=\"password\"><br>\n");
      out.write("\n");
      out.write("            <input type=\"submit\" value=\"Login\" id=\"loginhijau\">\n");
      out.write("            <a href=\"register.jsp\" id=\"tombolcustom\">Register </a>\n");
      out.write("\n");
      out.write("        </form>\n");
      out.write("    </div>  \n");
      out.write("    <div class=\"copy\">\n");
      out.write("        <p>sahidin &copy; 2023</p>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    ");
      out.write("\n");
      out.write("    ");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Mengecek apakah tombol submit sudah ditekan
        if (username != null && password != null) {
            // Membuat koneksi ke database
            Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;
            String dbUrl = "jdbc:mysql://localhost:3306/uas_sahidin";
            String dbUsername = "root";
            String dbPassword = "";

            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
                stmt = conn.createStatement();

                // Mengeksekusi query untuk memeriksa username dan password
                String query = "SELECT * FROM user WHERE username='" + username + "' AND password='" + password + "'";
                rs = stmt.executeQuery(query);

                if (rs.next()) {
                    // Jika username dan password valid, arahkan ke halaman sukses
                    session.setAttribute("username", username);
                    response.sendRedirect("index.jsp");
                } else {
                    // Jika username dan password tidak valid, tampilkan pesan error
                    pesan = "username dan password tidak valid";
                    if (pesan != null) {
                        
                        
      out.write(" \n");
      out.write("                        <script type=\"text/javascript\">\n");
      out.write("                            var alertMessage = '");
      out.print( pesan );
      out.write("';\n");
      out.write("                            alert(alertMessage);\n");
      out.write("                        </script>\n");
      out.write("                        ");

                        }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                // Menutup koneksi database
                if (rs != null) {
                    try { rs.close(); } catch (SQLException e) { }
                }
                if (stmt != null) {
                    try { stmt.close(); } catch (SQLException e) { }
                }
                if (conn != null) {
                    try { conn.close(); } catch (SQLException e) { }
                }
            }
        }
    
      out.write("\n");
      out.write("    \n");
      out.write("</body>\n");
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
