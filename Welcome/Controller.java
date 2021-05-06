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
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Controller implements Initializable {
    public static String url="jdbc:mysql://localhost/test?useSSL=false";
    public static String user="root";
    public static String password="password";
    public static List<Book> list = new ArrayList<>();
    @FXML
    private Button in;
    public void setIn(ActionEvent event) throws Exception {
        sample.Main.MainGraph mainGraph=new MainGraph();
        mainGraph.show();
        in.getScene().getWindow().hide();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources){

       try(Connection connection= DriverManager.getConnection(url,user,password)){
           try(PreparedStatement statement=connection.prepareStatement("SELECT * from library")){
            try(ResultSet resultSet=statement.executeQuery()){
                while (resultSet.next()){
                    String a1=resultSet.getString(1);
                    String a2=resultSet.getString(2);
                    String a3=resultSet.getString(3);
                    String a4=resultSet.getString(4);
                    list.add(new Book(a1,a2,a3,a4));
                }
            }
           }


        } catch (SQLException throwables) {
           throwables.printStackTrace();
       }

    }
}
