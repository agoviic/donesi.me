package Core;

public class Main {
	
	public static void main(String[] args) {
		Food f1 = new Food("Piletina", 2.8);
		Food f2 = new Food("Tortilje",  3.3);
		Food f3 = new Food("Sendvic", 4.1);
		Food f4 = new Food("Pizza", 3.4);

		Drink d1 = new Drink("Coca Cola", 2.5);
		Drink d2 = new Drink("Fanta", 2.5);
		Drink d3 = new Drink("Caj", 1.5);
		Drink d4 = new Drink("Kafa", 1.5);

		
		Resturant r = new Resturant("Luda Kuca", "Ul. Marsala Tita bb");
		r.addFood(f1);
		r.addFood(f2);
		r.addFood(f3);
		r.addFood(f4);
		System.out.println(r.showFood());
		System.out.println();
		r.addDrink(d1);
		r.addDrink(d2);
		r.addDrink(d3);
		r.addDrink(d4);
		System.out.println(r.showDrink());
		System.out.println();
		r.serialize("file.txt");
		System.out.println("Deserialize:");
		r.deserialize("file.txt");
	}
	
	

}
