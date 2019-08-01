package it.contrader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import it.contrader.dto.JoinSportDTO;
import it.contrader.model.Feedback;
import it.contrader.utils.ConnectionSingleton;

public class JoinSportDAO {
	
	private final String QUERY_CREATE="INSERT INTO `iteams`.`sportusers` (`idsport`, `iduser`) VALUES (?, ?);";
	private final String QUERY_DELETE="DELETE FROM `iteams`.`sportusers` WHERE (`idsport` = ?) and (`iduser` = ?);";
	
	
	
	public boolean insert(JoinSportDTO jmToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setInt(1, jmToInsert.getIdSport());
			preparedStatement.setInt(2, jmToInsert.getIdUser());
						preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}
	
	public boolean delete(JoinSportDTO jmToDelete) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, jmToDelete.getIdSport());
			preparedStatement.setInt(2, jmToDelete.getIdUser());
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;

		} catch (SQLException e) {
		}
		return false;
	}
}