package couscous.configuration;

import java.util.ArrayList;
import java.util.Observable;

import couscous.observable.IObservable;

public abstract class AbstractConfiguration implements Configuration {
	private ArrayList<IObservable> observables;
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}
	
	public void addObservable(IObservable o) {
		observables.add(o);
	}

}
