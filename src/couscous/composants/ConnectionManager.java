package couscous.composants;

import couscous.message.Message;
import couscous.observable.AbstractComposant;

public class ConnectionManager extends AbstractComposant  {

	public ConnectionManager() {
		super();
		this.addManageable("Authorization"); // Voir 
		this.addManageable("Request");
	}
	
	@Override
	public void recevoirMessage(Message msg) {
		// TODO Auto-generated method stub
		
	}

}
