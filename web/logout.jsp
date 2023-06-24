<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>

<%
    // Memeriksa apakah pengguna sudah login dengan memeriksa atribut session
    String loggedInUser = (String) session.getAttribute("username");
    if (loggedInUser == null) {
        // Jika pengguna belum login, arahkan kembali ke halaman login
        response.sendRedirect("login.jsp");
    } else {
        // Menghapus atribut sesi 'username'
        session.removeAttribute("username");

        // Menghapus semua atribut sesi
        session.invalidate();
        String message = "Berhasil Logout";
        %>
        <script type="text/javascript">
            var alertMessage = "<%= message %>"; //menaruh pesan
            alert(alertMessage); // menampilkan di alert
            window.location.href = "login.jsp"; // Ganti dengan halaman tujuan yang sesuai
        </script>
        <% 
    }
%>

