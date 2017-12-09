package couscous.connectors;

import couscous.observable.AbstractConnector;

//Connector entre la BD et le g�stionnaire de s�curit�
public class ConnectorDatabaseAndSecurity extends AbstractConnector {
	
	// Rapelle � l'inverse des Composants les fournis sont � gauche et les requis � droite
	public ConnectorDatabaseAndSecurity () {
		super();
		this.addManageable("PortFRequestOpening", "PortRAskedOpening"); // Voir M1
		this.addManageable("PortSendRequest", "PortRDataReady");
	}

}
