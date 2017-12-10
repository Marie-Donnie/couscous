package couscous.application;

import couscous.composants.*;
import couscous.configuration.*;
import couscous.connectors.*;
import couscous.message.Message;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Client cl = new Client();
		ConnectionManager CoManager = new ConnectionManager();
		Database db = new Database();
		GestionnaireSecurite gestionSecu = new GestionnaireSecurite();
		Server serv = new Server();
		
		SystemCS systemCS = new SystemCS();
		SystemServerDetail systemSD = new SystemServerDetail();
		
		BindingCStoClient bindingCsClient = new BindingCStoClient();
		BindingTransmitRequest bindingTRequest = new BindingTransmitRequest();
		ConnectorDatabaseAndConnection connectorDataCo = new ConnectorDatabaseAndConnection();
		ConnectorDatabaseAndSecurity connectorDataSecu = new ConnectorDatabaseAndSecurity();
		ConnectorSecurityAndConnection connectorSecuCo = new ConnectorSecurityAndConnection();
		RPC rpc = new RPC();

		
		systemCS.addObservable(cl);
		systemCS.addObservable(serv);
		systemCS.addObservable(bindingCsClient);
		systemCS.addObservable(rpc);
		
		
		systemSD.addObservable(CoManager);
		systemSD.addObservable(db);
		systemSD.addObservable(gestionSecu);
		systemSD.addObservable(bindingTRequest);
		systemSD.addObservable(connectorDataCo);
		systemSD.addObservable(connectorDataSecu);
		systemSD.addObservable(connectorSecuCo);
				
		Message msg = new Message("Initial", "tutu","0010042");
		systemCS.ApiRequest(msg);
		 System.out.println("Fini éxé");
		

	}

}
