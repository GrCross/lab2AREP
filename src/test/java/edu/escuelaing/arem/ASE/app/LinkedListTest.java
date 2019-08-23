package edu.escuelaing.arem.ASE.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.File;
import java.io.FileNotFoundException;

import co.edu.escuelaing.sparksimpleexample.entities.Calc;


/**
 * Unit test for simple App.
 */
public class LinkedListTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public LinkedListTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( LinkedListTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    
    public void testMeans() throws FileNotFoundException{
        
        File file = new File("entryTest1.in"); 
        Calc calc = new Calc(file);

        assertEquals(550.6, calc.mean());

        file = new File("entryTest2.in"); 
        calc.setFile(file);

        assertEquals(60.32, calc.mean());
    }

    public void testDesviation() throws FileNotFoundException{
        File file = new File("entryTest1.in"); 
        Calc calc = new Calc(file);

        assertEquals(572.03, calc.desviation());

        file = new File("entryTest2.in"); 
        calc.setFile(file);

        assertEquals(62.26, calc.desviation());
    }
    


}
