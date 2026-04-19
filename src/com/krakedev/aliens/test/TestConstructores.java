package com.krakedev.aliens.test;

import com.krakedev.aliens.Aliens;

public class TestConstructores {

	public static void main(String[] args) {
		Aliens prueba1=new Aliens(2, "rojo");
		prueba1.imprimir();
		
		Aliens prueba2=new Aliens(10, "azul");
		prueba2.imprimir();

	}

}
