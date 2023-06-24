<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="tokobuku" scope="page" class="tokobuku.tokobuku" />
<jsp:setProperty name="tokobuku" property="*" />

<%
String message = "";
String id = request.getParameter("id") ;
String product = request.getParameter("productid") ;
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
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html;
 charset=UTF-8">
 <title>GuestBook</title>
</head>
<body>
 <h1>Guest Book</h1>
 
 <form name="login" action="edit.jsp" method="post">
    <input type="hidden" name="id" value="<%=id%>">
    <input type="hidden" name="tabel" value="promotion">
    <table width="200" border="1">
    <tr>
    <td>Categorie Name</td>
    <td><input type="text" name="idpromo" value="<%=product%>"></td>
    </tr>
    
    <tr>
    <td colspan="2"><input type="submit" name="Submit" value="Submit"></td>
    </tr>
    </table>
    
</form>    
 
 

 <h2><a href="categorie.jsp"> List Categorie </a></h2>
</body>
</html>