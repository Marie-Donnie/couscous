package couscous.connectors;

import couscous.observable.IObservable;

public interface Connector extends IObservable {
	
	public void reçoitMessage(String msg);
	public void transmetMessage(String msg);

}
