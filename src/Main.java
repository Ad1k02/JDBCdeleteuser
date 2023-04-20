import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
public class Main {
    static final String DB_URL = "jdbc:postgresql://localhost:5432/test_db";
    static final String USER = "postgres";
    static final String PASS = "123";
    static final String QUERY = "Select id, login, fullname, age FROM users";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(QUERY)){
            while(rs.next()){
                System.out.println("ID      :" + rs.getInt("id"));
                System.out.println("Age     :" + rs.getInt("age"));
                System.out.println("Login   :" + rs.getString("login"));
                System.out.println("Fullname:" + rs.getString("fullname"));
                System.out.println();
            }
            int rows = stmt.executeUpdate("delete from users where id = 11");
            System.out.printf("Удалено!", rows);
        }
        catch (SQLException e){
            e.printStackTrace();
        }


        System.out.println();
        System.out.println("Обновлённая версия:");
        System.out.println();



        try (Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(QUERY)){
            while(rs.next()){
                System.out.println("ID      :" + rs.getInt("id"));
                System.out.println("Age     :" + rs.getInt("age"));
                System.out.println("Login   :" + rs.getString("login"));
                System.out.println("Fullname:" + rs.getString("fullname"));
                System.out.println();
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }



}