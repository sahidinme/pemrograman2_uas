
<jsp:include page="nav/header.jsp" />    




<div class="konten">
    <h1>Tambah Kategorie</h1>
    <br>
    <form name="login" action="categorieprocess.jsp" method="post">
        <label for="fname">Categorie Name</label>
        <input type="text" name="caname" placeholder="Categorie Name">

        <label for="lname">Categorie Description</label>
        <input type="text" name="cadetail" placeholder="Categorie Description">

        <input type="submit" value="Submit"name="Submit">
    </form>  
</div>  


<jsp:include page="nav/footer.jsp" />