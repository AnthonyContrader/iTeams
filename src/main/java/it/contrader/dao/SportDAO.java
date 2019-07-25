package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Sport;

/**
 * 
 * @author Vittorio
 *
 *Per i dettagli della classe vedi Guida sez 6: DAO
 */
public class SportDAO implements DAO<Sport> {

	private final String QUERY_ALL = "SELECT * FROM iteams.sport";
	private final String QUERY_CREATE = "INSERT INTO iteams.sport (nplayers, name) VALUES (?,?)";
	private final String QUERY_READ = "SELECT * FROM iteams.sport WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE iteams.sport SET nplayers=?, name=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM iteams.sport WHERE id=?";

	public SportDAO() {

	}

	public List<Sport> getAll() {
		List<Sport> sportsList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Sport sport;
			while (resultSet.next()) {
				int players = resultSet.getInt("nplayers");
				
				String name = resultSet.getString("name");
				
				int id = resultSet.getInt("id");
				
				sport = new Sport(players, name);
				sport.setId(id);
				sportsList.add(sport);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sportsList;
	}

	public boolean insert(Sport sportToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setInt(1, sportToInsert.getPlayers());			
			preparedStatement.setString(2, sportToInsert.getName());
			preparedStatement.execute();
			return true;
			
		} catch (SQLException e) {
			return false;
		}

	}

	public Sport read(int sportId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {


			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, sportId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			int players;
			String name;
			
			players = resultSet.getInt("nplayers");
			
			name = resultSet.getString("name");
			
			Sport sport= new Sport(players, name);
			sport.setId(resultSet.getInt("id"));

			return sport;
		} catch (SQLException e) {
			return null;
		}

	}

	public boolean update(Sport sportToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (sportToUpdate.getId() == 0)
			return false;

		Sport sportRead = read(sportToUpdate.getId());
		if (!sportRead.equals(sportToUpdate)) {
			try {
				// Fill the matchToUpdate object
				if (sportToUpdate.getPlayers() == 0) {
					sportToUpdate.setPlayers(sportRead.getPlayers());
				}

							
				if (sportToUpdate.getName() == null || sportToUpdate.getName().equals("") || sportToUpdate.getName().equals("0")) {
					sportToUpdate.setName(sportRead.getName());
				}

				// Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setInt(1, sportToUpdate.getPlayers());				
				preparedStatement.setString(2, sportToUpdate.getName());				
				preparedStatement.setInt(3, sportToUpdate.getId());
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