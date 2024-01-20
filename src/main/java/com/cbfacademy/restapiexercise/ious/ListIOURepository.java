package com.cbfacademy.restapiexercise.ious;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.cbfacademy.restapiexercise.core.PersistenceException;

@Repository
public class ListIOURepository implements IOURepository {

    final List<IOU> ious = new ArrayList<>();

    @Override
    public List<IOU> retrieveAll() throws PersistenceException {
        return new ArrayList<>(ious);
    }

    @Override
    public IOU retrieve(UUID id) throws IllegalArgumentException, PersistenceException {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");     
        }
            for (IOU iou : ious) {
                // If id is equal to the param name id
                //use geter method to check if id matches name
                if (iou.getID().compareTo(id) == 0) {
                    // Add the borrower to a list we want to return
                    //use add method from newlist to add
                    return iou;
                }  
                
            }
          throw new PersistenceException("IOU not found for ID" +id);  
    }

    @Override
    public IOU create(IOU entity) throws IllegalArgumentException, PersistenceException {
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
        try{
            //if statement if id does not exist
           if(!ious.contains(entity)){
                // exception message shows if the id does not exists
                throw new IllegalArgumentException("iou does not exist");
            }
            ious.update(entity);
    
        } catch (PersistenceException e) {
            e.getMessage();
           }
           catch (Exception e){
            e.getMessage();
            e.getStackTrace();   
           }
    
          }
    

    @Override
    public List<IOU> searchByBorrower(String name) {
        List<IOU> matchedBorrowers = new ArrayList <>();

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
    @Override
    public List<IOU> searchByLender(String name) {
        List<IOU> matchedLenders = new ArrayList <>();

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
    

