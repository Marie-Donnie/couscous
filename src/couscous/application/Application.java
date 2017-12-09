package couscous.application;

import couscous.configuration.SystemCS;
import couscous.configuration.SystemServerDetail;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SystemCS systemCS = new SystemCS();
		SystemServerDetail systemSD = new SystemServerDetail(systemCS.getBindingCStoSD(), systemCS.getBindingSDtoCS());
		
		

	}

}
