package sample.Remove;

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
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import sample.Book;
import sample.Main.MainGraph;
import sample.Welcome.Controller;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;

public class RemoveControl implements Initializable {
    public static String number;
    @FXML
    public Button back;
    @FXML
    public Button submit;
    @FXML
    public TextField input;
    @FXML
    public  Text text;
    @FXML
    public boolean test=false;
    @FXML
    public TableView<Book> tableview=new TableView<>();
    public TableColumn<Book,String>bookNumber=new TableColumn<>("编号");
    public TableColumn<Book,String>bookName= new TableColumn<>("书名");
    public TableColumn<Book,String>bookWriter=new TableColumn<>("作者");
    public TableColumn<Book,String>bookPrice=new TableColumn<>("价格");
    public void initialize(URL location, ResourceBundle resources){
        setPreWidth(bookNumber, bookName, bookWriter, bookPrice, tableview);
        connect(bookNumber, bookName, bookWriter, bookPrice, tableview);

    }

    public static void connect(TableColumn<Book, String> bookNumber, TableColumn<Book, String> bookName, TableColumn<Book, String> bookWriter, TableColumn<Book, String> bookPrice, TableView<Book> tableview) {
        ObservableList<Book> observableList= FXCollections.observableArrayList(Controller.list);
        bookNumber.setCellValueFactory(new PropertyValueFactory<>("bookNumber"));
        bookName.setCellValueFactory(new PropertyValueFactory<>("bookName"));
        bookWriter.setCellValueFactory(new PropertyValueFactory<>("bookWriter"));
        bookPrice.setCellValueFactory(new PropertyValueFactory<>("bookPrice"));
        tableview.setItems(observableList);
    }

    public static void setPreWidth(TableColumn<Book, String> bookNumber, TableColumn<Book, String> bookName, TableColumn<Book, String> bookWriter, TableColumn<Book, String> bookPrice, TableView<Book> tableview) {
        bookNumber.setPrefWidth(155);
        bookName.setPrefWidth(155);
        bookWriter.setPrefWidth(155);
        bookPrice.setPrefWidth(155);
        tableview.getColumns().addAll(bookNumber, bookName, bookWriter, bookPrice);
        bookNumber.setStyle(" -fx-alignment: center");
        bookName.setStyle(" -fx-alignment: center");
        bookWriter.setStyle(" -fx-alignment: center");
        bookPrice.setStyle(" -fx-alignment: center");
    }

    public void back(ActionEvent event) throws Exception {
        sample.Main.MainGraph a=new MainGraph();
        a.show();
        back.getScene().getWindow().hide();

    }
    public void setSubmit() throws IOException {
        if(test){
            updateTxtCollection();
            connect(bookNumber,bookName,bookWriter,bookPrice,tableview);
            SuccessSubmit a=new SuccessSubmit();
            a.show();

        }else{
            DefeatSubmit a=new DefeatSubmit();
            a.show();

        }
        RemoveControl.this.Clear();
    }
    public void setInput(){
        String info=input.getText();
        String regex="[0-9]{4}";
        if(!info.matches("[0-9]+")){
            text.setText("输入编号必须全为数字!");
            text.setFill(Color.RED);
            test=false;
        }
        else if(info.length() != 4){
            text.setText("输入编号必须为4位数字!");
            text.setFill(Color.RED);
            test=false;
        }
       else if(info.matches(regex)){
            Iterator<Book> iterator=Controller.list.iterator();
            while(iterator.hasNext()){
                Book temp=iterator.next();
                if(temp.getBookNumber().equals(info)){
                    text.setText("当前输入编号符合规则!");
                    text.setFill(Color.GREEN);
                    test=true;
                    number=input.getText();
                    break;
                }
                else{
                    text.setText("输入编号必须在列表中!");
                    text.setFill(Color.RED);
                    test=false;

                }
            }
        }


    }
    public   void  Clear(){
        text.setText(null);
        input.setText(null);
        test=false;
    }
    public static void updateTxtCollection() throws IOException {


        Iterator<Book> iterator = Controller.list.iterator();
        while(iterator.hasNext()){
            Book temp=iterator.next();
            if(temp.getBookNumber().equals(number)){
                Controller.list.remove(temp);
                break;
            }
        }
        Iterator<Book> temp=Controller.list.listIterator();
        Writer writer = new FileWriter("./src/sample/图书信息.txt");
        for (; temp.hasNext(); ) {
            Book msginput = temp.next();
            writer.write(msginput.getBookNumber() + "\t" + msginput.getBookName() + "\t" + msginput.getBookWriter() + "\t" + msginput.getBookPrice() + "\n");
        }
        writer.close();
    }


}
