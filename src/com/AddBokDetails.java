package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class AddBokDetails 
{
 public static void main(String[] args) 
 { 
	 
   try
   {
	   Scanner sc=new Scanner(System.in);
	   Class.forName("oracle.jdbc.driver.OracleDriver");
	   Connection con=DriverManager.getConnection
		("jdbc:oracle:thin:@localhost:1521:orcl","system","abc");
	   Statement stm=con.createStatement();
	  
	    while(true)
	    {
	      System.out.println("\n1.AddBookDetails"+"\n2.View BookDetails"+ "\n3.exit");
	      
	     switch(Integer.parseInt(sc.nextLine()))
	     {
	     case 1:
	    	 System.out.println("Enter the Book Code");
	    	 String Bcode=sc.nextLine();
	    	 System.out.println("Enter the Book Name");
	    	 String Bname=sc.nextLine();
	    	 System.out.println("Enter the Book Price");
	    	 float Bprice=Float.parseFloat(sc.nextLine());
	    	 System.out.println("Enter the Book Quentity");
	    	 int Bqty=Integer.parseInt(sc.nextLine());
	    	 System.out.println("Enter the Book Auther");
	    	 String BAuth=sc.nextLine();
	    	int k= stm.executeUpdate
	    	 ("insert into BookDetails51 values('"+Bcode+"','"+Bname+"',"+Bprice+","+Bqty+",'"+BAuth+"' )");
	    	 if(k>0)
	    	 {
	    		  System.out.println("BookDetails updata successfully..");
	    	 }
	    	 break;
	     case 2:
	    	 ResultSet rs=stm.executeQuery("select * from BookDetails51");
	    	 while(rs.next())
	    	 {
	    		  System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getFloat(3)+"\t"+rs.getInt(4)+"\t"+rs.getString(5));
	    		  
	    	 }
	    	 
	    	 break;
	     case 3:
	    	 System.exit(0);
	    	 break;
	    	 
	    	 default :
	    		 System.out.println("Invalid Choice...");
	    	 
	     }
	     
	    }
	    
   }catch(Exception e) {e.printStackTrace();
}
}
}