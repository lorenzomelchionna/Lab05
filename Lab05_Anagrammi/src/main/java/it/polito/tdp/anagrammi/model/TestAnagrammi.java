package it.polito.tdp.anagrammi.model;

import java.util.List;

public class TestAnagrammi {

	public static void main(String[] args) {
		
		Anagrammi Anagrammi = new Anagrammi();
		
		List<String> AnagrammiTrovati = Anagrammi.AnagrammiParola("ciao");
		
		System.out.println(AnagrammiTrovati);

	}

}
