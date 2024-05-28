package accesBDD;

public class mainbddaccess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//creation de l'objet bddaccess
		BddAccess bdd = new BddAccess();
		bdd.rechercherDriver("com.mysql.jdbc.Driver");
		bdd.connecterBdd("jdbc:mysql://localhost/ecole?useSSL=false", "root", "");
		bdd.creerStatement();
		bdd.envoiRequeteUpdate("DELETE from profeleve where matiere='Philo'");

	}

}
