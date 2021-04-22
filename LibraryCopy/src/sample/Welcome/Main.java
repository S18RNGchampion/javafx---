package sample.Welcome;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Book;
import sample.test.library;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {
    public static List<Book> list = new ArrayList<>();
//    public static List<library> list=new ArrayList<>();
    public static final File file = new File("sample.");
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 732, 490));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
