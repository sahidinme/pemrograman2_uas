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
 list=tokobuku.listCate(mulai,jumlah);
%>

<jsp:include page="nav/header.jsp" />

<div class="konten">
    
     <h1>Daftar kategori </h1>
 
     <a href="createcategorie.jsp" id="tombol">Tambahkan Kategori </a><br>
 
 <table id="tabel">

<tr>
    <th>No</th>
    <th>Categorie Name</th>
    <th>Categorie description</th>
    <th colspan="2">Action</th>
</tr>
 <%
 if (list != null){
 for (int i=0; i<list.length; i++){
 int no=i+1;
 String id=list[i][0].toString();
 String nm=list[i][1].toString();
 String dsc=list[i][2].toString();


//out.print("<tr><td>"+no+"</td><td>"+listGuestBook[i][1].toString()+"</td><td>"+listGuestBook[i][2].toString()+"</td><td>"+listGuestBook[i][3].toString()+"</td><td>"+listGuestBook[i][4].toString()+"</td></tr>");
 %>
 <tr>
 <td> <%=no%></td>
 <td> <%=nm%></td>
 <td> <%=dsc%></td>

 <td><a href="editcategorie.jsp?id=<%=id%>&name=<%=nm%>&desc=<%=dsc%>" id="tombolkuning">Edit</a></td>
 <td> <a href="delete.jsp?id=<%=id%>&tabel=categorie" id="tombolmerah">Delete</a> </td>

 </tr>
 <%
 }

 }
 %>
 </table>
 <p></p>
    
</div>

<jsp:include page="nav/footer.jsp" />