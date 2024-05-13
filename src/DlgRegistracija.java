import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class DlgRegistracija extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldImeKorisnika;
	private JTextField textFieldPrezimeKorisnika;
	private JTextField textFieldBrojTelefonaKorisnika;
	private JTextField textFieldEmailKorisnika;
	private JTextField textFieldDatumRodenja;
	private JTextField textFieldAdresaStanovanja;
	private JTextField textFieldNadimakKorisnika;
	private JPasswordField passwordFieldLozinkaKorisnika;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgRegistracija dialog = new DlgRegistracija();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgRegistracija() {
		setTitle("REGISTRACIJA KORISNIKA");
		setBounds(100, 100, 463, 489);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(240, 248, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ime korisnika");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(21, 11, 120, 26);
		contentPanel.add(lblNewLabel);
		
		textFieldImeKorisnika = new JTextField();
		textFieldImeKorisnika.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textFieldImeKorisnika.setColumns(10);
		textFieldImeKorisnika.setBackground(new Color(230, 230, 230));
		textFieldImeKorisnika.setBounds(175, 16, 248, 19);
		contentPanel.add(textFieldImeKorisnika);
		
		JLabel lblPrezimeKorisnika = new JLabel("Prezime korisnika");
		lblPrezimeKorisnika.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblPrezimeKorisnika.setBounds(21, 57, 120, 26);
		contentPanel.add(lblPrezimeKorisnika);
		
		textFieldPrezimeKorisnika = new JTextField();
		textFieldPrezimeKorisnika.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textFieldPrezimeKorisnika.setColumns(10);
		textFieldPrezimeKorisnika.setBackground(new Color(230, 230, 230));
		textFieldPrezimeKorisnika.setBounds(175, 62, 248, 19);
		contentPanel.add(textFieldPrezimeKorisnika);
		
		JLabel lblBrojTelefonaKorisnika = new JLabel("Broj telefona korisnika");
		lblBrojTelefonaKorisnika.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblBrojTelefonaKorisnika.setBounds(21, 103, 144, 26);
		contentPanel.add(lblBrojTelefonaKorisnika);
		
		textFieldBrojTelefonaKorisnika = new JTextField();
		textFieldBrojTelefonaKorisnika.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textFieldBrojTelefonaKorisnika.setColumns(10);
		textFieldBrojTelefonaKorisnika.setBackground(new Color(230, 230, 230));
		textFieldBrojTelefonaKorisnika.setBounds(175, 108, 248, 19);
		contentPanel.add(textFieldBrojTelefonaKorisnika);
		
		JLabel lblEmailKorisnika = new JLabel("E-mail korisnika");
		lblEmailKorisnika.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblEmailKorisnika.setBounds(21, 149, 144, 26);
		contentPanel.add(lblEmailKorisnika);
		
		textFieldEmailKorisnika = new JTextField();
		textFieldEmailKorisnika.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textFieldEmailKorisnika.setColumns(10);
		textFieldEmailKorisnika.setBackground(new Color(230, 230, 230));
		textFieldEmailKorisnika.setBounds(175, 154, 248, 19);
		contentPanel.add(textFieldEmailKorisnika);
		
		JLabel lblDatumRodenja = new JLabel("Datum ro\u00C4\u2018enja");
		lblDatumRodenja.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblDatumRodenja.setBounds(21, 194, 144, 26);
		contentPanel.add(lblDatumRodenja);
		
		JLabel lblNewLabel_1 = new JLabel("YYYYMMDD");
		lblNewLabel_1.setBounds(175, 188, 85, 13);
		contentPanel.add(lblNewLabel_1);
		
		textFieldDatumRodenja = new JTextField();
		textFieldDatumRodenja.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textFieldDatumRodenja.setColumns(10);
		textFieldDatumRodenja.setBackground(new Color(230, 230, 230));
		textFieldDatumRodenja.setBounds(175, 201, 248, 19);
		contentPanel.add(textFieldDatumRodenja);
		
		JLabel lblMjestoStanovanja = new JLabel("Mjesto stanovanja");
		lblMjestoStanovanja.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblMjestoStanovanja.setBounds(21, 239, 144, 26);
		contentPanel.add(lblMjestoStanovanja);
		
		JComboBox comboBoxMjestoStanovanja = new JComboBox();
		comboBoxMjestoStanovanja.setModel(new DefaultComboBoxModel(new String[] {"Odaberi mjesto stanovanja...", "Rijeka", "Kastav", "Zagreb", "Samobor", "Osijek", "Opatija", "Slavonski Brod", "Split", "Dubrovnik", "Novi Vinodolski", "Delnice", "Vinkovci", "Vukovar", "Pula", "Rovinj", "Zadar"}));
		comboBoxMjestoStanovanja.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		comboBoxMjestoStanovanja.setBackground(new Color(230, 230, 230));
		comboBoxMjestoStanovanja.setBounds(175, 240, 248, 26);
		contentPanel.add(comboBoxMjestoStanovanja);
		
		JLabel lblAdresaStanovanja = new JLabel("Adresa stanovanja");
		lblAdresaStanovanja.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblAdresaStanovanja.setBounds(21, 279, 120, 26);
		contentPanel.add(lblAdresaStanovanja);
		
		textFieldAdresaStanovanja = new JTextField();
		textFieldAdresaStanovanja.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textFieldAdresaStanovanja.setColumns(10);
		textFieldAdresaStanovanja.setBackground(new Color(230, 230, 230));
		textFieldAdresaStanovanja.setBounds(175, 284, 248, 19);
		contentPanel.add(textFieldAdresaStanovanja);
		
		JLabel lblNadimakKorisnika = new JLabel("Nadimak korisnika");
		lblNadimakKorisnika.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblNadimakKorisnika.setBounds(21, 322, 120, 26);
		contentPanel.add(lblNadimakKorisnika);
		
		textFieldNadimakKorisnika = new JTextField();
		textFieldNadimakKorisnika.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textFieldNadimakKorisnika.setColumns(10);
		textFieldNadimakKorisnika.setBackground(new Color(230, 230, 230));
		textFieldNadimakKorisnika.setBounds(175, 327, 248, 19);
		contentPanel.add(textFieldNadimakKorisnika);
		
		JLabel lblLozinkaKorisnika = new JLabel("Lozinka korisnika");
		lblLozinkaKorisnika.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblLozinkaKorisnika.setBounds(21, 369, 120, 26);
		contentPanel.add(lblLozinkaKorisnika);
		
		passwordFieldLozinkaKorisnika = new JPasswordField();
		passwordFieldLozinkaKorisnika.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		passwordFieldLozinkaKorisnika.setBackground(new Color(230, 230, 230));
		passwordFieldLozinkaKorisnika.setBounds(175, 374, 248, 21);
		contentPanel.add(passwordFieldLozinkaKorisnika);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(176, 196, 222));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String ime_korisnika = textFieldImeKorisnika.getText();
						String prezime_korisnika = textFieldPrezimeKorisnika.getText();
						String broj_telefona_korisnika = textFieldBrojTelefonaKorisnika.getText();
						String email_korisnika = textFieldEmailKorisnika.getText();
						String datum_rodenja = textFieldDatumRodenja.getText();
						String mjesto_stanovanja = (String)comboBoxMjestoStanovanja.getSelectedItem();
						String adresa_korisnika = textFieldAdresaStanovanja.getText();
						String nadimak_korisnika = textFieldNadimakKorisnika.getText();
						String lozinka_korisnika = passwordFieldLozinkaKorisnika.getUIClassID();
						
						
						try {
							Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
							Connection conn = DriverManager.getConnection("jdbc:mysql://ucka.veleri.hr/kblazevic?" +
								                                   "user=kblazevic&password=11");
							
							//ime_korisnika,prezime_korisnika,broj_telefona_korisnika,email_korisnika,datum_rodenja,mjesto_stanovanja,adresa_korisnika,nadimak_korisnika,lozinka_korisnika
							String sql = "INSERT INTO Korisnik VALUES(?,?,?,?,?,?,?,?,?,NULL,null);";
							PreparedStatement stmt = conn.prepareStatement(sql);
							
							stmt.setString(1,ime_korisnika);
							stmt.setString(2, prezime_korisnika);
							stmt.setString(3, broj_telefona_korisnika);
							stmt.setString(4, email_korisnika);
							stmt.setString(5, datum_rodenja);
							stmt.setString(6, mjesto_stanovanja);
							stmt.setString(7, adresa_korisnika);
							stmt.setString(8, nadimak_korisnika);
							stmt.setString(9, lozinka_korisnika);

							stmt.execute();
							
							conn.close();
							
							textFieldImeKorisnika.setText("");
							textFieldPrezimeKorisnika.setText("");
							textFieldBrojTelefonaKorisnika.setText("");
							textFieldEmailKorisnika.setText("");
							textFieldDatumRodenja.setText("");
							comboBoxMjestoStanovanja.setSelectedIndex(-1);
							textFieldAdresaStanovanja.setText("");
							textFieldNadimakKorisnika.setText("");
							passwordFieldLozinkaKorisnika.setText("");
							
						} catch(Exception ex) {
							JOptionPane.showMessageDialog(null, ex.getMessage(),"Greška", JOptionPane.ERROR_MESSAGE);
						}
					}
					
				});
				okButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 11));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					dispose();
					}
				});
				cancelButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 11));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
