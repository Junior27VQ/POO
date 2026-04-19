package com.krakedev.aliens.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.krakedev.aliens.Aliens;

public class TestExtremidadesJUnit {
	@Test
    public void testAgregarBrazosValido() {
        Aliens alien = new Aliens(20, "Verde");
        
        // Caso: Agregar 4 brazos (Total: 4 extremidades, es menor a 10)
        boolean resultado = alien.agregarBrazos(4);
        
        assertTrue(resultado, "Debería permitir agregar 4 brazos");
        assertEquals(4, alien.getNumeroBrazos(), "El número de brazos debería ser 4");
    }

    @Test
    public void testAgregarPiernasValido() {
        Aliens alien = new Aliens(20, "Azul");
        
        // Caso: Agregar 6 piernas (Total: 6 extremidades)
        boolean resultado = alien.agregarPiernas(6);
        
        assertTrue(resultado, "Debería permitir agregar 6 piernas");
        assertEquals(6, alien.getNumeroPies(), "El número de pies debería ser 6");
    }

    @Test
    public void testLimiteExactoDiez() {
        Aliens alien = new Aliens(20, "Rojo");
        
        // Caso Límite: Agregar 5 brazos y luego 5 piernas (Total: 10)
        alien.agregarBrazos(5);
        boolean resultadoPiernas = alien.agregarPiernas(5);
        
        assertTrue(resultadoPiernas, "Debería permitir llegar exactamente a 10 extremidades");
        assertEquals(5, alien.getNumeroBrazos());
        assertEquals(5, alien.getNumeroPies());
    }

    @Test
    public void testExcederLimiteBrazos() {
        Aliens alien = new Aliens(20, "Gris");
        
        // Caso: Intentar agregar 11 brazos de golpe
        boolean resultado = alien.agregarBrazos(11);
        
        assertFalse(resultado, "No debería permitir agregar más de 10 brazos");
        assertEquals(0, alien.getNumeroBrazos(), "Si falla, no debe sumar nada");
    }

    @Test
    public void testExcederLimiteCombinado() {
        Aliens alien = new Aliens(20, "Negro");
        
        // Caso Combinado: Ya tiene 8 brazos e intenta agregar 3 piernas (Total sería 11)
        alien.agregarBrazos(8);
        boolean resultadoPiernas = alien.agregarPiernas(3);
        
        assertFalse(resultadoPiernas, "No debería permitir exceder las 10 extremidades en total");
        assertEquals(8, alien.getNumeroBrazos(), "Los brazos deben mantenerse en 8");
        assertEquals(0, alien.getNumeroPies(), "No se debieron agregar piernas");
    }

    @Test
    public void testAgregarVariosPasosSinPasarLimite() {
        Aliens alien = new Aliens(20, "Amarillo");
        
        // Caso: Ir agregando poco a poco
        alien.agregarBrazos(2); // Total 2
        alien.agregarPiernas(3); // Total 5
        boolean resultadoFinal = alien.agregarBrazos(4); // Total 9
        
        assertTrue(resultadoFinal, "Debería permitir agregar mientras el total sea <= 10");
        assertEquals(6, alien.getNumeroBrazos(), "Total de brazos debería ser 6 (2 + 4)");
        assertEquals(3, alien.getNumeroPies(), "Total de pies debería ser 3");
    }

}
