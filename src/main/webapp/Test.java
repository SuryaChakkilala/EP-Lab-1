package webapp;

import java.util.Scanner;

public class Test {
	private static final Scanner s = new Scanner(System.in);
	
	private static void displayMenu() {
		System.out.println("1. Insert 1 record");
		System.out.println("2. Insert 5 records");
		System.out.println("3. Display all records");
		System.out.println("4. Update address");
		System.out.println("5. Delete entry from table");
	}
	
	private static int getChoice() {
		displayMenu();
		System.out.println("Enter your choice: ");
		int choice = s.nextInt();
		return choice;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		boolean isRunning = true;
		while(isRunning) {
			int personid, id, c=0;
			String fn, ln, ad, ci;
			switch(getChoice()) {
			case 1:
				System.out.println("Enter personid: ");
				personid = s.nextInt();
				System.out.println("Enter First name: ");
				fn = s.next();
				System.out.println("Enter Last name: ");
				ln = s.next();
				System.out.println("Enter Address: ");
				ad = s.next();
				System.out.println("Enter city: ");
				ci = s.next();
				System.out.println(DBOperations.insertPerson(new Person(personid, fn, ln, ad, ci)) + " records inserted");
				break;
			case 2:
				for(int i=0;i<5;i++) {
					System.out.println("Enter personid: ");
					personid = s.nextInt();
					System.out.println("Enter First name: ");
					fn = s.next();
					System.out.println("Enter Last name: ");
					ln = s.next();
					System.out.println("Enter Address: ");
					ad = s.next();
					System.out.println("Enter city: ");
					ci = s.next();
					DBOperations.insertPerson(new Person(personid, fn, ln, ad, ci));
					c += 1;
				}
				System.out.println(c + " records inserted");
				c = 0;
				break;
			case 3: 
				DBOperations.getPersons().stream().forEach(person -> {
					System.out.println(person);
				});
				break;
			case 4: 
				System.out.println("Enter old id: ");
				id = s.nextInt();
				System.out.println("Enter personid: ");
				personid = s.nextInt();
				System.out.println("Enter First name: ");
				fn = s.next();
				System.out.println("Enter Last name: ");
				ln = s.next();
				System.out.println("Enter Address: ");
				ad = s.next();
				System.out.println("Enter city: ");
				ci = s.next();
				System.out.println(DBOperations.updatePersonById(id, personid, fn, ln, ad, ci) + " record(s) updated");
				break;
			case 5:
				System.out.println("Enter id: ");
				id = s.nextInt();
				System.out.println(DBOperations.deletePersonById(id) + " record(s) deleted");
				break;
			default:
				System.out.println("Ended.");
				isRunning = false;
			}
		}
		s.close();
	}
}
