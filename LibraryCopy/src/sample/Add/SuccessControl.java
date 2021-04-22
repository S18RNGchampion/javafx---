package sample.Add;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;



public class SuccessControl {
    @FXML
    private Button confirm;
    public void setConfirm(ActionEvent event){
        confirm.getScene().getWindow().hide();
    }

}
