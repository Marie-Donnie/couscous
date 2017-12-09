package couscous.connectors;

import java.util.ArrayList;

import couscous.observable.AbstractConnector;

public class BindingCStoClient extends AbstractConnector {
	
	// Rapelle à l'inverse des Composants les fournis sont à gauche et les requis à droite
	public BindingCStoClient() {
		super();
		this.addManageable("PortAskClient", "PortReceiveAsk"); // Voir M1
	}


	



}
