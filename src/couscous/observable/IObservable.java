package couscous.observable;

import java.util.Observer;

import couscous.message.Message;

public interface IObservable {

	void addObserver(Observer o);
	void deleteObserver(Observer o);
	void notifyObservers();
	void notifyObservers(Object arg);
	
	boolean ICanManageThis(String str);
	public void recevoirMessage(Message msg);
}
