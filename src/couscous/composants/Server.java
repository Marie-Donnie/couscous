package couscous.composants;

import couscous.message.Message;
import couscous.observable.AbstractComposant;

public class Server extends AbstractComposant {

	public Server() {
		super();
		this.addManageable("PortReceiveReponse", "PortTransmitReponse"); // Voir M1
		this.addManageable("PortReceiveRequest", "PortTransmitRequest");
	}
	
	
	
	

}
