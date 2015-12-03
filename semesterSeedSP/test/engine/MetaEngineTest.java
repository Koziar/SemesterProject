/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package engine;

import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author wookash
 */
public class MetaEngineTest
{
    
    public MetaEngineTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp()
    {
    }
    
    @After
    public void tearDown()
    {
    }

    
    @Test(expected = IOException.class)
    public void testGetFlightsFromTO2() throws Exception
    {
        System.out.println("getFlightsFromTO2");
        String from = "CPH";
        String to = "STN";
        String date = "2016-06-06T00:00:00.000Z";
        String persons = "50";
        MetaEngine.getFlightsFromTO(from, to, date, persons);
    }
    
    @Test(expected = IOException.class)
    public void testGetFlightsFromTO3() throws Exception
    {
        System.out.println("getFlightsFromTO3");
        String from = "CPH";
        String to = "CPH";
        String date = "2016-06-06T00:00:00.000Z";
        String persons = "2";
        MetaEngine.getFlightsFromTO(from, to, date, persons);
    }
    
}
