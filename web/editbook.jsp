<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="tokobuku" scope="page" class="tokobuku.tokobuku" />
<jsp:setProperty name="tokobuku" property="*" />
<%@ page import="java.sql.*" %>

<%
String message = "";
String id = request.getParameter("id") ;

String namebook = request.getParameter("namebook") ;
String autorbook = request.getParameter("autorbook") ;
String desbook = request.getParameter("desbook") ;
String pricebook = request.getParameter("pricebook") ;
String catebook = request.getParameter("catebook") ;
String imgbook = request.getParameter("imgbook") ;
String kat = request.getParameter("kat") ;

//jika name, address, company dan email tidak (“”) maka
if(!id.equals("")){
 message="data ditemukan";
}else{
 message="data tidak ditemukan";
}
//lakukan insert data ke database
//jika berhasil message = "Thank you " + name + " for Registering "
;
//jika tidak set message = "Error" ;
%>

<jsp:include page="nav/header.jsp" />    
    <div class="konten">    
        <h1>Tambah buku</h1>
        <form name="login" action="edit.jsp" method="post">
            <input type="hidden" name="id" value="<%=id%>">
            <input type="hidden" name="tabel" value="book">
            
            <label for="fname">Book name</label>
            <input type="text" name="namebook" value="<%=namebook%>">

            <label for="lname">Autor name</label>
            <input type="text" name="autorbook"value="<%=autorbook%>">

            <label for="lname">Description</label>
            <input type="text" name="desbook" value="<%=desbook%>">

            <label for="lname">Description</label>
             <input type="text" name="pricebook" value="<%=pricebook%>">
            
           
            <label for="lname">Categorie</label>
            
            <select id="categori" name="catebook">
                <!--Menampilkan data dari database-->
                <option value="<%=catebook%>"><%=kat%></option>
                <!--Menampilkan pilihan dari tabel kategorie-->
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
            <input type="text" name="imgbook" value="<%=imgbook%>">

            <input type="submit" value="Submit" name="Submit">
        </form>
    </div>    
<jsp:include page="nav/footer.jsp" />   