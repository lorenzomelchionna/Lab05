package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;

import java.util.List;

import it.polito.tdp.anagrammi.db.DizionarioDAO;

public class Anagrammi {
	
	DizionarioDAO dao = new DizionarioDAO();
	
	public List<String> AnagrammiParola(String parola){
		
		List<String> Risultato = new ArrayList<>();
		
		List<String> RisultatoCorretto = new ArrayList<>();
		
		permuta("", parola, 0, Risultato);
		
		for(String s : Risultato)
			if(dao.parolaValida(s))
				RisultatoCorretto.add(s);
		
		return RisultatoCorretto;
		
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
