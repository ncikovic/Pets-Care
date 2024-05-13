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
import java.awt.ScrollPane;
import java.awt.TextArea;
//import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.Color;
//import com.toedter.calendar.JDayChooser;

public class DlgUnosLjubimca extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldImeLjubimca;
	private JTextField textFieldKilazaLjubimca;
	private JTextField textFieldRodovnicaLjubimca;
	private JTextField textFieldPutovnicaLjubimca;
	private JTextField textFieldRodenjeLjubimca;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgUnosLjubimca dialog = new DlgUnosLjubimca();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgUnosLjubimca() {
		setTitle("Unos ljubimca u sustav");
		setBounds(100, 100, 548, 661);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(240, 248, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblImeLjubimca = new JLabel("Ime ljubimca");
			lblImeLjubimca.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
			lblImeLjubimca.setBounds(21, 32, 120, 26);
			contentPanel.add(lblImeLjubimca);
		}
		{
			textFieldImeLjubimca = new JTextField();
			textFieldImeLjubimca.setBackground(new Color(230, 230, 230));
			textFieldImeLjubimca.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			textFieldImeLjubimca.setColumns(10);
			textFieldImeLjubimca.setBounds(239, 36, 248, 19);
			contentPanel.add(textFieldImeLjubimca);
		}
		{
			JLabel lblDatumRodenjaLjubimca = new JLabel("Datum rođenja ljubimca");
			lblDatumRodenjaLjubimca.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
			lblDatumRodenjaLjubimca.setBounds(21, 83, 167, 23);
			contentPanel.add(lblDatumRodenjaLjubimca);
		}
		{
			JLabel lblKilaaLjubimca = new JLabel("Kilaža ljubimca");
			lblKilaaLjubimca.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
			lblKilaaLjubimca.setBounds(24, 128, 120, 26);
			contentPanel.add(lblKilaaLjubimca);
		}
		{
			textFieldKilazaLjubimca = new JTextField();
			textFieldKilazaLjubimca.setBackground(new Color(230, 230, 230));
			textFieldKilazaLjubimca.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			textFieldKilazaLjubimca.setColumns(10);
			textFieldKilazaLjubimca.setBounds(239, 132, 248, 19);
			contentPanel.add(textFieldKilazaLjubimca);
		}
		{
			JLabel lblRodovnicaLjubimca = new JLabel("Rodovnica ljubimca");
			lblRodovnicaLjubimca.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
			lblRodovnicaLjubimca.setBounds(21, 182, 120, 26);
			contentPanel.add(lblRodovnicaLjubimca);
		}
		{
			textFieldRodovnicaLjubimca = new JTextField();
			textFieldRodovnicaLjubimca.setBackground(new Color(230, 230, 230));
			textFieldRodovnicaLjubimca.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			textFieldRodovnicaLjubimca.setColumns(10);
			textFieldRodovnicaLjubimca.setBounds(239, 186, 248, 19);
			contentPanel.add(textFieldRodovnicaLjubimca);
		}
		{
			JLabel lblPutovnicaLjubimca = new JLabel("Putovnica ljubimca");
			lblPutovnicaLjubimca.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
			lblPutovnicaLjubimca.setBounds(21, 238, 120, 26);
			contentPanel.add(lblPutovnicaLjubimca);
		}
		{
			textFieldPutovnicaLjubimca = new JTextField();
			textFieldPutovnicaLjubimca.setBackground(new Color(230, 230, 230));
			textFieldPutovnicaLjubimca.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			textFieldPutovnicaLjubimca.setColumns(10);
			textFieldPutovnicaLjubimca.setBounds(239, 242, 248, 19);
			contentPanel.add(textFieldPutovnicaLjubimca);
		}
		{
			JLabel lblPodaciONjezi = new JLabel("Podaci o njezi ljubimca");
			lblPodaciONjezi.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
			lblPodaciONjezi.setBounds(21, 291, 167, 26);
			contentPanel.add(lblPodaciONjezi);
		}
		
		TextArea textAreaPodaciONjeziLjubimca = new TextArea();
		textAreaPodaciONjeziLjubimca.setBackground(new Color(230, 230, 230));
		textAreaPodaciONjeziLjubimca.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textAreaPodaciONjeziLjubimca.setBounds(239, 291, 248, 108);
		contentPanel.add(textAreaPodaciONjeziLjubimca);
		
		JLabel lblPodaciOPrehrani = new JLabel("Podaci o prehrani ljubimca");
		lblPodaciOPrehrani.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblPodaciOPrehrani.setBounds(21, 434, 167, 26);
		contentPanel.add(lblPodaciOPrehrani);
		
		TextArea textAreaPodaciOPrehraniLjubimca = new TextArea();
		textAreaPodaciOPrehraniLjubimca.setBackground(new Color(230, 230, 230));
		textAreaPodaciOPrehraniLjubimca.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textAreaPodaciOPrehraniLjubimca.setBounds(239, 434, 248, 108);
		contentPanel.add(textAreaPodaciOPrehraniLjubimca);
		
		textFieldRodenjeLjubimca = new JTextField();
		textFieldRodenjeLjubimca.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textFieldRodenjeLjubimca.setColumns(10);
		textFieldRodenjeLjubimca.setBackground(new Color(230, 230, 230));
		textFieldRodenjeLjubimca.setBounds(239, 86, 248, 19);
		contentPanel.add(textFieldRodenjeLjubimca);
		{
			JLabel lblNewLabel = new JLabel("YYYYMMDD");
			lblNewLabel.setBounds(239, 72, 58, 13);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("0.00");
			lblNewLabel_1.setBounds(239, 120, 45, 13);
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
						String ime_ljubimca = textFieldImeLjubimca.getText();
						String datum_rodenja_ljubimca = textFieldRodenjeLjubimca.getText();
						String kilaza_ljubimca = textFieldKilazaLjubimca.getText();
						String rodovnica_ljubimca = textFieldRodovnicaLjubimca.getText();
						String putovnica_ljubimca = textFieldPutovnicaLjubimca.getText();
						String podaci_o_njezi_ljubimca = textAreaPodaciONjeziLjubimca.getText();
						String podaci_o_prehrani_ljubimca = textAreaPodaciOPrehraniLjubimca.getText();
						
						
						
						try {
							Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
							Connection conn = DriverManager.getConnection("jdbc:mysql://ucka.veleri.hr/kblazevic?" +
								                                   "user=kblazevic&password=11");
							
							//ime_ljubimca,datum_rodenja_ljubimca,kilaza_ljubimca,rodovnica_ljubimca,putovnica_ljubimca,podaci_o_njezi_ljubimca,podaci_o_prehrani_ljubimca
							String sql = "INSERT INTO Ljubimac VALUES(null,?,?,?,?,?,?,?,null);";
							PreparedStatement stmt = conn.prepareStatement(sql);
							stmt.setString(1,ime_ljubimca);
							stmt.setString(2, datum_rodenja_ljubimca);
							stmt.setString(3, kilaza_ljubimca);
							stmt.setString(4, rodovnica_ljubimca);
							stmt.setString(5, putovnica_ljubimca);
							stmt.setString(6, podaci_o_njezi_ljubimca);
							stmt.setString(7, podaci_o_prehrani_ljubimca);

							stmt.execute();
							conn.close();
							
							textFieldImeLjubimca.setText("");
							textFieldRodenjeLjubimca.setText("");
							textFieldKilazaLjubimca.setText("");
							textFieldRodovnicaLjubimca.setText("");
							textFieldPutovnicaLjubimca.setText("");
							textAreaPodaciONjeziLjubimca.setText("");
							textAreaPodaciOPrehraniLjubimca.setText("");
							
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
