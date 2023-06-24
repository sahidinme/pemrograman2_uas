<jsp:useBean id="tokobuku" scope="page" class="tokobuku.tokobuku" />
<jsp:setProperty name="tokobuku" property="*" />

<%
    
// Memeriksa apakah pengguna sudah login dengan memeriksa atribut session
    String loggedInUser = (String) session.getAttribute("username");
    if (loggedInUser == null) {
        // Jika pengguna belum login, arahkan kembali ke halaman login
        response.sendRedirect("login.jsp");
    }     
    
 int mulai=0, jumlah=10;
 Object[][] list= null;
 list=tokobuku.listProm(mulai,jumlah);
%>

<jsp:include page="nav/header.jsp" />

<div class="konten">
    
     <h1>Daftar Promo </h1>
 
     <a href="createpromo.jsp" id="tombol">Tambahkan Promotion </a><br>
 
 <table id="tabel">

<tr>
    <th>No</th>
    <th>Nama Product</th>
    <th>Date</th>
    <th>Action</th>
</tr>
 <%
 if (list != null){
 for (int i=0; i<list.length; i++){
 int no=i+1;
 String id=list[i][0].toString();
 String nm=list[i][1].toString();
 String tgl=list[i][2].toString();


//out.print("<tr><td>"+no+"</td><td>"+listGuestBook[i][1].toString()+"</td><td>"+listGuestBook[i][2].toString()+"</td><td>"+listGuestBook[i][3].toString()+"</td><td>"+listGuestBook[i][4].toString()+"</td></tr>");
 %>
 <tr>
 <td> <%=no%></td>
 <td> <%=nm%></td>
 <td> <%=tgl%></td>

 <td> <a href="delete.jsp?id=<%=id%>&tabel=promotion" id="tombolmerah">Delete</a> </td>

 </tr>
 <%
 }

 }
 %>
 </table>
 <p></p>

    
</div>

<jsp:include page="nav/footer.jsp" />