package com.krakedev.aliens.test;

import com.krakedev.aliens.Aliens;

public class TestConstructores {

	public static void main(String[] args) {
		Aliens prueba1=new Aliens(2, "rojo");
		boolean valido1;
		valido1=prueba1.agregarBrazos(10);
		valido1=prueba1.agregarPiernas(5);
		System.out.println(valido1);
		prueba1.imprimir();
		
		Aliens prueba2=new Aliens(10, "azul");
		boolean valido2;
		valido2=prueba2.agregarBrazos(5);
		valido2=prueba2.agregarPiernas(5);
		System.out.println(valido2);
		prueba2.imprimir();
		
		Aliens alien = new Aliens(20, "Amarillo");
        
        // Caso: Ir agregando poco a poco
        alien.agregarBrazos(2); // Total 2
        alien.agregarPiernas(3); // Total 5
        boolean resultadoFinal = alien.agregarBrazos(4);
        System.out.println(resultadoFinal);
		alien.imprimir();

	}

}
