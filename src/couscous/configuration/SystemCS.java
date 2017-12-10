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
		System.out.println("Hey update");
		for (IObservable obs : this.getObservables()) {
			if (obs.ICanManageThis(msg.getDestinataire())) {
				obs.recevoirMessage(msg);
			}
		}
		
	}
	
	public void ApiRequest(Message msg) {
		if (msg.getDestinataire() == "Initial") {
			msg.setDestinataire("PortAskClient");
		}
		for (IObservable obs : this.getObservables()) {
			if (obs.ICanManageThis(msg.getDestinataire())) {
				obs.recevoirMessage(msg);
			}
		}
		
	}
}
