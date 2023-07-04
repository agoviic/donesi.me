package Core;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Resturant implements Serializable {
	
	private static final long serialVersionUID = 6323567925916817908L;
	private String name;
	private String address;
	private Set<Food> food;
	private List<Drink> drink;

	public Resturant(String name, String address) {
		super();
		this.name = name;
		this.address = address;
		this.food = new HashSet<>();
		this.drink = new LinkedList<>();
	}

	public boolean addFood(Food f) {
		return food.add(f);
	}

	public boolean addDrink(Drink d) {
		if (drink.contains(d)) {
			return false;
		}
		return drink.add(d);
	}

	public String showFood() {
		String s = "";
		s += name + ", " + address + ", hrana:\n";
		Iterator<Food> i = food.iterator();
		while (i.hasNext()) {
			s += i.next() + "\n";
		}

		return s;
	}

	public String showDrink() {
		String s = "";
		s += name + ", " + address + ", pica:\n";
		Iterator<Drink> i = drink.iterator();
		while (i.hasNext()) {
			s += i.next() + "\n";
		}
		return s;
	}

	public void serialize(String fileName) {
		try {
			ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(fileName));
			int counter = 0;
			for (Food f : food) {
				counter++;
			}
			o.writeInt(counter);
			for (Food f : food) {
				o.writeObject(f);
			}
			o.flush();
			o.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void deserialize(String fileName) {
		try {
			ObjectInputStream o = new ObjectInputStream(new FileInputStream(fileName));
			int counter = o.readInt();
			for (int i = 0; i < counter; i++) {
				System.out.println((Food) o.readObject());
			}
			o.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Set<Food> getFood() {
		return food;
	}

	public void setFood(Set<Food> food) {
		this.food = food;
	}

	public List<Drink> getDrink() {
		return drink;
	}

	public void setDrink(List<Drink> drink) {
		this.drink = drink;
	}

	@Override
	public String toString() {
		return "Resturant: " + name + ", address: " + address;
	}

}
