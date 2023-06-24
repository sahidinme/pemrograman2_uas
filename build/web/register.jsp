<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    
// Memeriksa apakah pengguna sudah login dengan memeriksa atribut session
    String loggedInUser = (String) session.getAttribute("username");
    if (loggedInUser != null) {
        // Jika pengguna sudah login, arahkan kembali ke halaman index
        response.sendRedirect("index.jsp");
    } 
    
%>    
<!DOCTYPE html>
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html;
 charset=UTF-8">
 <title>Register</title>
 <link href="asset/css/style.css" rel="stylesheet">
 <style>
        .login {
            width: 300px;
            margin-top: 10px;
            margin-bottom: 10px;
            margin-left: auto;
            margin-right: auto;
        }
        
        .logo {
            width: 300px;
            margin-top: 150px;
            margin-bottom: 10px;
            margin-left: auto;
            margin-right: auto;
            text-align: center;
            background-color: #04AA6D;
            color:white;
        }
        
        #loginhijau{
            background-color: #04AA6D;
            
        }
        
        .copy {
            width: 300px;
            margin-top: 10px;
            margin-bottom: 10px;
            margin-left: auto;
            margin-right: auto;
            text-align: center;
            background-color: #333;
            color:white;
        }
        
        #tombolcustom{
            border-radius: 4px;
            background-color: #04AA6D;
            border: none;
            color: white;
            padding: 10px 15px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 14px;
            cursor: pointer;
            width: 270px;
        }
        
    </style>
</head>
<body>
    <div class="logo">
        <h1>tokOBuku</h1>
    </div>
    <div class="login">

    <form name="login" action="registerproses.jsp" method="post">

        <label for="username">Username:</label>
        <input type="text" id="username" name="username"><br>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password"><br>

        <input type="hidden" name="level" value="2">


        <input type="submit" value="Register" id="loginhijau" name="Submit">
        <a href="login.jsp" id="tombolcustom">Login </a>
    </form>  
        
    </div>

    <div class="copy">
        <p>sahidin &copy; 2023</p>
    </div>

</body>
</html>