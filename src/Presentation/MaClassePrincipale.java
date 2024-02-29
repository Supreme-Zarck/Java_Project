package Presentation;

import java.sql.SQLException;

import DAO.MaConnexion;
import DAO.AeroportDAO;

public class MaClassePrincipale {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		MaConnexion connexion=new MaConnexion();
		AeroportDAO Arcane = new AeroportDAO(connexion);
	}
}