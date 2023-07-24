package com.app.springfirst.dipendencyinjection;

import java.util.List;

public class Pizza implements IProdotto{
	
	private double prezzo;
	private double calorie;
	private double zuccheri;
	private double grassi;
	private List<Topping> topping;
	private Formato formato;
	private String nome;
	
	public Pizza(double prezzo, double calorie, double zuccheri, double grassi,
			List<Topping> topping, Formato formato, String nome) {
		super();
		this.prezzo = prezzo;
		this.calorie = calorie;
		this.zuccheri = zuccheri;
		this.grassi = grassi;
		topping.add(Topping.POMODORO);
		topping.add(Topping.MOZZARELLA);
		this.topping.addAll(topping);
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

	public List<Topping> getTopping() {
		return topping;
	}

	public void setTopping(List<Topping> topping) {
		this.topping = topping;
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
		return "Pizza [prezzo=" + prezzo + ", calorie=" + calorie + ", zuccheri=" + zuccheri + ", grassi=" + grassi
				+ ", Topping=" + topping + ", formato=" + formato + ", nome=" + nome + "]";
	}
	

	
}
