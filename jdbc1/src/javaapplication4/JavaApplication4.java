package javaapplication4;

import java.sql.*;

public class JavaApplication4 {
     Connection conn = null; //Bağlantı nesnemiz
     String url = "jdbc:mysql://localhost:3306/";//veritabanının adresi ve portu
     String dbName = "vt"; //veritabanının ismi
     String driver = "com.mysql.jdbc.Driver";//mySQL ile Java arasındaki bağlantıyı sağlayan JDBC sürücüsü
     String userName = "root"; //veritabanı için kullanıcı adı
     String password = "1234"; //kullanıcı şifresi
     ResultSet res; // sorgulardan dönecek kayıtlar (sonuç kümesi) bu nesne içerisinde tutulacak
    
    public void baglantiAc() throws Exception{
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url + dbName , userName , password);
            Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            res = st.executeQuery("SELECT * FROM kisiler");
    }
    
    public static void main(String[] args) {
        JavaApplication4 a = new JavaApplication4();
        try{
            a.baglantiAc();
            a.res.next();
            
            do{
                System.out.println(a.res.getString("Ad"));
            }while(a.res.next());
            
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
    
}
