package it.contrader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import it.contrader.dto.FeedbackAvgDTO;
import it.contrader.dto.MatchCountDTO;
import it.contrader.model.Match;
import it.contrader.utils.ConnectionSingleton;

public class MatchCountDAO {
	
	private final String QUERY_ALL = "SELECT * FROM iteams.matchcount";
	private final String QUERY_READ = "SELECT * FROM iteams.matchcount WHERE idMatch=?";
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public MatchCountDAO() {
		
	}
	
	public List<MatchCountDTO> getAll() {
		List<MatchCountDTO> feedbackAvgList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			MatchCountDTO feedbackavg;
			while (resultSet.next()) {
				int subscribers= resultSet.getInt("subscribers");
				int idMatch= resultSet.getInt("idMatch");
				Date matchtime = resultSet.getTimestamp("matchtime");
				String address = resultSet.getString("address");
				int max = resultSet.getInt("max");
				feedbackavg = new MatchCountDTO(subscribers, idMatch, matchtime, address, max);
				feedbackAvgList.add(feedbackavg);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return feedbackAvgList;
	}
	
	public MatchCountDTO read(int id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {


			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			int subscribers, idMatch, max;
			String address;
			Date matchtime;
			subscribers = resultSet.getInt("subscribers");
			idMatch = resultSet.getInt("idMatch");
			matchtime = resultSet.getTimestamp("matchtime");
			address = resultSet.getString("address");
			max = resultSet.getInt("max");
			//localTime = LocalDateTime.parse(matchtime, formatter);
			MatchCountDTO match= new MatchCountDTO(subscribers, idMatch, matchtime, address, max);

			return match;
		} catch (SQLException e) {
			return null;
		}

	}
	
}
