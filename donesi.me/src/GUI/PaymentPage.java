package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class PaymentPage extends JFrame {

	private static final long serialVersionUID = 677637759276919061L;
	private JPanel contentPane;
	private JLabel lblLogo;
	private JLabel lblNewLabel;
	private JLabel lblplacanje;
	private JRadioButton rdbtnKes;
	private JRadioButton rdbtnKartica;
	private JTextField textFieldBrojKartice;
	private JLabel lblbrojKartice;
	private JButton btnNaruci;
	private JLabel lblKesOpcija;
	private JCheckBox chckbxDa;
	private JCheckBox chckbxNe;
	private JTextArea textAreaNapomena;
	private JLabel lblNapomena;
	private JLabel lblCVC;
	private JTextField textFieldCVC;
	private JLabel lblUnosNovca;
	private JTextField textFieldKesValue;
	private JTable table;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel_1;
	DatabaseConnection db = new DatabaseConnection("jdbc:mysql://localhost/donesi", "root", "");
	private JScrollPane scrollPane_1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaymentPage frame = new PaymentPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PaymentPage() {

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 633, 442);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 102, 153));
		contentPane.setForeground(new Color(51, 102, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblLogo());
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblplacanje());
		contentPane.add(getRdbtnKes());
		contentPane.add(getRdbtnKartica());
		contentPane.add(getTextFieldBrojKartice());
		contentPane.add(getLblbrojKartice());
		contentPane.add(getBtnNaruci());
		contentPane.add(getLblKesOpcija());
		contentPane.add(getChckbxDa());
		contentPane.add(getChckbxNe());
		contentPane.add(getScrollPane_1());
		contentPane.add(getLblNapomena());
		contentPane.add(getLblCVC());
		contentPane.add(getTextFieldCVC());
		contentPane.add(getLblUnosNovca());
		contentPane.add(getTextFieldKesValue());
		contentPane.add(getScrollPane());
		contentPane.add(getLblNewLabel_1());

	}

	private JLabel getLblLogo() {
		if (lblLogo == null) {
			lblLogo = new JLabel("");
			lblLogo.setIcon(new ImageIcon(PaymentPage.class.getResource("/img/delivery-man.png")));
			lblLogo.setBounds(33, 26, 128, 133);
		}
		return lblLogo;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("dostavi.me");
			lblNewLabel.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 24));
			lblNewLabel.setForeground(new Color(255, 255, 255));
			lblNewLabel.setBounds(318, 49, 114, 30);
		}
		return lblNewLabel;
	}

	private JLabel getLblplacanje() {
		if (lblplacanje == null) {
			lblplacanje = new JLabel("Kako placate?");
			lblplacanje.setForeground(new Color(255, 255, 255));
			lblplacanje.setFont(new Font("Calibri", Font.BOLD, 13));
			lblplacanje.setBounds(240, 231, 88, 14);
		}
		return lblplacanje;
	}

	private JRadioButton getRdbtnKes() {
		if (rdbtnKes == null) {
			rdbtnKes = new JRadioButton("Kes");
			rdbtnKes.setForeground(new Color(255, 255, 255));
			rdbtnKes.setBackground(Color.WHITE);
			rdbtnKes.setBounds(384, 225, 48, 23);
			rdbtnKes.setOpaque(false);

			rdbtnKes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					rdbtnKartica.setSelected(false);
					textFieldBrojKartice.setVisible(false);
					lblbrojKartice.setVisible(false);
					lblCVC.setVisible(false);
					textFieldCVC.setVisible(false);
					lblKesOpcija.setVisible(true);
					chckbxDa.setVisible(true);
					chckbxNe.setVisible(true);
					lblUnosNovca.setVisible(true);
					textFieldKesValue.setVisible(true);
					lblUnosNovca.setVisible(false);
					textFieldKesValue.setVisible(false);
				}

			});
		}
		return rdbtnKes;
	}

	private JRadioButton getRdbtnKartica() {
		if (rdbtnKartica == null) {
			rdbtnKartica = new JRadioButton("Kartica");
			rdbtnKartica.setBackground(new Color(51, 102, 153));
			rdbtnKartica.setForeground(new Color(255, 255, 255));
			rdbtnKartica.setBounds(434, 225, 73, 23);
			rdbtnKartica.setOpaque(false);

			rdbtnKartica.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					rdbtnKes.setSelected(false);
					textFieldBrojKartice.setVisible(true);
					lblbrojKartice.setVisible(true);
					lblCVC.setVisible(true);
					textFieldCVC.setVisible(true);
					lblKesOpcija.setVisible(false);
					chckbxDa.setVisible(false);
					chckbxNe.setVisible(false);
					lblUnosNovca.setVisible(false);
					textFieldKesValue.setVisible(false);
					chckbxDa.setSelected(false);
					chckbxNe.setSelected(false);
				}

			});
		}
		return rdbtnKartica;
	}

	private JTextField getTextFieldBrojKartice() {
		if (textFieldBrojKartice == null) {
			textFieldBrojKartice = new JTextField();
			textFieldBrojKartice.setBounds(330, 302, 213, 20);
			textFieldBrojKartice.setBorder(new LineBorder(new Color(153, 102, 51), 3));
			textFieldBrojKartice.setVisible(false);
			textFieldBrojKartice.setColumns(10);
		}
		return textFieldBrojKartice;
	}

	private JLabel getLblbrojKartice() {
		if (lblbrojKartice == null) {
			lblbrojKartice = new JLabel("Broj kartice:");
			lblbrojKartice.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblbrojKartice.setForeground(new Color(255, 255, 255));
			lblbrojKartice.setBounds(240, 305, 73, 14);
			lblbrojKartice.setVisible(false);
		}
		return lblbrojKartice;
	}

	private JButton getBtnNaruci() {
		if (btnNaruci == null) {
			btnNaruci = new JButton("Naruci");
			btnNaruci.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (!(rdbtnKes.isSelected() || rdbtnKartica.isSelected())) {
						JOptionPane.showMessageDialog(contentPane, "Izaberite nacin placanja!", "Greska",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
					if (!(chckbxDa.isSelected() || chckbxNe.isSelected()) && chckbxDa.isVisible() == true
							&& chckbxNe.isVisible() == true) {
						JOptionPane.showMessageDialog(contentPane, "Morate izabrati da li imate tacan iznos ili ne!",
								"Greska", JOptionPane.ERROR_MESSAGE);
						return;
					}
					if (getTextFieldKesValue().getText().equals("") && getTextFieldKesValue().isVisible() == true) {
						JOptionPane.showMessageDialog(contentPane, "Unesite sumu sa kojom placate!", "Greska",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
					if (getTextFieldBrojKartice().getText().equals("") && getLblbrojKartice().isVisible() == true) {
						JOptionPane.showMessageDialog(contentPane, "Unesite podatke o kartici!", "Greska",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
					if (getTextFieldCVC().getText().equals("") && getLblCVC().isVisible() == true) {
						JOptionPane.showMessageDialog(contentPane, "Unesite CVC broj!", "Greska",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
					LastGUI lg = new LastGUI();
					contentPane.setVisible(false);
					lg.setVisible(true);
					return;
				}
			});
			btnNaruci.setForeground(new Color(255, 255, 255));
			btnNaruci.setBackground(new Color(153, 102, 51));
			btnNaruci.setBounds(506, 369, 89, 23);
		}
		return btnNaruci;
	}

	private JLabel getLblKesOpcija() {
		if (lblKesOpcija == null) {
			lblKesOpcija = new JLabel("Da li imate tacan iznos?");
			lblKesOpcija.setForeground(Color.WHITE);
			lblKesOpcija.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblKesOpcija.setBounds(240, 256, 143, 14);
			lblKesOpcija.setVisible(false);
		}
		return lblKesOpcija;
	}

	private JCheckBox getChckbxDa() {
		if (chckbxDa == null) {
			chckbxDa = new JCheckBox("Da");
			chckbxDa.setForeground(new Color(255, 255, 255));
			chckbxDa.setBackground(new Color(51, 102, 153));
			chckbxDa.setBounds(384, 251, 48, 23);
			chckbxDa.setOpaque(false);

			chckbxDa.setVisible(false);
			chckbxDa.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					chckbxNe.setSelected(false);
					lblUnosNovca.setVisible(false);
					textFieldKesValue.setVisible(false);
				}
			});

		}
		return chckbxDa;
	}

	private JCheckBox getChckbxNe() {
		if (chckbxNe == null) {
			chckbxNe = new JCheckBox("Ne");
			chckbxNe.setBackground(new Color(51, 102, 153));
			chckbxNe.setForeground(new Color(255, 255, 255));
			chckbxNe.setBounds(434, 252, 48, 23);
			chckbxNe.setOpaque(false);
			chckbxNe.setVisible(false);
			chckbxNe.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					chckbxDa.setSelected(false);
					lblUnosNovca.setVisible(true);
					textFieldKesValue.setVisible(true);
				}
			});
		}
		return chckbxNe;
	}

	private JTextArea getTextAreaNapomena() {
		if (textAreaNapomena == null) {
			textAreaNapomena = new JTextArea();
			textAreaNapomena.setLineWrap(true);
			textAreaNapomena.setBackground(new Color(255, 255, 255));
			textAreaNapomena.setBorder(new LineBorder(new Color(153, 102, 51), 3));
		}
		return textAreaNapomena;
	}

	private JLabel getLblNapomena() {
		if (lblNapomena == null) {
			lblNapomena = new JLabel("Napomena:");
			lblNapomena.setForeground(new Color(255, 255, 255));
			lblNapomena.setBounds(34, 199, 67, 14);
		}
		return lblNapomena;
	}

	private JLabel getLblCVC() {
		if (lblCVC == null) {
			lblCVC = new JLabel("CVC broj:");
			lblCVC.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblCVC.setForeground(new Color(255, 255, 255));
			lblCVC.setBounds(240, 330, 73, 14);
			lblCVC.setVisible(false);
		}
		return lblCVC;
	}

	private JTextField getTextFieldCVC() {
		if (textFieldCVC == null) {
			textFieldCVC = new JTextField();
			textFieldCVC.setForeground(new Color(0, 0, 0));
			textFieldCVC.setBounds(331, 327, 86, 20);
			textFieldCVC.setBorder(new LineBorder(new Color(153, 102, 51), 3));
			textFieldCVC.setVisible(false);
			textFieldCVC.setColumns(10);
		}
		return textFieldCVC;
	}

	private JLabel getLblUnosNovca() {
		if (lblUnosNovca == null) {
			lblUnosNovca = new JLabel("Sa koliko placate?");
			lblUnosNovca.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblUnosNovca.setForeground(Color.WHITE);
			lblUnosNovca.setBounds(240, 280, 128, 14);
			lblUnosNovca.setVisible(false);
		}
		return lblUnosNovca;
	}

	private JTextField getTextFieldKesValue() {
		if (textFieldKesValue == null) {
			textFieldKesValue = new JTextField();
			textFieldKesValue.setBounds(384, 277, 98, 20);
			textFieldKesValue.setColumns(10);
			textFieldKesValue.setVisible(false);
		}
		return textFieldKesValue;
	}

	public JTable getTable() {
		if (table == null) {
			table = new JTable();
			String[] s = db.findOrder().split("/");
			table.setModel(
					new DefaultTableModel(
							new Object[][] { { "1." + s[0] }, { "2." + s[1] }, { null },
									{ "Za placanje: " + s[2] + " eura." }, },
							new String[] { "Informacije o porudzbini:" }) {
						/**
						 * 
						 */
						private static final long serialVersionUID = 4637451491957422059L;
						boolean[] columnEditables = new boolean[] { false };

						public boolean isCellEditable(int row, int column) {
							return columnEditables[column];
						}
					});
			table.getColumnModel().getColumn(0).setResizable(false);
			table.getColumnModel().getColumn(0).setPreferredWidth(219);
		}
		return table;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(240, 107, 308, 91);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1
					.setIcon(new ImageIcon(PaymentPage.class.getResource("/img/wallpaperflare.com_wallpaper.jpg")));
			lblNewLabel_1.setBounds(0, 0, 617, 403);
		}
		return lblNewLabel_1;
	}

	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(33, 224, 136, 133);
			scrollPane_1.setViewportView(getTextAreaNapomena());
		}
		return scrollPane_1;
	}
}
