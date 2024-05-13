import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PrijavaUSustav {

	private JFrame frmPrijavaUSustav;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrijavaUSustav window = new PrijavaUSustav();
					window.frmPrijavaUSustav.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PrijavaUSustav() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPrijavaUSustav = new JFrame();
		frmPrijavaUSustav.setTitle("Prijava u sustav");
		frmPrijavaUSustav.setBounds(100, 100, 524, 307);
		frmPrijavaUSustav.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPrijavaUSustav.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Unos korisnika");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			DlgUnosKorisnika dlg = new DlgUnosKorisnika();
			dlg.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		btnNewButton.setBounds(20, 55, 203, 73);
		frmPrijavaUSustav.getContentPane().add(btnNewButton);
		
		JButton btnUnosLjubimca = new JButton("Unos ljubimca");
		btnUnosLjubimca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			DlgUnosLjubimca dlg = new DlgUnosLjubimca();
			dlg.setVisible(true);
			}
		});
		btnUnosLjubimca.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		btnUnosLjubimca.setBounds(20, 146, 203, 73);
		frmPrijavaUSustav.getContentPane().add(btnUnosLjubimca);
		
		JButton btnPregledVeterinara = new JButton("Pregled veterinara");
		btnPregledVeterinara.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		btnPregledVeterinara.setBounds(270, 55, 203, 73);
		frmPrijavaUSustav.getContentPane().add(btnPregledVeterinara);
		
		JButton btnUnosUZdravstveni = new JButton("Unos u zdravstveni obrazac");
		btnUnosUZdravstveni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgUnosUZdravstveniObrazac dlg = new DlgUnosUZdravstveniObrazac();
				dlg.setVisible(true);
			}
		});
		btnUnosUZdravstveni.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		btnUnosUZdravstveni.setBounds(270, 146, 203, 73);
		frmPrijavaUSustav.getContentPane().add(btnUnosUZdravstveni);
	}

}
