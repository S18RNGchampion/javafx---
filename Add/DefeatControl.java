package sample.Add;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DefeatControl implements Initializable {
    @FXML
    private GridPane gridpane;
    @FXML
    private Text first;
    @FXML
    private Text second;
    @FXML
    private Text third;
    @FXML
    private Text fourth;
    @FXML
    private Button cancel;

    private int number = 1;
    private int lay=0;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        if (AddControl.arrays[0] == 0) {
            Text temp=new Text("图书编号需修改！");
            temp.setWrappingWidth(250);
            temp.setTextAlignment(TextAlignment.CENTER);


            gridpane.add(temp,0,lay);
            lay++;
        }
        if (AddControl.arrays[1] == 0) {
            Text temp=new Text("图书名称需修改！");
            temp.setWrappingWidth(250);
            temp.setTextAlignment(TextAlignment.CENTER);

            gridpane.add(temp,0,lay);
            lay++;

        }
        if (AddControl.arrays[2] == 0) {
            Text temp=new Text("图书作者需修改！");
            temp.setWrappingWidth(250);
            temp.setTextAlignment(TextAlignment.CENTER);

            gridpane.add(temp,0,lay);
            lay++;

        }
        if (AddControl.arrays[3] == 0) {
            Text temp=new Text("图书价格需修改！");
            temp.setWrappingWidth(250);
            temp.setTextAlignment(TextAlignment.CENTER);

            gridpane.add(temp,0,lay);
            lay++;

        }

    }
    public void returnAdd(ActionEvent event) throws IOException {
        cancel.getScene().getWindow().hide();
    }
}

