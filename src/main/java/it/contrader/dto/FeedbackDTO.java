package it.contrader.dto;


public class FeedbackDTO {

	private int id;
	private int idSport;
	private int idUser;
	private int rate;

	
	
	public FeedbackDTO () {}
	
	public FeedbackDTO (int id,int idSport, int idUser, int rate) {
		this.idSport= idSport;
		this.idUser= idUser;
		this.rate= rate;
		this.id= id;
		
		
		
	}

	public FeedbackDTO (int idSport, int idUser, int rate) {
		this.idSport= idSport;
		this.idUser= idUser;
		this.rate= rate;
	
	
	
		
		
	}

	public int getIdSport() {
		return idSport;
	}
	
	public void setIdSport(int idSport) {
		this.idSport= idSport;
	}
	
	public int getIdUser() {
		return idUser;
	}
	
	public void setIdUser(int idUser) {
		this.idUser= idUser;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return id + "\t" + idUser + "\t\t" + idSport + "\t\t" + rate;
	}
	
}
