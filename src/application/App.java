package application;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.OrderStatus;
import entities.Product;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class App {

  public static void main(String[] args) throws Exception {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter client data: ");
    System.out.print("Name: ");
    String name = sc.nextLine();
    System.out.print("Email: ");
    String email = sc.nextLine();
    System.out.print("Birth date (dd/MM/yyyy): ");
    Date date = sdf.parse(sc.nextLine());
    System.out.println("Enter order data: ");
    System.out.print("Status: ");
    String status = sc.nextLine();
    System.out.println("How many items to this order?");
    int quantityOrder = sc.nextInt();
    Order order = new Order(
      OrderStatus.valueOf(status),
      new Client(name, email, date)
      );
      for (int i = 1; i <= quantityOrder; i++) {
      sc.nextLine();
      System.out.println("Enter #" + i + " item data: ");
      System.out.print("Product name: ");
      name = sc.nextLine();
      System.out.print("Product price: ");
      double priceProduct = sc.nextDouble();
      System.out.print("Quantity: ");
      int quantity = sc.nextInt();
      OrderItem orderItem = new OrderItem(
        quantity,
        new Product(name, priceProduct)
      );
      order.addItem(orderItem);
    }
    System.out.println("ORDER SUMMARY: ");
    System.out.println(order);
  }
}
