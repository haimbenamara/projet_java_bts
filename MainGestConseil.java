package projet_E_5;

import accesBDD.BddAccess;

public class MainGestConseil {
	//creation de l'objet bddaccess

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BddAccess bdd = new BddAccess();
		//recherche et chargement du driver en memoire
		bdd.rechercherDriver("com.mysql.jdbc.Driver");
		
		//connexxion a la base de donnees
		bdd.connecterBdd("jdbc:mysql://localhost/M2Lassoc?useSSL=false", "root", "");
		
		//creation du statement(conteneur de la requete)
		bdd.creerStatement();
		
		
		//-------------------------------------------------------------------------------

		//creation de l'objet membre
		Membre m = new Membre();
		
		//main donne la reference de bdd a membre
		m.setRefBdd(bdd);
		
		Responsable resp = new Responsable();
		
		//main donne la reference de bdd a Responsable
		 resp.setRefBdd(bdd);
		 
		 //creation de l'objet ihmGestConseils
		 IhmGestConseils ihmGest = new IhmGestConseils();
		 ihmGest.SetRefBdd(bdd);
		 ihmGest.setRefMembre(m);
		 ihmGest.setRefResponsable(resp);
		
		
	}
	
	

}
