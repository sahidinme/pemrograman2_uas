package tokobuku;
import java.util.Vector;
import java.sql.*;

/**
 *
 * @author Lenovo
 */
public class tokobuku {
    private String username, password, caname, cadetail, category_name, namebook, autorbook, desbook, pricebook, catebook, imgbook, tabel, idpromo;
    private final connection koneksi = new connection();
    private String pesan;
    private Object[][] listcate, listbook, listprom;
    private int level, id;
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }  
    
    public int getLevel(){
        return level;
    }
    
     public void setLevel(int level) {
        this.level = level;
    }
    
//    categorie 
     
    public String getCaname() {
        return caname;
    }
    
    public void setCaname(String caname) {
        this.caname = caname;
    }
    
    public String getCadetail() {
        return cadetail;
    }
    
    public void setCadetail(String cadetail) {
        this.cadetail = cadetail;
    }  
    
/// create book

    public String getNamebook() {
        return namebook;
    }
    
    public void setNamebook(String namebook) {
        this.namebook = namebook;
    }
    
    public String getAutorbook() {
        return autorbook;
    }
    
    public void setAutorbook(String autorbook) {
        this.autorbook = autorbook;
    }
    
    public String getDesbook() {
        return desbook;
    }
    
    public void setDesbook(String desbook) {
        this.desbook = desbook;
    }
    
    public String getPricebook() {
        return pricebook;
    }
    
    public void setPricebook(String pricebook) {
        this.pricebook = pricebook;
    }
    
    public String getCatebook() {
        return catebook;
    }
    
    public void setCatebook(String catebook) {
        this.catebook = catebook;
    }
    
    public String getImgbook() {
        return imgbook;
    }
    
    public void setImgbook(String imgbook) {
        this.imgbook = imgbook;
    }
    
    public String getIdpromo() {
        return idpromo;
    }
    
    public void setIdpromo(String idpromo) {
        this.idpromo = idpromo;
    }
    
    public int getId(){
        return id;
    }
    
     public void setId(int id) {
        this.id = id;
    }
     
