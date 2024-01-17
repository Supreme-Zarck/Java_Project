package buisness;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends Person{
////////////////////////////////////////// Attributs
		Scanner sc = new Scanner(System.in);

	private ArrayList<Employe> listeEmploye = new ArrayList<>();
	private ArrayList<Avion> listeAvion = new ArrayList<>();
	private ArrayList<Vol> listeVols = new ArrayList<>();
	private String[] jours = {"Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi"};
	
////////////////////////////////////////// Constructor 
	public Admin(int id,String username, String password, String nom, String prenom) {
		super(id,username,password,nom,prenom);
	}

////////////////////////////////////////// Methods 
	public void ajouterEmploye(int id,String username, String password, String nom, String prenom, String role ,double Salaire) {
		Employe employe = new Employe(id,username, password, nom, prenom, role, Salaire);
		listeEmploye.add(employe);
		System.out.println("Vous avez bien ajoutez " + employe);
	}

	public void ajouterAvion(int id,String modele,double capaciteMax) {
		Avion avion = new Avion(id,modele,capaciteMax);
		listeAvion.add(avion);
		System.out.println("Vous avez bien ajoutez " + avion);
	}

	public void ajouterVol(String destination,String origine,String depart,String arrive){
		System.out.println("Choisir l'id de l'employee : ");
		int pilote_id = sc.nextInt();
		Employe pilote = searchByIdEmploye(listeEmploye,pilote_id);
		
		System.out.println("Choisir l'id de l'avion : ");
		int avion_id = sc.nextInt();
		Avion avion = searchByIdAvion(listeAvion,avion_id);
		
		Vol vol = new Vol(destination,origine,pilote,depart,arrive,avion);
		listeVols.add(vol);
		System.out.println("Vous avez bien ajoutez " + vol);
	}
	
	
	
	public void affecterEmploiDuTemps() {
	    for (String jour : jours) {
	        for (Vol vol : listeVols) {
	            if (vol.getDepart().toLowerCase().contains(jour.toLowerCase()) && vol.getArrive().toLowerCase().contains(jour.toLowerCase())) {
	                Employe pilote = searchByIdEmploye(listeEmploye, vol.getPilote().getId());
	                String emploi = vol.getDepart() + " - " + vol.getArrive();

	                if (pilote.getEmploi() == null) {
	                    pilote.setEmploi(new ArrayList<>());
	                }

	                pilote.getEmploi().add(emploi);
	            }
	        }

	        for (Employe employe : listeEmploye) {
	            if (!employe.getRole().equalsIgnoreCase("pilote")) {
	                String emploi = jour + " 09:00 AM - 05:00 PM";

	                if (employe.getEmploi() == null) {
	                    employe.setEmploi(new ArrayList<>());
	                }

	                employe.getEmploi().add(emploi);
	            }
	        }
	    }
	}

	public void afficherEmplois() {
	    for (Employe employe : listeEmploye) {
	        System.out.println("Emploi de " + employe.getNom() + " " + employe.getPrenom() + ":");
	        if (employe.getEmploi() != null) {
	            for (String emploi : employe.getEmploi()) {
	                System.out.println("- " + emploi);
	            }
	        } else {
	            System.out.println("Pas d'emploi assigné.");
	        }
	        System.out.println();  // Add a newline for better readability
	    }
	}


	private static Employe searchByIdEmploye(ArrayList<Employe> listeEmploye,int id) {
		for (Employe employe : listeEmploye) {
			if (employe.getId() == id) {
				return employe;
			}
		}
		return null;
	}

	private static Avion searchByIdAvion(ArrayList<Avion> listeAvion,int id) {
		for (Avion avion : listeAvion) {
			if (avion.getId() == id) {
				return avion;
			}
		}
		return null;
	}


	//////////////////////////////////////////toString
	@Override
	public String toString() {
		return "Admin [listeEmploye=" + listeEmploye + "]";
	}
	
}
