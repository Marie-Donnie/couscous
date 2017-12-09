package couscous.composants;

import couscous.message.Message;
import couscous.observable.AbstractComposant;

public class ConnectionManager extends AbstractComposant  {

	public ConnectionManager() {
		super();
		this.addManageable("PortRRequestArrive", "PortFRequestOpening"); // Pas dans le M1 (Request Arrive)
		this.addManageable("PortRReceiveAuthorization", "PortFAskData");
		this.addManageable("PortRReceiveData", "PortFSendBackData");// Pas dans le M1 (Send Back Data)
	}


}
