package couscous.connectors;

import couscous.observable.AbstractConnector;

public class BindingTransmitRequest extends AbstractConnector {
	
	// Rapelle à l'inverse des Composants les fournis sont à gauche et les requis à droite
	public BindingTransmitRequest() {
		super();
		this.addManageable("PortTransmitRequest", "PortReceiveRequestIntoDetail"); // Pas dans le M1
		this.addManageable("PortFSendBackData","PortReponseFromDetail");
		this.addManageable("PortReponseFromDetail", "PortReceiveResponse");
	}

}
