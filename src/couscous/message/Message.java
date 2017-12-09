package couscous.message;

import couscous.composants.Composant;

public class Message {
	private Class<? extends Composant> destinataire;
	private String message;
	
	public Message(Class<? extends Composant> destinataire, String message) {
		super();
		this.destinataire = destinataire;
		this.message = message;
	}

	public Class<? extends Composant> getDestinataire() {
		return destinataire;
	}

	public void setDestinataire(Class<Composant> destinataire) {
		this.destinataire = destinataire;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
