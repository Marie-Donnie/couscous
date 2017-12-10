package couscous.configuration;

import java.util.Observable;

import couscous.message.Message;
import couscous.observable.IObservable;

public class SystemCS extends AbstractConfiguration {

	
	public SystemCS() {
		super();
		
	}
	
	@Override
	public void update(Observable o, Object arg) {
		Message msg = (Message)arg;
		
		//Garder en commentaire car utiles pour v�rifier par ou on passe 
		
		//System.out.println("Hey update CS");
		//System.out.println(" msg dest update : "+ msg.getDestinataire());
		//System.out.println("msg content : "+ msg.getMessage());
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
