package GUI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
	private String url;
	private String user;
	private String pass;

	public DatabaseConnection(String url, String user, String pass) {
		this.url = url;
		this.user = user;
		this.pass = pass;
	}

	public Connection open() {
		try {
			return DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			System.out.println("Greska! Ne moze se konektovati na bazu!");
			return null;
		}
	}

	public boolean close(Connection c) {
		try {
			c.close();
			return true;
		} catch (SQLException e) {
			System.out.println("Greska! Ne moze se zatvoriti konekcija!");
			return false;
		}
	}

	public int getResturantID(String name) {
		Connection conn = open();
		int i = 0;
		String sql = "SELECT id FROM resturant WHERE name LIKE ('" + name + "');";
		Statement st;
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				i = rs.getInt("id");
			}
			close(conn);
			return i;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	public int getFoodID(String name) {
		Connection conn = open();
		int i = 0;
		String sql = "SELECT id FROM food WHERE name LIKE ('" + name + "');";
		Statement st;
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				i = rs.getInt("id");
			}
			close(conn);
			return i;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	public int getDrinkID(String name) {
		Connection conn = open();
		int i = 0;
		String sql = "SELECT id FROM drink WHERE name LIKE ('" + name + "');";
		Statement st;
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				i = rs.getInt("id");
			}
			close(conn);
			return i;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	public String insertResturant() {
		String name = "";
		Connection conn = open();
		String sql = "SELECT name FROM `resturant` WHERE name IS NOT NULL";
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				name += rs.getString("name") + "/";
			}
			close(conn);
			if (name == "") {
				return "";
			}
			return name;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String insertFood(String name) {
		int a = getResturantID(name);
		String s = "";
		Connection conn = open();
		String sql = "SELECT name FROM `food` WHERE resturant_id = '" + a + "'";
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				s += rs.getString("name") + "/";
			}
			close(conn);
			if (s == "") {
				return "";
			}
			return s;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String insertDrink(String name) {
		int a = getResturantID(name);
		String s = "";
		Connection conn = open();
		String sql = "SELECT name FROM `drink` WHERE resturant_id = '" + a + "'";
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				s += rs.getString("name") + "/";
			}
			close(conn);
			if (s == "") {
				return "";
			}
			return s;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public double foodPrice(String name) {
		int a = getFoodID(name);
		Connection conn = open();
		double i = 0;

		String sql = "SELECT price FROM food WHERE id = " + a + ";";
		Statement st;
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				i = rs.getDouble("price");
			}
			close(conn);
			return i;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	public double drinkPrice(String name) {
		int a = getDrinkID(name);
		Connection conn = open();
		double i = 0;

		String sql = "SELECT price FROM drink WHERE id = " + a + ";";
		Statement st;
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				i = rs.getDouble("price");
			}
			close(conn);
			return i;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	public boolean addToOrder(String name, String food, String drink, int pieces, double price) {
		int a = getResturantID(name);
		int b = getFoodID(food);
		int c = getDrinkID(drink);
		Connection conn = open();

		String sql = "INSERT INTO orders (`id`, `resturant_id` , `food_id`, `drink_id`, `pieces`, `price`) VALUES (NULL, '"
				+ a + "', '" + b + "', '" + c + "', '" + pieces + "', '" + price + "')";
		try {
			Statement st = conn.createStatement();
			st.executeUpdate(sql);
			close(conn);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean addToUser(String name, String email, String password) {
		Connection conn = open();

		String sql = "INSERT INTO user (`id`, `username` , `email`, `password`) VALUES (NULL, '" + name + "', '" + email
				+ "', '" + password + "')";
		try {
			Statement st = conn.createStatement();
			st.executeUpdate(sql);
			close(conn);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public String findOrder() {

		String s = "";
		Connection conn = open();
		String sql = "SELECT f.name, d.name, o.price FROM food f, drink d, orders o WHERE f.id = (SELECT food_id FROM orders WHERE id = (SELECT MAX(id) FROM orders)) AND d.id = (SELECT drink_id FROM orders WHERE id = (SELECT MAX(id) FROM orders)) AND o.food_id = f.id AND o.drink_id = d.id";
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				s += rs.getString("f.name") + "/" + rs.getString("d.name") + "/" + rs.getDouble("o.price") + "/";
			}
			close(conn);
			if (s == "") {
				return "";
			}
			return s;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String findUser(String name, String password) {
		String s = "";
		Connection conn = open();
		String sql = "SELECT username, password FROM user WHERE username LIKE '" + name + "' AND password LIKE '"
				+ password + "';";
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				s += rs.getString("username") + "/" + rs.getString("password");
			}
			close(conn);
			if (s == "") {
				return "";
			}
			return s;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
