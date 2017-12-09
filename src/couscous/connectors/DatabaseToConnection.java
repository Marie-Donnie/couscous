package couscous.connectors;

import couscous.observable.AbstractConnector;

public class DatabaseToConnection extends AbstractConnector {
	

	// Rapelle à l'inverse des Composants les fournis sont à gauche et les requis à droite
	public DatabaseToConnection() {
		super();
		this.addManageable("PortFAskData", "PortRAskedData"); // Voir M1
		this.addManageable("PortFSendData", "PortRReceiveData");
	}
}
