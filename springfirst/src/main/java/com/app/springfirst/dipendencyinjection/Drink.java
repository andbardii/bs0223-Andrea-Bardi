package com.app.springfirst.dipendencyinjection;

public class Drink implements IProdotto{
	
	private double prezzo;
	private double calorie;
	private double zuccheri;
	private double grassi;
	private Formato formato;
	private String nome;
	
	public Drink(double prezzo, double calorie, double zuccheri, double grassi, Formato formato, String nome) {
		super();
		this.prezzo = prezzo;
		this.calorie = calorie;
		this.zuccheri = zuccheri;
		this.grassi = grassi;
		this.formato = formato;
		this.nome = nome;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public double getCalorie() {
		return calorie;
	}

	public void setCalorie(double calorie) {
		this.calorie = calorie;
	}

	public double getZuccheri() {
		return zuccheri;
	}

	public void setZuccheri(double zuccheri) {
		this.zuccheri = zuccheri;
	}

	public double getGrassi() {
		return grassi;
	}

	public void setGrassi(double grassi) {
		this.grassi = grassi;
	}

	public Formato getFormato() {
		return formato;
	}

	public void setFormato(Formato formato) {
		this.formato = formato;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Drink [prezzo=" + prezzo + ", calorie=" + calorie + ", zuccheri=" + zuccheri + ", grassi=" + grassi
				+ ", formato=" + formato + ", nome=" + nome + "]";
	}
	
}
