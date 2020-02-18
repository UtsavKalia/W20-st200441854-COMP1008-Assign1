import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class HobbiesController implements Initializable {
    @FXML private AnchorPane Second;
    @FXML private CheckBox photography;
    @FXML private CheckBox camping;
    @FXML private CheckBox painting;
    @FXML private CheckBox running;
    @FXML private CheckBox hiking;
    private List<String> hobbiesList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String imageLocation = "./Image/utsav.JPG";
        Student utsav = new Student("utsav", "kalia", 200441854, "running", new Image(imageLocation));
        hobbiesList= utsav.listOfActivities();
    }

    /**
     *
     * @param actionEvent-when update button is pressed this method will transfer us two scene that
     *                   is connected to StudentCard.fxml and help o transfer some data
     */
    public void update(javafx.event.ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("StudentCard.fxml"));
        Parent activitiesView = loader.load();
        Scene activitiesScene = new Scene(activitiesView);
        StudentCardController controller = loader.getController();
        controller.listView(hobbiesList);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(activitiesScene);
        window.show();
    }

    /**
     *
     * @param myList-this method will check if list already contain that
     *              item it will check it already
     */
    public void checkData(List<String> myList){
        if (myList.contains("photography")){
           photography.setSelected(true);
        }
        if (myList.contains("camping")){
            camping.setSelected(true);
        }
        if (myList.contains("painting")){
            painting.setSelected(true);
        }
        if (myList.contains("running")){
            running.setSelected(true);
        }
        if (myList.contains("hiking")){
            hiking.setSelected(true);
        }
    }

    /**
     * these methods will check if user select a checkbox it will add item to list
     */
    public void checkCamping() {
        if (camping.isSelected()){
            hobbiesList.add("camping");
            camping.setSelected(true);
        }
    }
    public void checkPhotography(){
        if (photography.isSelected()){
            hobbiesList.add("photography");
            photography.setSelected(true);
        }
    }
    public void checkPainting(){
        if (painting.isSelected()){
            hobbiesList.add("painting");
            painting.setSelected(true);
        }
    }
    public void checkRunning(){
        if (running.isSelected()){
            hobbiesList.add("running");
            running.setSelected(true);
        }
    }
    public void checkHiking(){
        if (hiking.isSelected()){
            hobbiesList.add("hiking");
            hiking.setSelected(true);
        }
    }
}
