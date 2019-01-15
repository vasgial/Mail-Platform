package user;

import java.util.ArrayList;

public class Sent {
	
	private ArrayList<Message> messages;

	public Sent() {
		// TODO Auto-generated constructor stub
	}
	
	public Sent(ArrayList<Message> messages) {
		this.messages = messages;
	}

	public ArrayList<Message> getMessages() {
		return messages;
	}

	public void setMessages(ArrayList<Message> messages) {
		this.messages = messages;
	}

}
