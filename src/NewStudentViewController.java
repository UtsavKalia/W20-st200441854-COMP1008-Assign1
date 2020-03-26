import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NewStudentViewController implements Initializable {
    @FXML private Button viewStudent;
    @FXML private TextField firstName;
    @FXML private TextField lastName;
    @FXML private TextField studentNumber;
    @FXML private CheckBox exercise;
    @FXML private CheckBox sleeping;
    @FXML private CheckBox sports;
    @FXML private CheckBox music;
    @FXML private CheckBox fishing;
    @FXML private CheckBox familyTime;
    @FXML private CheckBox watchingTV;
    @FXML private CheckBox reading;
    @FXML private Label errorDisplay;
    private Student newStudent;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        errorDisplay.setText("");
        viewStudent.setVisible(false);
    }

    /**
     * this method will try to create a student object using the data entered by user
     * @param actionEvent
     */
    public void submit(ActionEvent actionEvent) {
       if(checkFields())
        try {
            newStudent = new Student(firstName.getText(), lastName.getText(), Integer.parseInt(studentNumber.getText()));
            activities();
            viewStudent.setVisible(true);
            System.out.println("new student: " + newStudent);
        } catch (IllegalArgumentException e){
            errorDisplay.setText(e.getMessage());
        }
    }

    /**
     * this method will make sure that text fields or required fields are not left by user
     * @return
     */
    public boolean checkFields(){
        String message = "";
        if (firstName.getText().isEmpty()){
            message="First name is required";
        }
        if (lastName.getText().isEmpty()){
            if (message.isEmpty())
                message = "Last name is required";
            else
                message = "First name and Last name are required";
        }
        if (studentNumber.getText().isEmpty()){
            if (message.isEmpty())
                message = "Student Number is required";
            else if (firstName.getText().isEmpty()&& !lastName.getText().isEmpty())
                message = "First name and Student number required";
            else if (!firstName.getText().isEmpty() && lastName.getText().isEmpty())
                message = "Last name and Student number required";
            else
                message = "all fields are required";
        }
        errorDisplay.setText(message);
        return message.equals("");
    }

    /**
     * this method will add selected checkbox value into the list of activity
     */
    public void activities(){
        if (exercise.isSelected()){
            newStudent.addActivity("exercise");
        }
        if (sleeping.isSelected()){
            newStudent.addActivity("sleeping");
        }
        if (sports.isSelected()){
            newStudent.addActivity("sports");
        }
        if (music.isSelected()){
            newStudent.addActivity("music");
        }
        if (fishing.isSelected()){
            newStudent.addActivity("fishing");
        }
        if (familyTime.isSelected()){
            newStudent.addActivity("familyTime");
        }
        if (watchingTV.isSelected()){
            newStudent.addActivity("watchingTV");
        }
        if (reading.isSelected()){
            newStudent.addActivity("reading");
        }
    }

    /**
     * this method will help us to change the scene and pass created student object to new desired scene
     */
    public void viewStudent(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("StudentCard.fxml"));
        Parent activitiesView = loader.load();
        Scene activitiesScene = new Scene(activitiesView);
        StudentCardController controller = loader.getController();
        controller.intData(newStudent);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(activitiesScene);
        window.show();
    }
}
