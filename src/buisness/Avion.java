package buisness;

public class Avion {
//////////////////////////////////////////Attributs
	private String modele;
	private double capaciteMax;
	private int id;

	public Avion() {
		// TODO Auto-generated constructor stub
	}

	public Avion(int id , String modele, double capaciteMax) {
			this.id = id;
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
		return "Avion{" +
				"modele='" + modele + "\n" +
				", capaciteMax=" + capaciteMax +"\n"+
				", id=" + id +"\n"+
				'}';
	}
}
