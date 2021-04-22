package sample.Add;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import sample.Book;
import sample.Main.MainGraph;
import sample.Welcome.Controller;
import sample.test.library;

import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.Iterator;


public class AddControl {
    @FXML
    private Button back;
    @FXML
    private Button confirm;
    @FXML
    private TextField bookName;
    @FXML
    private TextField bookNumber;
    @FXML
    private TextField bookWriter;
    @FXML
    private TextField bookPrice;
    @FXML
    private Text number;
    @FXML
    private Text name;
    @FXML
    private Text writer;
    @FXML
    private Text price;
    private String regex1 = "[0-9]{4}";
    public static String []info=new String[4];

//    private String regex2=".{1,5}";

    public static int[] arrays = new int[]{0, 0, 0, 0};
    public static String[] strings = new String[4];
    public static int []resetArrays=new int[]{0,0,0,0};
    public static String[] resetStrings=new String[4];
    public void setBack() throws Exception {
        sample.Main.MainGraph a = new MainGraph();
        a.show();
        back.getScene().getWindow().hide();
    }

    public void getBookNumber() {
        Iterator<Book> iterator = Controller.list.iterator();
//        Iterator<library> iterator = Controller.list.iterator();
        if (bookNumber.getText().matches(regex1)) {
            while (iterator.hasNext()) {
                if (bookNumber.getText().equals(iterator.next().getBookNumber())) {
                    number.setFill(Color.RED);
                    number.setText("  当前输入图书编号与现有图书编号重复！");

                    arrays[0] = 0;
                    strings[0] = null;
                    break;
                } else {
                    number.setFill(Color.BLACK);
                    number.setText("当前输入图书编号可用！");
                    number.setFill(Color.GREEN);
                    arrays[0] = 2;
                    strings[0] = bookNumber.getText();
                }
            }

        } else {
            number.setText("  输入的图书编号必须为4位数字！");
            number.setFill(Color.RED);
            arrays[0] = 0;
            strings[0] = null;
        }
    }

    public void getBookName() {
        if (bookName.getText().length()<=5&&bookName.getText().length()>0) {
            strings[1] = bookName.getText();
            arrays[1] = 2;
            name.setFill(Color.BLACK);
            name.setText("当前输入图书名称可用！");
            name.setFill(Color.GREEN);

        } else {
            arrays[1] = 0;
            strings[1] = null;
            name.setFill(Color.RED);
            name.setText("  输入的图书名字必须长度小于等于5");
        }
    }

    public void getBookWriter() {
        if (bookWriter.getText().length()<=5&&bookWriter.getText().length()>0) {
            strings[2] = bookWriter.getText();
            arrays[2] = 2;
            writer.setFill(Color.BLACK);
            writer.setText("当前输入作者名称可用！");
            writer.setFill(Color.GREEN);


        } else {
            arrays[2] = 0;
            strings[2] = null;
            writer.setFill(Color.RED);
            writer.setText("  输入的图书作者姓名必须长度小于等于5");
        }
    }

    public void getBookPrice() {
        try {
            double Price=Double.parseDouble(bookPrice.getText());
            if(Price>=9999){
                arrays[3] = 0;
                strings[3] = null;
                price.setText("数字必须小于9999！");
                price.setFill(Color.RED);
            }else if(Price<=0){
                arrays[3] = 0;
                strings[3] = null;
                price.setText("数字必须大于0！");
                price.setFill(Color.RED);
            }else{
                price.setText("当前输入图书价格可用！");
                strings[3] = bookPrice.getText();
                price.setFill(Color.GREEN);
                arrays[3] = 2;
            }
        }catch (NumberFormatException e){
            arrays[3] = 0;
            strings[3] = null;
            price.setFill(Color.RED);
            price.setText("输入必须为数字！");
        }
    }

    public void setConfirm(ActionEvent event) throws IOException {

        if(arrays[0]==2&&arrays[1]==2&&arrays[2]==2&&arrays[3]==2){
            sample.Add.SuccessGraph successGraph=new SuccessGraph();
            successGraph.show();
            for(int i=0;i<4;i++){
                info[i]=strings[i];
            }
            updateTxtCollection();
            arrays=new int[]{0,0,0,0};
            strings=new String[4];
            bookName.setText(null);
            bookNumber.setText(null);
            bookWriter.setText(null);
            bookPrice.setText(null);
            name.setText(null);
            number.setText(null);
            writer.setText(null);
            price.setText(null);
        }else{
            DefeatGraph defeatGraph=new DefeatGraph();
            defeatGraph.show();
        }

    }
    public static void updateTxtCollection() throws IOException {
        Controller.list.add(new Book(info[0],info[1],info[2],info[3]));
//        Controller.list.add(new library(info[0],info[1],info[2],info[3]));
        Iterator<Book> iterator = Controller.list.iterator();
//        Iterator<library> iterator = Controller.list.iterator();
        Writer writer = new FileWriter("./src/sample/图书信息.txt");
        for (; iterator.hasNext(); ) {
            Book msginput = iterator.next();
//            library msginput = iterator.next();
            writer.write(msginput.getBookNumber() + "\t" + msginput.getBookName() + "\t" + msginput.getBookWriter() + "\t" + msginput.getBookPrice() + "\n");
//            writer.write(msginput.getNumber() + "\t" + msginput.getBookName() + "\t" + msginput.getBookName() + "\t" + msginput.getPrice() + "\n");
        }
        writer.close();
    }

}
