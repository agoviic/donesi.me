package Core;
import java.io.Serializable;

public class Food implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2134986906284879471L;

	private String name;
	private double price;

	public Food(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Food) {
			return ((Food) obj).getName().equals(name);
		}
		return false;
	}

	public String toString() {
		return name + ", " + price;
	}
}
