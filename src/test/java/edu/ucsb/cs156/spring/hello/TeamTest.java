package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    // Same Object
    @Test
    public void testEquals_sameObject() {
        Team t = new Team("TeamName");
        assertTrue(t.equals(t));
    }

    //Different class
    @Test
    public void testEquals_differentClass() {
        Team t = new Team("TeamName");
        String notATeam = "Not a team";
        assertFalse(t.equals(notATeam));
    }

    // Different combinations
    //TT
    @Test
    public void testEquals_sameName_sameMembers() {
        Team t1 = new Team("TeamName");
        t1.addMember("Alice");
        Team t2 = new Team("TeamName");
        t2.addMember("Alice");
        assertTrue(t1.equals(t2));
    }

    //TF
    @Test
    public void testEquals_sameName_differentMembers() {
        Team t1 = new Team("TeamName");
        t1.addMember("Alice");

        Team t2 = new Team("TeamName");
        t2.addMember("Bobby");

        assertFalse(t1.equals(t2));
    }

    //FT
    @Test
    public void testEquals_differentName_sameMembers() {
        Team t1 = new Team("TeamOne");
        t1.addMember("Alice");

        Team t2 = new Team("TeamTwo");
        t2.addMember("Alice");

        assertFalse(t1.equals(t2));
    }

    //FF
    @Test
    public void testEquals_differentName_differentMembers() {
        Team t1 = new Team("TeamOne");
        t1.addMember("Alice");

        Team t2 = new Team("TeamTwo");
        t2.addMember("Bobby");

        assertFalse(t1.equals(t2));
    }

    //hash code

    // instantiate t as a Team object
    @Test
    public void testHashCode() {
        Team t = new Team();
        int result = t.hashCode();
        int expectedResult = 1;

        assertEquals(expectedResult, result);
    }
    
   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}
