package com.StepsJdbc;
import java.sql.*;
import java.util.Scanner;

public class StudentDemo {

	public static void main(String[] args) {
		Scanner t=new Scanner(System.in);
		Connection cn=null;
		PreparedStatement pst=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=abcd&useSSL=false");
			String qu="insert into  studentdatabase.studenttable values(?,?,?,?)";
			pst=cn.prepareStatement(qu);//platform created--->compillation---->data may not be present
			int r=0;
			do {
				System.out.println("Enter name , rollnum,SSC% and HSC%");
				String na=t.next();
				int rollnum=t.nextInt();
				double SSCPercentage=t.nextDouble();
				double HSCPercentage=t.nextDouble();
				pst.setString(1, na);
				pst.setInt(2, rollnum);
				pst.setDouble(3, SSCPercentage);
				pst.setDouble(4, HSCPercentage);
				pst.executeUpdate();
				System.out.println("Data Inserted");
				System.out.println("press 1 for inseting one more record");
				r=t.nextInt();
				
			}
			while(r==1);
}catch(ClassNotFoundException |SQLException e) {
	e.printStackTrace();
}

}
}
