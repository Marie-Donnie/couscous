package couscous.composants;

import couscous.message.Message;
import couscous.observable.AbstractComposant;

public class Database extends AbstractComposant  {



	@Override
	public void recevoirMessage(Message msg) {
		String message = msg.getMessage();
		
		
	}

}
