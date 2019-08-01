package entites;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entites.enums.OrderStatus;

public class Order {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:MM:ss");
	
	private Date moment;
	private OrderStatus order;
	
	private Client client;
	
	private List <OrderItem> items= new ArrayList<>();
	
	public Order() {
		
	}

	public Order(Date moment, OrderStatus order,Client client) {
		this.moment = moment;
		this.order = order;
		this.client = client;
		
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getOrder() {
		return order;
	}

	public void setOrder(OrderStatus order) {
		this.order = order;
	}
	public Client getClient() {
		return client;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void addItem(OrderItem items) {
		this.items.add(items);
	}
	public void removeItem(OrderItem items) {
		this.items.remove(items);
	}
	
	public double Total() {
		double sum = 0.0;
		for (OrderItem item : items) {
			sum += item.subTotal();
		}
		return sum;
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Order moment: ");
		sb.append(moment+"\n");
		sb.append("Order Status: ");
		sb.append(order+"\n");
		sb.append(client +"\n");
		sb.append("Order itens: \n");
		for (OrderItem item : items) {
			sb.append(item +"\n");
		}
		sb.append("Total price: ");
		sb.append(String.format("%.2f",Total()));
		
		return sb.toString();
	}
	
}
