package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

  private Date momentDate = new Date();
  private OrderStatus status;
  List<OrderItem> listOrdemItem = new ArrayList<>();

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

  public double total() {
    Double total = 0.0;
    for (OrderItem item : listOrdemItem) {
      total += item.subTotal();
    }
    return total;
  }
}
