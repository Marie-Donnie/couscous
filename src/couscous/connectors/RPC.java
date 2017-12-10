package couscous.connectors;

import couscous.observable.AbstractConnector;

public class RPC extends AbstractConnector {

	// Rappel : à l'inverse des Composants les fournis sont à gauche et les requis à droite
	public RPC() {
		super();
		this.addManageable("PortTransmitReponse", "PortFinalReponse"); // Voir M1
		this.addManageable("PortSendRequest", "PortReceiveRequest");
	}

 


}
