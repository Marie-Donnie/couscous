package couscous.configuration;

import java.util.Observable;

import couscous.composants.ConnectionManager;
import couscous.composants.Database;
import couscous.composants.GestionnaireSecurite;
import couscous.connectors.BindingCStoClient;
import couscous.message.Message;
import couscous.observable.IObservable;

public class SystemServerDetail extends AbstractConfiguration {

	
	public SystemServerDetail() {
		super();
	}
	
	@Override
	public void update(Observable o, Object arg) {
		Message msg = (Message)arg;
		
		//Garder en commentaire car utiles pour vérifier par ou on passe 

		//System.out.println("Hey update Detail");
		//System.out.println(" msg dest update : "+ msg.getDestinataire());
		for (IObservable obs : this.getObservables()) {
			if (obs.ICanManageThis(msg.getDestinataire())) {
				obs.recevoirMessage(msg);
			}
		}
		
	}
}
