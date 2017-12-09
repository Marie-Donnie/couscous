package couscous.configuration;

import java.util.Observable;

import couscous.composants.ConnectionManager;
import couscous.composants.Database;
import couscous.connectors.Binding;

public class SystemServerDetail implements Configuration {


	private ConnectionManager connectionmanager;
	private SecurityManager securitymanager;
	private Database database;
	private Binding bindingCStoSD;
	private Binding bindingSDtoCS;
	
	
	public SystemServerDetail(Binding bindingCStoSD, Binding bindingSDtoCS) {
		super();
		this.connectionmanager = new ConnectionManager();
		this.securitymanager = new SecurityManager();
		this.database = new Database();	
		this.bindingCStoSD = bindingCStoSD;
		this.bindingSDtoCS = bindingSDtoCS;		
		this.bindingSDtoCS.addObserver(this);
	}

	
	public ConnectionManager getConnectionmanager() {
		return connectionmanager;
	}

	public void setConnectionmanager(ConnectionManager connectionmanager) {
		this.connectionmanager = connectionmanager;
	}

	public SecurityManager getSecuritymanager() {
		return securitymanager;
	}

	public void setSecuritymanager(SecurityManager securitymanager) {
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
		
	}

}
