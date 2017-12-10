package couscous.composants;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import couscous.message.Message;
import couscous.observable.AbstractComposant;

public class Client extends AbstractComposant {

	
	public Client () {
		super();
		this.addManageable("PortReceiveAsk", "PortRetreiveRequest"); // Voir M1 cas particulier pour binding
		this.addManageable("PortRetreiveRequest", "PortSendRequest");
		this.addManageable("PortFinalReponse", "fisnish"); // On stop la chaine ici pour l'instant
	}
	
	@Override
	public void recevoirMessage(Message msg) {
		if (msg.getDestinataire() == "PortFinalReponse") {
			System.out.println("Ladies and gentlemen the response is : "+msg.getMessage());
		}else {
			envoyerMessage(msg);
		}	
	}
	
	public void afficherReponse(String msg) {
		System.out.println("La donnée que vous cherchiez est : " + msg);
	}
	
	public Message demanderDonnee() {
		String donneeCherchee = "";
		String mdp = "";
		System.out.println("Que voulez vous récupérer ? Vous pouvez chercher par nom ou id.");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
			donneeCherchee = br.readLine();
		} catch (IOException e) {
			System.out.println("Mauvais format.");
			e.printStackTrace();
		}
        System.out.print("Mot de passe ?");
        try{
            mdp = br.readLine();
        }catch(IOException e){
            System.out.println("Mauvais format.");
        }
        return new Message("Initial", donneeCherchee , mdp);
	}

}
