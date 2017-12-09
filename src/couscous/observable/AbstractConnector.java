package couscous.observable;

import java.util.Observable;
import java.util.Observer;

import couscous.composants.Composant;

public abstract class AbstractConnector implements Composant {
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

}