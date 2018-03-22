package com.mavenpizza.PizzaShopOrder;
/**
 * @author Sonali
 *
 */
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import com.mavenpizza.pizzashoporder.ReadFile;
import com.mavenpizza.pizzashoporder.WriteFile;
import java.util.Date;
/**
 * Unit test for simple App.
 */
public class MainAppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public MainAppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( MainAppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    
    public void headerCheck(){         
        String actualorderHeader1 = "ORDER";
        String actualorderHeader2 = "TIME";
        assertTrue(ReadFile.ValidateFileHeader(actualorderHeader1, actualorderHeader2));
    }
    
    public void humanReadbleDate(){         
        String actualDate = "Oct.27.2016 02:24:47";  
        String longTime = "1477578287";
        Date orderDate  = new Date(Long.parseLong(longTime) * 1000);        
        assertEquals(actualDate, WriteFile.getDateFromSeconds(orderDate));
    }
              
}
