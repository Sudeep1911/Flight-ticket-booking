package dbms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
public class JavaConnectionStudy {
    static Connection con;

    public static Connection getCon() throws Exception {
        if (con == null) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "sudeep2004");
        }
        return con;
    }

    public static void insertData(String sql) throws Exception {
        getCon().createStatement().executeUpdate(sql);
    }

    public ResultSet Select(int i) {
        ResultSet rs=null;
        if(i==2){
            try {
                rs = getCon().createStatement().executeQuery("select From_city from airline.domestic_flight");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        else if(i==3){
            try {
                rs = getCon().createStatement().executeQuery("select To_city from airline.domestic_flight");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        else if(i==4){
            try {
                rs = getCon().createStatement().executeQuery("select From_city from airline.international_flight");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        else if(i==5){
            try {
                rs = getCon().createStatement().executeQuery("select To_city from airline.international_flight");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return rs;
    }
}