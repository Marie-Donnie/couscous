package couscous.composants;

import couscous.message.Message;
import couscous.observable.AbstractComposant;

public class Client extends AbstractComposant {

	
	public Client () {
		super();
		this.addManageable("ReceiveAsk"); // Voir 
		this.addManageable("RetreiveRequest");
	}
	
	public void envoyerMessageAuServeur(String msg) {		
		Message message = new Message("Server", msg);
		envoyerMessage(message);
	}

	@Override
	public void recevoirMessage(Message msg) {
		// TODO Auto-generated method stub
		
	}

}
