package couscous.connectors;

import couscous.message.Message;
import couscous.observable.IObservable;

public interface Connector extends IObservable {
	
	public void recevoirMessage(Message msg);
	public void transmettreMessage(Message msg);

}
