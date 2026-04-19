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
		if(tamanio<=5 & tamanio>=30) {
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

}
