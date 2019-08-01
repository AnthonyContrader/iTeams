package it.contrader.dto;

public class JoinSportDTO {
	private int idSport;
	private int idUser;
	
	public JoinSportDTO(int idSport, int idUser) {
		this.idSport= idSport;
		this.idUser = idUser;
	}

	public int getIdSport() {
		return idSport;
	}

	public void setIdSport(int idSport) {
		this.idSport = idSport;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	@Override
	public String toString() {
		return "JoinSportDTO [idSport=" + idSport + ", idUser=" + idUser + "]";
	}
	
	
}
