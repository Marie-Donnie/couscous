package couscous.composants;

import couscous.message.Message;
import couscous.observable.AbstractComposant;

public class Server extends AbstractComposant {

	public Server() {
		super();
		this.addManageable("ReceiveReponse"); // Voir 
		this.addManageable("ReceiveRequest");
	}
	
	public void envoyerMessageAuClient(String msg) {
		Message message = new Message("Client", msg);
		envoyerMessage(message);
	}
	
	public void envoyerMessageAuConnectionManager(String msg) {
		Message message = new Message("ConnectionManager", msg);
		envoyerMessage(message);
	}
	
	@Override
	public void recevoirMessage(Message msg) {
		// TODO Auto-generated method stub
		
	}

}
