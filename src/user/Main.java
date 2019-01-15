package user;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
	
	
	static Scanner sc = new Scanner(System.in);
	static Scanner scn = new Scanner(System.in);
	static PlatformMail pl = new PlatformMail();
	static DatabaseManager db = new DatabaseManager();
	
	//create message	
	public static void getMessage(User user) {
		System.out.println("give me receiver username");
		String username = sc.next();
		sc.nextLine();
		if(pl.exist(username)) {
			System.out.println("write the text: ");
			String text = sc.nextLine().trim();
			user.createMessages(text, pl.getUser(username).getId());
			Message.writeMessage( username, user.getUsername() , text);
			pl.downloadMessages(user.getId());
		} else {
			System.out.println("this username doesn't exist!");
		}
		
	}
	
	//create user
	public static void getNewUser(Admin admin) {
		System.out.println("give me the new username");
		String username = sc.nextLine();
		System.out.println("give me the new password");
		String password = sc.nextLine();
		System.out.println("give me the user's role");
		System.out.println("1.UserView.");
		System.out.println("2.UserViewEdit.");
		System.out.println("3.UserViewEditDelete.");
		String role = sc.nextLine();
		switch(role) {
		case "1":
			role = "UserView";
			admin.createUsers(username, password, role);
			pl.downloadUsers();
			break;
		case "2":
			role = "UserViewEdit";
			admin.createUsers(username, password, role);
			pl.downloadUsers();
			break;
		case "3":
			role = "UserViewEditDelete";
			admin.createUsers(username, password, role);
			pl.downloadUsers();
			break;
		default:
			System.out.println("Wrong choice!.");
		}
		
	}
	
	//delete  messages
	public static void deleteAMessage() {
		System.out.println("Which  message do you want to delete? ");
		for(int i=0 ; i<PlatformMail.getMessages().size() ; i++) {
			System.out.println(PlatformMail.getMessages().get(i));
		}
		System.out.println("Which message's id do you want to delete?");
		int messageId = scn.nextInt();
		if(pl.existMessageId(messageId)) {
			try {
				DatabaseManager.deleteMessage(messageId);
				PlatformMail.getMessages().remove(PlatformMail.getMessageIndexFromId(messageId));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			System.out.println("This id doesn't exist.");
		}
	} 
	
	//delete user
	public static void deleteAUser() {
		System.out.println("Who user do you want to delete? ");
		for(int i=0 ; i<PlatformMail.getUsers().size() ; i++) {
			System.out.println(PlatformMail.getUsers().get(i));
		}
		System.out.println("Please write the user's id: ");
		int userId = scn.nextInt();
		if(pl.existUserId(userId)) {
			try {
				DatabaseManager.deleteUser(userId);
				pl.downloadUsers();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			System.out.println("This id doesn't exist.");
		}
	}
	
	
	//update message
	public static void updateAMessage(int userId) {
		System.out.println("Which message do you want to update? ");
		for(int i=0 ; i<PlatformMail.getMessages().size() ; i++) {
			System.out.println(PlatformMail.getMessages().get(i));
		}
		System.out.println();
		System.out.println("Please write the message's id: ");
		int messageId = scn.nextInt();
		if(pl.existMessageId(messageId)) {
			try {
				System.out.println("Please write the new text: ");
				String text = sc.nextLine();
				DatabaseManager.updateMessage(messageId, text);
				pl.downloadMessages(userId);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//update a user
	public static void updateAUser() {
		System.out.println("Who user do you want to update? ");
		for(int i=0 ; i<PlatformMail.getUsers().size() ; i++) {
			System.out.println(PlatformMail.getUsers().get(i));
		}
		System.out.println();
		System.out.println("Please write the user's id: ");
		int userId = scn.nextInt();
		//System.out.println(pl.existUserId(userId));
		if(pl.existUserId(userId)) {
			System.out.println("give me the user's role");
			System.out.println("1.UserView.");
			System.out.println("2.UserViewEdit.");
			System.out.println("3.UserViewEditDelete.");
			String role = sc.nextLine();
			switch(role) {
			case "1":
				role = "UserView";
				DatabaseManager.updateUser(role, userId);
				pl.downloadUsers();
				break;
			case "2":
				role = "UserViewEdit";
				DatabaseManager.updateUser(role, userId);
				pl.downloadUsers();
				break;
			case "3":
				role = "UserViewEditDelete";
				DatabaseManager.updateUser(role, userId);
				pl.downloadUsers();
				break;
			default:
				System.out.println("Wrong choice!.");
			}
		

				
			
		}
	}
	
	
	public static void main(String[] args) {

		
		boolean running = true;
		while(running) {
			//System.out.println("Sossss!!!");
			System.out.print("username: ");
			String username = sc.nextLine();
			if(pl.exist(username)) {
				System.out.println("password: ");
				String password = sc.nextLine();
				
				
				if(pl.confirm(username, password)) {
					
					User.writeAction(username,  "login");
					if(username.equals("admin") && password.equals("admin")) {
						Admin admin= new Admin(1, "admin", "admin", "admin");
						pl.downloadMessages(1);
						//admin menu
						boolean adminRunning = true;
						while(adminRunning ) {
							System.out.println("What do you want to do?");
							System.out.println("-----------------");
							System.out.println("USER MENU: ");
							System.out.println("1.View all Users?");
							System.out.println("2.Create a new User?");
							System.out.println("3.Delete a User");
							System.out.println("4.Update the role of a user?");
							System.out.println("-----------------");
							System.out.println("MESSAGE MENU: ");
							System.out.println("5.View messages?");
							System.out.println("6.Create a new message?");
							System.out.println("7.Update a message? ");
							System.out.println("8.Delete a message?");
							System.out.println("-----------------");
							System.out.println("L.LogOut!");
							String answer1 = sc.nextLine();
							switch(answer1) {
							case "1":
								PlatformMail.printUsers();
								User.writeAction(username,  "View all Users");
								break;
							case "2":
								getNewUser(admin);
								User.writeAction(username,  "Create a new User");
								break;
							case "3":
								deleteAUser();
								User.writeAction(username,  "Delete a User");
								break;
							case "4":
								updateAUser();
								User.writeAction(username,  "Update the role of a user");
								break;
							case "5":
								PlatformMail.printMessages();
								User.writeAction(username,  "View messages");
								break;
							case "6":
								getMessage(admin);
								User.writeAction(username,  "Create a new message");
								break;
							case "7":
								updateAMessage(1);
								User.writeAction(username,  "Update a message");
								break;
							case "8":
								deleteAMessage();
								User.writeAction(username,  "Delete a message");
								break;
							case "L":
								adminRunning = false;
								User.writeAction(username,  "Logout");
								break;
							default:
								System.out.println("wrong command!!");
								System.out.println();
							}
						}
						
					}
					else {
						//user menu
						User user= pl.getUser(username);
						pl.downloadMessages(user.getId());
						boolean userRunning = true;
						while(userRunning) {
							System.out.println("What do you want to do?");
							System.out.println("1.View messages? ");
							System.out.println("2.Create a new message? ");
							
							if (user instanceof UserViewEditDelete || user instanceof UserViewEdit) {
								System.out.println("3.Update a message? ");
							}
							if((user instanceof UserViewEditDelete)) {
								System.out.println("4.Delete a message? ");
							}
							System.out.println("L.LogOut! ");
							String answer = sc.nextLine();
							switch(answer) {
							case "1" : 
								//DatabaseManager.viewMessages();
								PlatformMail.printMessages();
								User.writeAction(username,  "View messages");
								System.out.println("------------------");
								break;
							case "2" :
								getMessage(user);
								User.writeAction(username,  "Create a new message");
								break;
							case "3" :
								if (user instanceof UserViewEditDelete || user instanceof UserViewEdit) {
									updateAMessage(user.getId());
									User.writeAction(username,  "Update a message");
								}else {
									System.out.println("wrong command!!");
								}
								break;
							case "4" :
								if((user instanceof UserViewEditDelete)) {
									deleteAMessage();
									User.writeAction(username,  "Delete a message");
								}else {
									System.out.println("wrong command!!");
								}
								
								break;
							case "L" :
								userRunning = false;
								User.writeAction(username,  "Logout");
								break;
							default:
								System.out.println("wrong command!!");	
							
							}
						}
						
						
					}
				}
			}	
			else {
				System.out.println("This username doesn't exist. Please try again! ");
			}
			
		}
		

	}
	
	

}
