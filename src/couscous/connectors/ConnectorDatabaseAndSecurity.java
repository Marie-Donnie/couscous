package couscous.connectors;

import couscous.observable.AbstractConnector;

//Connector entre la BD et le gestionnaire de sécurité
public class ConnectorDatabaseAndSecurity extends AbstractConnector {
	
	// Rapel: à l'inverse des Composants les fournis sont à gauche et les requis à droite
	public ConnectorDatabaseAndSecurity () {
		super();
		this.addManageable("PortFRequestOpening", "PortRAskedOpening"); // Voir M1
		this.addManageable("PortSendRequest", "PortRDataReady");
	}

}
