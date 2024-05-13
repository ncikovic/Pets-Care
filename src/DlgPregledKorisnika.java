import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class DlgPregledKorisnika extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	JTextArea textAreaPregledPodatakaKorisnika; 
	private JTextArea textAreaPregledPodatakaKorisnika_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgPregledKorisnika dialog = new DlgPregledKorisnika();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgPregledKorisnika() {
		setTitle("Pregled podataka o korisnicima");
		setBounds(100, 100, 754, 328);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(240, 248, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPanePregledKorisnika = new JScrollPane();
		scrollPanePregledKorisnika.setBounds(29, 38, 678, 193);
		contentPanel.add(scrollPanePregledKorisnika);
		{
			textAreaPregledPodatakaKorisnika = new JTextArea();
			scrollPanePregledKorisnika.setViewportView(textAreaPregledPodatakaKorisnika);
		}
		
			textAreaPregledPodatakaKorisnika_1 = new JTextArea();
			textAreaPregledPodatakaKorisnika_1.setBackground(new Color(255, 255, 255));
			scrollPanePregledKorisnika.setViewportView(textAreaPregledPodatakaKorisnika_1);
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
					dispose();
					}
				});
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
				cancelButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		selectPregledKorisnika();
	}
	private void selectPregledKorisnika() {
		//TODO Auto-generated method stub
		try {
		  	  Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			  Connection conn = 
		DriverManager.getConnection("jdbc:mysql://ucka.veleri.hr/kblazevic?" +
		 "user=kblazevic&password=11");
			  
			  //ime_korisnika,prezime_korisnika,broj_telefona_korisnika,email_korisnika,datum_rodenja,mjesto_stanovanja,adresa_korisnika,nadimak_korisnika,lozinka_korisnika
			  String sql = "SELECT * FROM Korisnik";
			  Statement stmt = conn.createStatement();
			  ResultSet rs = stmt.executeQuery(sql);
			  String tekst = "";
			  
			  while (rs.next()) {
				tekst += "Ime korisnika: "+rs.getString("ime_korisnika")+"\t";				
				tekst += "Prezime korisnika: "+rs.getString("prezime_korisnika")+"\t";
				tekst += "Broj telefona korisnika: "+rs.getString("broj_telefona_korisnika")+"\t"+"\t";
				tekst += "E-mail korisnika: "+rs.getString("email_korisnika")+"\t";
				tekst += "Datum rođenja korisnika: "+rs.getString("datum_rodenja")+"\t";				
				tekst += "Mjesto stanovanja: "+rs.getString("mjesto_stanovanja")+"\t";
				tekst += "Adresa korisnika: "+rs.getString("adresa_korisnika")+"\t"+"\t";
				tekst += "Nadimak korisnika: "+rs.getString("nadimak_korisnika")+"\t"+"\t";
				tekst += "Lozinka korisnika"+rs.getString("lozinka_korisnika")+"\n";
				
			  }
			  textAreaPregledPodatakaKorisnika_1.setText(tekst);
			  conn.close();
			
		} catch(Exception ex) {
				JOptionPane.showMessageDialog(null, ex.getMessage(),"Greška",JOptionPane.ERROR_MESSAGE);
			}
		}


}
