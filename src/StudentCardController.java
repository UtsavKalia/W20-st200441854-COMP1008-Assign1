import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class StudentCardController implements Initializable {
    @FXML private AnchorPane anchor;
    @FXML private TextArea listActivities;
    @FXML private Label firstName;
    @FXML private Label lastName;
    @FXML private Label studentNumber;
    @FXML private ImageView imageView;
    private List<String> activityList;

    /**
     * @param actionEvent- when list of activities button is pressed it will help
     *                   to go to second controller named Hobbies.fxml
     */
    public void listOfActivitiesPage(javafx.event.ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Hobbies.fxml"));
        Parent activitiesView = loader.load();
        Scene activitiesScene = new Scene(activitiesView);
        HobbiesController controller = loader.getController();
        controller.checkData(activityList);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(activitiesScene);
        window.show();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String imageLocation = "./Image/utsav.JPG";
        Student utsav = new Student("utsav", "kalia", 200441854, "running", new Image(imageLocation));
        activityList = utsav.listOfActivities();
        imageView.setImage(utsav.getStudentImage());
        firstName.setText(String.format("First Name : %10s", utsav.getFirstName()));
        lastName.setText(String.format("Last Name : %10s", utsav.getLastName()));
        studentNumber.setText(String.format("Student#%d", utsav.getStudentNumber()));
         for (String element : activityList){
           listActivities.appendText(element+"\n");
        }
    }

    /**
     * @param listItems-this method will help to get connect two controllers and update listActivities text field
     */
    public void listView(List<String> listItems){
        String textAreaString = "";
        for (Object item:listItems){
            textAreaString += String.format("%s%n",(String) item);
        }
        this.listActivities.setText(textAreaString);
        }
}
