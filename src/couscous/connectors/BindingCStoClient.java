package couscous.connectors;

import java.util.ArrayList;

import couscous.observable.AbstractConnector;

public class BindingCStoClient extends AbstractConnector {
	
	// Rapelle � l'inverse des Composants les fournis sont � gauche et les requis � droite
	public BindingCStoClient() {
		super();
		this.addManageable("PortAskClient", "PortReceiveAsk"); // Voir M1
	}


	



}
