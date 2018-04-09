/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designassignment.bll.Collaborator;

import designassignment.be.User;
import java.util.ArrayList;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author janvanzetten
 */
public class EndlessCollaboratorIteraterTest {
    private static EndlessCollaboratorIterater ecol;
    private static List<User> collabs = new ArrayList<User>();
    
    public EndlessCollaboratorIteraterTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        collabs = new ArrayList<User>();
        collabs.add(new User(0, "Jens", "Jens@jensen.dk", "1234"));
        collabs.add(new User(1, "Hans", "Jens@jensen.dk", "1234"));
        collabs.add(new User(2, "Erik", "Jens@jensen.dk", "1234"));
        collabs.add(new User(3, "Peter", "Jens@jensen.dk", "1234"));
        collabs.add(new User(4, "Ole", "Jens@jensen.dk", "1234"));
        collabs.add(new User(5, "Ib", "Jens@jensen.dk", "1234"));
        collabs.add(new User(6, "Jens", "Jens@jensen.dk", "1234"));
    }
    
    @AfterClass
    public static void tearDownClass() {
        ecol = null;
    }

    /**
     * Test of next method, of class EndlessCollaboratorIterater.
     */
    @Test
    public void testNext() throws Exception {
        System.out.println(this.getClass().getSimpleName()+":" + new Object(){}.getClass().getEnclosingMethod().getName());
        
        ecol = new EndlessCollaboratorIterater(collabs);
        int testSize = 3;
        List<User> list = ecol.next(testSize);
        
        assertEquals("Check for same length",testSize, list.size());
        
        
        for (int i = 0; i < testSize; i++) {
            assertEquals("Check for same user", list.get(i), collabs.get(i));
        }
        
    }

    /**
     * Test of previous method, of class EndlessCollaboratorIterater.
     */
    @Test
    public void testPrevious() throws Exception {
        System.out.println(this.getClass().getSimpleName()+":" + new Object(){}.getClass().getEnclosingMethod().getName());
        
        ecol = new EndlessCollaboratorIterater(collabs);
        int testSize = 3;
        List<User> list = ecol.previous(testSize);
        
        assertEquals("Check for same length",testSize, list.size());
        
        assertEquals(list.get(0), collabs.get(0));
        for (int i = 1; i < testSize; i++) {
            assertEquals(list.get(i), collabs.get(collabs.size()-i));
        }
        
    }
    
}
