package couscous.configuration;

import java.util.ArrayList;
import java.util.Observable;

import couscous.message.Message;
import couscous.observable.IObservable;

public abstract class AbstractConfiguration implements Configuration {
	private ArrayList<IObservable> observables = new ArrayList<IObservable>();
	
	
	public ArrayList<IObservable> getObservables() {
		return observables;
	}

	public void setObservables(ArrayList<IObservable> observables) {
		this.observables = observables;
	}

	@Override
	public void update(Observable o, Object arg) {
		Message msg = (Message)arg;
		
		for (IObservable obs : this.getObservables()) {
			if (obs.ICanManageThis(msg.getDestinataire())) {
				obs.recevoirMessage(msg);
			}
		}
	}
	
	public void addObservable(IObservable o) {
		observables.add(o);
		o.addObserver(this);
	}
	

	

}
