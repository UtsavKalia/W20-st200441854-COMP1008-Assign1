import javafx.scene.input.DataFormat;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class StudentTest {
    private Student student1;
    private Student student2;

    @Before
    public void setUp() throws Exception{
        student1 =new Student("utsav","kalia", LocalDate.of(2001,1,1));
        student2=new Student("varun","sood",LocalDate.of(2000,12,18));
    }


    @Test
    public void setFirstName() {
        student1.setFirstName("piyush");
        assertEquals("Piyush",student1.getFirstName());
        student2.setFirstName("Sushant");
        assertEquals("Sushant",student2.getFirstName());
    }
    @Test
    public void getFirstName() {
        assertEquals("Utsav",student1.getFirstName());
        assertEquals("Varun",student2.getFirstName());
    }

    @Test
    public void settingFirstNameLow(){
        try {
            student1.setFirstName("U");
            fail("FirstName must be grater than 2 letters");
        }
        catch (IllegalArgumentException e){
            System.out.printf("message: "+e.getMessage());
        }
    }

    @Test
    public void setLastName() {
        student1.setLastName("sharma");
        assertEquals("Sharma",student1.getLastName());
        student2.setLastName("singh");
        assertEquals("Singh",student2.getLastName());
    }
    @Test
    public void getLastName() {
        assertEquals("Kalia",student1.getLastName());
        assertEquals("Sood",student2.getLastName());
    }
    @Test
    public void settingLastNameLow(){
        try {
            student1.setLastName("K");
            fail("LastName must be grater than 2 letters");
        }
        catch (IllegalArgumentException e){
            System.out.printf("message: "+e.getMessage());
        }
    }

    @Test
    public void getStudentNumber() {
    }

    @Test
    public void getNewStudentNumber() {

    }

    @Test
    public void getBirthday() {
        assertEquals(LocalDate.of(2001,1,1),student1.getBirthday());
        assertEquals(LocalDate.of(2000,12,18),student2.getBirthday());
    }

    @Test
    public void setBirthday() {
        student1.setBirthday(LocalDate.of(2000,12,29));
        student2.setBirthday(LocalDate.of(1998,8,4));
        assertEquals(LocalDate.of(2000,12,29),student1.getBirthday());
        assertEquals(LocalDate.of(1998,8,4),student2.getBirthday());
    }

    @Test
    public void getAge() {
        assertEquals("19",student1.getAge());
        assertEquals("19",student2.getAge());
    }

    @Test
    public void addActivity() {
    }

    @Test
    public void getFavouriteActivities() {
        student1.addActivity("dancing");
        student1.addActivity("playing");
        ArrayList<String> hey = new ArrayList<>();
        hey.add("dancing");
        hey.add("playing");
        assertEquals(hey,student1.getFavouriteActivities());

        student2.addActivity("dancing");
        student2.addActivity("playing");
        ArrayList<String> heyy = new ArrayList<>();
        heyy.add("dancing");
        heyy.add("playing");
        assertEquals(heyy,student2.getFavouriteActivities());
    }

    @Test
    public void getFavActivitiesString() {
        student1.addActivity("dancing");
        student1.addActivity("music");
        assertEquals("dancing\r\nmusic\r\n",student1.getFavActivitiesString());
        student2.addActivity("dancing");
        student2.addActivity("music");
        assertEquals("dancing\r\nmusic\r\n",student2.getFavActivitiesString());
    }

    @Test
    public void testToStringStudent1() {
        String stu = "Utsav Kalia, student# 100000001";
        assertEquals(stu,student1.toString());
    }
    @Test
    public void testToStringStudent2() {
        String stu = "Varun Sood, student# 100000002";
        assertEquals(stu,student2.toString());
    }


}