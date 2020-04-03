import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HobbiesController implements Initializable {
    @FXML
    private Button updateActivities;
    @FXML
    private CheckBox exercise;
    @FXML
    private CheckBox sleeping;
    @FXML
    private CheckBox sports;
    @FXML
    private CheckBox music;
    @FXML
    private CheckBox reading;
    @FXML
    private CheckBox watchingTV;
    @FXML
    private CheckBox familyTime;
    @FXML
    private CheckBox fishing;
    @FXML
    private AnchorPane Second;
    private Student selectedStudent;

    public void intData(Student student) {
        selectedStudent = student;
        selectHobbies();
    }

    /**
     * selectHobbies will check if student already contain that activity and if yes
     * then it is going to check that particular checkbox
     */
    public void selectHobbies() {
        if (selectedStudent.getFavouriteActivities().contains("exercise")) {
            exercise.setSelected(true);
        }
        if (selectedStudent.getFavouriteActivities().contains("sleeping")) {
            sleeping.setSelected(true);
        }
        if (selectedStudent.getFavouriteActivities().contains("sports")) {
            sports.setSelected(true);
        }
        if (selectedStudent.getFavouriteActivities().contains("music")) {
            music.setSelected(true);
        }
        if (selectedStudent.getFavouriteActivities().contains("reading")) {
            reading.setSelected(true);
        }
        if (selectedStudent.getFavouriteActivities().contains("watchingTV")) {
            watchingTV.setSelected(true);
        }
        if (selectedStudent.getFavouriteActivities().contains("familyTime")) {
            familyTime.setSelected(true);
        }
        if (selectedStudent.getFavouriteActivities().contains("fishing")) {
            fishing.setSelected(true);
        }
    }

    /**
     * this method will help user to add newly selected checkbox value into our list of activity
     */
    public void addHobbies() {
        if (exercise.isSelected() && !selectedStudent.getFavouriteActivities().contains("exercise")) {
            selectedStudent.addActivity("exercise");
        }
        if (sleeping.isSelected() && !selectedStudent.getFavouriteActivities().contains("sleeping")) {
            selectedStudent.addActivity("sleeping");
        }
        if (sports.isSelected() && !selectedStudent.getFavouriteActivities().contains("sports")) {
            selectedStudent.addActivity("sports");
        }
        if (music.isSelected() && !selectedStudent.getFavouriteActivities().contains("music")) {
            selectedStudent.addActivity("music");
        }
        if (fishing.isSelected() && !selectedStudent.getFavouriteActivities().contains("fishing")) {
            selectedStudent.addActivity("fishing");
        }
        if (familyTime.isSelected() && !selectedStudent.getFavouriteActivities().contains("familyTime")) {
            selectedStudent.addActivity("familyTime");
        }
        if (watchingTV.isSelected() && !selectedStudent.getFavouriteActivities().contains("watchingTV")) {
            selectedStudent.addActivity("watchingTV");
        }
        if (reading.isSelected() && !selectedStudent.getFavouriteActivities().contains("reading")) {
            selectedStudent.addActivity("reading");
        }
    }
    /**
     * @param actionEvent-when update button is pressed this method will transfer us two scene that
     *                         is connected to StudentCard.fxml and help o transfer some data.
     */
    public void setUpdateActivities(javafx.event.ActionEvent actionEvent) throws IOException {
        addHobbies();
        System.out.printf("new updated activities of student are:%n%s%n",selectedStudent.getFavActivitiesString());
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("StudentCard.fxml"));
        Parent activitiesView = loader.load();
        Scene activitiesScene = new Scene(activitiesView);
        StudentCardController controller = loader.getController();
        controller.intData(selectedStudent);
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(activitiesScene);
        window.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

}

