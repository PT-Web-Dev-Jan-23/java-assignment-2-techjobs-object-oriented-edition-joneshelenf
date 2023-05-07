package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static junit.framework.TestCase.*;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(), job2.getId());
    }
    @Test
    public void testJobConstructorSetsAllFields() {
        Job job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

    assertTrue(job3.getName() instanceof String);
    assertTrue(job3.getEmployer() instanceof Employer);
    assertTrue(job3.getLocation() instanceof Location);
    assertTrue(job3.getPositionType() instanceof PositionType);
    assertTrue(job3.getCoreCompetency() instanceof CoreCompetency);



    assertEquals("Product tester",job3.getName());
    assertEquals("ACME",job3.getEmployer().getValue());
    assertEquals("Desert",job3.getLocation().getValue());
    assertEquals("Quality control",job3.getPositionType().getValue());
    assertEquals("Persistence",job3.getCoreCompetency().getValue());
}
    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job1 = new Job("Product Tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals('\n', job1.toString().charAt(0));
        assertEquals('\n', job1.toString().charAt(job1.toString().length() - 1));
    }

    @Test
    public void testJobsForEquality() {
        Job testJob3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job testJob4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(testJob3.equals(testJob4));
    }
    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job3 = new Job("Product Tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals("\nID: " + job3.getId() + "\nName: Product Tester\nEmployer: ACME \nLocation: Desert\nPosition Type: Quality control\nCore Competency: Persistence\n", job3.toString());

    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job3 = new Job("Product Tester", new Employer("ACME"), new Location("Desert"), new PositionType(""), new CoreCompetency(""));
        assertEquals("\nID: " + job3.getId() + "\nName: Product Tester\nEmployer: ACME\nLocation: Desert\nPosition Type: Data not available\nCore Competency: Data Not available\n", job3.toString());

    }
}
