package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */

@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId() {
        Job testJobOne = new Job();
        Job testJobTwo = new Job();
        assertNotEquals(testJobOne, testJobTwo);
    }
    @Test
    public void testJobConstructorSetsAllFields(){
        Job testjobThree = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(testjobThree.getName() instanceof String);
        assertEquals("Product tester", testjobThree.getName());
        assertTrue(testjobThree.getEmployer() instanceof Employer);
        assertEquals("ACME", testjobThree.getEmployer().getValue());
        assertTrue(testjobThree.getLocation() instanceof Location);
        assertEquals("Desert", testjobThree.getLocation().getValue());
        assertTrue(testjobThree.getPositionType() instanceof PositionType);
        assertEquals("Quality control", testjobThree.getPositionType().getValue());
        assertTrue(testjobThree.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Persistence", testjobThree.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        Job testJobFour = new Job("Programmer", new Employer("LaunchCode"), new Location("St. Louis"), new PositionType("Web development"), new CoreCompetency("Java"));
        Job testJobFive = new Job("Programmer", new Employer("LaunchCode"), new Location("St. Louis"), new PositionType("Web development"), new CoreCompetency("Java"));

        assertFalse(testJobFour.equals(testJobFive));
    }
    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job testJobThree = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals('\n',testJobThree.toString().charAt(0));
        assertEquals('\n',testJobThree.toString().charAt(testJobThree.toString().length() - 1));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job testJobThree = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String testString = "\nID: " + testJobThree.getId() +
                "\nName: " + testJobThree.getName() +
                "\nEmployer: " + testJobThree.getEmployer() +
                "\nLocation: " + testJobThree.getLocation() +
                "\nPosition Type: " + testJobThree.getPositionType() +
                "\nCore Competency: " + testJobThree.getCoreCompetency() +
                '\n';
        assertEquals(testString,testJobThree.toString());
    }
    @Test
    public void testToStringHandlesEmptyField() {
        Job testJobthree = new Job("", new Employer("ACME"), new Location(""), new PositionType("Quality control"), new CoreCompetency(""));
        String testString = "\nID: " + testJobthree.getId() +
                "\nName: Data not available" +
                "\nEmployer: ACME" +
                "\nLocation: Data not available" +
                "\nPosition Type: Quality control" +
                "\nCore Competency: Data not available" +
                '\n';
        assertEquals(testString,testJobthree.toString());
    }
}
