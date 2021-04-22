package sample.test;

import javafx.beans.property.SimpleStringProperty;

public class library {
    public SimpleStringProperty Number = new SimpleStringProperty();
    public SimpleStringProperty BookName = new SimpleStringProperty();
    public SimpleStringProperty Writer = new SimpleStringProperty();
    public SimpleStringProperty Price = new SimpleStringProperty();
    public library(String number,String bookName,String writer,String price){
        Number.set(number);
        BookName.set(bookName);
        Writer.set(writer);
        Price.set(price);
    }

    public String getNumber() {
        return Number.get();
    }


    public void setNumber(String Number) {
        this.Number.set(Number);
    }

    public String getBookName() {
        return BookName.get();
    }


    public void setBookName(String BookName) {
        this.BookName.set(BookName);
    }

    public String getWriter() {
        return Writer.get();
    }



    public void setWriter(String Writer) {
        this.Writer.set(Writer);
    }

    public String getPrice() {
        return Price.get();
    }



    public void setPrice(String Price) {
        this.Price.set(Price);
    }
}
