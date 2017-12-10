package couscous.application;

import couscous.composants.Database;
import couscous.configuration.SystemCS;
import couscous.configuration.SystemServerDetail;
import couscous.message.Message;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Database db = new Database();
		
		
		SystemCS systemCS = new SystemCS();
		SystemServerDetail systemSD = new SystemServerDetail();
		
		
		systemSD.addObservable(db);
		
		Message msg = new Message("Initial", "tutu","0010042");
		db.recevoirMessage(msg);
		
		

	}

}
