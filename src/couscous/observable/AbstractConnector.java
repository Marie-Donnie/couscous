package couscous.observable;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import couscous.connectors.Case;
import couscous.connectors.Connector;
import couscous.message.Message;

public abstract class AbstractConnector implements Connector {
	private Observable obs = new Observable();
	private Case manageable; // Lit ou non des ports requis

	public AbstractConnector () {
		manageable = new Case();
	}
	
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
	public void recevoirMessage(Message msg) {
		transmettreMessage(msg);
		
	}
	
	@Override
	public void transmettreMessage(Message msg) {
		msg.setDestinataire(this.manageable.getToCorrespondant(msg.getDestinataire()));
		notifyObservers(msg);			
	}
	
	public void addManageable(String from, String to) {
		manageable.addCouple(from, to);
	}
	
	@Override
	public boolean ICanManageThis(String str) {
		return manageable.fromContain(str);
	}
	
	
}
