import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;
import java.io.FileWriter;
import java.io.*;

public class Addressbook{

	private ArrayList<Person> personArray;
	private int numberOfPerson = 0;
	public Scanner sc = new Scanner(System.in);

	public Addressbook(){
		personArray = new ArrayList<Person>();
	}

	public void readData()throws Exception{
		try{
			FileInputStream fstream = new FileInputStream("output");
    			DataInputStream in = new DataInputStream(fstream);
    			BufferedReader br = new BufferedReader(new InputStreamReader(in));
    			String data;
    			while ((data = br.readLine()) != null)   {
				String[] tmp = data.split("\t");    //Split space
				Person person = new Person( tmp[0], tmp[1], tmp[2], tmp[3], Long.parseLong(tmp[4]), Long.parseLong(tmp[5]));
				personArray.add(person);
    			}
		}catch (Exception ex){
			System.out.println("File Not Exist:");
		}
	}

	public Person takeUserInput()
	{
		System.out.print("\n Enter Person First Name: ");
                String firstName = sc.next();
                System.out.print("Enter Person Last Name: ");
                String lastName = sc.next();
                System.out.print("Enter Address: ");
                String address = sc.next();
                System.out.print("Enter State: ");
                String state = sc.next();
                System.out.print("Enter the Zip Code: ");
                long zipCode = sc.nextLong();
                System.out.print("Enter the Phone Number: ");
                long phoneNumber = sc.nextLong();
                Person person = new Person( firstName, lastName, address, state, zipCode, phoneNumber);
		return person;
	}

	public void addPerson(){
		Person person = takeUserInput();
		personArray.add(person);
		numberOfPerson++;
	}

	public int getPersonIndex(String name){
		int cnt = 0;
		while(cnt < personArray.size()){
                        if((personArray.get(cnt).firstName).equals(name)){
                                return cnt;
                        }
                        cnt++;
                }
		return cnt;
	}

	public void editPerson(){
		System.out.println("\n Enter name of person you want to Edit: ");
		String name = sc.next();
		int cnt = 0;
		cnt = getPersonIndex(name);
		if (cnt < personArray.size()){
			personArray.get(cnt).readEntry();
			Person person = takeUserInput();
			personArray.set(cnt, person);
			return;
		}
		System.out.println("Person not found");

	}

	public void displayData(){
		for (int i=0; i<personArray.size(); i++){
			System.out.println();
			personArray.get(i).readEntry();
		}
	}

	public void deletePerson(){
		System.out.println("\n Enter the name of person you want to Delete: ");
		String name = sc.next();
		int cnt = 0;
		cnt = getPersonIndex(name);
		if (cnt < personArray.size()){
			personArray.remove(cnt);
			return;
		}
		System.out.println("Person not found:");
	}

	public void sort(int n){
		for (int i = 0; i<personArray.size(); i++){
			for (int j = 0; j<personArray.size(); j++){
				switch(n){
					case 1:
						if (personArray.get(i).firstName.compareToIgnoreCase(personArray.get(j).firstName)<0){
							Person temp = personArray.get(i);
                            				personArray.set(i, personArray.get(j));
                           			 	personArray.set(j, temp);
                        			}
						break;
					case 2:
						if ( personArray.get(i).zipCode < personArray.get(j).zipCode){
							Person temp = personArray.get(i);
                                                        personArray.set(i, personArray.get(j));
                                                        personArray.set(j, temp);
						}
						break;
				}
			}
		}
	}

	public void sortAddressBook(){
		System.out.println("Enter your sorting Choice:");
		int choice = 0;
		System.out.println("1. Sort by Name \n2. Sort by ZipCode");
		choice = sc.nextInt();
		sort(choice);
	}

	public void save()throws IOException{
		FileWriter writer = new FileWriter("output");
		for(int i=0; i<personArray.size(); i++) {
		  	writer.write(personArray.get(i).writePerson()+System.lineSeparator());
		}
		writer.close();
	}
}
