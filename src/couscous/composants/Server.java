package couscous.composants;

import couscous.message.Message;
import couscous.observable.AbstractComposant;

public class Server extends AbstractComposant {


	public void envoyerMessageAuClient(String msg) {
		Message message = new Message(Client.class, msg);
		envoyerMessage(message);
	}
	
	public void envoyerMessageAuConnectionManager(String msg) {
		Message message = new Message(ConnectionManager.class, msg);
		envoyerMessage(message);
	}
	
	@Override
	public void recevoirMessage(Message msg) {
		// TODO Auto-generated method stub
		
	}

}
