package recordControl;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import mainControl.MainController;
import sortAndSearch.Search;

public class OnModifyController extends MainController {
    public TextField getInput;
    public TextField nameInput;
    public TextField idInput;
    public TextField marksInput;
    public Button idBtn;

    private int index;

    public void onTextFieldClick() {
        String name = getInput.getText();
        index = new Search().binarySearch(list, name);
        
        if(index != -1){
            idBtn.setDisable(false);
        }
        else{
            idBtn.setText("Record not found!");
            idBtn.setTextFill(Color.RED);
        }
        getInput.setText("");
    }

    public void onSaveClicked() {
        int marksReplaceWith = Integer.parseInt(marksInput.getText());
        
        list.get(index).setName(nameInput.getText());
        list.get(index).setID(idInput.getText());
        list.get(index).setMarks(marksReplaceWith);

        nameInput.setText(""); idInput.setText("");  marksInput.setText("");

        idBtn.setText("Done!");
        idBtn.setTextFill(Color.GREEN);
    }
}


