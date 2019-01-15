package user;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class User implements ViewCreatable {

	private int id;
	private String username;
	private String password;
	private Received received;
	private Sent sent;
	private String role;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(String username, String password, Received received, Sent sent, String role) {
		this.username = username;
		this.password = password;
		this.received = received;
		this.sent = sent;
		this.role = role;
	}
	
	
	public User(String username, String password, String role) {
		this.username = username;
		this.password = password;
		this.role = role;
	}
	
	public User(int id,String username, String password, String role) {
		this.username = username;
		this.password = password;
		this.role = role;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Received getReceived() {
		return received;
	}

	public void setReceived(Received received) {
		this.received = received;
	}

	public Sent getSent() {
		return sent;
	}

	public void setSent(Sent sent) {
		this.sent = sent;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
	//create a message
	@Override
	public void createMessages(String text, int receiver_id)  {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			String currentTime = sdf.format(date);
		try {
			DatabaseManager.createMessages(currentTime,text, this.id, receiver_id) ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	//view messages
	@Override
	public boolean viewMessages() {
		DatabaseManager.viewMessages(id);
		System.out.println();
		// TODO Auto-generated method stub
		return false;
	}
		

	public String toString() {
		return "id: " + id  + ", username: " + username + ", password: " + password + ", role:" + role + ". ";		
	}
	
	public static void writeAction(String username, String action ) {
		try {
			Date date = new Date(System.currentTimeMillis());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			String currentTime = sdf.format(date);
		
			String str= currentTime + " " + username + " " + action ;
		    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("Action_User_file.txt", true)));
		    out.println(str);
		    out.close();
		} catch (IOException e) {
		    //exception handling left as an exercise for the reader
		}
	}
}
