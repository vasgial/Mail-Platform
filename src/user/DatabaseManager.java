package user;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import user.User;




public class DatabaseManager {

	
		static DatabaseManager dbManager;
		private static Connection conn;
		
		DatabaseManager() {
			conn=conn();
		}
		
		private static Connection conn() {
			if(conn==null) {
				try {
					conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/platform_mail?autoReconnect=true&useSSL=false","user","test");
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return conn;
		}
		
		public static DatabaseManager dbManager() {
			if(dbManager==null) {
				dbManager=new DatabaseManager();
			}
			return dbManager;
		}
		public static void close() {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
		//view messages
		public static ArrayList<Message> viewMessages(int id1) {			
			ArrayList<Message> messages = new ArrayList<Message>();
			String viewMessagesSQL = "SELECT * FROM messages WHERE receiver_id=? OR senter_id = ?";
	
			PreparedStatement preparedStatement;
			
			try {
				preparedStatement = conn().prepareStatement(viewMessagesSQL);
				preparedStatement.setInt(1, id1);
				preparedStatement.setInt(2, id1);
				ResultSet rs = preparedStatement.executeQuery();
				while (rs.next()) {
					int id = rs.getInt("id");
					int receiver_id = rs.getInt("receiver_id");
					int senter_id = rs.getInt("senter_id");
					String dateTime = rs.getString("dateTime");
					String text = rs.getString("text");
					boolean receiverHasRead = rs.getBoolean("receiverHasRead");
					new User();
					messages.add(new Message(id, PlatformMail.getUserId(receiver_id) , PlatformMail.getUserId(senter_id) , dateTime, text, receiverHasRead));
					//System.out.println(id + " " +PlatformMail.getUsernameFromId(senter_id) + " " + PlatformMail.getUsernameFromId(receiver_id) + " " + dateTime + " " + text +  " " );
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return messages;
		}
		
				
		//view users
		public static ArrayList<User> getUsers(){
			ArrayList<User> users = new ArrayList<User>();
			String selectSQL = "select * from users";
			PreparedStatement preparedStatement;
			try {
				preparedStatement = conn().prepareStatement(selectSQL);
				ResultSet rs = preparedStatement.executeQuery(selectSQL );
				//System.out.println("id " + "username " + "password " + "role " );
				while (rs.next()) {
					int id = rs.getInt("id");
					String username = rs.getString("username");	
					String password = rs.getString("password");
					String role = rs.getString("role");
					new User();
					if(role.equals("UserView")) {
						users.add(new UserView(id, username, password, role));
					} 
					else if(role.equals("UserViewEdit")) {
						users.add(new UserViewEdit(id, username, password, role));
					}
					else if(role.equals("UserViewEditDelete")) {
						users.add(new UserViewEditDelete(id, username, password, role));
					}
					else {
						users.add(new Admin(id, username, password, role));
					}
					
					//System.out.println(id + " " + username + " " + password + " " + role);
					
				}
				//System.out.println(" ");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return users;
			
		}		
		
		//create message
		public static void createMessages(String dateTime, String text, int senter_id, int receiver_id) throws SQLException {
			String createMessageSQL = "INSERT INTO platform_mail.messages" 
						+ "(id, dateTime, text, senter_id, receiver_id, receiverHasRead) VALUES"
						+ "(null, ?, ?, ?, ?, false)";
			PreparedStatement preparedStatement = conn.prepareStatement(createMessageSQL);
			
			preparedStatement.setString(1, dateTime); 
			preparedStatement.setString(2, text);
			preparedStatement.setInt(3, senter_id);
			preparedStatement.setInt(4, receiver_id);
			
			preparedStatement.executeUpdate();
		}
		
		//create user
		public static void createUsers(String username, String password, String role) throws SQLException {
			String createUsersSQL = "INSERT INTO platform_mail.users"
					+ "(id, username, password, role) VALUES"
					+ "(null, ?, ?, ?)";
			PreparedStatement preparedStatement = conn.prepareStatement(createUsersSQL);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			preparedStatement.setString(3, role);
			
			preparedStatement.executeUpdate();
		}
		
		
		//delete message
		public static void deleteMessage(int id) throws SQLException {
		
			String deleteMessageSQL = "DELETE FROM messages WHERE id=?";
			PreparedStatement preparedStatement = conn.prepareStatement(deleteMessageSQL);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		}
		
		
		//delete user
		public static void deleteUser(int id) throws SQLException {
			String deleteUserSQL = "DELETE FROM users WHERE id=?";
			PreparedStatement preparedStatement = conn.prepareStatement(deleteUserSQL);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		}
		
		//update message
		public static void updateMessage(int id, String text) throws SQLException {
			String updateMessageSQL = "UPDATE messages SET text = ? WHERE id = ?";
			PreparedStatement preparedStatement = conn.prepareStatement(updateMessageSQL);
			preparedStatement.setString(1, text);
			preparedStatement.setInt(2, id);
			preparedStatement .executeUpdate();
		}
		
		
		//update user
		public static void updateUser(String role, int id)  {
			String updateUserSQL = "UPDATE users SET role = ? WHERE id = ?";
			PreparedStatement preparedStatement;
			try {
				preparedStatement = conn.prepareStatement(updateUserSQL);
				preparedStatement.setString(1, role);
				preparedStatement.setInt(2, id);
				preparedStatement .executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

}
