package couscous.connectors;

import java.util.ArrayList;

public class Case {
	
	private ArrayList<String> from = new ArrayList<String>();
	private ArrayList<String> to = new ArrayList<String> ();
	
	
	// Add un couple dans from et to
	public void addCouple(String f, String t) {
		from.add(f);
		to.add(t);
	}
	
	// Prend en paramètre un string de la liste from
	// Renvoie le string de la liste to au même indice
	//Pré-conditon : f apartient à la liste from
	public String getToCorrespondant(String f) {
		String res ="";
		int index = 0;
		for (String e : from) {
			if(e==f) {
				index =from.indexOf(e);
				res = to.get(index);
				System.out.println(res + "11");
			}
		}
		return res;
	}
	
	
	// Retourne si dans la liste de from on a bien la string
	public boolean fromContain(String str) {
		boolean verdict = false;
		
		for ( String e : from) {
			if(e == str) {
				verdict = true;
				System.out.println("Trouver " + e);
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
