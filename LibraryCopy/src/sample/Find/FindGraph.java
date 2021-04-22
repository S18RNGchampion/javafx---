package sample.Find;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import sample.Book;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

public class FindGraph extends Application {
    public Stage stage=new Stage();

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass()
                .getResource("test.fxml")));
        primaryStage.setTitle("查找界面");
        primaryStage.setScene(new Scene(root, 732, 490));
        primaryStage.show();
    }
    public void show() throws IOException {
        start(stage);
    }
}
