package couscous.connectors;

import couscous.observable.AbstractConnector;

public class ConnectorSecurityAndConnection extends AbstractConnector {

	// Rappel : à l'inverse des Composants les fournis sont à gauche et les requis à droite
	public ConnectorSecurityAndConnection() {
		super();
		this.addManageable("PortFAskAuthorization", "PortRAskedAuthorization"); // Voir M1
		this.addManageable("PortFSendAuthorization", "PortRReceiveAuthorization");
	}
}
