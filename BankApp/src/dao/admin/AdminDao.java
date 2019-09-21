package dao.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dbutil.OracleConnection;

import accounts.Checking;
import exception.BusinessException;
import transact.Transaction;
import userdata.AccountHolder;

public class AdminDao {
	
	public ArrayList<Transaction> getAllTransactions() throws BusinessException {
		ArrayList<Transaction> mylist = new ArrayList<Transaction>();
		try (Connection connection = OracleConnection.getConnection()) {
			String sql = "select dateof, transactionno, t_type, amount, newbalance from transaction";
			PreparedStatement pstmt = connection.prepareStatement(sql);
		    ResultSet resultset = pstmt.executeQuery();
		    
		    //incomplete
		return mylist;
		}
		 catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("AdminDao.getAllTransactions " + e.getMessage());
		}
	}
	
	public ArrayList<Checking> getAllAccounts() throws BusinessException {
		ArrayList<Checking> mylist = new ArrayList<Checking>();
		try (Connection connection = OracleConnection.getConnection()) {
		String sql = "select accountno, accounttype, balance from checking";
		
		// incomplete
		return mylist;
		}
	 catch (ClassNotFoundException | SQLException e) {
		throw new BusinessException("AdminDao.getAllAccounts " + e.getMessage());
	}

	}
	
	
	public ArrayList<AccountHolder> GetAllAcountHolders() throws BusinessException{
		ArrayList<AccountHolder> mylist = new ArrayList<AccountHolder>();
		try (Connection connection = OracleConnection.getConnection()) {
		String sql = "select username, acct, passwd, flname from accountholder";
		//incomplete
		return mylist;
		}
		 catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("AdminDao.getAllAccountHolders " + e.getMessage());
		}
	}
	
	
	public long deleteTransactionById(long transactionNo) throws BusinessException{
	    
		try (Connection connection = OracleConnection.getConnection()) { 
		String sql = "delete transactionno, accountno, t_type, dateof, amount, newbalance from tranaction where transactionno = ?";
		return 7;
		
		// incomplete
		}
		  
		 
		
		 catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("deleteTranactionById.getAllAccounts " + e.getMessage());
		}
	}
	
	public void deleteAccountHolderByUserName(String username) throws BusinessException{
		
		try (Connection connection = OracleConnection.getConnection()) { 
		String sql = "delete username, acct, passwd, flname from accountholder where username = ?";
		}
		 catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("deleteAccountHolderByUserName " + e.getMessage());
		}
	}
	public void deleteCheckingByAcountNo(long accountNo) throws BusinessException {
		ArrayList<Transaction> mylist = new ArrayList<Transaction>();
		try (Connection connection = OracleConnection.getConnection()) {
		String sql = "";
		
	}
	 catch (ClassNotFoundException | SQLException e) {
		throw new BusinessException("AdminDao.deleteCheckingByAccountNo " + e.getMessage());
	}
}
	
}
