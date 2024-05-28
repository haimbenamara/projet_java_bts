package projet_E_5;

import java.sql.ResultSet;

import accesBDD.BddAccess;

public class Membre {
 private BddAccess  refBdd = null;
 private ResultSet result;
 
 
 public void visualiserConseils(String typeConseil) {
	 String req = "select libelle, dateParution from conseils where type=";
	 req = req + "'"+typeConseil+"'";
	 result = refBdd.envoiRequeteSelect(req);
	 //pour recuperer le resutat d'une requete select on doit le mettre 
	 //dans un objet de type resultset
	 refBdd.recupereReponseSelect();
	 
 }
 
 public void setRefBdd(BddAccess bdd) {
	 refBdd = bdd;
 }
}
