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

	public void ajouterVol(int id,String destination,String origine,String depart,String arrive){
		System.out.println("Choisir l'id de l'employee : ");
		int pilote_id = sc.nextInt();
		Employe pilote = searchByIdEmploye(listeEmploye,pilote_id);

		System.out.println("Choisir l'id de l'avion : ");
		int avion_id = sc.nextInt();
		Avion avion = searchByIdAvion(listeAvion,avion_id);

		Vol vol = new Vol(id,destination,origine,pilote,avion,depart,arrive);
		listeVols.add(vol);
		System.out.println("Vous avez bien ajoutez " + vol);
	}

	public void modifierEmploye() {
		System.out.println("Choisir l'id de l'employee : ");
		int employe_id = sc.nextInt();
		Employe employe = searchByIdEmploye(listeEmploye,employe_id);
		System.out.println("Entrer le nouveau username : ");
		String employeUsername = sc.nextLine();
		employe.setUsername(employeUsername);

		System.out.println("Entrer le nouveau password : ");
		String employe_password = sc.nextLine();
		employe.setPassword(employe_password);


		System.out.println("Entrer le nouveau nom : ");
		String employe_nom = sc.nextLine();
		employe.setNom(employe_nom);


		System.out.println("Entrer le nouveau prenom : ");
		String employe_prenom = sc.nextLine();
		employe.setPrenom(employe_prenom);


		System.out.println("Entrer le nouveau role : ");
		String employe_role = sc.nextLine();
		employe.setRole(employe_role);


		System.out.println("Entrer le nouveau salaire : ");
		double employe_salaire = sc.nextDouble();
		employe.setSalaire(employe_salaire);
	}

	public void modifierAvion() {
		System.out.println("Choisir l'id de l'avion : ");
		int avion_id = sc.nextInt();
		Avion avion = searchByIdAvion(listeAvion,avion_id);

		System.out.println("Entrer le nouveau modele : ");
		String avion_model = sc.nextLine();
		avion.setModele(avion_model);


		System.out.println("Entrer le nouveau capacite maximal : ");
		double avion_capaciteMax = sc.nextDouble();
		avion.setCapaciteMax(avion_capaciteMax);
	}

	public void modifierVol(){
		System.out.println("Choisir l'id du vol :  ");
		int vol_id = sc.nextInt();
		Vol vol = searchByIdVol(listeVols,vol_id);

		System.out.println("Entrer le nouveau destination : ");
		String vol_destination = sc.nextLine();
		vol.setDestination(vol_destination);


		System.out.println("Entrer le nouveau origine: ");
		String vol_origine = sc.nextLine();
		vol.setOrigine(vol_origine);


		System.out.println("Entrer le nouveau id de pilote qui vous voulez modifier : ");
		int pilote_id = sc.nextInt();
		Employe pilote = searchByIdEmploye(listeEmploye,pilote_id);
		vol.setPilote(pilote);

		System.out.println("Entrer le nouveau id d'avion qui vous voulez modifier : ");
		int avion_id = sc.nextInt();
		Avion avion = searchByIdAvion(listeAvion,avion_id);
		vol.setAvion(avion);

		System.out.println("Entrer le nouveau depart : ");
		String vol_depart = sc.nextLine();
		vol.setDepart(vol_depart);


		System.out.println("Entrer le nouveau arrive: ");
		String vol_arrive= sc.nextLine();
		vol.setArrive(vol_arrive);
	}


	public void supprimerEmploye() {
		System.out.println("Choisir l'id de l'employee : ");
		int employe_id = sc.nextInt();
		Employe employe = searchByIdEmploye(listeEmploye,employe_id);

		listeEmploye.remove(employe);
	}

	public void supprimerAvion() {
		System.out.println("Choisir l'id de l'avion : ");
		int avion_id = sc.nextInt();
		Avion avion = searchByIdAvion(listeAvion,avion_id);

		listeAvion.remove(avion);
	}

	public void supprimerVol(){
		System.out.println("Choisir l'id du vol :  ");
		int vol_id = sc.nextInt();
		Vol vol = searchByIdVol(listeVols,vol_id);

		listeVols.remove(vol);
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

	public void genererRapportAeroport(){
		System.out.println("La liste des avions disponibles : ");
		listeAvion.toString();
		System.out.println("\nLa liste des vols dipsonibles : ");
		listeVols.toString();
		System.out.println("\nLa liste des employes : ");
		listeEmploye.toString();
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

	private static Vol searchByIdVol(ArrayList<Vol> listeVols,int id) {
		for (Vol vol : listeVols) {
			if (vol.getId() == id) {
				return vol;
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