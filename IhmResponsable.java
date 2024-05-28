package projet_E_5;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class IhmResponsable extends JFrame implements ActionListener {
	private JPanel pan = new JPanel();
	
	private JLabel labelSaisie = new JLabel("Saisie conseils: ");
	private JLabel labelCategConseils = new JLabel("Categories conseils: ");
	
	// Liste deroulante
			private String[] listeCategorie = {"Juridiques", "Remboursement frais", "Litiges"};
			private JComboBox combo = new JComboBox(listeCategorie);
			
			//creation d'une zone de texte de 20 caracteres
			private JTextField zoneConseil = new JTextField(50);
			private JButton boutonOK = new JButton("Validation");
			public IhmResponsable() {
				// Ajoute un titre a la fenetre
				setTitle("Fenetre Ihm responsable");
				setSize(400, 500);
				
				// Associer le panel au cadre defini
				setContentPane(pan);
				
				
				// Associer une couleur de fond au Panel
				pan.setBackground(Color.yellow);
				
				pan.add(labelCategConseils);
				pan.add(combo);
				pan.add(labelSaisie);
				pan.add(zoneConseil);
				pan.add(boutonOK);
				//la fonction set vsible permet d'afficher la fenetre a lecran 
				//ce qu'elle ne fait pas sans la fonction
				setVisible(true);
			}
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
}
