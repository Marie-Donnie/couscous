package couscous.composants;

import couscous.message.Message;
import couscous.observable.AbstractComposant;

public class Client extends AbstractComposant {

	
	public Client () {
		super();
		this.addManageable("PortReceiveAsk", "PortRetreiveRequest"); // Voir M1 cas particulier pour binding
		this.addManageable("PortRetreiveRequest", "PortSendRequest");
		this.addManageable("PortFinalReponse", "fisnish"); // On stop la chaine ici pour l'instant
	}
	
	@Override
	public void recevoirMessage(Message msg) {
		if (msg.getDestinataire() == "PortFinalReponse") {
			System.out.println(msg.getMessage());
		}else {
			envoyerMessage(msg);
		}	
	}

}
