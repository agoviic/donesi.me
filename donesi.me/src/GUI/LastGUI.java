package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JButton;

public class LastGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JButton btnNewButton;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LastGUI frame = new LastGUI();
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
	public LastGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 466, 260);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getLblNewLabel_2());
		contentPane.add(getLblNewLabel_3());
		contentPane.add(getBtnNewButton());
		contentPane.add(getLblNewLabel_4());
		contentPane.add(getLblNewLabel_5());
		contentPane.add(getLblNewLabel());
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(LastGUI.class.getResource("/img/wallpaperflare.com_wallpaper.jpg")));
			lblNewLabel.setBounds(0, 0, 450, 221);
		}
		return lblNewLabel;
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon(LastGUI.class.getResource("/img/delivery-man.png")));
			lblNewLabel_1.setBounds(24, 30, 118, 128);
		}
		return lblNewLabel_1;
	}

	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("dostavi.me");
			lblNewLabel_2.setForeground(Color.WHITE);
			lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 24));
			lblNewLabel_2.setBounds(234, 41, 128, 30);
		}
		return lblNewLabel_2;
	}

	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel(" Priprema i dostava hrane \u0107e\r\n ");
			lblNewLabel_3.setForeground(new Color(255, 255, 255));
			lblNewLabel_3.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 22));
			lblNewLabel_3.setBounds(152, 97, 288, 23);
		}
		return lblNewLabel_3;
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Odjavi se");
			btnNewButton.setBackground(new Color(153, 102, 51));
			btnNewButton.setForeground(Color.WHITE);
			btnNewButton.setBounds(234, 165, 112, 23);
			btnNewButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {	
						UserLogin ul = new UserLogin();
						contentPane.setVisible(false);
						ul.setVisible(true);
						return;
					
				}
			});
		}
		return btnNewButton;
	}

	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("biti izvr\u0161ena u najkra\u0107em \r\n ");
			lblNewLabel_4.setFont(new Font("Calibri", Font.BOLD, 22));
			lblNewLabel_4.setForeground(new Color(255, 255, 255));
			lblNewLabel_4.setBounds(174, 115, 239, 23);
		}
		return lblNewLabel_4;
	}

	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("mogu\u0107em roku...");
			lblNewLabel_5.setFont(new Font("Calibri", Font.BOLD, 22));
			lblNewLabel_5.setForeground(new Color(255, 255, 255));
			lblNewLabel_5.setBounds(211, 131, 162, 23);
		}
		return lblNewLabel_5;
	}
}
