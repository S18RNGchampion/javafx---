package sample;

import javafx.beans.property.SimpleStringProperty;

public class Book {
    public SimpleStringProperty bookNumber;
    public SimpleStringProperty bookName;
    public SimpleStringProperty bookWriter;
    public SimpleStringProperty bookPrice;
    public Book(String number,String name,String writer,String price){
        this.bookNumber=new SimpleStringProperty(number);
        this.bookName=new SimpleStringProperty(name);
        this.bookWriter=new SimpleStringProperty(writer);
        this.bookPrice=new SimpleStringProperty(price);
    }

    public String getBookNumber() {
        return bookNumber.get();
    }



    public String getBookName() {
        return bookName.get();
    }



    public String getBookWriter() {
        return bookWriter.get();
    }



    public String getBookPrice() {
        return bookPrice.get();
    }

    public void setBookNumber(String bookNumber) {
        this.bookNumber.set(bookNumber);
    }

    public void setBookName(String bookName) {
        this.bookName.set(bookName);
    }

    public void setBookWriter(String bookWriter) {
        this.bookWriter.set(bookWriter);
    }

    public void setBookPrice(String bookPrice) {
        this.bookPrice.set(bookPrice);
    }
}
