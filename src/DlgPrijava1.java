import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.Color;
import java.awt.Canvas;
import java.awt.Label;

import java.awt.Image;
import javax.swing.*;
import java.awt.EventQueue; 
import java.awt.*;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class DlgPrijava1 extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldKorisImeAdmina;
	private JTextField textFieldImeKorisnika;
	private JPasswordField passwordFieldAdmin;
	private JPasswordField passwordFieldKorisnik;
	DlgAdministrator dlg1;
	DlgKorisnici dlg2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgPrijava1 dialog = new DlgPrijava1();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgPrijava1() {
		setTitle("Prijava u sustav Pets&Care");
		setBounds(100, 100, 642, 424);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(240, 248, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabelNazivApp = new JLabel("Pets&Care");
		lblNewLabelNazivApp.setBackground(new Color(209, 252, 214));
		lblNewLabelNazivApp.setFont(new Font("Perpetua Titling MT", Font.BOLD, 19));
		lblNewLabelNazivApp.setBounds(255, 34, 135, 42);
		contentPanel.add(lblNewLabelNazivApp);
		
		textFieldKorisImeAdmina = new JTextField();
		textFieldKorisImeAdmina.setFont(new Font("Arial", Font.BOLD, 12));
		textFieldKorisImeAdmina.setBounds(133, 147, 115, 21);
		contentPanel.add(textFieldKorisImeAdmina);
		textFieldKorisImeAdmina.setColumns(10);
		
		textFieldImeKorisnika = new JTextField();
		textFieldImeKorisnika.setFont(new Font("Arial", Font.BOLD, 12));
		textFieldImeKorisnika.setColumns(10);
		textFieldImeKorisnika.setBounds(375, 147, 115, 21);
		contentPanel.add(textFieldImeKorisnika);
		
		JButton btnNewButtonPrijavaAdmina = new JButton("Prijava administratora");
		btnNewButtonPrijavaAdmina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String admin_ime = textFieldKorisImeAdmina.getText();
				char[] admin_lozinka = passwordFieldAdmin.getPassword();
				String admin_lozinka_String = new String(admin_lozinka);
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
					Connection conn = DriverManager.getConnection("jdbc:mysql://ucka.veleri.hr/kblazevic?user=kblazevic&password=11");

					String strQuery = "SELECT * FROM Administrator WHERE (Koris_ime_admina = ? AND lozinka_admina = ?)";
					PreparedStatement statement = conn.prepareStatement(strQuery);
					statement.setString(1, admin_ime);
					statement.setString(2, admin_lozinka_String);
					ResultSet rs = statement.executeQuery();
					if (!rs.next()) {
						JOptionPane.showMessageDialog(null, "Pogrešno korisničko ime admina ili lozinka!");
					} else {
						JOptionPane.showMessageDialog(null, "Autentikacija admina je uspješna!");
						dlg1 = new DlgAdministrator();
				        dlg1.setVisible(true);
					}
					rs.close();
					statement.close();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(),"Greška", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButtonPrijavaAdmina.setFont(new Font("Perpetua Titling MT", Font.BOLD, 10));
		btnNewButtonPrijavaAdmina.setBounds(89, 273, 193, 21);
		contentPanel.add(btnNewButtonPrijavaAdmina);
		
		JButton btnPrijavaKorisnika = new JButton("Prijava korisnika");
		btnPrijavaKorisnika.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nadimak_korisnika = textFieldImeKorisnika.getText();
				char[] lozinka_korisnika = passwordFieldKorisnik.getPassword();
				String lozinka_korisnika_string = new String(lozinka_korisnika);
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
					Connection conn = DriverManager.getConnection("jdbc:mysql://ucka.veleri.hr/kblazevic?user=kblazevic&password=11");

					String strQuery = "SELECT * FROM Korisnik WHERE (nadimak_korisnika = ? AND lozinka_korisnika = ?)";
					PreparedStatement statement = conn.prepareStatement(strQuery);
					statement.setString(1, nadimak_korisnika);
					statement.setString(2, lozinka_korisnika_string);
					ResultSet rs = statement.executeQuery();
					if (!rs.next()) {
						JOptionPane.showMessageDialog(null, "Pogre�an nadimak korisnika ili lozinka!");
					} else {
						JOptionPane.showMessageDialog(null, "Autentikacija korisnika je uspje�na!");
						dlg2 = new DlgKorisnici();
				        dlg2.setVisible(true);
					}
					rs.close();
					statement.close();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(),"Greška", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnPrijavaKorisnika.setFont(new Font("Perpetua Titling MT", Font.BOLD, 10));
		btnPrijavaKorisnika.setBounds(365, 273, 153, 21);
		contentPanel.add(btnPrijavaKorisnika);
		
		JLabel lblNewLabelImeAdmina = new JLabel("Korisničko ime admina");
		lblNewLabelImeAdmina.setFont(new Font("Calibri Light", Font.PLAIN, 12));
		lblNewLabelImeAdmina.setBounds(116, 124, 132, 13);
		contentPanel.add(lblNewLabelImeAdmina);
		
		JLabel lblNewLabelLozinkaAdmina = new JLabel("Lozinka admina");
		lblNewLabelLozinkaAdmina.setFont(new Font("Calibri Light", Font.PLAIN, 12));
		lblNewLabelLozinkaAdmina.setBounds(116, 188, 132, 13);
		contentPanel.add(lblNewLabelLozinkaAdmina);
		
		JLabel lblNewLabelImeKorisnika = new JLabel("Korisničko ime korisnika");
		lblNewLabelImeKorisnika.setFont(new Font("Calibri Light", Font.PLAIN, 12));
		lblNewLabelImeKorisnika.setBounds(351, 124, 132, 13);
		contentPanel.add(lblNewLabelImeKorisnika);
		
		JLabel lblNewLabelLozinkaKorisnika = new JLabel("Lozinka korisnika");
		lblNewLabelLozinkaKorisnika.setFont(new Font("Calibri Light", Font.PLAIN, 12));
		lblNewLabelLozinkaKorisnika.setBounds(351, 186, 132, 13);
		contentPanel.add(lblNewLabelLozinkaKorisnika);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(new Color(0, 0, 0));
		separator.setBackground(new Color(0, 0, 0));
		separator.setBounds(312, 111, 5, 183);
		contentPanel.add(separator);
		
		passwordFieldAdmin = new JPasswordField();
		passwordFieldAdmin.setBounds(133, 207, 115, 21);
		contentPanel.add(passwordFieldAdmin);
		
		passwordFieldKorisnik = new JPasswordField();
		passwordFieldKorisnik.setBounds(375, 208, 115, 21);
		contentPanel.add(passwordFieldKorisnik);
		
		JButton btnNewButton = new JButton("Pregled administratora");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgPregledAdministratora dlg = new DlgPregledAdministratora();
				dlg.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Perpetua Titling MT", Font.BOLD, 10));
		btnNewButton.setBounds(10, 10, 193, 21);
		contentPanel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\natal\\Downloads\\Korisnicko-Sucelje\\Korisnicko-Sucelje\\Pets&Care - logo.png"));
		//ImageIcon img = new ImageIcon(this.getClass().getResource("Pets&Care-logo.png"));
		//lblNewLabel.setIcon(img);
		lblNewLabel.setBounds(473, 0, 153, 134);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nema\u0161 ra\u010Dun? Registriraj se!");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 323, 160, 21);
		contentPanel.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("REGISTRIRAJ SE!");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			DlgRegistracija dlg = new DlgRegistracija();
			dlg.setVisible(true); 
			}
		});
		btnNewButton_1.setBackground(new Color(176, 196, 222));
		btnNewButton_1.setFont(new Font("Perpetua Titling MT", Font.BOLD, 10));
		btnNewButton_1.setBounds(20, 351, 147, 23);
		contentPanel.add(btnNewButton_1);
	

		
	}
}
