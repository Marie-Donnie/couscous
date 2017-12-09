package couscous.application;

import couscous.composants.Database;
import couscous.configuration.SystemCS;
import couscous.configuration.SystemServerDetail;
import couscous.message.Message;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SystemCS systemCS = new SystemCS();
		SystemServerDetail systemSD = new SystemServerDetail(systemCS.getBindingCStoSD(), systemCS.getBindingSDtoCS());
		Database db = systemSD.getDatabase();
		Message msg = new Message("Database", "coucou	lol");
		db.recevoirMessage(msg);
		
		

	}

}
