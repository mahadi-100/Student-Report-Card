package recordControl;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import mainControl.MainController;
import sortAndSearch.Search;

public class onDeleteController extends MainController {
    public TextField getInput;
    public Label output;

    public void oneTextFieldClicked() {
        String name = getInput.getText();

        int index = new Search().binarySearch(list, name);
        output.setDisable(false);

        if(index != -1){
            output.setTextFill(Color.GREEN);
            output.setText("Deleted");
            list.remove(index);
        }
        else{
            output.setText("Not Found");
            output.setTextFill(Color.RED);
        }
    }
}
