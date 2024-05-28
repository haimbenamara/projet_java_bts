package projet_E_5;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	private String nom;
	private String login;
	private String motDePasse;
	
	
	//creation d'une zone de texte de 20 caracteres
	private JTextField zoneNom = new JTextField(20);
	private JTextField zoneLogin = new JTextField(20);
	private JTextField zoneMotDePasse = new JTextField(20);
	
	//creation d'un bouton d'envoie
	private JButton boutonCNX = new JButton("Connexion");
	
	private boolean clickSurResp = false;
	private boolean clickSurMembre = false;
	private IhmMembre ihmM;
	private Membre refMembre;
	private Responsable refResp;
	
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
		
		pan.add(labelMotDdePasse);
		pan.add(zoneMotDePasse);
		pan.add(boutonCNX);
		
		//definir la fenetre comme ecouteur de levenement du bouton
		//et faire connaitre a l'ecouteur(actionPerformed) le clique du boutons pour qu'il puisse
		// accomplir une actiona la  suite du bouton
		boutonCNX.addActionListener(this);
		radMembre.addActionListener(this);
		radResp.addActionListener(this);;
		
	}
	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		
		/*pour le controle
		int age;
		age = Integer.parseInt(zoneNom.getText());
		age = age+1;
		System.out.println(age);
		pour mettre une valeur ou remplacer une valeur une valeur de texte
		ZoneLogin.setText("Tata");
		*/
		ResultSet rs = null;
		
		if(evt.getSource() == boutonCNX) {
		
			System.out.println("Vous avez appuye sur Connexion ");
		
			// Recuperer les nom, login et mot de passe
			// des zones de saisie
			nom = zoneNom.getText();
			login = zoneLogin.getText();
			motDePasse = zoneMotDePasse.getText();
		
			//Exemple pour le controle
			/*
			int age;
			age = Integer.parseInt(zoneNom.getText());
			age = age +1;
			System.out.println(age);
		
			// Pour mettre une valeur dans une zone de saisie
			zoneLogin.setText("Tata");
			 */
			// Fin controle
			
			if(clickSurMembre == true) {
				// Formuler la requete d'authentification
				String req = "SELECT nom from connexionmember where nom =";
				req = req +"'"+nom+"'";
				req = req + " and login="+"'"+login+"'";
				req = req + " and mdp="+"'"+motDePasse+"'";
				rs = refBdd.envoiRequeteSelect(req);
						
				// Traiter la reponse
				try {
					if(rs.next()) {
						System.out.println("Membre reconnu");
						IhmMembre ihmM = new IhmMembre();
						//donner a ihmmembre la reference de membre
						ihmM.setRefMembre(refMembre);
						//donner a bdd la reference de ihmmembre
						refBdd.setIhmMembre(ihmM);
					}
					else {
						System.out.println("Desole vous n'avez pas acces en tant que membre!!");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(clickSurResp == true) {
				// Formuler la requete d'authentification
				String req = "SELECT nom from connexionresp where nom =";
				req = req +"'"+nom+"'";
				req = req + " and login="+"'"+login+"'";
				req = req + " and mdp="+"'"+motDePasse+"'";
				rs = refBdd.envoiRequeteSelect(req);
						
				// Traiter la reponse
				try {
					if(rs.next()) {
						System.out.println("Responsable reconnu");
						IhmResponsable ihmResp= new IhmResponsable();
					}
					else {
						System.out.println("Desole vous n'avez pas acces en tant que responsable!!");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else if(evt.getSource() == radMembre) {
			System.out.println("Vous avez appuye sur membre ");
			clickSurMembre = true;
			clickSurResp = false;
			
		}
		else if(evt.getSource() == radResp) {
			System.out.println("Vous avez appuye sur responsable ");
			clickSurMembre = false;
			clickSurResp = true;
		}
	
		
	}
	
	
	public  void SetRefBdd(BddAccess bdd) {
		// TODO Auto-generated method stub
		refBdd = bdd;
	}
	public void setRefMembre(Membre m) {
		refMembre = m;
		
	}
	public void setRefResponsable(Responsable resp) {
		
		refResp = resp;
	}

}
