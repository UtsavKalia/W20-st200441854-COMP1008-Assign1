import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentCardController implements Initializable {
    @FXML private ListView<Student> listOfStudents;
    @FXML private Label birthday;
    @FXML private TextArea listActivities;
    @FXML private Label firstName;
    @FXML private Label lastName;
    @FXML private Label studentNumber;
    @FXML private ImageView imageView;
    private Student getStudent;
    private ObservableList<Student> studentList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void intDatas(Student student){
        getStudent = student;
    }

    public void intData(ObservableList<Student> studentLists){
        studentList = FXCollections.observableArrayList();
        studentList = studentLists;
        int lastStudent = (studentLists.size()-1);
        getStudent = studentLists.get(lastStudent);
        firstName.setText(String.format("First Name : %10s", getStudent.getFirstName()));
        lastName.setText(String.format("Last Name : %10s", getStudent.getLastName()));
        studentNumber.setText(String.format("Student#%10d", getStudent.getNewStudentNumber()));
        listActivities.setText(String.format("%s", getStudent.getFavActivitiesString()));
        birthday.setText("birthday: " + getStudent.getBirthday() + ", age: " + getStudent.getAge());
        imageView.setImage(getStudent.getImage());
        listOfStudents.getItems().addAll(studentList);
    }




    /**
     * @param actionEvent- when list of activities button is pressed it will help
     *                   to go to second controller named Hobbies.fxml.
     */
   /** public void listOfActivitiesPage(javafx.event.ActionEvent actionEvent) throws IOException {
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
    */

   public void listOfActivitiesPage(javafx.event.ActionEvent actionEvent) throws IOException {
       FXMLLoader loader = new FXMLLoader();
       loader.setLocation(getClass().getResource("NewStudentView.fxml"));
       Parent activitiesView = loader.load();
       Scene activitiesScene = new Scene(activitiesView);
       NewStudentViewController controller = loader.getController();
       controller.intData(studentList);
       Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
       window.setScene(activitiesScene);
       window.show();
   }

    public void particularStudent(MouseEvent mouseEvent) {
       Student par = studentList.get(listOfStudents.getSelectionModel().getSelectedIndex());
        firstName.setText(String.format("First Name : %10s", par.getFirstName()));
        lastName.setText(String.format("Last Name : %10s", par.getLastName()));
        studentNumber.setText(String.format("Student#%10d", par.getNewStudentNumber()));
        listActivities.setText(String.format("%s", par.getFavActivitiesString()));
        birthday.setText("birthday: " + par.getBirthday() + ", age: " + par.getAge());
        imageView.setImage(par.getImage());
    }
}
