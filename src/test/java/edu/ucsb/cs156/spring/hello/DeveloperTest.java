package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        assertEquals("Eyob T.", Developer.getName());
    }

    @Test
    public void getGithubId_returns_correct_githubId() {
        assertEquals("EyobTe", Developer.getGithubId());
    }

    @Test void getTeam_returns_team_with_correct_name() {
        Team t = Developer.getTeam();
        assertEquals("s25-01", t.getName());
    }

    @Test
    public void getTeam_returns_team_with_correct_members() {
        Team t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Alec S"), "Team should contain Alec S");
        assertTrue(t.getMembers().contains("Eyob T"), "Team should contain Eyob T");
        assertTrue(t.getMembers().contains("Hao J"), "Team should contain Hao J");
        assertTrue(t.getMembers().contains("Lexuan H"), "Team should contain Lexuan H");
        assertTrue(t.getMembers().contains("Oscar L"), "Team should contain Oscar L");
        assertTrue(t.getMembers().contains("Ran C"), "Team should contain Ran C");
    }


}
