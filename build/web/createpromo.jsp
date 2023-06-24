<%@ page import="java.sql.*" %>


<jsp:include page="nav/header.jsp" />    




<div class="konten">
    <h1>Tambah Promo</h1>
    <br>

    <form name="login" action="promoprocess.jsp" method="post">
    <label for="promo">Nama Buku</label>
<%
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
%>
<input type="submit" name="Submit" value="Submit">
</form>
</div>  


<jsp:include page="nav/footer.jsp" />