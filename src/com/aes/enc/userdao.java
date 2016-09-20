package com.aes.enc;

import java.sql.*;

public class userdao {

   static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";

   static final String USER = "postgres";
   static final String PASS = "password";
    
   public boolean authenticate(String loggedusername, String loggedpassword) {
   Connection conn = null;
   Statement stmt = null;
   boolean status = false;
   try{
	   Class.forName("org.postgresql.Driver");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      stmt = conn.createStatement();
      String sqlstatement = "SELECT * FROM users where username = " + "'" + loggedusername + "'";   
      ResultSet rs = stmt.executeQuery(sqlstatement);
     

      while(rs.next()){
  
         int id  = rs.getInt("id");
         String dbUserName = rs.getString("username");
         String dbPassWord = rs.getString("password");

         System.out.print("ID: " + id);
         System.out.print(", username: " + dbUserName);
         System.out.println(", password: " + dbPassWord);
         
         if(dbUserName.equals(loggedusername) && dbPassWord.equals(loggedpassword)){
        	 System.out.println("Authorized user");
        	 status = true;
      
         }
        	 else{
        		 System.out.println("Unauthorized user");
        		 status = false;
        		
        	 }
         
      }
     
      rs.close();
      stmt.close();
      conn.close();
      
      return status;
   }
   
   
   /*catch (Exception e){
	   System.out.println("Exception occurred");
	   status = false;
	   return status;
   }
   */
   
   catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
      return status;
   
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
      return status;
   }finally{
      //finally block used to close resources
	 
      try{
    
         if(stmt!=null)
            stmt.close();
            return status;
      }catch(SQLException se2){

      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
    
     
      }catch(SQLException se){
         se.printStackTrace();
         return status;
       
      }//end finally try
   }//end try

   }
   
   public static void main (String args[]){
	   userdao a = new userdao();
	   boolean status = a.authenticate("aditya", "loggedpassword");
	   System.out.println("Status : "+status);
	   
	   
   }
}