package org.junitproject;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( false );
    }

    @Test
    public void su(){
        int a=2,b=2;
        Assert.assertEquals(2, a+b);
    }
}
