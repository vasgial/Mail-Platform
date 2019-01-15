package user;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class Message {
	
	private int id;
	private String dateTime;
	private String text;
	private User senter;
	private User receiver;
	private boolean receiverHasRead;

	public Message() {
		// TODO Auto-generated constructor stub
	}
	
	public Message(int id, User receiver,User  senter,String dateTime,String text,boolean receiverHasRead) {
		this.id = id;
		this.receiver = receiver;
		this.senter = senter;
		this.dateTime = dateTime;
		this.text = text;
		this.receiverHasRead = receiverHasRead;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public User getSenter() {
		return senter;
	}

	public void setSenter(User senter) {
		this.senter = senter;
	}

	public User getReceiver() {
		return receiver;
	}

	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}

	public boolean isReceiverHasRead() {
		return receiverHasRead;
	}

	public void setReceiverHasRead(boolean receiverHasRead) {
		this.receiverHasRead = receiverHasRead;
	}
	
	public String toString() {
		return "id: " + id + " ,senter: " + senter.getUsername() + " ,receiver: " + receiver.getUsername() +  " ,dateTime: " + dateTime + " ,text: " + text + " ,receiverHasRead: " + receiverHasRead + ". ";		
	}
	
	public static void writeMessage(String receiver, String sent, String text ) {
		try {
			Date date = new Date(System.currentTimeMillis());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			String currentTime = sdf.format(date);
		
			String str= currentTime + " " + sent + " " +  receiver + " " + text ;
		    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("Message_file.txt", true)));
		    out.println(str);
		    out.close();
		} catch (IOException e) {
		    //exception handling left as an exercise for the reader
		}
	}

}
