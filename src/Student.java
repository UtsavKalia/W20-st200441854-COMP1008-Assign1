import javafx.scene.image.Image;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
/*
 * Firstly we are going to create instance variables for student class
*/
public class Student {
    private String firstName, lastName;
    private static int studentNumber = 100000001;
    private int newStudentNumber;
    private Image image;
    private ArrayList<String> favouriteActivities;
    private LocalDate birthday;
    /**
     *  constructor will create the object in the system
     */
    public Student(String firstName, String lastName, LocalDate birthday, Image image) {
        setFirstName(firstName);
        setLastName(lastName);
        favouriteActivities = new ArrayList<>();
        setImage(image);
        setBirthday(birthday);
        newStudentNumber = setStudentNumber(studentNumber);
    }

    public Student(String firstName, String lastName, LocalDate birthday) {
        setFirstName(firstName);
        setLastName(lastName);
        favouriteActivities = new ArrayList<>();
        setImage(image);
        setBirthday(birthday);
        newStudentNumber = setStudentNumber(studentNumber);
    }
    public String getFirstName() {
        return firstName;
    }
    /**
     * @param firstName- this method will make sure that firstName is greater than 2 characters and if user
     *                 enter all letters in small it will convert 1st character to uppercase
     */
    public void setFirstName(String firstName) {
        if (firstName.length()>2){
            String firstNameToUpperCase = String.valueOf((firstName.toUpperCase().charAt(0)));
            this.firstName = firstNameToUpperCase+ firstName.substring(1);
        }
        else
            throw new IllegalArgumentException("first name must be greater than 2 character");
    }

    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName-this method will make sure that lastName is greater than 2 characters and if user
     *                 enter all letters in small it will convert 1st character to uppercase
     */
    public void setLastName(String lastName) {
        if (lastName.length()>2){
            String lastNameToUpperCase = String.valueOf(lastName.toUpperCase().charAt(0));
            this.lastName = lastNameToUpperCase + lastName.substring(1);
        }
        else
            throw new IllegalArgumentException("last name must be greater than 2 character");
    }

    /**
     * @param birthday- this method will help user to set birthday if its difference with current year is between 10 to 120
     */
    public void setBirthday(LocalDate birthday){
        if (Period.between(birthday, LocalDate.now()).getYears()>=10 && Period.between(birthday, LocalDate.now()).getYears()<120){
            this.birthday = birthday;
        }
        else
            throw new IllegalArgumentException("your age must be between 10-120 if you want to be student");
    }
    public LocalDate getBirthday(){
        return birthday;
    }
    /**
     * @return- this method will calculate current age of user and return it  as a string.
     */
    public String getAge(){
        return String.valueOf(Period.between(birthday, LocalDate.now()).getYears());
    }

    /**
     * @param activity- this will add entered activities into the list
     */
    public void addActivity(String activity){
        if (!activity.isEmpty())
            favouriteActivities.add(activity);
        else
            throw new IllegalArgumentException("activities cannot be empty");
    }

    public ArrayList<String> getFavouriteActivities() {
        return favouriteActivities;
    }

    public String getFavActivitiesString(){
        StringBuilder sb = new StringBuilder();
        for (String activity: favouriteActivities)
            sb.append(String.format("%s%n",activity));
        return sb.toString();
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image){
        this.image =image;
    }

    public static int getStudentNumber() {
        return studentNumber;
    }
    /**
     * @param studentNumber-this method will make sure that student number contain 9 numbers otherwise
     *                     it will throw an illegal argument exception
     * @return
     */
    private int setStudentNumber(int studentNumber) {
        if (Integer.toString(studentNumber).length() == 9) {
            this.newStudentNumber = studentNumber;
            studentNumber = Student.studentNumber++;
        }
        else
            throw new IllegalArgumentException("student number length must be 9 ");
        return studentNumber;
    }
    public int getNewStudentNumber() {
        return newStudentNumber;
    }


    /**
     * @return- this method will help to use Student object in console using toString method
     */
    public String toString(){
        return String.format("%s %s, student# %d",firstName,lastName,getNewStudentNumber());
    }
}