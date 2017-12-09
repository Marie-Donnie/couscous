package couscous.observable;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import couscous.composants.Composant;
import couscous.message.Message;

public abstract class AbstractComposant implements Composant {
	private Observable obs = new Observable();
	private ArrayList<String> manageable = new ArrayList<String>();
	
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
	public void envoyerMessage(Message msg) {
		notifyObservers(msg);		
	}
	
	public void addManageable(String str) {
		manageable.add(str);
	}
	
	public boolean ICanManageThis(String str) {
		boolean verdict = false;
		for ( String e : manageable) {
			if(e == str) {
				verdict = true;
			}
		}
		return verdict;
	}
	
	

}
