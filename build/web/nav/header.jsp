<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>tokOBuku</title>
        <link href="asset/css/style.css" rel="stylesheet">
        <script src="asset/js/jquery.js"></script>
        <script>
        $(document).ready(function(){
          $("#myInput").on("keyup", function() {
            var value = $(this).val().toLowerCase();
            $("#myTable tr").filter(function() {
              $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
            });
          });
        });
        </script>
    </head>
    
    <style>
        
    </style>
    </head>
    <body>

    <ul>
    <li><a href="index.jsp" class="active">tokOBuku</a></li>
    <li><a href="book.jsp">Buku</a></li>
    <li><a href="categorie.jsp">Kategori</a></li>
    <li><a href="promotion.jsp">Promo</a></li>
    <li style="float:right"><a  href="logout.jsp">Logout</a></li>
    </ul>
        