//    register
    public boolean register() {
        boolean adaKesalahan = false;
        Connection connection;
        
        if ((connection = koneksi.getConnection()) != null) {
            int jumlahSimpan = 0;
            boolean simpan = false;
            Statement sta;
            ResultSet rset;
            
            try {
                simpan = true;
                String SQLStatemen = "insert into user(username,password,level) values('" + username + "','" + password + "','" + level + "')";
                sta = connection.createStatement();
                jumlahSimpan = sta.executeUpdate(SQLStatemen);
                if (simpan) {
                    if (jumlahSimpan < 1) {
                    adaKesalahan = true;
                    pesan = "Gagal menyimpan data guest_book";
                    System.out.println(pesan);
                    }
                } else {
                    adaKesalahan = true;
                    pesan = "Tidak dapat melakukan koneksi keserver\n" +
                    koneksi.getPesanKesalahan();
                    System.out.println(pesan);
                }
            
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
        
        return !adaKesalahan;
    } 
    
    
//  create categorie   
    public boolean categorie() {
        boolean adaKesalahan = false;
        Connection connection;
        
        if ((connection = koneksi.getConnection()) != null) {
            int jumlahSimpan = 0;
            boolean simpan = false;
            Statement sta;
            ResultSet rset;
            
            try {
                simpan = true;
                String SQLStatemen = "insert into categories(category_name, category_description) values('" + caname + "', '" + cadetail + "')";
                sta = connection.createStatement();
                jumlahSimpan = sta.executeUpdate(SQLStatemen);
                if (simpan) {
                    if (jumlahSimpan < 1) {
                    adaKesalahan = true;
                    pesan = "Gagal menyimpan data guest_book";
                    System.out.println(pesan);
                    }
                } else {
                    adaKesalahan = true;
                    pesan = "Tidak dapat melakukan koneksi keserver\n" +
                    koneksi.getPesanKesalahan();
                    System.out.println(pesan);
                }
            
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
        
        return !adaKesalahan;
    }
    
//  listcategorie
    public Object[][] listCate(int mulai, int jumlah) {
        boolean adaKesalahan = false;
        Connection connection;
        this.category_name = category_name;
        
        if ((connection = koneksi.getConnection()) != null) {
            String SQLStatemen;
            Statement sta;
            ResultSet rset;
           
                try {
                    SQLStatemen = "select * from categories limit " + mulai + "," + jumlah + " ";
                    sta = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
                    rset = sta.executeQuery(SQLStatemen);
                    rset.next();
                    rset.last();
                    listcate = new Object[rset.getRow()][];
                    rset.first();
                    int i = 0;
                    
                    do {
                        if (!rset.getString("category_name").equals("")) {
                            listcate[i] = new Object[]{rset.getString("category_id"), rset.getString("category_name"), rset.getString("category_description")};
                        }
                    i++;
                    } while (rset.next());
                        if (listcate.length > 0) {
                        adaKesalahan = false;
                    }
                        
                    sta.close();
                    rset.close();
                    connection.close();
                } catch (SQLException ex) {
                    adaKesalahan = true;
                    pesan = "Tidak dapat membaca guest_book\n" + ex.getMessage();
                }
        } else {
            adaKesalahan = true;
            pesan = "Tidak dapat melakukan koneksi ke server\n" + koneksi.getPesanKesalahan();
        }
    return listcate;
    }
    
    
//  create book
    public boolean createBook() {
        boolean adaKesalahan = false;
        Connection connection;
        
        if ((connection = koneksi.getConnection()) != null) {
            int jumlahSimpan = 0;
            boolean simpan = false;
            Statement sta;
            ResultSet rset;
            
            try {
                simpan = true;
                String SQLStatemen = "insert into books( title, author, description, price, category_id, image) values('" + namebook + "', '" + autorbook + "', '" + desbook + "', '" + pricebook + "', '" + catebook + "', '" + imgbook + "')";
                sta = connection.createStatement();
                jumlahSimpan = sta.executeUpdate(SQLStatemen);
                if (simpan) {
                    if (jumlahSimpan < 1) {
                    adaKesalahan = true;
                    pesan = "Gagal menyimpan data guest_book";
                    System.out.println(pesan);
                    }
                } else {
                    adaKesalahan = true;
                    pesan = "Tidak dapat melakukan koneksi keserver\n" +
                    koneksi.getPesanKesalahan();
                    System.out.println(pesan);
                }
            
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
        
        return !adaKesalahan;
    }
    
    
    
    public Object[][] listBook(int mulai, int jumlah) {
        boolean adaKesalahan = false;
        Connection connection;
        
        
        if ((connection = koneksi.getConnection()) != null) {
            String SQLStatemen;
            Statement sta;
            ResultSet rset;
           
                try {
                    SQLStatemen = "SELECT * FROM books INNER JOIN categories ON books.Category_id = categories.Category_id LIMIT " + mulai + "," + jumlah + "  ";
                    
                    sta = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
                    rset = sta.executeQuery(SQLStatemen);
                    rset.next();
                    rset.last();
                    listbook = new Object[rset.getRow()][];
                    rset.first();
                    int i = 0;
                    
                    do {
                        if (!rset.getString("title").equals("")) {
                            listbook[i] = new Object[]{rset.getString("product_id"),
                                rset.getString("title"),
                                rset.getString("author"),
                                rset.getString("description"),
                                rset.getString("price"),
                                rset.getString("category_name"), //mengambil data dari kategori dengan inner
                                rset.getString("image"),
                                rset.getString("date"),
                                rset.getString("category_id")};
                        }
                    i++;
                    } while (rset.next());
                        if (listbook.length > 0) {
                        adaKesalahan = false;
                    }
                        
                    sta.close();
                    rset.close();
                    connection.close();
                } catch (SQLException ex) {
                    adaKesalahan = true;
                    pesan = "Tidak dapat membaca guest_book\n" + ex.getMessage();
                }
        } else {
            adaKesalahan = true;
            pesan = "Tidak dapat melakukan koneksi ke server\n" + koneksi.getPesanKesalahan();
        }
    return listbook;
    }
    
    
 //   create categorie   
    public boolean promo() {
        boolean adaKesalahan = false;
        Connection connection;
        
        if ((connection = koneksi.getConnection()) != null) {
            int jumlahSimpan = 0;
            boolean simpan = false;
            Statement sta;
            ResultSet rset;
            
            try {
                simpan = true;
                String SQLStatemen = "insert into promotion (product_id) values('" + idpromo + "')";
                sta = connection.createStatement();
                jumlahSimpan = sta.executeUpdate(SQLStatemen);
                if (simpan) {
                    if (jumlahSimpan < 1) {
                    adaKesalahan = true;
                    pesan = "Gagal menyimpan data guest_book";
                    System.out.println(pesan);
                    }
                } else {
                    adaKesalahan = true;
                    pesan = "Tidak dapat melakukan koneksi keserver\n" +
                    koneksi.getPesanKesalahan();
                    System.out.println(pesan);
                }
            
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
        
        return !adaKesalahan;
    }
    
    
    public Object[][] listProm(int mulai, int jumlah) {
        boolean adaKesalahan = false;
        Connection connection;
        
        
        if ((connection = koneksi.getConnection()) != null) {
            String SQLStatemen;
            Statement sta;
            ResultSet rset;
           
                try {
                    SQLStatemen = "SELECT * FROM promotion INNER JOIN books ON promotion.product_id = books.product_id LIMIT " + mulai + "," + jumlah + " ";
                    
                    sta = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
                    rset = sta.executeQuery(SQLStatemen);
                    rset.next();
                    rset.last();
                    listbook = new Object[rset.getRow()][];
                    rset.first();
                    int i = 0;
                    
                    do {
                        if (!rset.getString("promotion_id").equals("")) {
                            listbook[i] = new Object[]{rset.getString("promotion_id"),
                                rset.getString("title"),
                                rset.getString("date")};
                        }
                    i++;
                    } while (rset.next());
                        if (listbook.length > 0) {
                        adaKesalahan = false;
                    }
                        
                    sta.close();
                    rset.close();
                    connection.close();
                } catch (SQLException ex) {
                    adaKesalahan = true;
                    pesan = "Tidak dapat membaca guest_book\n" + ex.getMessage();
                }
        } else {
            adaKesalahan = true;
            pesan = "Tidak dapat melakukan koneksi ke server\n" + koneksi.getPesanKesalahan();
        }
    return listbook;
    }
    
    
    public boolean deleteBook(int id) {
    boolean adaKesalahan = false;
    Connection connection = null;
    Statement statement = null;
    
    try {
        connection = koneksi.getConnection();
        statement = connection.createStatement();

        String SQLStatement = "DELETE FROM books WHERE product_id="+id+" ";
        int jumlahSimpan = statement.executeUpdate(SQLStatement);

        if (jumlahSimpan < 1) {
            adaKesalahan = true;
            pesan = "Gagal menghapus data buku";
            System.out.println(pesan);
        }
    } catch (SQLException ex) {
        adaKesalahan = true;
        pesan = "Terjadi kesalahan saat menghapus data buku: " + ex.getMessage();
        System.out.println(pesan);
    } finally {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException ex) {
                System.out.println("Terjadi kesalahan saat menutup statement: " + ex.getMessage());
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                System.out.println("Terjadi kesalahan saat menutup koneksi: " + ex.getMessage());
            }
        }
    }
    
    return !adaKesalahan;
}

    public boolean deleteCategory(int id) {
        boolean adaKesalahan = false;
        Connection connection;
        
        if ((connection = koneksi.getConnection()) != null) {
            int jumlahSimpan = 0;
            boolean simpan = false;
            Statement sta;
            ResultSet rset;
                try {
                simpan = true;
                String SQLStatemen = "delete from categories where category_id=" + id + " ";
                sta = connection.createStatement();
                jumlahSimpan = sta.executeUpdate(SQLStatemen);
                
                if (simpan) {
                    if (jumlahSimpan < 1) {
                    adaKesalahan = true;
                    pesan = "Gagal menghapus data guest_book";
                    System.out.println(pesan);
                    }
                    } else {
                    adaKesalahan = true;
                    pesan = "Tidak dapat melakukan koneksi keserver\n" +
                    koneksi.getPesanKesalahan();
                    System.out.println(pesan);
                    }
                } catch (SQLException ex) {
                System.out.println(ex);
                }
        }
        

        return !adaKesalahan;
    }
      
    public boolean deletePromo(int id) {
        boolean adaKesalahan = false;
        Connection connection;
        
        if ((connection = koneksi.getConnection()) != null) {
            int jumlahSimpan = 0;
            boolean simpan = false;
            Statement sta;
            ResultSet rset;
                try {
                simpan = true;
                String SQLStatemen = "delete from promotion where promotion_id=" + id + " ";
                sta = connection.createStatement();
                jumlahSimpan = sta.executeUpdate(SQLStatemen);
                
                if (simpan) {
                    if (jumlahSimpan < 1) {
                    adaKesalahan = true;
                    pesan = "Gagal menghapus data guest_book";
                    System.out.println(pesan);
                    }
                    } else {
                    adaKesalahan = true;
                    pesan = "Tidak dapat melakukan koneksi keserver\n" +
                    koneksi.getPesanKesalahan();
                    System.out.println(pesan);
                    }
                } catch (SQLException ex) {
                System.out.println(ex);
                }
        }
        

        return !adaKesalahan;
    }

    
    public boolean updateCategory(int id) {
        boolean adaKesalahan = false;
        Connection connection;
        
        if ((connection = koneksi.getConnection()) != null) {
            int jumlahSimpan = 0;
            boolean simpan = false;
            Statement sta;
            ResultSet rset;
            
            try {
            simpan = true;
            String SQLStatemen = "update categories set category_name='" + caname + "',category_description='" + cadetail + "' where category_id=" + id + " ";
            sta = connection.createStatement();
            jumlahSimpan = sta.executeUpdate(SQLStatemen);
            if (simpan) {
            if (jumlahSimpan < 1) {
            adaKesalahan = true;
            pesan = "Gagal menyimpan data guest_book";
            System.out.println(pesan);
            }
        } else {
            adaKesalahan = true;
            pesan = "Tidak dapat melakukan koneksi keserver\n" +
           koneksi.getPesanKesalahan();
            System.out.println(pesan);
            }
            } catch (SQLException ex) {
            System.out.println(ex);
            }
        }
    return !adaKesalahan;
    }
    
    
    public boolean updateProm(int id) {
        boolean adaKesalahan = false;
        Connection connection;
        
        if ((connection = koneksi.getConnection()) != null) {
            int jumlahSimpan = 0;
            boolean simpan = false;
            Statement sta;
            ResultSet rset;
            
            try {
            simpan = true;
            String SQLStatemen = "update promotion set product_id='" + idpromo + "' where promotion_id=" + id + " ";
            sta = connection.createStatement();
            jumlahSimpan = sta.executeUpdate(SQLStatemen);
            if (simpan) {
            if (jumlahSimpan < 1) {
            adaKesalahan = true;
            pesan = "Gagal menyimpan data guest_book";
            System.out.println(pesan);
            }
        } else {
            adaKesalahan = true;
            pesan = "Tidak dapat melakukan koneksi keserver\n" +
           koneksi.getPesanKesalahan();
            System.out.println(pesan);
            }
            } catch (SQLException ex) {
            System.out.println(ex);
            }
        }
    return !adaKesalahan;
    }
    
    
    public boolean updateBook(int id) {
        boolean adaKesalahan = false;
        Connection connection;
        
        if ((connection = koneksi.getConnection()) != null) {
            int jumlahSimpan = 0;
            boolean simpan = false;
            Statement sta;
            ResultSet rset;
            
            try {
            simpan = true;
            String SQLStatemen = "update books set title='" + namebook + "',"
                    + "author='" + autorbook + "',"
                    + "description='" + desbook + "',"
                    + "price='" + pricebook + "',"
                    + "category_id='" + catebook + "',"
                    + "image='" + imgbook + "' where product_id=" + id + " ";
            sta = connection.createStatement();
            jumlahSimpan = sta.executeUpdate(SQLStatemen);
            if (simpan) {
            if (jumlahSimpan < 1) {
            adaKesalahan = true;
            pesan = "Gagal menyimpan data guest_book";
            System.out.println(pesan);
            }
        } else {
            adaKesalahan = true;
            pesan = "Tidak dapat melakukan koneksi keserver\n" +
           koneksi.getPesanKesalahan();
            System.out.println(pesan);
            }
            } catch (SQLException ex) {
            System.out.println(ex);
            }
        }
    return !adaKesalahan;
    }
    
    
}
