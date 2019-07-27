package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Feedback;

public class FeedbackDAO implements DAO<Feedback> {

	private final String QUERY_ALL = "SELECT * FROM iteams.feedback";
	private final String QUERY_CREATE = "INSERT INTO iteams.feedback (idsport, iduser,rate) VALUES (?,?,?)";
	private final String QUERY_READ = "SELECT * FROM iteams.feedback WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE iteams.feedback SET idsport=?, iduser=?, rate=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM iteams.feedback WHERE id=?";

	public FeedbackDAO() {

	}

	public List<Feedback> getAll() {
		List<Feedback> feedbacksList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Feedback feedback;
			while (resultSet.next()) {
				int idSport = resultSet.getInt("idsport");
				int idUser = resultSet.getInt("iduser");
				int rate = resultSet.getInt("rate");
				int id = resultSet.getInt("id");
				feedback = new Feedback(idSport, idUser, rate);
				feedback.setId(id);
				feedbacksList.add(feedback);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return feedbacksList;
	}

	public boolean insert(Feedback feedbackToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setInt(1, feedbackToInsert.getIdSport());
			preparedStatement.setInt(2, feedbackToInsert.getIdUser());
			preparedStatement.setInt(3, feedbackToInsert.getRate());
			
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	public Feedback read(int feedbackId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {


			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, feedbackId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			int idSport, idUser, rate;
			idSport = resultSet.getInt("idsport");
			idUser = resultSet.getInt("iduser");
			rate = resultSet.getInt("rate");
			Feedback feedback= new Feedback(idSport, idUser, rate);
			feedback.setId(resultSet.getInt("id"));

			return feedback;
		} catch (SQLException e) {
			return null;
		}

	}

	public boolean update(Feedback feedbackToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		if (feedbackToUpdate.getId() == 0)
			return false;

		Feedback feedbackRead = read(feedbackToUpdate.getId());
		if (!feedbackRead.equals(feedbackToUpdate)) {
			try {
				if (feedbackToUpdate.getIdSport() == 0) {
					feedbackToUpdate.setIdSport(feedbackRead.getIdSport());
				System.out.println("primo if ");
				}

				if (feedbackToUpdate.getIdUser() == 0) {
					feedbackToUpdate.setIdUser(feedbackRead.getIdUser());
				}

				if (feedbackToUpdate.getRate() == 0) {
					feedbackToUpdate.setRate(feedbackRead.getRate());
				}
				
				
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setInt(1, feedbackToUpdate.getIdSport());
				preparedStatement.setInt(2, feedbackToUpdate.getIdUser());
				preparedStatement.setInt(3, feedbackToUpdate.getRate());
				preparedStatement.setInt(4, feedbackToUpdate.getId());
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
