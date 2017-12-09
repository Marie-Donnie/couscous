package couscous.observable;

import java.util.Observable;
import java.util.Observer;

import couscous.connectors.Connector;

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

	@Override
	public void reçoitMessage(String msg) {
		transmetMessage(msg);
		
	}

	@Override
	public void transmetMessage(String msg) {
		notifyObservers(msg);
		
	}
	
}
