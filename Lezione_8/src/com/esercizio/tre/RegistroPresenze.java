package com.esercizio.tre;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;

public class RegistroPresenze {
	
	private static File file = new File("doc/test.txt");
	private Map<String, Integer> Registro;
	
	public RegistroPresenze() throws IOException {
		Registro = new HashMap<String, Integer>();
		deleteFile();
	}
	public void addDipendente(Dipendente d) {
		Registro.put(d.name, d.getPresenze());
		try {
			writeOnFile(d);
			System.out.println("Dipendente memorizzato in locale");
			System.out.println(readFile());
			System.out.println();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	public void licenziaDipendente(Dipendente d) {
			Registro.remove(d.name, d.getPresenze());
	}
	public void getAndSaveDipendenti() throws IOException {
		for(String name: Registro.keySet()) {
			Integer presenze = Registro.get(name);
			System.out.println("Nome: " + name + " Presenze: " + presenze);
		}
		String text = FileUtils.readFileToString(file, "UTF-8");
		System.out.println();
		System.out.println("Dipendenti salvati in locale: " + text);
		System.out.println(text);
		System.out.println();
	}
	private void writeOnFile(Dipendente d) throws IOException{
		FileUtils.writeStringToFile(file, d.name+"@"+d.getPresenze()+"#" , "UTF-8", true);
	}
	public String readFile() throws IOException {
		String text = FileUtils.readFileToString(file, "UTF-8");
		return text;
	}
	public void deleteFile() throws IOException {
		FileUtils.deleteQuietly(file);
	}
	public void toggleLocalUsers() throws IOException {
		
		String localString = readFile();
		String[] localArr = localString.split("#");

	    for (String local : localArr) {
	        String[] parts = local.split("@");
	        String name = parts[0];
	        int presenze = Integer.parseInt(parts[1]);
	        new DipendeteLocal(name, presenze);
	        System.out.println("Dipendente in locale: " + name + " Presenze: " + presenze);
	    }
	}
}
