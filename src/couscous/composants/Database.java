package couscous.composants;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import couscous.message.Message;
import couscous.observable.AbstractComposant;

public class Database extends AbstractComposant  {

	private static final String databasePath = "database/base_de_donnees_trop_bien.tsv";
	private ArrayList<Integer> ouverts;
	
	public Database() {
		super();
		this.ouverts = new ArrayList<Integer>();
		this.addManageable("PortRAskedData", "PortFSendData"); // Connection Manager
		this.addManageable("PortRAskedOpening", "PortFConfirmOpened"); // Security Manager
	}
	
	 @Override
	    public void recevoirMessage(Message msg) {
	        String message = msg.getMessage();
	        // Regarde si le message demande une ouverture ou les donn�es
	        if (msg.getDestinataire().equals("PortRAskedOpening")) {
	            int ret = askedOpening(message);
	            if (ret != -1) {
	                msg.setMessage(Integer.toString(ret));
	                confirmOpened(msg);
	            }
	            else {
	                msg.setMessage("Mauvais identifiant");
	                confirmOpened(msg);
	            }
	        }
	        if (msg.getDestinataire().equals("PortRAskedData")) {
	            try {
	                if (!message.equals("Mauvais identifiant")){
	                    String ret = askedData(message);
	                    msg.setMessage(ret);
	                    sendData(msg);
	                    String[] parts = ret.split("\t");
	                    String id = parts[0];
	                    closeData(Integer.parseInt(id));
	                }
	                else {
	                    msg.setMessage("L'information n'a pas �t� trouv�e. Essayez un autre identifiant");
	                    sendData(msg);
	                }
	            }
	            catch(NumberFormatException ex) {
	                System.out.println("Le message n'a pas �t� correctement renvoy�");
	            }
	        }

	    }
		
	public int openLineById(int id) {
        try {
            FileReader fileReader = new FileReader(databasePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while((line = bufferedReader.readLine()) != null) {
            	String[] parts = line.split("\t");
            	// Vérification du format de base de données
                if ( parts.length == 3 && parts[0].matches("^-?\\d+$") ) {
                	// On vérifie si la ligne est l'entrée qu'on cherche
                	if ((Integer.parseInt(parts[0]) == id)) {
                		openData(id);
                		// On referme le buffer avant de sortir
                        bufferedReader.close();
                		return id;
                	}
                }
            }   
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" 
                + databasePath + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + databasePath + "'");       
        }
        return -1;
	}
	
	public int openLineByString(String nom) {
        try {
            FileReader fileReader = new FileReader(databasePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while((line = bufferedReader.readLine()) != null) {
            	String[] parts = line.split("\t");
            	// Vérification du format de base de données
                if ( parts.length == 3 && parts[0].matches("^-?\\d+$") ) {
                	// On vérifie si la ligne est l'entrée qu'on cherche
                	if (parts[1].equals(nom)) {
                		// On récupère l'id de cette entrée
                		int id = Integer.parseInt(parts[0]);
                		openData(id);
                        bufferedReader.close();
                		return id;
                	}
                }
            }   
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" 
                + databasePath + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + databasePath + "'");       
        }
        return -1;
	}
	
	public boolean checkline(String ligne) {
		String[] parts = ligne.split("\t");
		return (parts.length == 3 && parts[0].matches("^-?\\d+$"));
	}
	
	public String askedData(String msg) {
		int ident = Integer.parseInt(msg);
		for (int id : ouverts) {
			if (id == ident) {
		        try {
		            FileReader fileReader = new FileReader(databasePath);
		            BufferedReader bufferedReader = new BufferedReader(fileReader);
		            String line;
		            while((line = bufferedReader.readLine()) != null) {
		            	String[] parts = line.split("\t");
		                if ( parts.length == 3 && parts[0].matches("^-?\\d+$") ) {
		                	if (Integer.parseInt(parts[0]) == ident) {
		    		            bufferedReader.close();
		                		return (parts[0] + "\tNom : " + parts[1] + "\tInformation : " + parts[2]);
		                	}
		                }
		            }   
		            bufferedReader.close();
		        }
		        catch(FileNotFoundException ex) {
		            System.out.println(
		                "Unable to open file '" 
		                + databasePath + "'");                
		        }
		        catch(IOException ex) {
		            System.out.println(
		                "Error reading file '" 
		                + databasePath + "'");       
		        }
			}
		}
		return "L'identifiant n'a pas été trouvé";
	}
	
	public int askedOpening(String msg) {
		if (msg.matches("^-?\\d+$")) {
			return (openLineById(Integer.parseInt(msg)));
		}
		else {
			return (openLineByString(msg));
		}
	}
	
	public void confirmOpened(Message msg) {
		envoyerMessage(msg);
	}
	
	public void sendData(Message msg) {
		envoyerMessage(msg);
	}
	
	public void openData(int id) {
		ouverts.add(id);
	}
	
	public void closeData(Integer id) {
		ouverts.remove(id);
	}

}
