package user;

import java.sql.SQLException;

public class Admin extends User implements Editable, Deletable{

	public Admin() {
		// TODO Auto-generated constructor stub
	}

	public Admin(int id, String username, String password,String role) {
		super(id, username, password, role);
	}
	
	public Admin( String username, String password,String role) {
		super( username, password, role);
	}


	//delete message
	@Override
	public boolean deleteMessages(int id) {
		try {
			DatabaseManager.deleteMessage(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return false;
	}
	
	
	//update message
	@Override
	public boolean editMessages(int id, String text) {
		try {
			DatabaseManager.updateMessage(id, text);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return false;
	}
	
	//create a user
	public void createUsers(String username, String password, String role) {
		try {
			DatabaseManager.createUsers(username, password, role);
			//PlatformMail.getUsers().addAll(PlatformMail.getUsers() );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//view users
	public void viewUsers() {
		DatabaseManager.getUsers();
	}
	
	//delete a user
	public boolean deleteUser(int id) {
		try {
			DatabaseManager.deleteUser(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	//update a user
	public boolean updateUser(String role,int id) {
		
			DatabaseManager.updateUser(role, id);
		
		return false;
	}


	
}
