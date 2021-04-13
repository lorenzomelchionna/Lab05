package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;

import java.util.List;

public class Anagrammi {
	
	public List<String> AnagrammiParola(String parola){
		
		List<String> Risultato = new ArrayList<>();
		permuta("", parola, 0, Risultato);
		return Risultato;
		
	}
	
	private void permuta(String parziale, String lettere, int livello, List<String> Risultato){
		
		if(lettere.length() == 0) {
			
			Risultato.add(parziale);
			
		} else {
			
			for(int pos=0; pos<lettere.length(); pos++) {
				
				char tentativo = lettere.charAt(pos);
				
				String nuovaParziale = parziale + tentativo;
				String nuoveLettere = lettere.substring(0, pos)+lettere.substring(pos+1);
				
				permuta(nuovaParziale, nuoveLettere, livello+1, Risultato);
				
			}
			
		}	
		
	}
	
}
