import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JLayeredPane;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JTextPane;
import javax.swing.DropMode;
import java.awt.SystemColor;
public class Einkauf extends JFrame {

	private JPanel contentPane;
	private JTextField jTFSt�ckzahl;
	private JTextField jTFSt�ckpreis;
	private JTextField jTFRabatt;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	private JTextField jTFAusgabe;

	/**
	 * Application Start
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Einkauf frame = new Einkauf();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Frame Create.
	 */
	
	public Einkauf() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 363, 172);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		jTFSt�ckzahl = new JTextField();
		jTFSt�ckzahl.setBounds(10, 36, 58, 20);
		contentPane.add(jTFSt�ckzahl);
		jTFSt�ckzahl.setColumns(10);
		
		JLabel jLblSt�ckzahl = new JLabel("St\u00FCckzahl");
		jLblSt�ckzahl.setBounds(10, 21, 58, 14);
		contentPane.add(jLblSt�ckzahl);
		
		jTFSt�ckpreis = new JTextField();
		jTFSt�ckpreis.setColumns(10);
		jTFSt�ckpreis.setBounds(88, 36, 58, 20);
		contentPane.add(jTFSt�ckpreis);
		
		JLabel jLblSt�ckpreis = new JLabel("St\u00FCckpreis");
		jLblSt�ckpreis.setBounds(90, 21, 77, 14);
		contentPane.add(jLblSt�ckpreis);
		
		jTFRabatt = new JTextField();
		jTFRabatt.setColumns(10);
		jTFRabatt.setBounds(165, 36, 58, 20);
		contentPane.add(jTFRabatt);
		
		JLabel jLblRabatt = new JLabel("Rabatt (%)");
		jLblRabatt.setBounds(165, 21, 58, 14);
		contentPane.add(jLblRabatt);
		
		JButton jBtnBerechnen = new JButton("Berechnen");
		jBtnBerechnen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double sz, sp, rt, eg1, eg2;
				sz = Double.parseDouble(jTFSt�ckzahl.getText());
				sp = Double.parseDouble(jTFSt�ckpreis.getText());
				rt = Double.parseDouble(jTFRabatt.getText());
				eg1 = sz * sp * rt / 100;
				eg2 = sz * sp - eg1;
				DecimalFormat f = new DecimalFormat("#0.00");
				jTFAusgabe.setText(f.format(eg2));
				
				
				
			}
		});
		jBtnBerechnen.setAction(action_1);
		jBtnBerechnen.setBounds(240, 35, 89, 23);
		contentPane.add(jBtnBerechnen);	
	
		JButton jBtnEnde = new JButton("Ende");
		jBtnEnde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		jBtnEnde.setAction(action);
		jBtnEnde.setBounds(240, 90, 89, 23);
		contentPane.add(jBtnEnde);
		
		jTFAusgabe = new JTextField();
		jTFAusgabe.setEditable(false);
		jTFAusgabe.setForeground(Color.BLACK);
		jTFAusgabe.setBackground(SystemColor.menu);
		jTFAusgabe.setBounds(10, 67, 213, 20);
		contentPane.add(jTFAusgabe);
		jTFAusgabe.setColumns(10);
		
		
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME,"Ende");
			putValue(SHORT_DESCRIPTION, "Das Programm Schlie�en");
			
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Berechnen");
			putValue(SHORT_DESCRIPTION, "Berechnet den Gesamtpreis inkl. Rabatt");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
