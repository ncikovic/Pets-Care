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
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.sql.*;

public class DlgPregledAdministratora extends JDialog {

	private static final long serialVersionUID = 1L;
	JTextArea textAreaAdmin; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgPregledAdministratora dialog = new DlgPregledAdministratora();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgPregledAdministratora() {
		getContentPane().setBackground(new Color(240, 248, 255));
		setTitle("Pregled admina");
		getContentPane().setLayout(null);
		
		JScrollPane scrollPaneAdmin = new JScrollPane();
		scrollPaneAdmin.setBounds(10, 10, 489, 122);
		getContentPane().add(scrollPaneAdmin);
		{
			textAreaAdmin = new JTextArea();
			scrollPaneAdmin.setViewportView(textAreaAdmin);
		}
		
		JButton btnNewButton = new JButton("Zatvori");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
			dispose();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		btnNewButton.setBounds(398, 142, 85, 21);
		getContentPane().add(btnNewButton);
		setTitle("PREGLED ADMINISTRATORA");
		setBounds(100, 100, 528, 204);
		getContentPane().setLayout(new BorderLayout());
	
		selectPregledAdmina();
	}
		
	private void selectPregledAdmina() {
		//TODO Auto-generated method stub
		try {
		  	  Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			  Connection conn = DriverManager.getConnection("jdbc:mysql://ucka.veleri.hr/kblazevic?" +
						 "user=kblazevic&password=11");
			  
			  //Koris_ime_admina, lozinka_admina
			  String sql = "SELECT * FROM Administrator";
			  Statement stmt = conn.createStatement();
			  ResultSet rs = stmt.executeQuery(sql);
			  String tekst = "";
			  
			  while (rs.next()) {
				tekst += "Korisničko ime admina: "+rs.getString("Koris_ime_admina")+"\t";				
				tekst += "Lozinka admina: "+rs.getString("lozinka_admina")+"\t"+"\n";
				
				
			  }
			  textAreaAdmin.setText(tekst);
			  conn.close();
			
		} catch(Exception ex) {
				JOptionPane.showMessageDialog(null, ex.getMessage(),"Greška",JOptionPane.ERROR_MESSAGE);
			}
		}


}
