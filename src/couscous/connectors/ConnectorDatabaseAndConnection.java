package couscous.connectors;

import couscous.observable.AbstractConnector;

public class ConnectorDatabaseAndConnection extends AbstractConnector {
	

	// Rapelle � l'inverse des Composants les fournis sont � gauche et les requis � droite
	public ConnectorDatabaseAndConnection() {
		super();
		this.addManageable("PortFAskData", "PortRAskedData"); // Voir M1
		this.addManageable("PortFSendData", "PortRReceiveData");
	}
}
