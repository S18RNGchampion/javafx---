package sample.Welcome;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import sample.Book;
import sample.test.library;
import sample.Main.MainGraph;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Controller implements Initializable {
    public static List<Book> list = new ArrayList<>();
//    public static List<library> list = new ArrayList<>();
    public static final File file = new File("./src/main/java/sample/图书信息.txt");
    @FXML
    private Button in;
    public void setIn(ActionEvent event) throws Exception {
        sample.Main.MainGraph mainGraph=new MainGraph();
        mainGraph.show();
        in.getScene().getWindow().hide();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources){
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assert scanner != null;
        scanner.useDelimiter("\n");
        for (; scanner.hasNext(); ) {
            String[] msg = scanner.next().split("\t");


//            list.add(book);
            list.add(new Book(msg[0],msg[1],msg[2],msg[3]));

        }

    }
}
