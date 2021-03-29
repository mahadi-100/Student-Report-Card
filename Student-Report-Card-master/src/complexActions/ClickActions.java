package complexActions;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import records.RecordInfo;

import java.util.ArrayList;

/**
 * @implSpec this class take the action when sortByName, id and grades
 * get clicked.
 *
 * @implNote the only method showTheList has parameter named token that
 * specifies which button have been clicked and take action according that.
 */
public class ClickActions {

    public static void showTheList(String title, int token, ArrayList<RecordInfo> list) {
        Stage stage = new Stage();
        stage.setTitle(title);
        VBox root = new VBox();
        root.setPadding(new Insets(100));

        Label showRecords = new Label();

        StringBuilder allTogether = new StringBuilder();
        if (token == 1) {
            for (RecordInfo recordInfo : list) {
                allTogether.append(recordInfo.getName()).append(" ----> ")
                        .append(recordInfo.getID()).append(" ----> ")
                        .append(recordInfo.getMarks()).append("\n");
            }

        } else if (token == 2) {
            for (RecordInfo recordInfo : list) {
                allTogether.append(recordInfo.getMarks()).append(" ----> ")
                        .append(recordInfo.getID()).append(" ----> ")
                        .append(recordInfo.getName()).append("\n");
            }

        } else if (token == 3) {
            for (RecordInfo recordInfo : list) {
                String grades = "C";

                if (recordInfo.getMarks() >= 560) grades = "A+";
                else if (recordInfo.getMarks() >= 550) grades = "A";
                else if (recordInfo.getMarks() >= 540) grades = "B+";
                else if (recordInfo.getMarks() >= 530) grades = "B";

                allTogether.append(recordInfo.getName()).
                        append(" ----> ").append(grades).append("\n");
            }
        }
        showRecords.setFont(Font.font(25));
        showRecords.setText(allTogether.toString());
        root.getChildren().add(showRecords);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
