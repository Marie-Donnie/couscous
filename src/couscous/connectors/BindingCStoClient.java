package couscous.connectors;

import java.util.ArrayList;

import couscous.observable.AbstractConnector;

public class BindingCStoClient extends AbstractConnector {
	private ArrayList<String> manageable = new ArrayList<String>(); // Li� ou non des ports requis

	@Override
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
