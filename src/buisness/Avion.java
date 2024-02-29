package buisness;

public class Avion {
//////////////////////////////////////////Attributs
	private String modele;
	private double capaciteMax;
	private int id;
	private static int tmp=1;

	public Avion() {
		// TODO Auto-generated constructor stub
	}

	public Avion(String modele, double capaciteMax) {
			this.id = tmp++;
			this.modele = modele;
			this.capaciteMax = capaciteMax;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public double getCapaciteMax() {
		return capaciteMax;
	}

	public void setCapaciteMax(double capaciteMax) {
		this.capaciteMax = capaciteMax;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "\n| Avion : "+id +" | Modele : " + modele + " | Capacite Max : " + capaciteMax  ;
	}

	
}
