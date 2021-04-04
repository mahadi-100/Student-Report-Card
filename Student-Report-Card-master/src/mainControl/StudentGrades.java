package mainControl;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import records.RecordInfo;

public class StudentGrades extends MainController{

    public void showGrades(){
        Stage stage = new Stage();
        stage.setTitle("Show Specific Records");
        VBox root = new VBox();
        root.setPadding(new Insets(100));

        Label showRecords = new Label();
        StringBuilder allTogether = new StringBuilder();

        for (RecordInfo recordInfo : list) {
            String grades = "C";

            if (recordInfo.getMarks() >= 560) grades = "A+";
            else if (recordInfo.getMarks() >= 550) grades = "A";
            else if (recordInfo.getMarks() >= 540) grades = "B+";
            else if (recordInfo.getMarks() >= 530) grades = "B";

            allTogether.append(recordInfo.getName()).
                    append(" ----> ").append(grades).append("\n");
        }

        showRecords.setFont(Font.font(25));
        showRecords.setText(allTogether.toString());
        root.getChildren().add(showRecords);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
