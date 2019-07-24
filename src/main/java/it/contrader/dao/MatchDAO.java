package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Match;

/**
 * 
 * @author Vittorio
 *
 *Per i dettagli della classe vedi Guida sez 6: DAO
 */
public class MatchDAO implements DAO<Match> {

	private final String QUERY_ALL = "SELECT * FROM iteams.match";
	private final String QUERY_CREATE = "INSERT INTO iteams.match (idsport, iduser,rate,address,matchtime) VALUES (?,?,?,?,?)";
	private final String QUERY_READ = "SELECT * FROM iteams.match WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE iteams.match SET idsport=?, iduser=?, rate=?, address=?, matchtime=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM iteams.match WHERE id=?";

	public MatchDAO() {

	}

	public List<Match> getAll() {
		List<Match> matchsList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Match match;
			while (resultSet.next()) {
				int idSport = resultSet.getInt("idsport");
				int idUser = resultSet.getInt("iduser");
				int rate = resultSet.getInt("rate");
				String address = resultSet.getString("address");
				String matchtime = resultSet.getString("matchtime");
				int id = resultSet.getInt("id");
				match = new Match(idSport, idUser, rate, address, matchtime);
				match.setId(id);
				matchsList.add(match);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return matchsList;
	}

	public boolean insert(Match matchToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setInt(1, matchToInsert.getIdSport());
			preparedStatement.setInt(2, matchToInsert.getIdUser());
			preparedStatement.setInt(3, matchToInsert.getRate());
			preparedStatement.setString(4, matchToInsert.getAddress());
			preparedStatement.setString(5, matchToInsert.getMatchtime());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	public Match read(int matchId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {


			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, matchId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			int idSport, idUser, rate;
			String address;
			String matchtime;
			idSport = resultSet.getInt("idsport");
			idUser = resultSet.getInt("iduser");
			rate = resultSet.getInt("rate");
			address = resultSet.getString("address");
			matchtime = resultSet.getString("matchtime");
			Match match= new Match(idSport, idUser, rate, address, matchtime);
			match.setId(resultSet.getInt("id"));

			return match;
		} catch (SQLException e) {
			return null;
		}

	}

	public boolean update(Match matchToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (matchToUpdate.getId() == 0)
			return false;

		Match matchRead = read(matchToUpdate.getId());
		if (!matchRead.equals(matchToUpdate)) {
			try {
				// Fill the matchToUpdate object
				if (matchToUpdate.getIdSport() == 0) {
					matchToUpdate.setIdSport(matchRead.getIdSport());
				System.out.println("primo if ");
				}

				if (matchToUpdate.getIdUser() == 0) {
					matchToUpdate.setIdUser(matchRead.getIdUser());
				}

				if (matchToUpdate.getRate() == 0) {
					matchToUpdate.setRate(matchRead.getRate());
				}
				
				if (matchToUpdate.getAddress() == null || matchToUpdate.getAddress().equals("") || matchToUpdate.getAddress().equals("0")) {
					matchToUpdate.setAddress(matchRead.getAddress());
				}
				
				if (matchToUpdate.getMatchtime() == null || matchToUpdate.getMatchtime().equals("") || matchToUpdate.getMatchtime().equals("0")) {
					matchToUpdate.setMatchtime(matchRead.getMatchtime());
				}

				// Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setInt(1, matchToUpdate.getIdSport());
				preparedStatement.setInt(2, matchToUpdate.getIdUser());
				preparedStatement.setInt(3, matchToUpdate.getRate());
				preparedStatement.setString(4, matchToUpdate.getAddress());
				preparedStatement.setString(5, matchToUpdate.getMatchtime());
				preparedStatement.setInt(6, matchToUpdate.getId());
				int a = preparedStatement.executeUpdate();
				if (a > 0)
					return true;
				else
					return false;

			} catch (SQLException e) {
				return false;
			}
		}

		return false;

	}

	public boolean delete(int id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, id);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;

		} catch (SQLException e) {
		}
		return false;
	}


}
