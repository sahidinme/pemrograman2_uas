<jsp:useBean id="tokobuku" scope="page" class="tokobuku.tokobuku" />
<jsp:setProperty name="tokobuku" property="*" />
<%@ page import="java.sql.*" %>


<jsp:include page="nav/header.jsp" />    
    <div class="konten">    
        <h1>Tambah buku</h1>
        <form name="login" action="bookprocess.jsp" method="post">
            <label for="fname">Book name</label>
            <input type="text"  name="namebook" placeholder="Book name..">

            <label for="lname">Autor name</label>
            <input type="text"  name="autorbook" placeholder="Autor name..">

            <label for="lname">Description</label>
            <input type="text"  name="desbook" placeholder="Description..">

            <label for="lname">Description</label>
            <input type="text"  name="pricebook" placeholder="Price..">
            
           
            <label for="categori">Kategori</label>
            <select id="categori" name="catebook">
            <%
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
            %>
            </select>
            
            

            <label for="lname">Image</label>
            <input type="text"  name="imgbook" placeholder="Image..">

            <input type="submit" value="Submit" name="Submit">
        </form>
    </div>    
<jsp:include page="nav/footer.jsp" />    




