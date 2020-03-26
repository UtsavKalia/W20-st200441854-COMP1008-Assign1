  import javafx.scene.image.Image;
  import java.util.ArrayList;
    /*
    * Firstly we are going to create instance variables for student class
    */
 public class Student {
    private String firstName, lastName;
    private int studentNumber;
    private Image image;
    private ArrayList<String> favouriteActivities;

    /**
     *  constructor will create the object in the system
     */
    public Student(String firstName, String lastName, int studentNumber) {
        setFirstName(firstName);
        setLastName(lastName);
        setStudentNumber(studentNumber);
        favouriteActivities = new ArrayList<>();
        setImage(image);
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

    /**
     * @return- this method will help to use Student object in console using toString method
     */
    public String toString(){
        return String.format("%s %s, student# %d %nfav activity: %n%s",firstName,lastName,studentNumber,getFavActivitiesString());
    }
}
