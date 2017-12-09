package couscous.observable;

import java.util.Observer;

public interface IObservable {

	void addObserver(Observer o);
	void deleteObserver(Observer o);
	void notifyObservers();
	void notifyObservers(Object arg);
}
