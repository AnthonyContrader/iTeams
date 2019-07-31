package it.contrader.dto;

public class JoinMatchDTO {
	private int idMatch;
	private int idUser;
	
	public JoinMatchDTO(int idMatch, int idUser) {
		this.idMatch = idMatch;
		this.idUser = idUser;
	}

	public int getIdMatch() {
		return idMatch;
	}

	public void setIdMatch(int idMatch) {
		this.idMatch = idMatch;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	@Override
	public String toString() {
		return "JoinMatchDTO [idMatch=" + idMatch + ", idUser=" + idUser + "]";
	}
	
	
}
