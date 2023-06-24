<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="tokobuku" scope="page" class="tokobuku.tokobuku" />
<jsp:setProperty name="tokobuku" property="*" />

<%
String message = "";
String namebook = request.getParameter("namebook") ;
String autorbook = request.getParameter("autorbook") ;
String desbook = request.getParameter("desbook") ;
String pricebook = request.getParameter("pricebook") ;
String catebook = request.getParameter("catebook") ;
String imgbook = request.getParameter("imgbook") ;
String tabel = "book"; 
String redirectPage = tabel + ".jsp";


//jika name, address, company dan email tidak (“”) maka
if((!namebook.equals("")) & (!autorbook.equals("")) & (!desbook.equals("")) & (!pricebook.equals("")) & (!catebook.equals("")) & (!imgbook.equals("")) ){
    if(tokobuku.createBook()){
        message = "Data berhasi di masukan ";
        
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