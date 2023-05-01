package tp5rmi;

import java.io.Serializable;

public class products implements Serializable {
	public String name;
	public int quantity;
	public products(String a,int b) {
		this.name = a;
		this.quantity =b;
	}
}
