<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="tokobuku" scope="page" class="tokobuku.tokobuku" />
<jsp:setProperty name="tokobuku" property="*" />

<%
String message = "";
String username = request.getParameter("username") ;
String password = request.getParameter("password") ;
String level = request.getParameter("level") ;


//jika name, address, company dan email tidak (“”) maka
if((!username.equals("")) & (!password.equals("")) & (!level.equals("")) ){
    if(tokobuku.register()){
        message = "Thank you " + username + " for Registering ";
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

<html>
<head>
<meta http-equiv="Content-Type" content="text/html;
charset=UTF-8">
<title>GuestBook</title>
</head>

<body>
<h2><%=message%>
<br>
<a href="login.jsp"> Login </a>
<br>
<!--<a href="guestBookView.jsp"> VIEW GUEST BOOK </a>-->
</h2>
</body>
</html>