package mainControl;

import complexActions.ClickActions;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javafx.stage.Stage;
import records.RecordInfo;
import records.Records;
import sortAndSearch.SortByMarks;
import sortAndSearch.SortByName;

import java.io.IOException;
import java.util.ArrayList;

public class MainController {
    public TextField IDStudentName, IDStudentId, IDStudentMarks;
    public Button IDSave;

    public static final ArrayList<RecordInfo> list = new Records().getList();


    public void onPreSavedClicked() {
        ClickActions.showTheList("PreSaved Records", 1, list);
    }


    public void saveButtonClicked() {
        String name = IDStudentName.getText();
        String id = IDStudentId.getText();
        int marks = Integer.parseInt(IDStudentMarks.getText());


        RecordInfo info = new RecordInfo(name, id, marks);
        list.add(info);

        IDStudentName.setText("");
        IDStudentId.setText("");
        IDStudentMarks.setText("");
    }


    public void onSortByNameClicked() {
        new SortByName().quickSort(list, 0, list.size() - 1);
        ClickActions.showTheList("Sort by names", 1, list);
    }


    public void onSortByMarksClicked() {
        new SortByMarks().quickSort(list, 0, list.size() - 1);
        ClickActions.showTheList("Sort by marks", 2, list);
    }


    public void onSpecificReportClicked() throws IOException {
        commonSteps("Specific Records", "/recordControl/onSpecific.fxml");
    }


    public void onStudentGradesClicked() {
        ClickActions.showTheList("All students Grades", 3, list);
    }


    public void onModifyClicked() throws IOException {
        commonSteps("Modify Records", "/recordControl/onModify.fxml");
    }


    public void onDeleteClicked() throws IOException {
        commonSteps("Delete Records", "/recordControl/onDelete.fxml");
    }

    private void commonSteps(String title, String path) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(path));

        Stage stage = new Stage();
        stage.setTitle(title);
        stage.setScene(new Scene(root));
        stage.show();
    }
}