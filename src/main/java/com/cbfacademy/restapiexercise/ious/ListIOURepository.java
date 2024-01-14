package com.cbfacademy.restapiexercise.ious;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

//Interfaces are completely abstract so I need to override the methods to implement the interface, which you will see below.

@Repository
public class ListIOURepository {

    //final means this cannot be changed. This is a list of ious that can't be changed. Database of ious
    final List<IOU> ious = new ArrayList<>();
    
    // implementing this method, which was taken from the IIOURepository interface. This has to be the same to satisfy the interface
    public List<IOU> searchByBorrower(String name){
        
        //Create new list to store borrower that match name param
        List<IOU> matchedBorrowers = new ArrayList <>();

        //IOU iou is the new variable created, ious is the list being looped throughe
        //enhanced for loop to loop through iou list
        for (IOU iou : ious) {
            // If borrower is equal to the param name
            //use geter method to check is borrower matches name
            if (iou.getBorrower() == name) {
                // Add the borrower to a list we want to return
                //use add method from newlist to add
                matchedBorrowers.add(iou);
            }
        
        }

        return matchedBorrowers;

    }
    // implementing this method, which was taken from the IIOURepository interface. This has to be the same to satisfy the interface
    public List<IOU> searchByLender(String name){

        //Create new list to store lenders that match name param
        List<IOU> matchedLenders = new ArrayList <>();

        //IOU iou is the new variable created, ious is the list being looped through
        //enhanced for loop to loop through iou list
        for (IOU iou : ious) {
            // If lender is equal to the param name
            //use geter method to check is borrower matches name
            if (iou.getLender() == name) {
                // Add the borrower to a list we want to return
                //use add method from newlist to add
                matchedLenders.add(iou);
            }
        
        }

        return matchedLenders;

    }


    
    
}
