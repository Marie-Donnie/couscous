package couscous.composants;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import couscous.message.Message;
import couscous.observable.AbstractComposant;

public class Database extends AbstractComposant  {



	@Override
	public void recevoirMessage(Message msg) {
		String message = msg.getMessage();
		String[] parts = message.split("\t");
		if (parts.length == 2) {
			
		}
		else {
			
		}
		
		String filename	= "database/base_de_donnees_trop_bien.tsv";
		
        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while((line = bufferedReader.readLine()) != null) {
                
            }   
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                filename + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + filename + "'");       
        }
		
	}

}
