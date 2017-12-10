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
		this.addManageable("PortRAskedData", "PortFSendData"); // Connection Manager
		this.addManageable("PortRAskedOpening", "PortFConfirmOpened"); // Security Manager
	}
	
	@Override
	public void recevoirMessage(Message msg) {
		if (msg.getDestinataire().equals("PortRAskedData")) {
			askedData(msg.getMessage());
		}

	}
		
	public void openLineById(int id) {
        try {
            FileReader fileReader = new FileReader(databasePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while((line = bufferedReader.readLine()) != null) {
            	String[] parts = line.split("\t");
                if ( parts.length == 4 && parts[0].matches("^-?\\d+$") ) {
                	if ((Integer.parseInt(parts[0]) == id)) {
                		ouverts.add(id);
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
	
	public void openLineByString(String nom) {
        try {
            FileReader fileReader = new FileReader(databasePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while((line = bufferedReader.readLine()) != null) {
            	String[] parts = line.split("\t");
                if ( parts.length == 3 && parts[0].matches("^-?\\d+$") ) {
                	if (parts[1].equals("nom")) {
                		ouverts.add(Integer.parseInt(parts[0]));
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
	
	public boolean checkline(String ligne) {
		String[] parts = ligne.split("\t");
		return (parts.length == 3 && parts[0].matches("^-?\\d+$"));
	}
	
	public void askedData(String msg) {
		if (msg.matches("^-?\\d+$")) {
			openLineById(Integer.parseInt(msg));
		}
		else {
			openLineByString(msg);
		}		
	}
	

}
