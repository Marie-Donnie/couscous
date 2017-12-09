package couscous.connectors;

import java.util.ArrayList;

import couscous.observable.AbstractConnector;

public class BindingCStoClient extends AbstractConnector {

	public BindingCStoClient() {
		super();
		this.addManageable("PortAskClient", "PortReceiveAsk"); // Voir M1
	}


	



}
