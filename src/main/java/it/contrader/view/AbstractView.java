package it.contrader.view;

import java.util.Scanner;

public abstract class AbstractView implements View {

	private Scanner scanner;

	/**
	*Questo metodo è usato da tutti i controller che lo ereditano (non devono definirlo) estendendo questa classe
	*/
	public String getInput() {
		scanner = new Scanner(System.in);
		String valore = scanner.nextLine();
		if(valore.equalsIgnoreCase("") || valore == null)
			return "0";
		return valore;
	}
}
