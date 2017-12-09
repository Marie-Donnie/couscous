package couscous.connectors;

import java.util.ArrayList;

public class Case {
	
	private ArrayList<String> from = new ArrayList<String>();
	private ArrayList<String> to = new ArrayList<String> ();
	
	
	// Add un couple dans from et to
	public void addCouple(String f, String t) {
		from.add(f);
		from.add(t);
	}
	
	// Prend en param�tre un string de la liste from
	// Renvoie le string de la liste to au m�me index
	//Pr�-conditon : f apartient � la liste from
	public String getToCorespondant(String f) {
		String res ="";
		int index = 0;
		for (String e : from) {
			if(e==f) {
				index =from.indexOf(e);
				res = to.get(index);
			}
		}
		return res;
	}
	
	
	// Dit si dans la liste de from on a bien str
	public boolean fromContain(String str) {
		boolean verdict = false;
		
		for ( String e : from) {
			if(e == str) {
				verdict = true;
			}
		}
		
		return verdict;
	}
	
	public ArrayList<String> getFrom() {
		return from;
	}
	public void setFrom(ArrayList<String> from) {
		this.from = from;
	}
	public ArrayList<String> getTo() {
		return to;
	}
	public void setTo(ArrayList<String> to) {
		this.to = to;
	}
	
	

}
