package couscous.connectors;

import couscous.observable.AbstractConnector;

public class ConnectorDatabaseAndConnection extends AbstractConnector {
	

	// Rapel : à l'inverse des Composants les fournis sont à gauche et les requis à droite
	public ConnectorDatabaseAndConnection() {
		super();
		this.addManageable("PortFAskData", "PortRAskedData"); // Voir M1
		this.addManageable("PortFSendData", "PortRReceiveData");
	}
}
