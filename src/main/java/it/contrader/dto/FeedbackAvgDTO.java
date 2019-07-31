package it.contrader.dto;

public class FeedbackAvgDTO {
	
	private String sportname;
	private String username;
	private double average;
	
	public FeedbackAvgDTO()  {
		super();
	}

	public FeedbackAvgDTO(String sportname, String username, double average) {
		super();
		this.sportname = sportname;
		this.username = username;
		this.average = average;
	}

	public String getSportname() {
		return sportname;
	}

	public void setSportname(String sportname) {
		this.sportname = sportname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public double getAverage() {
		return average;
	}

	public void setAverage(double average) {
		this.average = average;
	}

	@Override
	public String toString() {
		return "FeedbackAvgDTO [sportname=" + sportname + ", username=" + username + ", average=" + average + "]";
	}
	
}
