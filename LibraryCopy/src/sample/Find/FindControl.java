package sample.Find;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import sample.Book;
import sample.Main.MainGraph;
import sample.Remove.RemoveControl;
import sample.Welcome.Controller;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.*;

public class FindControl implements Initializable {
    @FXML
    private Button find;
    @FXML
    private Button listall;
    @FXML
    private TextField input;

    @FXML
    private Button returnMain;
    @FXML
    private TableView<Book> tableView=new TableView<>();

    public TableColumn<Book,String>bookNumber=new TableColumn<>("编号");
    public TableColumn<Book,String>bookName= new TableColumn<>("书名");
    public TableColumn<Book,String>bookWriter=new TableColumn<>("作者");
    public TableColumn<Book,String>bookPrice=new TableColumn<>("价格");



    @Override
    public void initialize(URL location, ResourceBundle resources){
        RemoveControl.setPreWidth(bookNumber, bookName, bookWriter, bookPrice, tableView);

    }
  public void listAll(ActionEvent event){
      RemoveControl.connect(bookNumber, bookName, bookWriter, bookPrice, tableView);


  }
  public void setFind(ActionEvent event){
      String info=input.getText();
      Iterator<Book>iterator= Controller.list.iterator();
      List<Book> find=new ArrayList<>();
      while(iterator.hasNext()){
          Book temp=iterator.next();
          if(temp.getBookName().equals(info)||temp.getBookNumber().equals(info) ||temp.getBookWriter().equals(info)||temp.getBookPrice().equals(info)){
              find.add(temp);
          }
      }
      bookNumber.setCellValueFactory(new PropertyValueFactory<>("bookNumber"));
      bookName.setCellValueFactory(new PropertyValueFactory<>("bookName"));
      bookWriter.setCellValueFactory(new PropertyValueFactory<>("bookWriter"));
      bookPrice.setCellValueFactory(new PropertyValueFactory<>("bookPrice"));
      ObservableList <Book>observableList=FXCollections.observableArrayList(find);
      tableView.setItems(observableList);

  }
  public void setReturnMain(ActionEvent event) throws Exception {
    sample.Main.MainGraph a=new MainGraph();
    a.show();
    find.getScene().getWindow().hide();
  }

}
