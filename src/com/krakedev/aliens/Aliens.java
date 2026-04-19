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
			+" Precio de Extremidades: "+precioExtremidad
			+" Precio de Ojos: "+precioOjos
			+" Precio de Cuerpo: "+precioCuerpo;
	System.out.println(mensaje);
	}
	
	public boolean agregarBrazos(int cantidad) {
		int extremidades=this.numeroBrazos+this.numeroPies+cantidad;
		
		if(extremidades<=10) {
			this.numeroBrazos+=cantidad;
			return true;
		}else {
			return false;
		}
	}
	public boolean agregarPiernas(int cantidad) {
		int extremidades=numeroBrazos+numeroPies+cantidad;
		
		if(extremidades<=10) {
			this.numeroPies+=cantidad;
			return true;
		}else {
			return false;
		}
	}
	public boolean agregarOjos(int cantidad) {
		int limite=0;
		
		if(this.tamanio>=5 & this.tamanio<=10) {
			limite=3;
		}else if(this.tamanio>10 & this.tamanio<=20) {
			limite=5;
		}else if(this.tamanio>20 & this.tamanio<=30) {
			limite=7;
		}
		
		if(limite > 0 && (this.numeroOjos + cantidad)<=limite) {
			this.numeroOjos+=cantidad;
			return true;
		}
			
		return false;

	}

}
