package couscous.observable;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import couscous.composants.Composant;
import couscous.connectors.Case;
import couscous.message.Message;

public abstract class AbstractComposant implements Composant {
	private Observable obs = new Observable();
	private ArrayList<Observer> listObs = new ArrayList<Observer>();
	private Case manageable; // Lit ou non des ports requis
	

	public AbstractComposant() {
		this.manageable = new Case();
	}

	@Override
	public void addObserver(Observer o) {
		obs.addObserver(o);
		listObs.add(o);
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
		msg.setDestinataire(this.manageable.getToCorrespondant(msg.getDestinataire()));
		for ( Observer obs : listObs) {
			obs.update(this.obs,msg);
		}			
	}
	
	public void addManageable(String from, String to) {
		manageable.addCouple(from, to);
	}
	
	@Override
	public boolean ICanManageThis(String str) {
		return manageable.fromContain(str);
	}

	public Observable getObs() {
		return obs;
	}

	public void setObs(Observable obs) {
		this.obs = obs;
	}

	public Case getManageable() {
		return manageable;
	}

	public void setManageable(Case manageable) {
		this.manageable = manageable;
	}
	
	

}
