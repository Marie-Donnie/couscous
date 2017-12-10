package couscous.connectors;

import couscous.observable.AbstractConnector;

public class BindingCStoClient extends AbstractConnector {
	
	// Rappel : à l'inverse des Composants les fournis sont à gauche et les requis à droite
	public BindingCStoClient() {
		super();
		this.addManageable("PortAskClient", "PortReceiveAsk"); // Voir M1
	}


	



}
