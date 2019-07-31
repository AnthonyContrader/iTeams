package it.contrader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import it.contrader.dto.JoinMatchDTO;
import it.contrader.model.Feedback;
import it.contrader.utils.ConnectionSingleton;

public class JoinMatchDAO {
	
	private final String QUERY_CREATE="INSERT INTO iteams.matchusers (idMatch, idUser) VALUES (?, ?);";
	private final String QUERY_DELETE="DELETE FROM iteams.matchusers WHERE (idMatch = ?) and (idUser = ?);";
	
	
	
	public boolean insert(JoinMatchDTO jmToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setInt(1, jmToInsert.getIdMatch());
			preparedStatement.setInt(2, jmToInsert.getIdUser());
						preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}
	
	public boolean delete(JoinMatchDTO jmToDelete) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, jmToDelete.getIdMatch());
			preparedStatement.setInt(2, jmToDelete.getIdUser());
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;

		} catch (SQLException e) {
		}
		return false;
	}
}
