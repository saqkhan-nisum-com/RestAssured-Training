package api.payload;

import com.github.javafaker.DateAndTime;

public class Store {
	
	int id;
	int quantity;
	String shipDate;
	boolean isComplete;
    String status;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getShipDate() {
		return shipDate;
	}
	public void setShipDate(String shipDate) {
		this.shipDate = shipDate;
	}
	public boolean getisComplete() {
		return isComplete;
	}
	public void setisComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}
	

}
