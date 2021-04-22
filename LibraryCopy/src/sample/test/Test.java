package sample.test;

import javafx.application.Application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;

import javafx.scene.Scene;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;



public class Test extends Application {

    Stage stage=new Stage();
    @Override
    public void start(Stage primaryStage) throws Exception{
        Scene scene = new Scene(new Group());
        stage.setTitle("Table View Sample");
        stage.setWidth(800);
        stage.setHeight(550);
        TableColumn<library,String> first=new TableColumn<>("first");
        TableColumn<library,String> second=new TableColumn<>("second");
        TableColumn<library,String> third=new TableColumn<>("third");
        TableColumn<library,String> fourth=new TableColumn<>("fourth");
        first.setPrefWidth(200);
        second.setPrefWidth(200);
        third.setPrefWidth(200);
        fourth.setPrefWidth(200);
        TableView<library> tableView=new TableView<>();
        tableView.getColumns().addAll(first,second,third,fourth);
        ((Group)scene.getRoot()).getChildren().addAll(tableView);
        stage.setScene(scene);
        stage.show();
        ObservableList<library> dataList= FXCollections.observableArrayList(new library("1","1","1","1"),
                new library("12","12","12","12"),
        new library("13","13","13","13"),
        new library("14","134","134","134"));
       first.setCellValueFactory(new PropertyValueFactory<>("Number"));
       second.setCellValueFactory(new PropertyValueFactory<>("BookName"));
       third.setCellValueFactory(new PropertyValueFactory<>("Writer"));
       fourth.setCellValueFactory(new PropertyValueFactory<>("Price"));
       tableView.setItems(dataList);



    }
    public void show() throws Exception {
        start(stage);
    }
}
