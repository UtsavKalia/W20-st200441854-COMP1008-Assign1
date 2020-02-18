import javafx.scene.image.Image;
import java.util.ArrayList;
import java.util.List;

    /*
    * Firstly we are going to create instance variables for student class
    */
 public class Student {
    private String firstName, lastName;
    private int studentNumber;
    private String hobby;
    private Image studentImage;

    /**
     * constructor will create the object in the system
     */
    public Student(String firstName, String lastName, int studentNumber, String  hobby, Image studentImage) {
        setFirstName(firstName);
        setLastName(lastName);
        setStudentNumber(studentNumber);
        setHobby(hobby);
        this.studentImage = studentImage;
    }

    public String getFirstName() {
        return firstName;
    }

        /**
         * @param firstName- this method will make sure that firstName is greater than 2 characters and if user
         *                 enter all name in small alphabet it will convert 1st character to uppercase
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
         *                 enter all name in small alphabet it will convert 1st character to uppercase
         */
    public void setLastName(String lastName) {
        if (lastName.length()>2){
            String lastNameToUpperCase = String.valueOf(lastName.toUpperCase().charAt(0));
            this.lastName = lastNameToUpperCase + lastName.substring(1);
        }
        else
            throw new IllegalArgumentException("last name must be greater than 2 character");
    }

    public int getStudentNumber() {
        return studentNumber;
    }

        /**
         * @param studentNumber-this method will make sure that student number contain 9 numbers otherwise
         *                     it will throw an illegal argument exception
         */
    public void setStudentNumber(int studentNumber) {
        if (Integer.toString(studentNumber).length() == 9) {
            this.studentNumber = studentNumber;
        }
        else
            throw new IllegalArgumentException("student number length must be 9 ");
    }

    public String getHobby() {
        return hobby;
    }

        /**
         * @param hobbies-this method will store hobby as a string and make sure user does not
         *               left it empty
         */
    public void setHobby(String  hobbies) {
        if (!hobbies.equals("")){
            this.hobby = hobbies;
        }
        else
            throw new IllegalArgumentException("hobby must be filled and should not be left empty");
    }

        /**
         * @return- this method will create a list of string and also add user entered
         * hobby in this list
         */
    public List<String> listOfActivities(){
        List<String> listActivities = new ArrayList<>();
        listActivities.add("hiking");
        listActivities.add("photography");
        listActivities.add(getHobby());
        return listActivities;
    }

    public Image getStudentImage() {
        return studentImage;
    }

        /**
         * @return- this method will help to use Student object in console
         */
    public String toString(){
        return String.format("%s %s student# %d",firstName,lastName,studentNumber);
    }
}
