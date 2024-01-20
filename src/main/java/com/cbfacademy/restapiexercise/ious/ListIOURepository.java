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
        return new ArrayList<>(ious)
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public IOU update(IOU entity) throws IllegalArgumentException, PersistenceException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public List<IOU> searchByBorrower(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchByBorrower'");
    }

    @Override
    public List<IOU> searchByLender(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchByLender'");
    }
    
}
