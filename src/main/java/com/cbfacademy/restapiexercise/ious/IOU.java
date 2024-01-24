package com.cbfacademy.restapiexercise.ious;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

    /** IOU class represents IOU entity with details such as ID, borrower, lender, amount and date/time
    */

public class IOU {  

    /** unique identifer for the IOU
    */
    private final UUID id;

     /** name of borrower in the IOU transaction
    */
    private String borrower;

     /** name of lender in the IOU transaction
      * 
    */
    private String lender;

    /** amount of money in the IOU transaction
     * 
    */
    private BigDecimal amount;

    /** date and time of the IOU was created
     * 
    */
    private Instant dateTime;

    
    /** IOU constructor method, did not include id as this constructor is to creates a new id
     * Paramatised constructor
     * @param borrower
     * @param lender
     * @param amount
     * @param dateTime
    */

    public IOU(String borrower, String lender, BigDecimal amount, Instant dateTime){

        //UUID.randomUUID generates a random id

        this.id = UUID.randomUUID();
        this.borrower = borrower;
        this.lender = lender;
        this.amount = amount;
        this.dateTime = dateTime;
    }
   
   
    /**
     * Create a getter method - Get the ID of the IOU
     * Always make your getters public
     * 
     * @return the unique identifer for IOU (id)
    */ 


    public UUID getId(){
        return this.id;
    }

     /** Create a getter method - get the name of the borrower 
      * 
     * @return the name of the borrower in the IOU transaction
    */
    
    public String getBorrower(){
        return this.borrower;
    }

   /** Create a getter method - get the name of the lender
    * 
     * @return the name of the lender in the IOU transaction
    */
    public String getLender(){
        return this.lender;
    }

   /** Create a getter method - get the IOU amount
     * 
     * @return the amount of money in the IOU transaction
    */
    public BigDecimal getAmount(){
        return this.amount;
    }

   /** Create a getter method - get the date and time the IOU was created
     * 
     * @return the date and time the IOU was created
    */
    public Instant getDateTime(){
        return this.dateTime;
    }

   
    /** Create a setter method - set the name of the borrower
     * 
     * @param borrower the name of the borrower to set in the IOU
    */
    public void setBorrower(String borrower){
        this.borrower = borrower;
    }

  /** Create a setter method - set the name of the lender
     * 
     *  @param lender the name of the lender to set in the IOU
    */
    public void setLender(String lender){
        this.lender = lender;
    }

     /** Create setter method - set amount of money in the IOU transaction
     * 
     * @param amount the amount of money to set in the IOU
    */
    public void setAmount(BigDecimal amount){
        this.amount = amount;
    }

    // Cannot set dat & time, this is done at the start with the constructor

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
