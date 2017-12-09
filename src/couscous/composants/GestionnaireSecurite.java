package couscous.composants;

import couscous.message.Message;
import couscous.observable.AbstractComposant;

public class GestionnaireSecurite extends AbstractComposant  {


	public GestionnaireSecurite () {
		super();
		this.addManageable("askAthorization"); // Voir 
		this.addManageable("dataReady");
	}
	@Override
	public void recevoirMessage(Message msg) {
		// TODO Auto-generated method stub
		
	}

	
	
}
