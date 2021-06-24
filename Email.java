package eMail;
import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String department;
	private String password;
	private int mailBoxCapacity = 500;
	private String alternateEmail;
	private String email;
	private String companySuffix = "company.com";
	
	Scanner sc = new Scanner(System.in);
	// Constructor for taking the firstName and lastName
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		//System.out.println("Email created: "+this.firstName+" "+this.lastName);
		department = Department();
		//System.out.println("Department selected is: "+ department);
		
		this.password = randomPassword(8);
		System.out.println("Your password is :"+this.password);
		
		// Combine all together to generate our email:-
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() +"@" + department+"."+companySuffix;
		//System.out.println("Your Email id is "+email);
	}
	// set a random password
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789@#$%";
		char []password = new char[length];
		for(int i=0;i<length;i++) {
			int rand =(int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String( password);
	}
	//ask for department
	private String Department() {
		int choice;
		System.out.println("New User "+firstName+" Department Codes:\n 1=> Sales\n 2=> Accounting\n 3=>Developement\n 0=> None");
		choice = sc.nextInt();
		if(choice == 1)	return "sales";
		else if(choice == 2) return "accounting";
		else if(choice == 3) return "developement";
		else return "" ;
	}
	// Set the mail box capacity
	public void setMailCapacity(int capacity) {
		this.mailBoxCapacity = capacity; 
	}
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}
	
	//Change the password
	public void setPassword(String pass) {
		this.password = pass;
	}
	
	public int getMailBoxCapacity() {
		return this.mailBoxCapacity;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public String getAlterEmail() {
		return this.email;
		}
	
	public String show() {
		return "Display Name: "+ firstName +" " + lastName + "\n"
				+"Company Email " + email + "\n" +
				"Mail Box Capacity " + mailBoxCapacity +" mb";
	}
}
