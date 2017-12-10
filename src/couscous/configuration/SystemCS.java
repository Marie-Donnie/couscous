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
		
		// if msg.destinataire = initial alors on configure
		if (msg.getDestinataire() == "initial") {
			msg.setDestinataire("PortAskClient");
			this.update(o,msg);
		}
		
		for (IObservable obs : this.getObservables()) {
			if (obs.ICanManageThis(msg.getDestinataire())) {
				obs.recevoirMessage(msg);
			}
		}
		
				
	}
}
