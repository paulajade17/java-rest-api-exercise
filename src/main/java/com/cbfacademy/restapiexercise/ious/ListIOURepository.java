package com.cbfacademy.restapiexercise.ious;

import static org.mockito.Mockito.inOrder;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.cbfacademy.restapiexercise.core.PersistenceException;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

//Interfaces are completely abstract so I need to override the methods to implement the interface, which you will see below.

@Repository
public class ListIOURepository implements IOURepository{

    //final means this cannot be changed. This is a list of ious that can't be changed. Database of ious
    final List<IOU> ious = new ArrayList<>();
    
    // implementing this method, which was taken from the IIOURepository interface. This has to be the same to satisfy the interface
   @Override
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
    @Override
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
    @Override
    public List<IOU> retrieveAll() throws PersistenceException {
        return new ArrayList<>(ious);
    }
    @Override
    public IOU retrieve(UUID id) throws IllegalArgumentException, PersistenceException {
        try {
            for (IOU iou : ious) {
                // If id is equal to the param name id
                //use geter method to check if id matches name
                if (iou.getID().equals(id)) {
                    // Add the borrower to a list we want to return
                    //use add method from newlist to add
                    return iou;
                }
                
            }
            
        } catch (Exception e) {
            throw new PersistenceException("failed to get iou");
        }
       
        //throw new illegal argument exception instead of returning null
        throw new IllegalArgumentException("iou does not exist");
        
        
    }
    @Override
    public IOU create(IOU entity) throws IllegalArgumentException, PersistenceException {
        //this is error handling for if someone else creates an id that is already on the list
        //if statement checks if id already exists
       try {
        if(ious.contains(entity)){
            // exception message shows if the id exists
            throw new IllegalArgumentException("iou already exists" + entity.getID());
        }
        //if iou doesn't exist it is added to the list. This is the created iou
        ious.add(entity);
        
       } catch (PersistenceException e) {
        e.getMessage();
       }
       catch (Exception e){
        e.getMessage();
        e.getStackTrace();   
       }
       
       return entity;
    }
       
    @Override
    public void delete(IOU entity) throws IllegalArgumentException, PersistenceException {
      try{
        //if statement if id does not exist
       if(!ious.contains(entity)){
            // exception message shows if the id does not exists
            throw new IllegalArgumentException("iou does not exist");
        }
        ious.remove(entity);

    } catch (PersistenceException e) {
        e.getMessage();
       }
       catch (Exception e){
        e.getMessage();
        e.getStackTrace();   
       }

      }
    
    @Override
    public IOU update(IOU entity) throws IllegalArgumentException, PersistenceException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }


    
    
}
