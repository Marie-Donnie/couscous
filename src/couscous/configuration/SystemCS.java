package couscous.configuration;

import java.util.Observable;

import couscous.composants.Client;
import couscous.composants.Server;
import couscous.connectors.Binding;
import couscous.message.Message;

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
		this.bindingSDtoCS = new Binding();	
		this.bindingSDtoCS.addObserver(this);
	}


	@Override
	public void update(Observable o, Object arg) {
		Message msg = (Message)arg;
		if (msg.getDestinataire().equals("Server")) {
			this.serveur.recevoirMessage(msg);
		}			
		if (msg.getDestinataire().equals("Client")) {
			this.client.recevoirMessage(msg);			
		}
		if (msg.getDestinataire().equals("ConnectionManager")) {
			this.bindingCStoSD.transmettreMessage(msg);
		}
		if (msg.getDestinataire().equals("SecurityManager")) {
			this.bindingCStoSD.transmettreMessage(msg);
		}
		if (msg.getDestinataire().equals("Database")) {
			this.bindingCStoSD.transmettreMessage(msg);
		}
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
