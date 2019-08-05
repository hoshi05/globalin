package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Memo;

public class memoImpl extends BaseDAO implements memoDAO{
		
		private static final String MEMO_INSERT_SQL="INSERT INTO MEMO VALUES(seq_memo.nextval,?,?)";
		private static final String MEMO_SELECT_ALL_SQL="SELECT MEMOID, NAME, AGE FROM MEMO ORDER BY MEMOID DESC";
		private static final String MEMO_SELECT_BY_MEMOID_SQL = "SELECT MEMOID,NAME,AGE FROM MEMO WHERE MEMOID=?";
		private static final String MEMO_UPDATE_SQL="UPDATE MEMO SET NAME=?, AGE=? WHERE MEMOID=?";
		private static final String MEMO_DELETE_SQL="DELETE FROM MEMO WHERE MEMOID=?";
		private static final String MEMO_SELECT_BY_NAME_SQL = "SELECT MEMOID, NAME, AGE FROM MEMO WHERE NAME LIKE ? ORDER BY MEMOID DESC";
		private static final String MEMO_SELECT_FOR_PAGE_SQL="SELECT * FROM(SELECT ROWNUM AS RN, MEMOS.* FROM (SELECT * FROM MEMO ORDER BY MEMOID DESC) MEMOS)"
				+ "												 WHERE RN BETWEEN ? AND ?";
		
		@Override
		public boolean insert(Memo memo) {
			boolean result = false;
			
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			
			try {
				connection = getConnection();
				preparedStatement = connection.prepareStatement(MEMO_INSERT_SQL);
				
				preparedStatement.setString(1, memo.getName());
				preparedStatement.setInt(2, memo.getAge());

				int rowCount = preparedStatement.executeUpdate();
				
				if(rowCount>0) {
					result = true;
				}
				}catch(SQLException e) {
				e.printStackTrace();
				}finally {
				closeDBObjects(null, preparedStatement, connection);
				}			
			return result;
		}

		@Override
		public List<Memo> selectAll() {
			
			List<Memo> memos = new ArrayList<Memo>();
			
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			
			try {
				connection = getConnection();
				preparedStatement = connection.prepareStatement(MEMO_SELECT_ALL_SQL);
				resultSet = preparedStatement.executeQuery();
				
				while(resultSet.next()) {
					Memo memo = new Memo();
					memo.setMemoid(resultSet.getInt("memoid"));
					memo.setName(resultSet.getString("name"));
					memo.setAge(resultSet.getInt("age"));
					
					memos.add(memo);
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				closeDBObjects(resultSet, preparedStatement,connection);
			}
			
			return memos;
		}
		
		@Override
		public Memo selectByMemoId(int memoid) {
			Memo memo = null;	
			
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			
			try {
				connection = getConnection();
				preparedStatement = connection.prepareStatement(MEMO_SELECT_BY_MEMOID_SQL);
				preparedStatement.setInt(1, memoid);
				resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				memo = new Memo();
				
				memo.setMemoid(resultSet.getInt("memoid"));
				memo.setName(resultSet.getString("name"));
				memo.setAge(resultSet.getInt("age"));}		

				}catch(SQLException e) {
				e.printStackTrace();
				}finally {
				closeDBObjects(resultSet, preparedStatement, connection);
				}			
			return memo;
		}
		
		@Override
		public boolean update(Memo memo) {
			boolean result = false;
			
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			
			try {
				connection = getConnection();
				preparedStatement = connection.prepareStatement(MEMO_UPDATE_SQL);
				
				preparedStatement.setString(1, memo.getName());
				preparedStatement.setInt(2, memo.getAge());
				preparedStatement.setInt(3, memo.getMemoid());

				int rowCount = preparedStatement.executeUpdate();
				
				if(rowCount>0) {
					result = true;
				}
				}catch(SQLException e) {
					e.printStackTrace();
				}finally {
					closeDBObjects(null, preparedStatement, connection);
				}			
			return result;
		}
	    
		@Override
		public boolean deleteByMemoId(int memoid) {
			boolean result = false;
			
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			
			try {
				connection = getConnection();
				preparedStatement = connection.prepareStatement(MEMO_DELETE_SQL);
				
				preparedStatement.setInt(1, memoid);

				int rowCount = preparedStatement.executeUpdate();
				
				if(rowCount>0) {
					result = true;
				}
				}catch(SQLException e) {
				e.printStackTrace();
				}finally {
				closeDBObjects(null, preparedStatement, connection);
				}			
			return result;
		}

		@Override
		public List<Memo> selectByMemoName(String name) {

			List<Memo> memos = new ArrayList<Memo>();
			
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			
			try {
				connection = getConnection();
				preparedStatement = connection.prepareStatement(MEMO_SELECT_BY_NAME_SQL);
				preparedStatement.setString(1,'%'+ name+ '%');
				resultSet = preparedStatement.executeQuery();
				
				while(resultSet.next()) {
					Memo memo = new Memo();
					memo.setMemoid(resultSet.getInt("memoid"));
					memo.setName(resultSet.getString("name"));
					memo.setAge(resultSet.getInt("age"));
					
					memos.add(memo);
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				closeDBObjects(resultSet, preparedStatement,connection);
			}
			
			return memos;
		}

		
		@Override
		public List<Memo> selectAll(int rowStartNumber, int rowEndNumber) {
			
			List<Memo> memos = new ArrayList<Memo>();
			
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			
			try {
				connection = getConnection();
				preparedStatement = connection.prepareStatement(MEMO_SELECT_FOR_PAGE_SQL);
				preparedStatement.setInt(1, rowStartNumber);
				preparedStatement.setInt(2, rowEndNumber);
				resultSet = preparedStatement.executeQuery();
				
				while(resultSet.next()) {
					Memo memo = new Memo();
					memo.setMemoid(resultSet.getInt("memoid"));
					memo.setName(resultSet.getString("name"));
					memo.setAge(resultSet.getInt("age"));
					
					memos.add(memo);
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				closeDBObjects(resultSet, preparedStatement,connection);
			}
			
			return memos;
		}

		
		
}


		
