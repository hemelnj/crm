/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hemel
 */



import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class) 
public class HelloWorldTest {
    @Test
    void firstTest() {
        System.out.println("First test");
    }
    
    @Test
    void secondTest() {
        System.out.println("Second  test");
       // Assert.fail("Exception expected");
    }
    
    @Test
    void thirdTest() {
        System.out.println("Third test");
    }
    
     @Test
    void fourthTest() {
        System.out.println("Four  test");
        //Assert.fail("Exception expected");
    }
   
}