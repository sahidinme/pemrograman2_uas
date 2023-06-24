<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="tokobuku" scope="page" class="tokobuku.tokobuku" />
<jsp:setProperty name="tokobuku" property="*" />

<%
String message = "";
String tabel = request.getParameter("tabel");
String redirectPage = tabel + ".jsp";
String id = request.getParameter("id");

// Jika id ada
if (!id.equals("")) {
    boolean deleteResult = false;

    if (tabel.equals("book")) {
        deleteResult = tokobuku.deleteBook(Integer.parseInt(id));
    } else if (tabel.equals("categorie")) {
        deleteResult = tokobuku.deleteCategory(Integer.parseInt(id));
    }else if (tabel.equals("promotion")) {
        deleteResult = tokobuku.deletePromo(Integer.parseInt(id));
    }

    if (deleteResult) {
        message = "Data telah terhapus";
        
        %>
        <script type="text/javascript">
            var alertMessage = "<%= message %>"; //menaruh pesan
            alert(alertMessage); // menampilkan di alert
            window.location.href = "<%= redirectPage %>"; // Ganti dengan halaman tujuan yang sesuai
        </script>
        <% 
        
    } else {
        message = "Error saat menghapus data";
    }
} else {
    message = "Data tidak ditemukan";
}
%>

<jsp:include page="nav/header.jsp" />

<div class="konten" >
    
    <h2><%=message%></h2>
    
</div>
    
<jsp:include page="nav/footer.jsp" />
