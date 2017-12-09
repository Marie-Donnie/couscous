package couscous.observable;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import couscous.composants.Composant;
import couscous.connectors.Case;
import couscous.message.Message;

public abstract class AbstractComposant implements Composant {
	private Observable obs = new Observable();
	private Case manageable; // Lié ou non des ports requis
	

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
		envoyerMessage(msg);
		
	}
	
	@Override
	public void envoyerMessage(Message msg) {
		msg.setDestinataire(this.manageable.getToCorespondant(msg.getDestinataire()));
		notifyObservers(msg);			
	}
	
	public void addManageable(String f, String t) {
		manageable.addCouple(f, t);
	}
	
	@Override
	public boolean ICanManageThis(String str) {
		return manageable.fromContain(str);
	}
	
	

}
