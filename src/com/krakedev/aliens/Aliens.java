package com.krakedev.aliens;

public class Aliens {
	private int tamanio;
	private String color;
	private int numeroOjos;
	private int numeroBrazos;
	private int numeroPies;
	private double precioExtremidad;
	private double precioOjos;
	private double precioCuerpo;
	
	public Aliens(int tamanio, String color) {
		super();
		if(tamanio>=5 & tamanio<=30) {
			this.tamanio = tamanio;
			this.color = color;
		}else {
			this.tamanio = 25;
			this.color = color;
		}
		this.precioCuerpo=this.tamanio*0.20;
		this.precioExtremidad=this.tamanio*0.10;
		this.precioOjos=this.tamanio*0.05;
	}

	public int getTamanio() {
		return tamanio;
	}
	public String getColor() {
		return color;
	}
	public int getNumeroOjos() {
		return numeroOjos;
	}
	public int getNumeroBrazos() {
		return numeroBrazos;
	}
	public int getNumeroPies() {
		return numeroPies;
	}
	public double getPrecioExtremidad() {
		return precioExtremidad;
	}
	public double getPrecioOjos() {
		return precioOjos;
	}
	public double getPrecioCuerpo() {
		return precioCuerpo;
	}

	public void imprimir() {
	String mensaje=" Tamaño: "+tamanio
			+" Color: "+color
			+" Numero de Ojos: "+numeroOjos
			+" Numero de Brazos: "+numeroBrazos
			+" Numero de Pies: "+numeroPies
			+" Precio de Extremidades"+precioExtremidad
			+" Precio de Ojos: "+precioOjos
			+" Precio de Cuerpo: "+precioCuerpo;
	System.out.println(mensaje);
	}
	

}
