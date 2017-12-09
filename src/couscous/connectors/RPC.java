package couscous.connectors;

import couscous.observable.AbstractConnector;

public class RPC extends AbstractConnector {

	// Rapelle � l'inverse des Composants les fournis sont � gauche et les requis � droite
	public RPC() {
		super();
		this.addManageable("PortTransmitReponse", "PortFinalReponse"); // Voir M1
		this.addManageable("PortSendRequest", "PortReceiveRequest");
	}

 


}
