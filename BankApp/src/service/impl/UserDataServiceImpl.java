package service.impl;

import exception.BusinessException;
import service.UserDataService;
import userdata.AccountHolder;
import dao.userdata.UserDataDaoImpl;

public class UserDataServiceImpl implements UserDataService {

	private UserDataDaoImpl uddi = new UserDataDaoImpl();

	@Override
	public boolean createUser(String username, String pw, String flname, String question, String answer) throws BusinessException {
		
		try{// TODO Auto-generated method stub
			
		return	uddi.createUser(username, pw, flname, question, answer);
		}
		
		catch(BusinessException ex) {
			throw ex;
		}
	}

	@Override
	public boolean deleteUser(String username) throws BusinessException {
		// TODO Auto-generated method stub
	 try {
		return uddi.deleteUser(username);
	  }catch(BusinessException ex) {
		  throw ex;
	  }
	}

	@Override
	public boolean updateUser(String username, String newpw) throws BusinessException {
	  try {	// TODO Auto-generated method stub
		return uddi.updateUser(username, newpw);
	 }
	  catch(BusinessException ex) {
		 throw ex; 
	  }
	}

	@Override
	public AccountHolder find(String username) throws BusinessException {
		AccountHolder ac = null;// TODO Auto-generated method stub
		try {
			ac = uddi.find(username);
         
			return ac;
        
		} catch (BusinessException ex) {
			throw ex;

		}

	}

	public AccountHolder find(String username, String pw) throws BusinessException {
		AccountHolder ac = null;// TODO Auto-generated method stub
		try {
			ac = uddi.find(username, pw);
			if(ac != null)
			   return ac;
			 else
	        	 throw new BusinessException("User name and password not found");
		} catch (BusinessException ex) {
			throw ex;
		}
	}
	public String getSecurityQuestion(String username) throws BusinessException{
		String question_answer = "";
		try {
			 question_answer = uddi.getSecurityQuestion(username);
			if(question_answer == null)
				throw new BusinessException("Username was not found");
			return question_answer;  //and answer
		}
		catch(BusinessException ex) {
			throw ex;
		}
	}

}
