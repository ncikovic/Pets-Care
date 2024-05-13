import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
//import com.toedter.calendar.JCalendar;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.Color;


public class DlgUnosUZdravstveniObrazac extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldNazivBolestiLjubimca;
	private JTextField textFieldVrstaBolestiLjubimca;
	private JTextField textFieldDatIVrijePojSimpt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgUnosUZdravstveniObrazac dialog = new DlgUnosUZdravstveniObrazac();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgUnosUZdravstveniObrazac() {
		setTitle("Zdravstveni Karton");
		setBounds(100, 100, 630, 470);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(240, 248, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblSimptomiLjubimca = new JLabel("Simptomi ljubimca");
		lblSimptomiLjubimca.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblSimptomiLjubimca.setBounds(22, 32, 120, 26);
		contentPanel.add(lblSimptomiLjubimca);
		
		JTextArea textAreaSimptomiLjubimca = new JTextArea();
		textAreaSimptomiLjubimca.setBackground(new Color(230, 230, 230));
		textAreaSimptomiLjubimca.setBounds(285, 39, 291, 107);
		contentPanel.add(textAreaSimptomiLjubimca);
		
		JLabel lblVrijemeIDatum = new JLabel("Vrijeme i datum pojave simptoma");
		lblVrijemeIDatum.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblVrijemeIDatum.setBounds(22, 187, 209, 36);
		contentPanel.add(lblVrijemeIDatum);
		
		JLabel lblNazivBolestiLjubimca = new JLabel("Naziv bolesti ljubimca");
		lblNazivBolestiLjubimca.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblNazivBolestiLjubimca.setBounds(22, 260, 209, 36);
		contentPanel.add(lblNazivBolestiLjubimca);
		
		JLabel lblVrstaBolestiLjubimca = new JLabel("Vrsta bolesti ljubimca");
		lblVrstaBolestiLjubimca.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblVrstaBolestiLjubimca.setBounds(22, 337, 209, 36);
		contentPanel.add(lblVrstaBolestiLjubimca);
		
		textFieldNazivBolestiLjubimca = new JTextField();
		textFieldNazivBolestiLjubimca.setBackground(new Color(230, 230, 230));
		textFieldNazivBolestiLjubimca.setBounds(285, 267, 291, 26);
		contentPanel.add(textFieldNazivBolestiLjubimca);
		textFieldNazivBolestiLjubimca.setColumns(10);
		
		textFieldVrstaBolestiLjubimca = new JTextField();
		textFieldVrstaBolestiLjubimca.setBackground(new Color(230, 230, 230));
		textFieldVrstaBolestiLjubimca.setColumns(10);
		textFieldVrstaBolestiLjubimca.setBounds(285, 337, 291, 26);
		contentPanel.add(textFieldVrstaBolestiLjubimca);
		
		textFieldDatIVrijePojSimpt = new JTextField();
		textFieldDatIVrijePojSimpt.setColumns(10);
		textFieldDatIVrijePojSimpt.setBackground(new Color(230, 230, 230));
		textFieldDatIVrijePojSimpt.setBounds(285, 194, 291, 26);
		contentPanel.add(textFieldDatIVrijePojSimpt);
		
		JLabel lblNewLabel = new JLabel("yymmddHHMMSS");
		lblNewLabel.setBounds(285, 171, 149, 13);
		contentPanel.add(lblNewLabel);
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
						String simptomi_ljubimca = textAreaSimptomiLjubimca.getText();
						String vrijeme_datum_pojave_simptoma_ljubimca = textFieldDatIVrijePojSimpt.getText();
						String naziv_bolesti_ljubimca = textFieldNazivBolestiLjubimca.getText();
						String vrsta_bolesti_ljubimca = textFieldVrstaBolestiLjubimca.getText();
					
						try {
							Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
							Connection conn = DriverManager.getConnection("jdbc:mysql://ucka.veleri.hr/kblazevic?" +
								                                   "user=kblazevic&password=11");
							
							//ime_ljubimca,datum_rodenja_ljubimca,kilaza_ljubimca,
							String sql = "INSERT INTO ZdravstveniKarton VALUES(?,?,?,?,NULL,NULL,NULL,NULL,NULL);";
							PreparedStatement stmt = conn.prepareStatement(sql);
							stmt.setString(1,simptomi_ljubimca);
							stmt.setString(2, vrijeme_datum_pojave_simptoma_ljubimca );
							stmt.setString(3, naziv_bolesti_ljubimca);
							stmt.setString(4, vrsta_bolesti_ljubimca);

							stmt.execute();
							conn.close();
							
							textAreaSimptomiLjubimca.setText("");
							textFieldDatIVrijePojSimpt.setText("");
							textFieldNazivBolestiLjubimca.setText("");
							textFieldVrstaBolestiLjubimca.setText("");
							
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
