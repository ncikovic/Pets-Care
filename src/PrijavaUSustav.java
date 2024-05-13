import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;

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
		frmPrijavaUSustav.setBackground(new Color(213, 196, 236));
		frmPrijavaUSustav.getContentPane().setBackground(new Color(235, 216, 243));
		frmPrijavaUSustav.setTitle("Prijava u sustav");
		frmPrijavaUSustav.setBounds(100, 100, 759, 359);
		frmPrijavaUSustav.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPrijavaUSustav.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Unos korisnika");
		btnNewButton.setBackground(new Color(193, 255, 255));
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
		btnUnosLjubimca.setBackground(new Color(193, 255, 255));
		btnUnosLjubimca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			DlgUnosLjubimca dlg = new DlgUnosLjubimca();
			dlg.setVisible(true);
			}
		});
		btnUnosLjubimca.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		btnUnosLjubimca.setBounds(270, 55, 203, 73);
		frmPrijavaUSustav.getContentPane().add(btnUnosLjubimca);
		
		JButton btnPregledVeterinara = new JButton("Pregled veterinara");
		btnPregledVeterinara.setBackground(new Color(193, 255, 255));
		btnPregledVeterinara.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgPregledVeterinara dlg = new DlgPregledVeterinara();
				dlg.setVisible(true);
			}
		});
		btnPregledVeterinara.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		btnPregledVeterinara.setBounds(530, 210, 203, 73);
		frmPrijavaUSustav.getContentPane().add(btnPregledVeterinara);
		
		JButton btnUnosUZdravstveni = new JButton("Unos u zdravstveni obrazac");
		btnUnosUZdravstveni.setBackground(new Color(193, 255, 255));
		btnUnosUZdravstveni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgUnosUZdravstveniObrazac dlg = new DlgUnosUZdravstveniObrazac();
				dlg.setVisible(true);
			}
		});
		btnUnosUZdravstveni.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		btnUnosUZdravstveni.setBounds(530, 55, 203, 73);
		frmPrijavaUSustav.getContentPane().add(btnUnosUZdravstveni);
		
		JButton btnPregledKorisnika = new JButton("Pregled korisnika");
		btnPregledKorisnika.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgPregledKorisnika dlg = new DlgPregledKorisnika();
				dlg.setVisible(true);
			}
		});
		btnPregledKorisnika.setBackground(new Color(193, 255, 255));
		btnPregledKorisnika.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		btnPregledKorisnika.setBounds(20, 210, 203, 73);
		frmPrijavaUSustav.getContentPane().add(btnPregledKorisnika);
		
		JButton btnPregledLjubimaca = new JButton("Pregled ljubimaca");
		btnPregledLjubimaca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgPregledLjubimaca dlg = new DlgPregledLjubimaca();
				dlg.setVisible(true);
			}
		});
		btnPregledLjubimaca.setBackground(new Color(193, 255, 255));
		btnPregledLjubimaca.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		btnPregledLjubimaca.setBounds(270, 210, 203, 73);
		frmPrijavaUSustav.getContentPane().add(btnPregledLjubimaca);
		
		JLabel lblUnosPodatakaUSustav = new JLabel("Unos podataka u sustav: ");
		lblUnosPodatakaUSustav.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblUnosPodatakaUSustav.setBounds(10, 14, 185, 31);
		frmPrijavaUSustav.getContentPane().add(lblUnosPodatakaUSustav);
		
		JLabel lblPregledPodatakaIz = new JLabel("Pregled podataka iz sustava:  ");
		lblPregledPodatakaIz.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblPregledPodatakaIz.setBounds(10, 169, 203, 31);
		frmPrijavaUSustav.getContentPane().add(lblPregledPodatakaIz);
	}
}
