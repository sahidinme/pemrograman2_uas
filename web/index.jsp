<%@page import="java.sql.*"%>
<%
    
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
%>


        <jsp:include page="nav/header.jsp" />
    
        <div class="konten">
            <h1>Hello, <%= loggedInUser %>! You are now logged in.</h1>

            <br><br>
            <table id="tabel">
            <tr>
            <th>Total buku</th>
            <th>Total Kategori</th>
            <th>Total promo</th>
            </tr>
            <tr>
            <td><%=buku%> buku</td>
            <td><%=kategori%> Kategori</td>
            <td><%=promo%> promo</td>
            </tr>

            </table>


            <br>    
<!--            <form method="post" action="logout.jsp">
            <input type="submit" value="Logout">
            </form>-->
        </div>
    
        <jsp:include page="nav/footer.jsp" />    
        
        
