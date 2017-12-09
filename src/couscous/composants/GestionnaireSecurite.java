package couscous.composants;

import couscous.message.Message;
import couscous.observable.AbstractComposant;

public class GestionnaireSecurite extends AbstractComposant  {
	
	private int mdpExpected = 0010042;

	public GestionnaireSecurite () {
		super();
		this.addManageable("PortRAskedAuthorization", "PortFRequestOpening"); // Voir M1
		this.addManageable("PortRDataReady", "PortTransmitRequest");
	}
	
	
	// Vérifie si on a le bon mdp
	@Override
	public void recevoirMessage(Message msg) {
		try {
			if (msg.getMdp()!= mdpExpected) {
				throw new Exception();
			}
			envoyerMessage(msg);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
}
