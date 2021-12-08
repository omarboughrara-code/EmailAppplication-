package EmailApplication;
import java.util.*;
import java.io.*;
import java.io.File; 
public class Email {
   public Scanner s = new Scanner(System.in);//scanner class global
   //setting variables as private to not give directory 
   private String fname;
   private String lname;
   private String dept;
   private String email;
   private String password;
   private int mailCapacity=500;
   private String alter_email ;
   //constructor to receive first name ,last name 
   public Email(String fname , String lname) {
	 this.fname = fname ;
	 this.lname = lname ;
	 System.out.println("New Employee :"+this.fname+"  "+this.lname);	 
	 // calling methods
 	 this.dept=this.setDept();//Departement
	 this.password=this.generate_password(8);//password
	 this.alter_email=this.generate_email();//email generation 
	 
   }
   //Generate mail method 
   private String generate_email() {
	   return this.fname.toLowerCase()+"."+this.lname.toLowerCase()+"@"+this.dept.toLowerCase()+".company.com";           
   }
  // Asking for dept
   private String setDept(){
	   System.out.println("department codes \n1 for sales \n2 for development \n3 for Accounting \n0 for none ");
	   boolean flag = false ;
	   do {
		  System.out.println("Enter departement code");
		  int choice = s.nextInt();
		  switch (choice) {
		  case 1 :
			  return "sales" ;
		  case 2:
			  return "Development";
		  case 3:
			  return "Accounting";
		  case 0:
			  return "none" ;
		  default:
			  System.out.println("Invalid choice please choose it again");
			  
		  }
	   }while (!flag);
	   return null;
   }
   //Generte Random password method 
   private String generate_password(int length) {
	   Random r =new Random();
	   String Capital_chars="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	   String Small_chars="abcdefghijklmnopqrstuvwxyz";
	   String numbers="0123456789";
	   String symbols="!@#$%&?";
	   String values=Capital_chars+Small_chars+numbers+symbols ;
	   String password="";
	   for ( int i=0; i<length;i++) {
		   password = password+values.charAt(r.nextInt(values.length()));
	   }
	   return password ;
   }
   // change password method 
   public void set_password() {
	   boolean flag=false ;
	   do {
		   System.out.println("do you want to change your password!(Y/N)");
		   char choice= s.next().charAt(0);
		   if (choice=='y'||choice=='Y') {
			   flag = true ;
			   System.out.println("Enter current password: ");
			   String temp = s.next();
			   if(temp.equals(this.password)) {
				   System.out.println("enter a new password");
				   this.password=s.next();
				   System.out.println("password changed successfully");
			   }
			   else {
				   System.out.println("Incorrect password");
			   }
		    }else if (choice=='N'||choice =='n') {
				  System.out.println("password changed option cancelled ! ");
			   }
			   else {
				   System.out.println("entrer valid syntax");
			   
		   }
	   } while (!flag);
   }
   
   // set mailbox capacity method 
   public void set_mailCap() {
	   System.out.println("current capacity= "+this.mailCapacity+"mb");
	   System.out.println("entrer new mailbox capacity");
	   this.mailCapacity = s.nextInt();
	   System.out.println("mailbox capacity is successfully changed ");
   }
   //set alternative email 
   public void alternate_email() {
	   
	   System.out.println("enter new alternate email:");
	   this.alter_email=s.next(); 
	   System.out.println("alternate email is seet");
   }
   // display information method 
   public void getInfo() {
	   System.out.println("new:"+this.fname+"  "+this.lname);
	   System.out.println("departement :"+this.dept);
	   System.out.println("email :"+this.email);
	   System.out.println("password :"+this.password);
	   System.out.println("mailbox  capacity: "+this.mailCapacity+"mb");
	   System.out.println("alternate mail: "+this.alter_email);
	   
   }
  // store in file  
   public void storefile() {
	   try {
		   FileWriter in= new FileWriter("home/omar/eclipse-workspace/omar.txt");
		   in.write("first name: "+this.fname);
		   in.append("\n last name: "+this.lname);
		   in.append("\n Email: "+this.email);
		   in.append("\n Password: "+this.password);
		   in.append("\n Capacity : "+this.mailCapacity);
		   in.append("\n Alternate mail: "+this.alter_email);
		   in.close(); 
		   
		   
		   
	   }catch (Exception e) {System.out.println(e); }
   
   
}
   // reading file method 
   public void read_file() {
	   try {
		   FileReader f1= new FileReader("home/omar/eclipse-workspace/omar.txt");
		   int i ;
		   while((i=f1.read())!=-1) {
			   System.out.println((char)i );		   
		   }
	     System.out.println();
	     f1.close();
	   
	   
   }catch (Exception e) {System.out.println(e); }
   }  
}