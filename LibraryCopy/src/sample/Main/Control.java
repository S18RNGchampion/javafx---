package sample.Main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import sample.Add.AddGraph;
import sample.Find.FindGraph;
import sample.Remove.RemoveGraph;

import java.io.IOException;

public class Control {

    @FXML
    private Button find;
    @FXML
    private Button add;
    @FXML
    private Button delete;
    public void setFind(ActionEvent event) throws IOException {
        sample.Find.FindGraph a=new FindGraph();
        a.show();
        find.getScene().getWindow().hide();
    }
    public void setAdd(ActionEvent event) throws IOException {
        sample.Add.AddGraph a=new AddGraph();
        a.show();
        find.getScene().getWindow().hide();

    }
    public void setDelete(ActionEvent event) throws IOException {
        sample.Remove.RemoveGraph a=new RemoveGraph();
        a.show();;
        find.getScene().getWindow().hide();
    }


}
