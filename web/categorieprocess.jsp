<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="tokobuku" scope="page" class="tokobuku.tokobuku" />
<jsp:setProperty name="tokobuku" property="*" />

<%
String message = "";
String caname = request.getParameter("caname") ;
String cadetail = request.getParameter("cadetail") ;
String tabel = "categorie";
String redirectPage = tabel + ".jsp";


//jika name, address, company dan email tidak (“”) maka
if((!caname.equals("")) & (!cadetail.equals("")) ){
    if(tokobuku.categorie()){
        message = "Kategori " + caname + " berhasilkan ditambahkan ";
        
        %>
        <script type="text/javascript">
            var alertMessage = "<%= message %>"; //menaruh pesan
            alert(alertMessage); // menampilkan di alert
            window.location.href = "<%= redirectPage %>"; // Ganti dengan halaman tujuan yang sesuai
        </script>
        <% 
        
    }else{
        message = "Error" ;
    }

}else{
 message="Field tidak boleh kosong";
}
//lakukan insert data ke database
//jika berhasil message = "Thank you " + name + " for Registering ";
//jika tidak set message = "Error" ;
%>

<jsp:include page="nav/header.jsp" />

<div class="konten" >
    
    <h2><%=message%></h2>
    
</div>
    
<jsp:include page="nav/footer.jsp" />