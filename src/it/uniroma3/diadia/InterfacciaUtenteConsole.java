package it.uniroma3.diadia;

import java.util.Scanner;

public class InterfacciaUtenteConsole implements InterfacciaUtente {

	@Override
	public void mostraMessaggio(String messaggio) {
		System.out.println(messaggio);
		
	}

	@Override
	public String prendiIstruzione() {
		Scanner scannerDiparole=new Scanner(System.in);
		return scannerDiparole.nextLine();
	}

}
