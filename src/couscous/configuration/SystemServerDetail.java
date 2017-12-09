package couscous.configuration;

import java.util.Observable;

import couscous.composants.ConnectionManager;
import couscous.composants.Database;
import couscous.composants.GestionnaireSecurite;
import couscous.connectors.Binding;
import couscous.message.Message;

public class SystemServerDetail implements Configuration {


	private ConnectionManager connectionmanager;
	private GestionnaireSecurite securitymanager;
	private Database database;
	private Binding bindingCStoSD;
	private Binding bindingSDtoCS;
	
	
	public SystemServerDetail(Binding bindingCStoSD, Binding bindingSDtoCS) {
		super();
		this.connectionmanager = new ConnectionManager();
		this.securitymanager = new GestionnaireSecurite();
		this.database = new Database();	
		this.bindingCStoSD = bindingCStoSD;
		this.bindingCStoSD.addObserver(this);
		this.bindingSDtoCS = bindingSDtoCS;		
	}

	
	public ConnectionManager getConnectionmanager() {
		return connectionmanager;
	}

	public void setConnectionmanager(ConnectionManager connectionmanager) {
		this.connectionmanager = connectionmanager;
	}

	public GestionnaireSecurite getSecuritymanager() {
		return securitymanager;
	}


	public void setSecuritymanager(GestionnaireSecurite securitymanager) {
		this.securitymanager = securitymanager;
	}


	public Database getDatabase() {
		return database;
	}

	public void setDatabase(Database database) {
		this.database = database;
	}

	public Binding getBindingCStoSD() {
		return bindingCStoSD;
	}


	public void setBindingCStoSD(Binding bindingCStoSD) {
		this.bindingCStoSD = bindingCStoSD;
	}


	public Binding getBindingSDtoCS() {
		return bindingSDtoCS;
	}


	public void setBindingSDtoCS(Binding bindingSDtoCS) {
		this.bindingSDtoCS = bindingSDtoCS;
	}


	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		Message msg = (Message)arg;
		if (msg.getDestinataire().equals("ConnectionManager")) {
			this.connectionmanager.recevoirMessage(msg);
		}
		if (msg.getDestinataire().equals("SecurityManager")) {
			this.securitymanager.recevoirMessage(msg);
		}
		if (msg.getDestinataire().equals("Database")) {
			this.database.recevoirMessage(msg);
		}
	}

}
