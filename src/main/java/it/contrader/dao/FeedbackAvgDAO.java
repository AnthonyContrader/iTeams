package it.contrader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.FeedbackAvgDTO;
import it.contrader.utils.ConnectionSingleton;

public class FeedbackAvgDAO {
	
	private final String QUERY_ALL = "SELECT * FROM iteams.feedbackavg";
	private final String QUERY_READ_USER = "SELECT * FROM iteams.feedbackavg WHERE username=?";
	private final String QUERY_READ_SPORT = "SELECT * FROM iteams.feedbackavg WHERE sportname=?";
		
	public FeedbackAvgDAO() {

	}

	public List<FeedbackAvgDTO> getAll() {
		List<FeedbackAvgDTO> feedbackAvgList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			FeedbackAvgDTO feedbackavg;
			while (resultSet.next()) {
				String sportName = resultSet.getString("sportname");
				String userName = resultSet.getString("username");
				double average = resultSet.getDouble("average");
				feedbackavg = new FeedbackAvgDTO(sportName, userName, average);
				feedbackAvgList.add(feedbackavg);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return feedbackAvgList;
	}

	public List<FeedbackAvgDTO> readUser(String user) {
		List<FeedbackAvgDTO> feedbackAvgList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ_USER);
			preparedStatement.setString(1, user);
			ResultSet resultSet = preparedStatement.executeQuery();
			FeedbackAvgDTO feedbackavg;
			while (resultSet.next()) {
				String sportName = resultSet.getString("sportname");
				String userName = resultSet.getString("username");
				double average = resultSet.getDouble("average");
				feedbackavg = new FeedbackAvgDTO(sportName, userName, average);
				feedbackAvgList.add(feedbackavg);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return feedbackAvgList;
	}
	
	
	
	public List<FeedbackAvgDTO> readSport(String sport) {
		List<FeedbackAvgDTO> feedbackAvgList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ_SPORT);
			preparedStatement.setString(1, sport);
			ResultSet resultSet = preparedStatement.executeQuery();
			FeedbackAvgDTO feedbackavg;
			while (resultSet.next()) {
				String sportName = resultSet.getString("sportname");
				String userName = resultSet.getString("username");
				double average = resultSet.getDouble("average");
				feedbackavg = new FeedbackAvgDTO(sportName, userName, average);
				feedbackAvgList.add(feedbackavg);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return feedbackAvgList;
	}
	

	/*public boolean insert(FeedbackAvgDAO dto) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean update(FeedbackAvgDAO dto) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}*/
	
}
