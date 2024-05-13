import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;

public class DlgUnosKorisnika extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldDatumRodenja;
	private JTextField textFieldEmailKorisnika;
	private JTextField textFieldBrojTelefonaKorisnika;
	private JTextField textFieldPrezimeKorisnika;
	private JTextField textFieldImeKorisnika;
	private JTextField textFieldAdresaStanovanja;
	private JTextField textFieldNadimakKorisnika;
	private JPasswordField passwordFieldLozinkaKorisnika;
	private JComboBox<?> comboBoxMjestoStanovanja; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgUnosKorisnika dialog = new DlgUnosKorisnika();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	@SuppressWarnings("rawtypes")
	public DlgUnosKorisnika() {
		setTitle("Unos korisnika");
		setBounds(100, 100, 484, 561);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(240, 248, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Ime korisnika");
			lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
			lblNewLabel.setBounds(21, 35, 120, 26);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblPrezimeKorisnika = new JLabel("Prezime korisnika");
			lblPrezimeKorisnika.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
			lblPrezimeKorisnika.setBounds(21, 81, 120, 26);
			contentPanel.add(lblPrezimeKorisnika);
		}
		{
			JLabel lblBrojTelefonaKorisnika = new JLabel("Broj telefona korisnika");
			lblBrojTelefonaKorisnika.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
			lblBrojTelefonaKorisnika.setBounds(21, 127, 144, 26);
			contentPanel.add(lblBrojTelefonaKorisnika);
		}
		{
			JLabel lblEmailKorisnika = new JLabel("E-mail korisnika");
			lblEmailKorisnika.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
			lblEmailKorisnika.setBounds(21, 173, 144, 26);
			contentPanel.add(lblEmailKorisnika);
		}
		{
			JLabel lblDatumRodenja = new JLabel("Datum rođenja");
			lblDatumRodenja.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
			lblDatumRodenja.setBounds(21, 218, 144, 26);
			contentPanel.add(lblDatumRodenja);
		}
		{
			JLabel lblMjestoStanovanja = new JLabel("Mjesto stanovanja");
			lblMjestoStanovanja.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
			lblMjestoStanovanja.setBounds(21, 263, 144, 26);
			contentPanel.add(lblMjestoStanovanja);
		}
		{
			JLabel lblAdresaStanovanja = new JLabel("Adresa stanovanja");
			lblAdresaStanovanja.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
			lblAdresaStanovanja.setBounds(21, 303, 120, 26);
			contentPanel.add(lblAdresaStanovanja);
		}
		{
			JLabel lblNadimakKorisnika = new JLabel("Nadimak korisnika");
			lblNadimakKorisnika.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
			lblNadimakKorisnika.setBounds(21, 346, 120, 26);
			contentPanel.add(lblNadimakKorisnika);
		}
		{
			JLabel lblLozinkaKorisnika = new JLabel("Lozinka korisnika");
			lblLozinkaKorisnika.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
			lblLozinkaKorisnika.setBounds(21, 393, 120, 26);
			contentPanel.add(lblLozinkaKorisnika);
		}
		{
			comboBoxMjestoStanovanja = new JComboBox(); // Umjesto: JComboBox comboBoxMjestoStanovanja = new JComboBox();
			comboBoxMjestoStanovanja.setEditable(true);
			comboBoxMjestoStanovanja.setBackground(new Color(230, 230, 230));
			comboBoxMjestoStanovanja.setModel(new DefaultComboBoxModel(new String[] {"Odaberi mjesto stanovanja...", "Rijeka", "Kastav", "Zagreb", "Samobor", "Osijek", "Opatija", "Slavonski Brod", "Split", "Dubrovnik", "Novi Vinodolski", "Delnice", "Vinkovci", "Vukovar", "Pula", "Rovinj", "Zadar", "Šibenik"}));
			comboBoxMjestoStanovanja.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			comboBoxMjestoStanovanja.setBounds(175, 264, 248, 26);
			contentPanel.add(comboBoxMjestoStanovanja);
		}
		{
			textFieldDatumRodenja = new JTextField();
			textFieldDatumRodenja.setBackground(new Color(230, 230, 230));
			textFieldDatumRodenja.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			textFieldDatumRodenja.setBounds(175, 225, 248, 19);
			contentPanel.add(textFieldDatumRodenja);
			textFieldDatumRodenja.setColumns(10);
		}
		{
			textFieldEmailKorisnika = new JTextField();
			textFieldEmailKorisnika.setBackground(new Color(230, 230, 230));
			textFieldEmailKorisnika.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			textFieldEmailKorisnika.setColumns(10);
			textFieldEmailKorisnika.setBounds(175, 178, 248, 19);
			contentPanel.add(textFieldEmailKorisnika);
		}
		{
			textFieldBrojTelefonaKorisnika = new JTextField();
			textFieldBrojTelefonaKorisnika.setBackground(new Color(230, 230, 230));
			textFieldBrojTelefonaKorisnika.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			textFieldBrojTelefonaKorisnika.setColumns(10);
			textFieldBrojTelefonaKorisnika.setBounds(175, 132, 248, 19);
			contentPanel.add(textFieldBrojTelefonaKorisnika);
		}
		{
			textFieldPrezimeKorisnika = new JTextField();
			textFieldPrezimeKorisnika.setBackground(new Color(230, 230, 230));
			textFieldPrezimeKorisnika.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			textFieldPrezimeKorisnika.setColumns(10);
			textFieldPrezimeKorisnika.setBounds(175, 86, 248, 19);
			contentPanel.add(textFieldPrezimeKorisnika);
		}
		{
			textFieldImeKorisnika = new JTextField();
			textFieldImeKorisnika.setBackground(new Color(230, 230, 230));
			textFieldImeKorisnika.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			textFieldImeKorisnika.setColumns(10);
			textFieldImeKorisnika.setBounds(175, 40, 248, 19);
			contentPanel.add(textFieldImeKorisnika);
		}
		{
			textFieldAdresaStanovanja = new JTextField();
			textFieldAdresaStanovanja.setBackground(new Color(230, 230, 230));
			textFieldAdresaStanovanja.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			textFieldAdresaStanovanja.setColumns(10);
			textFieldAdresaStanovanja.setBounds(175, 308, 248, 19);
			contentPanel.add(textFieldAdresaStanovanja);
		}
		{
			textFieldNadimakKorisnika = new JTextField();
			textFieldNadimakKorisnika.setBackground(new Color(230, 230, 230));
			textFieldNadimakKorisnika.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			textFieldNadimakKorisnika.setColumns(10);
			textFieldNadimakKorisnika.setBounds(175, 351, 248, 19);
			contentPanel.add(textFieldNadimakKorisnika);
		}
		{
			passwordFieldLozinkaKorisnika = new JPasswordField();
			passwordFieldLozinkaKorisnika.setBackground(new Color(230, 230, 230));
			passwordFieldLozinkaKorisnika.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			passwordFieldLozinkaKorisnika.setBounds(175, 398, 248, 21);
			contentPanel.add(passwordFieldLozinkaKorisnika);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("YYYYMMDD");
			lblNewLabel_1.setBounds(175, 212, 61, 13);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(176, 196, 222));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
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
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
