import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgKorisnici extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgKorisnici dialog = new DlgKorisnici();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgKorisnici() {
		setTitle("KORISNICI");
		setBounds(100, 100, 584, 333);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(240, 248, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblUnosPodatakaUSustav = new JLabel("Unos podataka u sustav: ");
			lblUnosPodatakaUSustav.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
			lblUnosPodatakaUSustav.setBounds(10, 10, 185, 31);
			contentPanel.add(lblUnosPodatakaUSustav);
		}
		{
			JButton btnUnosLjubimca = new JButton("Unos ljubimca");
			btnUnosLjubimca.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DlgUnosLjubimca dlg = new DlgUnosLjubimca();
					dlg.setVisible(true);
				}
			});
			btnUnosLjubimca.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
			btnUnosLjubimca.setBackground(new Color(176, 196, 222));
			btnUnosLjubimca.setBounds(50, 42, 203, 73);
			contentPanel.add(btnUnosLjubimca);
		}
		{
			JButton btnUnosUZdravstveni = new JButton("Unos u zdravstveni obrazac");
			btnUnosUZdravstveni.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DlgUnosUZdravstveniObrazac dlg = new DlgUnosUZdravstveniObrazac();
					dlg.setVisible(true);
				}
			});
			btnUnosUZdravstveni.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
			btnUnosUZdravstveni.setBackground(new Color(176, 196, 222));
			btnUnosUZdravstveni.setBounds(310, 42, 203, 73);
			contentPanel.add(btnUnosUZdravstveni);
		}
		{
			JLabel lblPregledPodatakaIz = new JLabel("Pregled podataka iz sustava:  ");
			lblPregledPodatakaIz.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
			lblPregledPodatakaIz.setBounds(10, 138, 203, 31);
			contentPanel.add(lblPregledPodatakaIz);
		}
		{
			JButton btnPregledLjubimaca = new JButton("Pregled ljubimaca");
			btnPregledLjubimaca.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DlgPregledLjubimaca dlg = new DlgPregledLjubimaca();
					dlg.setVisible(true);
				}
			});
			btnPregledLjubimaca.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
			btnPregledLjubimaca.setBackground(new Color(176, 196, 222));
			btnPregledLjubimaca.setBounds(50, 170, 203, 73);
			contentPanel.add(btnPregledLjubimaca);
		}
		{
			JButton btnPregledVeterinara = new JButton("Pregled veterinara");
			btnPregledVeterinara.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DlgPregledVeterinara dlg = new DlgPregledVeterinara();
					dlg.setVisible(true);
				}
			});
			btnPregledVeterinara.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
			btnPregledVeterinara.setBackground(new Color(176, 196, 222));
			btnPregledVeterinara.setBounds(310, 170, 203, 73);
			contentPanel.add(btnPregledVeterinara);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(176, 196, 222));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					dispose();
					}
				});
				okButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
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
	}

}
