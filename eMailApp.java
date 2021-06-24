package eMail;

public class eMailApp {

	public static void main(String[] args) {
		Email em1 = new Email("Ram","Gupta");
		
		em1.setMailCapacity(1200);
		em1.getMailBoxCapacity();
		
		em1.setPassword("CHIRAGGU");
		
		System.out.println(em1.show());
	}

}
