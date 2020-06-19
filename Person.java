//This My Addreess Book Project 
public class Person{
	public String firstName;
	public String lastName;
	public String address;
	public String state;
	public long zipCode;
	public long phoneNumber;

	public Person(String firstName, String lastName, String address, String state, long zipCode, long phoneNumber){
		this.firstName = firstName;
        	this.lastName = lastName;
        	this.address = address;
        	this.state = state;
        	this.zipCode = zipCode;
        	this.phoneNumber = phoneNumber;
	}

	public void readEntry(){
		System.out.print(firstName);
		System.out.print("\t\t"+lastName);
		System.out.print("\t\t"+address);
		System.out.print("\t\t"+state);
		System.out.print("\t\t"+zipCode);
		System.out.print("\t\t"+phoneNumber);
	}


	public String writePerson(){
		String str = firstName+"\t"+lastName+"\t"+address+"\t"+state+"\t"+zipCode+"\t"+phoneNumber;
		return str;
	}


	public static void main(String[] args){
		System.out.println("Welcome To My Address");
		String str = "ABC";
		System.out.println(str.compareTo("DEF"));
	}
}
