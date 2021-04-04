package sortAndSearch;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import mainControl.MainController;
import records.RecordInfo;

import java.net.URL;
import java.util.ResourceBundle;

public class SortController extends MainController implements Initializable {
    public TableView<RecordInfo> idTable;
    public TableColumn<RecordInfo, String> idName;
    public TableColumn<RecordInfo, String> id_ID;
    public TableColumn<RecordInfo, Integer> idMarks;

    public ObservableList<RecordInfo> getList(){
        return FXCollections.observableList(list);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idName.setCellValueFactory(new PropertyValueFactory<>("name"));
        id_ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        idMarks.setCellValueFactory(new PropertyValueFactory<>("marks"));
        idTable.setItems(getList());
    }
}
