package couscous.configuration;

import java.util.Observable;

import couscous.composants.Client;
import couscous.composants.Server;
import couscous.connectors.Binding;

public class SystemCS implements Configuration {
	private Client client;
	private Server serveur;
	// nécessaire ?
	//private RPC rpc;
	private Binding bindingCStoSD;
	private Binding bindingSDtoCS;

	
	public SystemCS() {
		super();
		this.client = new Client();
		this.client.addObserver(this);
		this.serveur = new Server();
		this.serveur.addObserver(this);
		this.bindingCStoSD = new Binding();		
		this.bindingCStoSD.addObserver(this);
		this.bindingSDtoCS = new Binding();	
	}


	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Server getServeur() {
		return serveur;
	}

	public void setServeur(Server serveur) {
		this.serveur = serveur;
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





}
