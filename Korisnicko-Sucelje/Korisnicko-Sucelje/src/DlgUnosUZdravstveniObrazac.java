import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import com.toedter.calendar.JCalendar;

public class DlgUnosUZdravstveniObrazac extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldNazivBolestiLjubimca;
	private JTextField textFieldVrstaBolestiLjubimca;

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
		setBounds(100, 100, 630, 588);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblSimptomiLjubimca = new JLabel("Simptomi ljubimca");
		lblSimptomiLjubimca.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblSimptomiLjubimca.setBounds(22, 32, 120, 26);
		contentPanel.add(lblSimptomiLjubimca);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(285, 39, 291, 107);
		contentPanel.add(textArea);
		
		JLabel lblVrijemeIDatum = new JLabel("Vrijeme i datum pojave simptoma");
		lblVrijemeIDatum.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblVrijemeIDatum.setBounds(22, 187, 209, 36);
		contentPanel.add(lblVrijemeIDatum);
		
		JCalendar calendar = new JCalendar();
		calendar.setBounds(285, 187, 188, 152);
		contentPanel.add(calendar);
		
		JLabel lblNazivBolestiLjubimca = new JLabel("Naziv bolesti ljubimca");
		lblNazivBolestiLjubimca.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblNazivBolestiLjubimca.setBounds(22, 383, 209, 36);
		contentPanel.add(lblNazivBolestiLjubimca);
		
		JLabel lblVrstaBolestiLjubimca = new JLabel("Vrsta bolesti ljubimca");
		lblVrstaBolestiLjubimca.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblVrstaBolestiLjubimca.setBounds(22, 460, 209, 36);
		contentPanel.add(lblVrstaBolestiLjubimca);
		
		textFieldNazivBolestiLjubimca = new JTextField();
		textFieldNazivBolestiLjubimca.setBounds(285, 390, 291, 26);
		contentPanel.add(textFieldNazivBolestiLjubimca);
		textFieldNazivBolestiLjubimca.setColumns(10);
		
		textFieldVrstaBolestiLjubimca = new JTextField();
		textFieldVrstaBolestiLjubimca.setColumns(10);
		textFieldVrstaBolestiLjubimca.setBounds(285, 460, 291, 26);
		contentPanel.add(textFieldVrstaBolestiLjubimca);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
