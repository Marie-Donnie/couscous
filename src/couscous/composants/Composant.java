package couscous.composants;

import couscous.message.Message;
import couscous.observable.IObservable;

public interface Composant extends IObservable {

	public void envoyerMessage(Message msg);
	public void recevoirMessage(Message msg);
	
}
