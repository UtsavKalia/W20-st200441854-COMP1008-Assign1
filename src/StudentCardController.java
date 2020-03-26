import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentCardController implements Initializable {
    @FXML private Button listOfActivitiesPage;
    @FXML private AnchorPane anchor;
    @FXML private TextArea listActivities;
    @FXML private Label firstName;
    @FXML private Label lastName;
    @FXML private Label studentNumber;
    @FXML private ImageView imageView;
    private Student getStudent;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            File imageFile = new File("./src/Image/defaultPerson.png");
            BufferedImage bufferedImage = ImageIO.read(imageFile);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            imageView.setImage(image);
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public void intData(Student student){
        getStudent = student;
        firstName.setText(String.format("First Name : %10s", getStudent.getFirstName()));
        lastName.setText(String.format("Last Name : %10s", getStudent.getLastName()));
        studentNumber.setText(String.format("Student#%10d", getStudent.getStudentNumber()));
        listActivities.setText(String.format("%s",getStudent.getFavActivitiesString()));
        String imageLocation = "./Image/utsav.JPG";
        getStudent.setImage(new Image(imageLocation));
        imageView.setImage(getStudent.getImage());
    }

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
        controller.intData(getStudent);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(activitiesScene);
        window.show();
    }
}
