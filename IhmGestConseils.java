package projet_E_5;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import accesBDD.BddAccess;

public class IhmGestConseils  extends JFrame implements ActionListener{
	private BddAccess  refBdd = null;
	private JPanel pan =new JPanel();
	private JRadioButton radMembre = new JRadioButton("Membre");
	private JRadioButton radResp = new JRadioButton("Responsable");
	private ButtonGroup bg = new ButtonGroup();
	
	//affichage d'un label
	private JLabel labelNom = new JLabel("Nom: ");
	private JLabel labelLogin = new JLabel("Login: ");
	private JLabel labelMotDdePasse = new JLabel("MotDePasse: ");
	
	
	//creation d'une zone de texte de 20 caracteres
	private JTextField zoneNom = new JTextField(20);
	private JTextField zoneLogin = new JTextField(20);
	private JTextField zoneMotDePasse = new JTextField(20);
	
	//creation d'un bouton d'envoie
	private JButton boutonCNX = new JButton("Valider");
	public IhmGestConseils() {
		//creation du titre qui va s'afficher sur la page (represente title en html)
		setTitle("Gestion conseils associations");
		setSize(400,400);
		//on va cliquer sur la croix le programme s'arretera
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//associer la toile(panel) au cadre (ihm qui est le cadre car il est l'extention de jfram)
		setContentPane(pan);
		//definition d'une couleur d'arriere plan
		pan.setBackground(Color.green);
		//rend la fenetre visible a l'ecran
		setVisible(true);
		bg.add(radMembre);
		bg.add(radResp);
		pan.add(radMembre);
		pan.add(radResp);
		pan.add(labelNom);
		pan.add(zoneNom);
		pan.add(labelLogin);
		pan.add(zoneLogin);
		pan.add(boutonCNX);
		//definir la fenetre comme ecouteur de levenement du bouton
		//et faire connaitre a l'ecouteur(actionPerformed) le clique du boutons pour qu'il puisse
		// accomplir une actiona la  suite du bouton
		boutonCNX.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		System.out.println("vous aves appuye sur connexion");
		
	}
	public static void SetRefBdd(BddAccess bdd) {
		// TODO Auto-generated method stub
		refBdd = bdd;
	}

}
