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
	private JTextField jTFStückzahl;
	private JTextField jTFStückpreis;
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
		
		jTFStückzahl = new JTextField();
		jTFStückzahl.setBounds(10, 36, 58, 20);
		contentPane.add(jTFStückzahl);
		jTFStückzahl.setColumns(10);
		
		JLabel jLblStückzahl = new JLabel("St\u00FCckzahl");
		jLblStückzahl.setBounds(10, 21, 58, 14);
		contentPane.add(jLblStückzahl);
		
		jTFStückpreis = new JTextField();
		jTFStückpreis.setColumns(10);
		jTFStückpreis.setBounds(88, 36, 58, 20);
		contentPane.add(jTFStückpreis);
		
		JLabel jLblStückpreis = new JLabel("St\u00FCckpreis");
		jLblStückpreis.setBounds(90, 21, 77, 14);
		contentPane.add(jLblStückpreis);
		
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
				sz = Double.parseDouble(jTFStückzahl.getText());
				sp = Double.parseDouble(jTFStückpreis.getText());
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
			putValue(SHORT_DESCRIPTION, "Das Programm Schließen");
			
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
