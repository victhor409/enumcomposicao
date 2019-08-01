package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entites.Client;
import entites.Order;
import entites.OrderItem;
import entites.Product;
import entites.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		System.out.println("Enter clien data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email=sc.nextLine();
		System.out.print("Birth Date: ");
		Date birthDate = sdf.parse(sc.next()); 
		Client client = new Client(name,email,birthDate);
		
		System.out.println("Enter Order Data:");
		sc.nextLine();
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());//instancia o valor de da classe enum
		
		
		Order order = new Order(new Date(),status,client);
		
		System.out.println("How many items to this order?");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println("Enter # "+i+" item data:");
			System.out.print("Product Name:");
			String nameProduct=sc.nextLine();
			sc.nextLine();
			System.out.print("Product Price: ");
			double price=sc.nextDouble();
			
			Product product = new Product(nameProduct,price);
			
			System.out.print("Quantity: ");
			int quantity=sc.nextInt();
			
			OrderItem orderitem = new OrderItem(quantity,price,product);
			
			order.addItem(orderitem);
		}
		
		System.out.println("Order Summary:");
		System.out.println(order);
		
		
		
		
		sc.close();
	}

}
