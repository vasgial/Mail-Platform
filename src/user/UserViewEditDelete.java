package user;

import java.sql.SQLException;

public class UserViewEditDelete extends User implements Editable, Deletable{

	public UserViewEditDelete() {
		// TODO Auto-generated constructor stub
	}
	
	public UserViewEditDelete(int id, String username, String password,String role) {
		super(id, username, password, role);
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

	
	//update a message
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
	

}
