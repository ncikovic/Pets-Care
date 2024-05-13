import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class DlgPregledLjubimaca extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	JTextArea textAreaPregledLjubimaca; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgPregledLjubimaca dialog = new DlgPregledLjubimaca();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgPregledLjubimaca() {
		setTitle("Pregled podataka ljubimaca");
		setBounds(100, 100, 528, 328);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(240, 248, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 494, 237);
		contentPanel.add(scrollPane);
		{
			JTextArea textAreaPregledLjubimaca = new JTextArea();
			scrollPane.setViewportView(textAreaPregledLjubimaca);
		}
		
		textAreaPregledLjubimaca = new JTextArea();
		textAreaPregledLjubimaca.setBackground(new Color(255, 255, 255));
		scrollPane.setViewportView(textAreaPregledLjubimaca);
		
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
		selectPregledLjubimaca();
	}
	private void selectPregledLjubimaca() {
		//TODO Auto-generated method stub
		try {
		  	  Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			  Connection conn = 
		DriverManager.getConnection("jdbc:mysql://ucka.veleri.hr/kblazevic?" +
		 "user=kblazevic&password=11");
			  
			  //ime_ljubimca,datum_rodenja_ljubimca,kilaza_ljubimca,rodovnica_ljubimca,putovnica_ljubimca,podaci_o_njezi_ljubimca,podaci_o_prehrani_ljubimca
			  String sql = "SELECT * FROM Ljubimac";
			  Statement stmt = conn.createStatement();
			  ResultSet rs = stmt.executeQuery(sql);
			  String tekst = "";
			  
			  while (rs.next()) {
				tekst += "Ime ljubimca: "+rs.getString("ime_ljubimca")+"\t";	
				tekst += "Datum rođenja ljubimca: "+rs.getString("datum_rodenja_ljubimca")+"\t";
				tekst += "Kilaza ljubimca: "+rs.getString("kilaza_ljubimca")+"\t";
				tekst += "Rodovnica ljubimca: "+rs.getString("rodovnica_ljubimca")+"\t";
				tekst += "Putovnica ljubimca: "+rs.getString("putovnica_ljubimca")+"\t";
				tekst += "Podaci o njezi ljubimca: "+rs.getString("podaci_o_njezi_ljubimca")+"\t"+"\t"+"\t";				
				tekst += "Podaci o prehrani ljubimca: "+rs.getString("podaci_o_prehrani_ljubimca")+"\n";
				
			  }
			  textAreaPregledLjubimaca.setText(tekst);
			  conn.close();
			
		} catch(Exception ex) {
				JOptionPane.showMessageDialog(null, ex.getMessage(),"Greška",JOptionPane.ERROR_MESSAGE);
			}
		}
	}

