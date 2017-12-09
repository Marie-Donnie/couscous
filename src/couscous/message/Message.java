package couscous.message;

public class Message {
	private String destinataire;
	private String message;
	
	public Message(String destinataire, String message) {
		super();
		this.destinataire = destinataire;
		this.message = message;
	}

	public String getDestinataire() {
		return destinataire;
	}

	public void setDestinataire(String destinataire) {
		this.destinataire = destinataire;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
