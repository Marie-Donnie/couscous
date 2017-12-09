package couscous.composants;

import couscous.message.Message;
import couscous.observable.AbstractComposant;

public class Client extends AbstractComposant {

	
	public void envoyerMessageAuServeur(String msg) {		
		Message message = new Message(Server.class, msg);
		envoyerMessage(message);
	}

	@Override
	public void recevoirMessage(Message msg) {
		// TODO Auto-generated method stub
		
	}

}
