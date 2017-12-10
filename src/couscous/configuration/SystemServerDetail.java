package couscous.configuration;

import java.util.Observable;

import couscous.message.Message;
import couscous.observable.IObservable;

public class SystemServerDetail extends AbstractConfiguration {

	
	public SystemServerDetail() {
		super();
	}
	
	@Override
	public void update(Observable o, Object arg) {
		Message msg = (Message)arg;
		
		//Garder en commentaire car utiles pour v�rifier par ou on passe 

		//System.out.println("Hey update Detail");
		//System.out.println(" msg dest update : "+ msg.getDestinataire());
		for (IObservable obs : this.getObservables()) {
			if (obs.ICanManageThis(msg.getDestinataire())) {
				obs.recevoirMessage(msg);
			}
		}
		
	}
}
