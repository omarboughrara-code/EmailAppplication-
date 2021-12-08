package EmailApplication;
import java.util.* ;

public class EmailApp {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		// user info 
		System.out.println("Enter first name:");
		String f_name=s.next();
		System.out.println("Enter last name:");
		String l_name=s.next();
		
		// creating object for email class 
		Email em1=new Email(f_name ,l_name);
		int choice=-1;
				do {
					System.out.println("\n********\n entrer your choice\n1.Show Info\n2.Change passsword\n3.change mailbox capacity\n4.set Alternate mail\n5.dtore data in file\n6.display data from file\n7.Exit");
					choice = s.nextInt();
					switch(choice) {
					case 1:
						em1.getInfo();
						break;
					case 2:
						em1.set_password();
						break;
					case 3:
						em1.set_mailCap();
						break;
					case 4:
						em1.alternate_email();
						break;
					case 5:
						em1.storefile();
						break;
					case 6:	
						em1.read_file();
						break;
					case 7:
						System.out.println("thank you for using appplication....");
						break;
					default :
						System.out.println("invalid choice entre propre  choice again ...");
						
					
					
					}
					
					
					
				}while (choice!=7) ;
		
		
		}
	

	
	
	
	
	
	
}
