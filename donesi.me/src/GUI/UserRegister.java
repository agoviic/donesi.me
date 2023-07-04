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
import javax.swing.border.EmptyBorder;

public class UserRegister extends JFrame {

	private static final long serialVersionUID = -3262375787755523786L;
	private JPanel contentPane;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JLabel lblEmail;
	private JTextField textFieldusername;
	private JTextField textFieldEmail;
	private JPasswordField passwordField;
	private JButton btnRegister;
	private JLabel lblIcon;
	private JLabel lblname;
	private JLabel lblbackground;
	DatabaseConnection db = new DatabaseConnection("jdbc:mysql://localhost/donesi", "root", "");

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserRegister frame = new UserRegister();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public UserRegister() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 424, 276);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblUsername());
		contentPane.add(getLblPassword());
		contentPane.add(getLblEmail());
		contentPane.add(getTextFieldusername());
		contentPane.add(getTextFieldEmail());
		contentPane.add(getPasswordField());
		contentPane.add(getBtnRegister());
		contentPane.add(getLblIcon());
		contentPane.add(getLblname());
		contentPane.add(getLblbackground());
	}

	private JLabel getLblUsername() {
		if (lblUsername == null) {
			lblUsername = new JLabel("Username:");
			lblUsername.setForeground(Color.WHITE);
			lblUsername.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblUsername.setBounds(143, 86, 69, 14);
		}
		return lblUsername;
	}

	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password:");
			lblPassword.setForeground(Color.WHITE);
			lblPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblPassword.setBounds(143, 114, 69, 14);
		}
		return lblPassword;
	}

	private JLabel getLblEmail() {
		if (lblEmail == null) {
			lblEmail = new JLabel("E-mail:");
			lblEmail.setForeground(Color.WHITE);
			lblEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblEmail.setBounds(143, 149, 69, 14);
		}
		return lblEmail;
	}

	private JTextField getTextFieldusername() {
		if (textFieldusername == null) {
			textFieldusername = new JTextField();
			textFieldusername.setBounds(222, 83, 124, 20);
			textFieldusername.setColumns(10);
		}
		return textFieldusername;
	}

	private JTextField getTextFieldEmail() {
		if (textFieldEmail == null) {
			textFieldEmail = new JTextField();
			textFieldEmail.setColumns(10);
			textFieldEmail.setBounds(222, 146, 124, 20);
		}
		return textFieldEmail;
	}

	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setBounds(222, 114, 124, 16);
		}
		return passwordField;
	}

	private JButton getBtnRegister() {
		if (btnRegister == null) {
			btnRegister = new JButton("Registruj se");
			btnRegister.setBackground(new Color(153, 102, 51));
			btnRegister.setForeground(Color.WHITE);
			btnRegister.setBounds(173, 189, 106, 23);
			btnRegister.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					String s = "";
					for (int i = 0; i < passwordField.getPassword().length; i++) {
						s += passwordField.getPassword()[i];
					}
					if (getTextFieldusername().getText().equals("") || getTextFieldEmail().getText().equals("")
							|| s.equals("")) {
						JOptionPane.showMessageDialog(contentPane, "Morate popuniti sva polja!", "Greska",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
					db.addToUser(getTextFieldusername().getText(), getTextFieldEmail().getText(), s);
					contentPane.setVisible(false);
					ProductSelection ps = new ProductSelection();
					ps.setVisible(true);
					return;
				}
			});
		}
		return btnRegister;
	}

	private JLabel getLblbackground() {
		if (lblbackground == null) {
			lblbackground = new JLabel("");
			lblbackground
					.setIcon(new ImageIcon(UserRegister.class.getResource("/img/wallpaperflare.com_wallpaper.jpg")));
			lblbackground.setBounds(0, 0, 408, 237);
		}
		return lblbackground;
	}

	private JLabel getLblIcon() {
		if (lblIcon == null) {
			lblIcon = new JLabel("");
			lblIcon.setIcon(new ImageIcon(UserRegister.class.getResource("/img/delivery-man.png")));
			lblIcon.setBounds(10, 30, 128, 128);
		}
		return lblIcon;
	}

	private JLabel getLblname() {
		if (lblname == null) {
			lblname = new JLabel("dostavi.me");
			lblname.setForeground(Color.WHITE);
			lblname.setToolTipText("");
			lblname.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 24));
			lblname.setBounds(204, 30, 142, 30);
		}
		return lblname;
	}
}
