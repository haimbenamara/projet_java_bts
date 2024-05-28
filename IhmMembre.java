package projet_E_5;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class IhmMembre extends JFrame implements ActionListener{
	// Creation d'un objet JPanel (toile)
		private JPanel pan = new JPanel();
		private Membre refMembre = null;
		private JLabel labelVisu = new JLabel("Visualisation conseils: ");
		private JLabel labelCategConseils = new JLabel("Categories conseils: ");
		
		// Zones de texte Area
		private JTextArea zoneAffich = new JTextArea(15,40);
			
		// Ascenseurs pour la JTextArea
		private JScrollPane scroll = new JScrollPane(zoneAffich);
		
		// Liste deroulante
		private String[] listeCategorie = {"Juridiques", "Remboursement frais", "Litiges"};
		private JComboBox combo = new JComboBox(listeCategorie);
		
		private JButton boutonOK = new JButton("Validation");
		
		
		public IhmMembre() {
			
			// Ajoute un titre a la fenetre
			setTitle("Fenetre Ihm membre");
					
			// Dimensionner la fenetre (300 pixels de large 
			// sur 400 de haut
			setSize(400, 500);
					
			// A la fermeture de la fenetre fermer le programme
			//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					
			// Associer le panel au cadre defini
			setContentPane(pan);
					
			// Associer une couleur de fond au Panel
			pan.setBackground(Color.cyan);
					
			pan.add(labelVisu);
			pan.add(scroll);
			pan.add(labelCategConseils);
			pan.add(combo);
			pan.add(boutonOK);
			
			setVisible(true);
			//pour que la fenetre s'affiche sinon la fenetre en s'affiche pas
			//les evenements vont etre ecoutes par l'objet de la fenetre
			boutonOK.addActionListener(this);
			combo.addActionListener(this);
		}
		String option= "Juridiques";//option par defaut

		@Override
		public void actionPerformed(ActionEvent evt) {
			// TODO Auto-generated method stub
			//variable qui va recuperer le type de conseil que le membre va choisir
						if(evt.getSource()== combo) {
				option = (String)combo.getSelectedItem();
				//recupere ce qui a ete choisi dans la liste deroulante
				//(c'est un objet special) et le transforme en string
			}
			else if(evt.getSource()== boutonOK) {
			
				refMembre.visualiserConseils(option);
			}
			
			
			
			
		}

		public void setRefMembre(Membre m) {
			refMembre = m;
			
		}

		public void afficherConseils(String msg) {
			zoneAffich.append(msg);
			
		}

}
