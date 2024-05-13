import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class DlgPregledVeterinara extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	JTextArea textAreaPregledVeterinara; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgPregledVeterinara dialog = new DlgPregledVeterinara();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgPregledVeterinara() {
		setTitle("Pregled veterinara");
		setBounds(100, 100, 556, 358);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(240, 248, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
	
		JScrollPane scrollPanePregledVeterinara = new JScrollPane();
		scrollPanePregledVeterinara.setBounds(21, 11, 502, 265);
		contentPanel.add(scrollPanePregledVeterinara);	
		{
			JTextArea textAreaPregledVeterinara = new JTextArea();
			scrollPanePregledVeterinara.setViewportView(textAreaPregledVeterinara);
		}
			
		textAreaPregledVeterinara = new JTextArea();
		textAreaPregledVeterinara.setBackground(new Color(255, 255, 255));
		scrollPanePregledVeterinara.setViewportView(textAreaPregledVeterinara);
	
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
			  
			  //ime_veterinara,prezime_veterinara,kontakt_veterinara,lokacija_veterinara,email_veterinara,specijalizacija_veterinara
			  String sql = "SELECT * FROM Veterinar";
			  Statement stmt = conn.createStatement();
			  ResultSet rs = stmt.executeQuery(sql);
			  String tekst = "";
			  
			  while (rs.next()) {
				tekst += "Ime veterinara: "+rs.getString("ime_veterinara")+"\t";	
				tekst += "Prezime veterinara: "+rs.getString("prezime_veterinara")+"\t";
				tekst += "Kontakt veterinara: "+rs.getString("kontakt_veterinara")+"\t"+"\t";
				tekst += "Lokacija veterinara: "+rs.getString("lokacija_veterinara")+"\t";
				tekst += "E-mail veterinara: "+rs.getString("email_veterinara")+"\t";
				tekst += "Specijalizacija veterinara: "+rs.getString("specijalizacija_veterinara")+"\n";
				
			  }
			  textAreaPregledVeterinara.setText(tekst);
			  conn.close();
			
		} catch(Exception ex) {
				JOptionPane.showMessageDialog(null, ex.getMessage(),"Greška",JOptionPane.ERROR_MESSAGE);
			}
	}

}
