import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.*;

public class Addressmanage{
	public static void main(String[] ars)throws Exception{
                int choice = 1;
                Scanner sc = new Scanner(System.in);
                Addressbook addressBook = new Addressbook();
                addressBook.readData();
                while(choice != 0){
                	System.out.println("\n==================Menu==================");
        			System.out.println("|\t1.Add Address\t\t\t|"); 
        			System.out.println("|\t2.Delete Address\t\t\t|");
        			System.out.println("|\t3.Edit Address\t\t|");
        			System.out.println("|\t4.Display All Address\t\t|");
        			System.out.println("|\t5.Sort Address\t\t\t|");
        			System.out.println("|\t6.Save AddressBook\t\t|"); 
        			System.out.println("|\t0.Enter any number to exit\t|");
        			System.out.println("========================================");
                	                        choice = sc.nextInt();
                        if (choice == 1)
                                addressBook.addPerson();
                        if (choice == 2)
                                addressBook.deletePerson();
                        if(choice == 3)
                                addressBook.editPerson();
                        if (choice == 4)
                                addressBook.displayData();
                        if (choice == 5)
                                addressBook.sortAddressBook();
                        if (choice == 6)
                                addressBook.save();
                        if(choice == 0)
                                break;
                }
        }
}
