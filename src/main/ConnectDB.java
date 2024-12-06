/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author rathe
 */
public class ConnectDB {
	public static Connection con=null;
	public static void connect() {
		String URL = "jdbc:mysql://localhost:3306/fbps";
		try{
		   Class.forName("com.mysql.cj.jdbc.Driver");
		   String username="root";
		   String password="root2005";
                    con = DriverManager.getConnection(URL,username,password);
                    if(con!=null) {
                        System.out.print("Connection established\n");
    	   }
    	   
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
		catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

	}
	public static void closecon() {
		try {
			con.close();
			System.out.print("\nConnection closed\n");
		}catch(SQLException e) {
			System.out.println("Error in closing connection!\n");
    }
			
	}
        public static void main(String[] args){
            connect();
            closecon();
        }


}

