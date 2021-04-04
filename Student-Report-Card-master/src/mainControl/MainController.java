package mainControl;


import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
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

    public void onPreSavedClicked() throws IOException {
        commonSortingLayout("PreSaved Records ");
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

    public void onSortByNameClicked() throws IOException {
       new SortByName().quickSort(list, 0, list.size() - 1);
       commonSortingLayout("Sorted By Name");
    }


    public void onSortByMarksClicked() throws IOException {
       new SortByMarks().quickSort(list, 0, list.size() - 1);
       commonSortingLayout("Sorted By Marks");
    }


    public void onSpecificReportClicked() throws IOException {
        CommonRecordChangeLayout("Specific Records", "/recordControl/onSpecific.fxml");
    }

    public void onStudentGradesClicked() {
        new StudentGrades().showGrades();
    }

    public void onModifyClicked() throws IOException {
        CommonRecordChangeLayout("Modify Records", "/recordControl/onModify.fxml");
    }

    public void onDeleteClicked() throws IOException {
        CommonRecordChangeLayout("Delete Records", "/recordControl/onDelete.fxml");
    }

    private void CommonRecordChangeLayout(String title, String path) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(path));

        Stage stage = new Stage();
        stage.setTitle(title);
        stage.setScene(new Scene(root));
        stage.show();
    }
    
    private void commonSortingLayout(String title) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/sortAndSearch/Sort.fxml"));

        Stage stage = new Stage();
        stage.setTitle(title);
        stage.setScene(new Scene(root));
        stage.show();
    }
}