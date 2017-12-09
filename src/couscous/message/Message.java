package couscous.message;

public class Message {
	private String destinataire;
	private String message;
	private String mdp;
	
	public String getMdp() {
		return mdp;
	}


	public Message(String destinataire, String message, String mdp) {
		super();
		this.destinataire = destinataire;
		this.message = message;
		this.mdp = mdp;
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
