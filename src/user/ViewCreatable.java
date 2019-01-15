package user;

public interface ViewCreatable {

	abstract void createMessages(String text, int receiver_id);
	
	abstract boolean viewMessages();
}
