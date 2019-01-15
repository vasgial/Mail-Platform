package user;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PlatformMail {
	
	/*private Admin admin;*/
	
	static ArrayList<User> users;
	
	private static ArrayList<Message> messages;
	

	public PlatformMail() {
		downloadUsers();
		// TODO Auto-generated constructor stub
	}
	
	
	//save messages into java
	public void downloadMessages(int id) {
		messages = DatabaseManager.viewMessages(id);
	}
	
	//save users into java
	public void downloadUsers() {
		users = DatabaseManager.getUsers();
	}
	
	public static ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

	public static ArrayList<Message> getMessages() {
		return messages;
	}

	public void setMessages(ArrayList<Message> messages) {
		this.messages = messages;
	}
 
	//if exist username
	public boolean exist(String username) {
		boolean exi = false;
		for(int i=0 ; i<users.size() ; i++) {
			if(username.equals(users.get(i).getUsername())) {
				exi = true;
				break;
			}
		}
		return exi;
	}
	
	//if exist message_id
	public boolean existMessageId(int id) {
		boolean exi = false;
		for(int i=0 ; i<messages.size() ; i++) {
			if(id == messages.get(i).getId()) {
				exi = true;
				break;
			}
		}
		return exi;
	}
	
	//if exist user_id
	public boolean existUserId(int id) {
		boolean exi = false;
		for(int i=0 ; i<users.size() ; i++) {
			if(id == users.get(i).getId()) {
				exi = true;
				break;
			}
		}
		return exi;
	}
	
	
	
	//confirm password
	public boolean confirm(String username, String password) {
		boolean conf = false;
		for(int i=0 ; i<users.size() ; i++) {
			if(password.equals(users.get(i).getPassword()) && username.equals(users.get(i).getUsername()) ) {
				conf = true;
				break;
			}
		}
		return conf;
	}
	
	public User getUser(String username){
		User user = null;
		for(int i=0 ; i<users.size() ; i++) {
			if(users.get(i).getUsername().equals(username)) {
				user = users.get(i);
				break;
			}
		}
		return user;
	}
	
	public static User getUserId(int id){
		User user = null;
		for(int i=0 ; i<users.size() ; i++) {
			if(users.get(i).getId() ==id) {
				user = users.get(i);
				break;
			}
		}
		return user;
	}
	
	public static String getUsernameFromId(int id) {
		for(int i=0 ; i<users.size() ; i++) {
			if(users.get(i).getId() ==id) {
				return users.get(i).getUsername();
			
			}
		}
		return null;
	}
	
	public static int getMessageIndexFromId(int id) {
		for(int i=0 ; i<messages.size() ; i++) {
			if(messages.get(i).getId() == id) {
				return i;
			}
		}
		return -1;
	}
	
	public static void printUsers() {
		for(int i=0 ; i<users.size() ; i++) {
			System.out.println(users.get(i));
		}
	}
	
	public static void printMessages() {
		for(int i=0 ; i<messages.size() ; i++) {
			System.out.println(messages.get(i));
		}
	}
	

}
