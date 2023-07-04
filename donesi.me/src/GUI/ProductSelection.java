package GUI;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ProductSelection extends JFrame {

	private static final long serialVersionUID = -676661067945218437L;
	private JLabel lblImage;
	private JPanel contentPane;
	private JLabel lblRestoran;
	private JLabel lblHrana;
	private JLabel lblBrojKomada;
	private JComboBox comboBoxRestoran;
	private JComboBox comboBoxHrana;
	private JLabel lblDostava;
	private JButton btnProvjeri;
	private JLabel labelUkupno;
	private JButton btnNewButton;
	private JComboBox comboBoxPice;
	private JLabel lblPice;
	private int flag = 1;
	DatabaseConnection db = new DatabaseConnection("jdbc:mysql://localhost/donesi", "root", "");
	private JSlider slider;
	private JLabel lblForSlider;
	private JLabel lblNewLabel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductSelection frame = new ProductSelection();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public ProductSelection() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 554, 401);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 102, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblImage());
		contentPane.add(getLblRestoran());
		contentPane.add(getLblHrana());
		contentPane.add(getLblBrojKomada());
		contentPane.add(getComboBoxRestoran());
		contentPane.add(getComboBoxHrana());
		contentPane.add(getLblDostava());
		contentPane.add(getBtnProvjeri());
		contentPane.add(getLabelUkupno());
		contentPane.add(getBtnNewButton());
		contentPane.add(getComboBoxPice());
		contentPane.add(getSlider());
		contentPane.add(getLblForSlider());
		contentPane.add(getLblPice());
		contentPane.add(getLblNewLabel());

	}

	private JLabel getLblImage() {
		if (lblImage == null) {
			lblImage = new JLabel("");
			lblImage.setBounds(20, 11, 128, 136);
			lblImage.setIcon(new ImageIcon(ProductSelection.class.getResource("/img/delivery-man.png")));
		}
		return lblImage;
	}

	private JLabel getLblRestoran() {
		if (lblRestoran == null) {
			lblRestoran = new JLabel("Restoran");
			lblRestoran.setForeground(new Color(248, 248, 255));
			lblRestoran.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblRestoran.setBounds(88, 158, 128, 20);
		}
		return lblRestoran;
	}

	private JLabel getLblHrana() {
		if (lblHrana == null) {
			lblHrana = new JLabel("Hrana");
			lblHrana.setForeground(new Color(248, 248, 255));
			lblHrana.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblHrana.setBounds(88, 189, 128, 20);
		}
		return lblHrana;
	}

	private JLabel getLblBrojKomada() {
		if (lblBrojKomada == null) {
			lblBrojKomada = new JLabel("Broj komada");
			lblBrojKomada.setForeground(new Color(248, 248, 255));
			lblBrojKomada.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblBrojKomada.setBounds(88, 251, 128, 20);
		}
		return lblBrojKomada;
	}

	private JComboBox getComboBoxRestoran() {
		if (comboBoxRestoran == null) {
			comboBoxRestoran = new JComboBox();
			comboBoxRestoran.setBounds(226, 159, 207, 20);
			comboBoxRestoran.addItem("Izaberite...");
			String[] s = db.insertResturant().split("/");
			for (int i = 0; i < s.length; i++) {
				comboBoxRestoran.addItem(s[i]);
			}

			// comboBoxRestoran.addItem(db.insertResturant());

			comboBoxRestoran.addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					if (comboBoxRestoran.getSelectedIndex() != 0) {
						comboBoxHrana.removeAllItems();
						comboBoxPice.removeAllItems();
						comboBoxHrana.addItem("Izaberite...");
						comboBoxPice.addItem("Izaberite...");
						String s = db.insertFood(getComboBoxRestoran().getSelectedItem().toString());
						Set<String> mySet = new HashSet<>();
						String[] forGui = s.split("/");
						for (int i = 0; i < forGui.length; i++) {
							mySet.add(forGui[i]);
						}
						for (String str : mySet) {
							comboBoxHrana.addItem(str);
						}
						String s2 = db.insertDrink(getComboBoxRestoran().getSelectedItem().toString());
						Set<String> mySet2 = new HashSet<>();
						String[] forGui2 = s2.split("/");
						for (int i = 0; i < forGui2.length; i++) {
							mySet2.add(forGui2[i]);
						}
						for (String str : mySet2) {
							comboBoxPice.addItem(str);
						}

					}
				}
			});
		}
		return comboBoxRestoran;
	}

	public JComboBox getComboBoxHrana() {
		if (comboBoxHrana == null) {
			comboBoxHrana = new JComboBox();
			comboBoxHrana.setModel(new DefaultComboBoxModel());
			comboBoxHrana.setBounds(226, 190, 207, 20);
			comboBoxHrana.addItem("Prvo izaberite restoran");
		}
		return comboBoxHrana;
	}

	private JLabel getLblDostava() {
		if (lblDostava == null) {
			lblDostava = new JLabel("dostavi.me\r\n");
			lblDostava.setHorizontalAlignment(SwingConstants.CENTER);
			lblDostava.setForeground(new Color(248, 248, 255));
			lblDostava.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
			lblDostava.setBounds(211, 66, 140, 23);
		}
		return lblDostava;
	}

	private JButton getBtnProvjeri() {
		if (btnProvjeri == null) {
			btnProvjeri = new JButton("Dodaj u korpu");
			btnProvjeri.setBackground(new Color(153, 102, 51));
			btnProvjeri.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (comboBoxRestoran.getSelectedIndex() == 0) {
						JOptionPane.showMessageDialog(contentPane, "Izaberite restoran", "Greska",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
					if (comboBoxHrana.getSelectedIndex() == 0) {
						JOptionPane.showMessageDialog(contentPane, "Izaberite jelo", "Greska",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
					if (comboBoxPice.getSelectedIndex() == 0) {
						JOptionPane.showMessageDialog(contentPane, "Izaberite pice", "Greska",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
					if (getSlider().getValue() == 0) {
						JOptionPane.showMessageDialog(contentPane, "Unesite broj komada", "Greska",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
					int pieces = 0;
					try {
						pieces = getSlider().getValue();
						if (pieces <= 0) {
							JOptionPane.showMessageDialog(contentPane, "Broj komada mora biti veci od 0", "Greska",
									JOptionPane.ERROR_MESSAGE);
							return;
						}
					} catch (Exception e) {
						JOptionPane.showMessageDialog(contentPane, "Broj komada mora biti broj", "Greska",
								JOptionPane.ERROR_MESSAGE);

						return;
					}

					double foodPrice = db.foodPrice(comboBoxHrana.getSelectedItem().toString());
					double drinkPrice = db.drinkPrice(comboBoxPice.getSelectedItem().toString());
					double sum = foodPrice + drinkPrice;
					double total = pieces * sum;
					labelUkupno.setText("Ukupno: " + total);
					labelUkupno.setVisible(true);
					db.addToOrder(comboBoxRestoran.getSelectedItem().toString(),
							comboBoxHrana.getSelectedItem().toString(), comboBoxPice.getSelectedItem().toString(), pieces, total);

					flag = 0;

				}

			});
			btnProvjeri.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnProvjeri.setForeground(new Color(255, 255, 255));
			btnProvjeri.setBounds(263, 283, 140, 23);
		}
		return btnProvjeri;
	}

	public JLabel getLabelUkupno() {
		if (labelUkupno == null) {
			labelUkupno = new JLabel("Za placanje:");
			labelUkupno.setForeground(new Color(248, 248, 255));
			labelUkupno.setFont(new Font("Tahoma", Font.BOLD, 13));
			labelUkupno.setBounds(10, 331, 128, 20);
			labelUkupno.setVisible(false);
		}
		return labelUkupno;
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Nastavi na placanje");
			btnNewButton.setBackground(new Color(153, 102, 51));
			btnNewButton.setForeground(new Color(255, 255, 255));
			btnNewButton.setBounds(373, 331, 155, 23);

			btnNewButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if (flag == 0) {
						PaymentPage p = new PaymentPage();
						contentPane.setVisible(false);
						p.setVisible(true);
						return;
					}
					JOptionPane.showMessageDialog(contentPane, "Morate izabrati proizvode.", "Greska",
							JOptionPane.ERROR_MESSAGE);
				}
			});

		}
		return btnNewButton;
	}

	public JComboBox getComboBoxPice() {
		if (comboBoxPice == null) {
			comboBoxPice = new JComboBox();
			comboBoxPice.setModel(new DefaultComboBoxModel());
			comboBoxPice.addItem("Prvo izaberite restoran");
			comboBoxPice.setBounds(226, 221, 207, 20);
		}
		return comboBoxPice;
	}

	private JLabel getLblPice() {
		if (lblPice == null) {
			lblPice = new JLabel("Pice");
			lblPice.setForeground(new Color(248, 248, 255));
			lblPice.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblPice.setBounds(88, 220, 128, 20);
		}
		return lblPice;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(
					new ImageIcon(ProductSelection.class.getResource("/img/wallpaperflare.com_wallpaper.jpg")));
			lblNewLabel.setBounds(0, 0, 538, 362);
		}
		return lblNewLabel;
	}

	private JSlider getSlider() {
		if (slider == null) {
			slider = new JSlider(1, 4, 1);
			slider.setSnapToTicks(true);
			slider.setFont(new Font("Tahoma", Font.PLAIN, 10));
			slider.setToolTipText("");
			slider.setMajorTickSpacing(1);
			slider.setValue(1);
			slider.setMaximum(5);
			slider.setPaintTicks(true);
			slider.setPaintTrack(true);
			slider.setBackground(new Color(240, 248, 255));
			slider.setBounds(226, 251, 207, 20);

			slider.addChangeListener(new ChangeListener() {
				@Override
				public void stateChanged(ChangeEvent e) {
					lblForSlider.setText(slider.getValue() + "");

				}
			});
		}
		return slider;
	}

	private JLabel getLblForSlider() {
		if (lblForSlider == null) {
			lblForSlider = new JLabel("");
			lblForSlider.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblForSlider.setForeground(Color.WHITE);
			lblForSlider.setBounds(137, 285, 31, 21);
		}
		return lblForSlider;
	}
}
