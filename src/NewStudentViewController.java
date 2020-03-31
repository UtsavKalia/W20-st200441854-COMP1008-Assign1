import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
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
    @FXML private ImageView selectImage;
    @FXML private Label ageLabel;
    @FXML private DatePicker birthday;
    private Student newStudent;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        studentNumber.setEditable(false);
        try {
            File imageFile = new File("./src/Image/defaultPerson.png");
            BufferedImage bufferedImage = ImageIO.read(imageFile);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            selectImage.setImage(image);
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
        errorDisplay.setText("");
        ageLabel.setText("");
        viewStudent.setVisible(false);
       // Student.getStudentNumber();
        studentNumber.setText(String.valueOf(Student.getStudentNumber()));
    }

    /**
     * this method will try to create a student object using the data entered by user
     * @param actionEvent
     */
    public void submit(ActionEvent actionEvent) {
        if(checkFields()) {
            try {
                newStudent = new Student(firstName.getText(), lastName.getText());
                newStudent.setStudentNumber((Student.getStudentNumber()));
                newStudent.setBirthday(birthday.getValue());
                activities();
                viewStudent.setVisible(true);
                System.out.println("new student: " + newStudent);
            } catch (IllegalArgumentException e){
                errorDisplay.setText(e.getMessage());
            }
        }
    }

    public void showBirthday(ActionEvent event) {
            ageLabel.setText(" age: " + String.valueOf(Period.between(birthday.getValue(), LocalDate.now()).getYears()));
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
    public void selectedImageButtonPushed(ActionEvent event) throws IOException {
        // get the Stage to open a new window
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("open Image");
        //filter for .jpg and .png
        FileChooser.ExtensionFilter imageFilter =
                new FileChooser.ExtensionFilter("Image Files","*.jpg","*.png");
        fileChooser.getExtensionFilters().add(imageFilter);
        // set the start directory
        String userDirectoryString = System.getProperty("user.home")+"\\Pictures";
        File userDirectory = new File(userDirectoryString);
        // confirm that system can reach the directory
        if (!userDirectory.canRead())
            userDirectory = new File(System.getProperty("user.home"));
        //set the file chooser to select intital directory
        fileChooser.setInitialDirectory(userDirectory);
        File imageFile = fileChooser.showOpenDialog(stage);
        if (imageFile != null && imageFile.isFile())
        {
            selectImage.setImage(new Image(imageFile.toURI().toString()));
        //    System.out.println(imageFile);
        //    String imageLoction = imageFile.toString();
        //    BufferedImage image = ImageIO.read(imageFile);
        //     newStudent.setImage(new Image(String.valueOf(image)));
        }
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