public class Student {

    private String firstName, lastName;
    private int studentNumber;

    public Student(String firstName, String lastName, int studentNumber) {
        setFirstName(firstName);

        setLastName(lastName);

        setStudentNumber(studentNumber);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName.length()>2){
            String firstNameToUpperCase = String.valueOf((firstName.toUpperCase().charAt(0)));
        this.firstName = firstNameToUpperCase+ firstName.substring(1);}
        else
            throw new IllegalArgumentException("first name must be greater than 2 character");
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName.length()>2){
            String lastNameToUpperCase = String.valueOf(lastName.toUpperCase().charAt(0));
        this.lastName = lastNameToUpperCase + lastName.substring(1);}
        else
            throw new IllegalArgumentException("last name must be greater than 2 character");
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        if (Integer.toString(studentNumber).length() == 9){
        this.studentNumber = studentNumber;}
        else
            throw new IllegalArgumentException("student number length must be 9 ");
    }

    public String toString(){
        return String.format("%s %s student# %d",firstName,lastName,studentNumber);
    }
}
