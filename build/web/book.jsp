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
 list=tokobuku.listBook(mulai,jumlah);
%>

<jsp:include page="nav/header.jsp" />

<div class="konten" style="overflow-x: auto;">
    
    <h1>Daftar Buku </h1>
    <a href="createbook.jsp" id="tombol">Tambahkan Buku </a><br>
    <input id="myInput" type="text" placeholder="Search.." style="width:280px">
    <table id="tabel">

   <tr>
   <thead>
       <th>No</th>
       <th>Judul</th>
       <th>Pembuat</th>
       <th>description</th>
       <th>Harga</th>
       <th>Kategori</th>
       <th>Gambar</th>
       <th>Tanggal</th>
       <th colspan="2">Action</th>
    </thead>
    </tr>
    <%
    if (list != null){
    for (int i=0; i<list.length; i++){
    int no=i+1;
    String id=list[i][0].toString();
    String jd=list[i][1].toString();
    String pem=list[i][2].toString();
    String des=list[i][3].toString();
    String har=list[i][4].toString();
    String kat=list[i][5].toString();
    String gam=list[i][6].toString();
    String tgl=list[i][7].toString();
    String idk=list[i][8].toString();


   //out.print("<tr><td>"+no+"</td><td>"+listGuestBook[i][1].toString()+"</td><td>"+listGuestBook[i][2].toString()+"</td><td>"+listGuestBook[i][3].toString()+"</td><td>"+listGuestBook[i][4].toString()+"</td></tr>");
    %>
    <tr>
    <tbody id="myTable">
    <td> <%=no%></td>
    <td> <%=jd%></td>
    <td> <%=pem%></td>
    <td> <%=des%></td>
    <td> <%=har%></td>
    <td> <%=kat%></td>
    <td> <img style="width:100px" src="asset/img/<%=gam%>"></td>
    <td> <%=tgl%></td>

    <td><a href="editbook.jsp?id=<%=id%>&namebook=<%=jd%>&autorbook=<%=pem%>&desbook=<%=des%>&pricebook=<%=har%>&catebook=<%=idk%>&imgbook=<%=gam%>&kat=<%=kat%>" id="tombolkuning">Edit</a></td>
    <td> <a href="delete.jsp?id=<%=id%>&tabel=book" id="tombolmerah">Delete</a> </td>
    </tbody>
    </tr>
    <%
    }

    }
    %>
    </table>
    

    
    
</div>
    
<jsp:include page="nav/footer.jsp" />