<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="tokobuku" scope="page" class="tokobuku.tokobuku" />
<jsp:setProperty name="tokobuku" property="*" />

<%
String message = "";
String id = request.getParameter("id") ;
String caname = request.getParameter("name") ;
String cadetail = request.getParameter("desc") ;
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
    <h1>Edit Kategorie</h1>
    <br>
    <form name="login" action="edit.jsp" method="post">
        <input type="hidden" name="id" value="<%=id%>">
        <input type="hidden" name="tabel" value="categorie">
        <label for="fname">Categorie Name</label>
        <input type="text" name="caname" value="<%=caname%>">

        <label for="lname">Categorie Description</label>
        <input type="text" name="cadetail" value="<%=cadetail%>">

        <input type="submit" value="Submit"name="Submit">
    </form>  
</div>  


<jsp:include page="nav/footer.jsp" />