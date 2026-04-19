package com.krakedev.aliens.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.aliens.Aliens;

public class TestPruebasJUnit {
	@Test
	public void pruebas1() {
		Aliens prueba1=new Aliens(2, "amarillo");
		assertEquals(2,prueba1.getTamanio(),0.0001);
	}
	@Test
	public void pruebas2() {
		Aliens prueba2=new Aliens(10, "celeste");
		assertEquals(10,prueba2.getTamanio(),0.0001);
	}

}
