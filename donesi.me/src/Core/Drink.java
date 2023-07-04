package Core;

public class Drink {

	private String name;
	private double price;

	public Drink(String name, double price) {
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
	public boolean equals(Object obj) {
		if (obj instanceof Drink) {
			return ((Drink) obj).getName().equals(name);
		}
		return false;
	}

	@Override
	public String toString() {
		return name + ", " + price;
	}

}
