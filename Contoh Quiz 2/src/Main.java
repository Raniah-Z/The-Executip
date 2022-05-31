import java.util.Scanner;
import java.util.Vector;

public class Main {
	
	Scanner scan = new Scanner(System.in);
	Vector<Dress> dresses = new Vector<Dress>();
	
	public void nextPage() {
		// TODO Auto-generated method stub
		System.out.println("\npress enter to continue..");
		scan.nextLine();
		for (int i = 0; i < 20; i++) {
			System.out.println("");
		}
	}
	
	public void menu() {
		// TODO Auto-generated method stub
		System.out.println("The Executip");
		System.out.println("=======================");
		System.out.println("1.	Insert new dress");
		System.out.println("2.	View all dresses");
		System.out.println("3.	Delete a dress");
		System.out.println("4.	Exit");	
		System.out.print(">> ");
	}
	
	public void insert() {
		System.out.println("pick which type of dress to insert: ");
		System.out.println("1. regular dress");
		System.out.println("2. limited edition dress");
		System.out.println("3. back");
		
		int choice = 0;
		
		do {
			System.out.print(">> ");
			try {
				choice = scan.nextInt();
			} catch (Exception e) {
				// TODO: handle exception
				choice = 0;
			} scan.nextLine();
		} while (choice < 1 || choice > 3);
		
		switch (choice) {
		case 1:
			dresses.add(new Regular());
			System.out.println("Successfully added a new Regular Dress!");
			break;
		case 2:
			dresses.add(new LimitedEdition());
			System.out.println("Successfully added a new Limited Edition Dress!");
			break;
		case 3:
			return;
		}
		
	}
	
	public void view() {
		if (dresses.isEmpty()) {
			System.out.println("No dresses available");
			return;
		} else {
			System.out.println("ID |\t name |\t fabric price |\t fabric type |\t discount |\t stock |\t total price");
			for (Dress dress : dresses) {
				System.out.print(dress.getID() + " |\t " + dress.getName() + " |\t " + dress.getFabricPrice() + " |\t " + dress.getFabricType());
				if (dress instanceof Regular) {
					System.out.println(" |\t " + ((Regular)dress).getDiscount() + " |\t " + "-" + " |\t " + dress.getTotalPrice());
				} else if (dress instanceof LimitedEdition) {
					System.out.println(" |\t " + "-" + " |\t " + ((LimitedEdition)dress).getStock() + " |\t " + dress.getTotalPrice());
				}
			}
		}
	}
	
	public int getIndex(String ID) {
		int i = 0;
		for (Dress dress : dresses) {
			if (dress.getID().equals(ID)) {
				return i;
			}
			i++;
		}
		return -1;
	}
	
	public void delete() {
		if (dresses.isEmpty()) {
			System.out.println("no dresses available");
			return;
		} else {
			view();
		}
		
		System.out.print("input dress id to delete: ");
		String input = scan.nextLine();
		
		int i = getIndex(input);
		if (i == -1) {
			System.out.println("dress id is invalid!!");
			return;
		} else {
			dresses.remove(i);
			System.out.println("Succesfully removed dress " + input + "!");
		}
	}

	public Main() {
		// TODO Auto-generated constructor stub
		do {
			menu();
			int choice = scan.nextInt();
			scan.nextLine();
			
			switch (choice) {
			case 1:
				insert();
				nextPage();
				break;
			case 2:
				view();
				nextPage();
				break;
			case 3:
				delete();
				nextPage();
				break;
			case 4:
				return;
			}
		} while (true);
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
