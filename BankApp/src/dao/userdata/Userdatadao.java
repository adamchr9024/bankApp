package dao.userdata;



//import accounts.Checking;
import exception.BusinessException;
//import transact.Transaction;
import userdata.AccountHolder;

public interface Userdatadao {
	
	boolean createUser(String username, String pw, String flname, String question, String answer) throws BusinessException;
	boolean deleteUser(String username) throws BusinessException;
	boolean updateUser (String username, String newpw) throws BusinessException;
	 AccountHolder find( String username) throws BusinessException;
}
