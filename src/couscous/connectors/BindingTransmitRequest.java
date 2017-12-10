package couscous.connectors;

import couscous.observable.AbstractConnector;

public class BindingTransmitRequest extends AbstractConnector {
	
	// Rapelle � l'inverse des Composants les fournis sont � gauche et les requis � droite
	public BindingTransmitRequest() {
		super();
		this.addManageable("PortTransmitRequest", "PortReceiveRequestIntoDetail"); // Pas dans le M1
		this.addManageable("PortFSendBackData","PortReponseFromDetail");
		this.addManageable("PortReponseFromDetail", "PortReceiveResponse");
	}

}
