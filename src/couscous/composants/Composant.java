package couscous.composants;

import couscous.observable.IObservable;

public interface Composant extends IObservable {

	public void envoieMessage(String msg);
	public void reçoitMessage(String msg);
	
}
