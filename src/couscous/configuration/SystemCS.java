package couscous.configuration;

import java.util.Observable;

import couscous.composants.Client;
import couscous.composants.Server;
import couscous.connectors.BindingCStoClient;
import couscous.message.Message;
import couscous.observable.IObservable;

public class SystemCS extends AbstractConfiguration {

	
	public SystemCS() {
		super();
		
	}
	
	@Override
	public void update(Observable o, Object arg) {
		Message msg = (Message)arg;
		Boolean trouver = false;
		
		for (IObservable obs : this.getObservables()) {
			if (obs.ICanManageThis(msg.getDestinataire())) {
				trouver = true;
				obs.recevoirMessage(msg);
			}
		}
		
		//Si trouver = false alors c'est le message initial et on configue le déstinataire en conséquence
		if( trouver == false) {
			msg.setDestinataire("PortAskClient");
			this.update(o, msg);
		}
	}
}
