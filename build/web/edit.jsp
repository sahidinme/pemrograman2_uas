<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="tokobuku" scope="page" class="tokobuku.tokobuku" />
<jsp:setProperty name="tokobuku" property="*" />

<%
String message = "";
String id = request.getParameter("id") ;
//categorie
String caname = request.getParameter("caname") ;
String cadetail = request.getParameter("cadetail") ;
//promo
String idpromo = request.getParameter("idpromo") ;

//book
String namebook = request.getParameter("namebook") ;
String autorbook = request.getParameter("autorbook") ;
String desbook = request.getParameter("desbook") ;
String pricebook = request.getParameter("pricebook") ;
String catebook = request.getParameter("catebook") ;
String imgbook = request.getParameter("imgbook") ;

String tabel = request.getParameter("tabel") ;
String redirectPage = tabel + ".jsp";





if (!id.equals("")) {
    boolean udateResult = false;

    if (tabel.equals("book")) {
        udateResult = tokobuku.updateBook(Integer.parseInt(id));
    } else if (tabel.equals("categorie")) {
        udateResult = tokobuku.updateCategory(Integer.parseInt(id));
    }else if (tabel.equals("promotion")) {
        udateResult = tokobuku.updateProm(Integer.parseInt(id));
    }

    if (udateResult) {
        message = "Data telah update";
        
            
        %>
        <script type="text/javascript">
            var alertMessage = "<%= message %>"; //menaruh pesan
            alert(alertMessage); // menampilkan di alert
            window.location.href = "<%= redirectPage %>"; // Ganti dengan halaman tujuan yang sesuai
        </script>
        <%    
        
        
    } else {
        message = "Error saat update";
    }
} else {
    message = "Data tidak ditemukan";
}


%>

<!--tidak terpakai-->

<jsp:include page="nav/header.jsp" />  

<div class="konten">
    
    <h2><%=message%>
    <br>
    
</div>

<jsp:include page="nav/footer.jsp" />  