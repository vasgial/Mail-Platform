package user;

import java.sql.SQLException;

public class UserViewEdit extends User implements Editable{

	public UserViewEdit() {
		// TODO Auto-generated constructor stub
	}
	
	public UserViewEdit(int id, String username, String password,String role) {
		super(id, username, password, role);
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
