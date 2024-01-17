package buisness;

import java.util.Date;

public class Vol {
//////////////////////////////////////////Attributs
	private String destination;
	private String origine; 
	private Employe pilote;
	private String depart;
	private String arrive; 
	private Avion  avion;
	
	public Vol() {
		// TODO Auto-generated constructor stub
	}

	public Vol(String destination, String origine, Employe pilote, String depart, String arrive, Avion avion) {
		super();
		this.destination = destination;
		this.origine = origine;
		this.pilote = pilote;
		this.depart = depart;
		this.arrive = arrive;
		this.avion = avion;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getOrigine() {
		return origine;
	}

	public void setOrigine(String origine) {
		this.origine = origine;
	}

	public Employe getPilote() {
		return pilote;
	}

	public void setPilote(Employe pilote) {
		this.pilote = pilote;
	}

	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}

	public String getArrive() {
		return arrive;
	}

	public void setArrive(String arrive) {
		this.arrive = arrive;
	}

	public Avion getAvion() {
		return avion;
	}

	public void setAvion(Avion avion) {
		this.avion = avion;
	}

	@Override
	public String toString() {
		return "Vol [destination=" + destination + ", origine=" + origine + ", pilote=" + pilote + ", depart=" + depart
				+ ", arrive=" + arrive + ", avion=" + avion + "]";
	}

	

}
