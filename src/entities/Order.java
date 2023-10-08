package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

  private static SimpleDateFormat sdf1 = new SimpleDateFormat(
    "dd/MM/yyyy HH:mm:ss"
  );
  private static SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
  private Date momentDate = new Date();
  private OrderStatus status;
  List<OrderItem> listOrdemItem = new ArrayList<>();
  private Client client;

  public Order(OrderStatus status, Client client) {
    this.status = status;
    this.client = client;
  }

  public void addItem(OrderItem item) {
    listOrdemItem.add(item);
  }

  public void removeItem(OrderItem item) {
    listOrdemItem.remove(item);
  }

  public OrderStatus getStatus() {
    return status;
  }

  public void setStatus(OrderStatus status) {
    this.status = status;
  }

  public Date getMomentDate() {
    return momentDate;
  }

  public List<OrderItem> getListOrdemItem() {
    return listOrdemItem;
  }

  public Client getClient() {
    return client;
  }

  public double total() {
    Double total = 0.0;
    for (OrderItem item : listOrdemItem) {
      total += item.subTotal();
    }
    return total;
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Order moment: " + sdf1.format(momentDate) + "\n");
    sb.append("Order status: " + getStatus() + "\n");
    sb.append(
      "Client: " +
      client.getName() +
      " (" +
      sdf2.format(client.getBirthDate()) +
      ") - " +
      client.getEmail() +
      "\n"
    );
    sb.append("Order items: \n");
    for (OrderItem item : listOrdemItem) {
      sb.append(item + "\n");
    }
    sb.append("Total price: $" + total());
    return sb.toString();
  }
}
