/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taza_patricia_prog06_practica;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author madrid
 */
public class Taza_Patricia_PROG06_PracticaTest {
    
    public Taza_Patricia_PROG06_PracticaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of generadorOperacion method, of class Taza_Patricia_PROG06_Practica.
     */
    @Test
    public void testGeneradorOperacion() {
        System.out.println("generadorOperacion");
        String expResult = "";
        String result = Taza_Patricia_PROG06_Practica.generadorOperacion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of elegirGanador method, of class Taza_Patricia_PROG06_Practica.
     */
    @Test
    public void testElegirGanador() {
        System.out.println("elegirGanador");
        String[][] concursantes = null;
        Taza_Patricia_PROG06_Practica.elegirGanador(concursantes);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class Taza_Patricia_PROG06_Practica.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Taza_Patricia_PROG06_Practica.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
