package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }


   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)
    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void test_equal_same_object() {
        assertEquals(true, team.equals(team));
    }

    @Test
    public void test_equal_different_class() {
        String notATeam = "Not a team";
        assertEquals(false, team.equals(notATeam));
    }

    @Test
    public void test_equal_same_name_and_members() {
        Team team1 = new Team("Team1");
        team1.addMember("Eugene");
        team1.addMember("Chris");

        Team team2 = new Team("Team1");
        team2.addMember("Eugene");
        team2.addMember("Chris");

        assertEquals(true, team1.equals(team2));
    }

    @Test
    public void test_equal_same_name_different_members() {
        Team team1 = new Team("Team1");
        team1.addMember("Eugene");
        team1.addMember("Chris");

        Team team2 = new Team("Team1");
        team2.addMember("Member1");
        team2.addMember("Member2");

        assertEquals(false, team1.equals(team2));
    }

    @Test
    public void test_equal_different_name_same_members() {
        Team team1 = new Team("Team1");
        team1.addMember("Eugene");
        team1.addMember("Chris");

        Team team2 = new Team("Team2");
        team2.addMember("Eugene");
        team2.addMember("Chris");

        assertEquals(false, team1.equals(team2));
    }

    @Test
    public void test_equal_different_name_and_members() {
        Team team1 = new Team("Team1");
        team1.addMember("Eugene");
        team1.addMember("Chris");

        Team team2 = new Team("Team2");
        team2.addMember("Member1");
        team2.addMember("Member2");

        assertEquals(false, team1.equals(team2));
    }

    @Test
    public void test_hash_code() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");

        int result = t1.hashCode();
        int expectedResult = 130294;
        assertEquals(expectedResult, result);


    }
}
