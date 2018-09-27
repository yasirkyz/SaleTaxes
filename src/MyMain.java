import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyMain {

	public static void main(String[] args) {
		
		List<Item> items = new ArrayList<>();
		double salesTaxes = 0;
		double totalPrice = 0;
		
		//For choosing a specific input from console
		Scanner scanner = new Scanner(System.in);
	    String option = null;
		showMenu();
		option = scanner.nextLine();
		
		switch(option) {
		case "1" :
			System.out.println("option 1 selected");
			//Item(name of Item,Number of items, price, boolean for imported,
			// boolean for basic sales tax on the basis of name)
			Item x1 = new Item("book",2,12.49,false,false);
			Item x2 = new Item("music CD",1,14.99,false,true);
			Item x3 = new Item("chocolate bar",1,0.85,false,false);
			items.add(x1);
			items.add(x2);
			items.add(x3);
			break;
		
		case "2" :
			System.out.println("option 2 selected");
			Item y1 = new Item("box of chocolates",1,10.00,true,false);
			Item y2 = new Item("bottle of perfume",1,47.50,true,true);
			items.add(y1);
			items.add(y2);
			break;
			
		case "3" :
			System.out.println("option 3 selected");
			Item z1 = new Item("bottle of perfume",1,27.99,true,true);
			Item z2 = new Item("bottle of perfume",1,18.99,false,true);
			Item z3 = new Item("packet of headache pills",1,9.75,false,false);
			Item z4 = new Item("box of chocolates",3,11.25,true,false);
			items.add(z1);
			items.add(z2);
			items.add(z3);
			items.add(z4);
			break;
			
		default :
			System.out.println("Invalid Option");
		}
	    scanner.close();
		System.out.println("OUTPUT :");
		for(Item x: items) {
			System.out.println(x);
			salesTaxes += x.getTaxes();
			totalPrice += x.getTotalPrice();
		}
		DecimalFormat f = new DecimalFormat("##.00");
		System.out.println("Sales Taxes: " + f.format(salesTaxes));
		System.out.println("Total: " + f.format(totalPrice));

	}
	
	private static void showMenu() {
		System.out.println("1: Input 1");
		System.out.println("2: Input 2");
		System.out.println("3: Input 3");
		System.out.println("SELECT THE OPTION :");
		
	}

}
