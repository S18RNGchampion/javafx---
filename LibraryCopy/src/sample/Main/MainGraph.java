package sample.Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class MainGraph extends Application {
    Stage stage=new Stage();
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass()
                .getResource("Main.fxml")));
        primaryStage.setTitle("主界面");
        primaryStage.setScene(new Scene(root, 732, 490));
        primaryStage.show();
    }
    public void show() throws Exception {
      start(stage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}