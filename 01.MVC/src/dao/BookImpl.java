package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookImpl extends BaseDAO implements BookDAO{
	
	private static final String SELECT_BY_PUBLISHER_SQL="SELECT DISTINCT PUBLISHER FROM BOOK";

	@Override
	public List<String>  selectByPublisher() {
		List<String> publishers = new ArrayList<String>();
			
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(SELECT_BY_PUBLISHER_SQL);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				resultSet.getString("publisher");	
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeDBObjects(resultSet, preparedStatement,connection);
		}
		
		System.out.println(publishers);
		return publishers;
	}
}
