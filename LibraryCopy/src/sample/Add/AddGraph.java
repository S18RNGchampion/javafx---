package sample.Add;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class AddGraph extends Application {
    public Stage stage=new Stage();
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass()
                .getResource("add.fxml")));
        primaryStage.setTitle("搜索界面");
        primaryStage.setScene(new Scene(root, 732, 490));
        primaryStage.show();
    }
    public void show() throws IOException {
        start(stage);
    }
}