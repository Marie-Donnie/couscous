package couscous.observable;

import java.util.Observable;
import java.util.Observer;

import couscous.connectors.Connector;
import couscous.message.Message;

public abstract class AbstractConnector implements Connector {
	private Observable obs = new Observable();

	@Override
	public void addObserver(Observer o) {
		obs.addObserver(o);

	}

	@Override
	public void deleteObserver(Observer o) {
		obs.deleteObserver(o);

	}

	@Override
	public void notifyObservers() {
		obs.notifyObservers();

	}

	@Override
	public void notifyObservers(Object arg) {
		obs.notifyObservers(arg);

	}

	public void recevoirMessage(Message msg) {
		transmettreMessage(msg);
		
	}

	public void transmettreMessage(Message msg) {
		notifyObservers(msg);
		
	}
	
}
