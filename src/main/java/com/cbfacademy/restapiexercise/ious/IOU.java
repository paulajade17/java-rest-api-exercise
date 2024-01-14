package com.cbfacademy.restapiexercise.ious;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public class IOU {  

    private UUID id;
    private String borrower;
    private String lender;
    private BigDecimal amount;
    private Instant dateTime;

    //IOU constructor method, did not include id as this constructor is to creates a new id

    public IOU(String borrower, String lender, BigDecimal amount, Instant dateTime){

        //UUID.randomUUID generates a random id

        this.id = UUID.randomUUID();
        this.borrower = borrower;
        this.lender = lender;
        this.amount = amount;
        this.dateTime = dateTime;
    }
    //yellow curly error line means field is not in use
    //Create getter methods to resolve this

    //Create a getter method for id field
    //getters are always public i.e. read only
    // access modifer, return type, method name (){}
    public UUID getID(){
        return id;
    }

    //Create a getter method for borrower field
    public String getBorrower(){
        return borrower;
    }

    //Create a getter method for lender field
    public String getLender(){
        return lender;
    }

    //Create a getter method for amount field
    public BigDecimal getAmount(){
        return amount;
    }

    //Create a getter method for dateTime field
    public Instant getDateTime(){
        return dateTime;
    }

    //Create setter method for borrower and has no return tyoe, so it is void
    //setBorrower is method name
    // Inside parameters () put in data type and new field
    //In {} method body put old field = new field
    public void setBorrower(String borrower){
        this.borrower = borrower;
    }
    
    //Create setter method for lender
    public void setLender(String lender){
        this.lender = lender;
    }

    //Create setter method for amount
    public void setAmount(BigDecimal amount){
        this.amount = amount;
    }

    //Create setter method for dateTime
    public void setDateTime(Instant dateTime){
        this.dateTime = dateTime;
    }

    //Anytime you create a getter & setter you need to override a toString method

    @Override
    public String toString(){
        return "{" +
            "id:" + id + 
            ", borrower:" + borrower +
            ", lender:" + lender +
            ", amount:" + amount +
            ", date:" + dateTime +
        "}";
    }

    // Have not created a setter method for ID, because this is something that shouldn't be update. It should be uniqually identified

    


}
