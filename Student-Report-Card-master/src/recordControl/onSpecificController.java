package recordControl;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import mainControl.MainController;
import records.RecordInfo;
import sortAndSearch.Search;

import java.util.ArrayList;

public class onSpecificController extends MainController{
    public TextField getInput;
    public Label showOutput;

    public void onTextFieldClick() {
        String name = getInput.getText();
        int namePlaceInIndex = new Search().binarySearch(list, name);

        if (namePlaceInIndex == -1){
            showOutput.setText("Record Not Found!");
        }
        else {
            showOutput.setText(list.get(namePlaceInIndex).getName() + " ---> "
                                + list.get(namePlaceInIndex).getID()+ " ---> "
                                + list.get(namePlaceInIndex).getMarks());
        }
    }
}
