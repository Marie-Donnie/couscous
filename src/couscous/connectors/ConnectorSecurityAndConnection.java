package couscous.connectors;

import couscous.observable.AbstractConnector;

public class ConnectorSecurityAndConnection extends AbstractConnector {

	// Rapelle � l'inverse des Composants les fournis sont � gauche et les requis � droite
	public ConnectorSecurityAndConnection() {
		super();
		this.addManageable("PortFAskAuthorization", "PortRAskedAuthorization"); // Voir M1
		this.addManageable("PortFSendAuthorization", "PortRReceiveAuthorization");
	}
}
