<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>

<%
    // Memeriksa apakah pengguna sudah login dengan memeriksa atribut session
    String pesan = "";
    String loggedInUser = (String) session.getAttribute("username");
    if (loggedInUser != null) {
        // Jika pengguna sudah login, arahkan ke halaman index.jsp
        response.sendRedirect("index.jsp");
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link href="asset/css/style.css" rel="stylesheet">
    <style>
        .login {
            width: 300px;
            margin-top: 10px;
            margin-bottom: 10px;
            margin-left: auto;
            margin-right: auto;
        }
        
        .logo {
            width: 300px;
            margin-top: 150px;
            margin-bottom: 10px;
            margin-left: auto;
            margin-right: auto;
            text-align: center;
            background-color: #04AA6D;
            color:white;
        }
        
        #loginhijau{
            background-color: #04AA6D;
            
        }
        
        .copy {
            width: 300px;
            margin-top: 10px;
            margin-bottom: 10px;
            margin-left: auto;
            margin-right: auto;
            text-align: center;
            background-color: #333;
            color:white;
        }
        
        #tombolcustom{
            border-radius: 4px;
            background-color: #04AA6D;
            border: none;
            color: white;
            padding: 10px 15px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 14px;
            cursor: pointer;
            width: 270px;
        }
        
    </style>
</head>
<body>
    <div class="logo">
        <h1>tokOBuku</h1>
    </div>
    <div class="login">
        
        <form method="post" action="login.jsp">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username"><br>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password"><br>

            <input type="submit" value="Login" id="loginhijau">
            <a href="register.jsp" id="tombolcustom">Register </a>

        </form>
    </div>  
    <div class="copy">
        <p>sahidin &copy; 2023</p>
    </div>

    <%-- Mendapatkan parameter dari form login --%>
    <%
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
                        
                        %> 
                        <script type="text/javascript">
                            var alertMessage = '<%= pesan %>';
                            alert(alertMessage);
                        </script>
                        <%
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
    %>
    
</body>
</html>
