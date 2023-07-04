package GUI;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class UserLogin extends JFrame {

	private static final long serialVersionUID = 3555596759357152442L;
	private JPanel contentPane;
	private JLabel lblUserName;
	private JLabel lblPassword;
	private JTextField textFieldUsername;
	private JButton btnLogin;
	private JPasswordField passwordField;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblRegisterLabel;
	private JButton btnNewButton;
	private JLabel lblNewLabel;
	DatabaseConnection db = new DatabaseConnection("jdbc:mysql://localhost/donesi", "root", "");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserLogin frame = new UserLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserLogin() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 466, 260);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 102, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblUserName());
		contentPane.add(getLblPassword());
		contentPane.add(getTextFieldUsername());
		contentPane.add(getBtnLogin());
		contentPane.add(getPasswordField());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getLblNewLabel_2());
		contentPane.add(getLblRegisterLabel());
		contentPane.add(getBtnNewButton());
		contentPane.add(getLblNewLabel());

	}

	private JLabel getLblUserName() {
		if (lblUserName == null) {
			lblUserName = new JLabel("Korisnicko ime : ");
			lblUserName.setForeground(new Color(255, 255, 255));
			lblUserName.setBackground(new Color(248, 248, 255));
			lblUserName.setFont(new Font("Cambria", Font.BOLD, 13));
			lblUserName.setBounds(169, 83, 101, 14);
		}
		return lblUserName;
	}

	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Lozinka :");
			lblPassword.setForeground(new Color(255, 255, 255));
			lblPassword.setBackground(new Color(248, 248, 255));
			lblPassword.setFont(new Font("Cambria", Font.BOLD, 13));
			lblPassword.setBounds(209, 108, 57, 14);
		}
		return lblPassword;
	}

	private JTextField getTextFieldUsername() {
		if (textFieldUsername == null) {
			textFieldUsername = new JTextField();
			textFieldUsername.setBounds(276, 81, 129, 20);
			textFieldUsername.setColumns(10);
		}
		return textFieldUsername;
	}

	private JButton getBtnLogin() {
		if (btnLogin == null) {
			btnLogin = new JButton("Login");
			btnLogin.setBackground(new Color(153, 102, 51));
			btnLogin.setForeground(new Color(255, 255, 255));
			btnLogin.setFont(new Font("Cambria", Font.BOLD, 12));
			btnLogin.setBounds(299, 137, 89, 23);

			/// USERNAME : user /// PASSWORD : user ///
			btnLogin.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					String s = "";
					for (int i = 0; i < passwordField.getPassword().length; i++) {
						s += passwordField.getPassword()[i];
					}

					String[] sql = db.findUser(textFieldUsername.getText(), s).split("/");

					if (textFieldUsername.getText().equals("") || !textFieldUsername.getText().equals(sql[0])) {
						JOptionPane.showMessageDialog(contentPane, "Pogresan username ili password", "Greska",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
					if (s.equals("") || !s.equals(sql[1])) {
						JOptionPane.showMessageDialog(contentPane, "Pogresan username ili password", "Greska",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
					contentPane.setVisible(false);
					ProductSelection p = new ProductSelection();
					p.setVisible(true);
					return;

				}
			});
		}
		return btnLogin;

	}

	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setBounds(276, 106, 129, 20);
		}
		return passwordField;
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("dostavi.me");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 24));
			lblNewLabel_1.setForeground(new Color(255, 255, 255));
			lblNewLabel_1.setBounds(237, 27, 129, 27);
		}
		return lblNewLabel_1;
	}

	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.setIcon(new ImageIcon(UserLogin.class.getResource("/img/delivery-man.png")));
			lblNewLabel_2.setBounds(20, 27, 128, 133);
		}
		return lblNewLabel_2;
	}

	private JLabel getLblRegisterLabel() {
		if (lblRegisterLabel == null) {
			lblRegisterLabel = new JLabel("Nemate nalog?");
			lblRegisterLabel.setForeground(Color.WHITE);
			lblRegisterLabel.setFont(new Font("Calibri", Font.BOLD, 13));
			lblRegisterLabel.setBounds(20, 193, 89, 14);
		}
		return lblRegisterLabel;
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Registruj se!");
			btnNewButton.setBackground(new Color(153, 102, 51));
			btnNewButton.setForeground(new Color(255, 255, 255));
			btnNewButton.setOpaque(true);
			btnNewButton.setBounds(114, 187, 112, 23);
			btnNewButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					contentPane.setVisible(false);
					UserRegister ur = new UserRegister();
					ur.setVisible(true);
					return;
				}
			});
		}
		return btnNewButton;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(UserLogin.class.getResource("/img/wallpaperflare.com_wallpaper.jpg")));
			lblNewLabel.setBounds(0, 0, 450, 221);
		}
		return lblNewLabel;
	}
}
