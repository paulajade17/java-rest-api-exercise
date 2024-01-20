package com.cbfacademy.restapiexercise.ious;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class ListIOUServiceold {

    final List<IOU> ious = new ArrayList<>();
    // Create a new field of type IOURepository called repository
    public IOURepository repository;
    public ListIOUServiceold (IOURepository iouRepository) {
        // Assign repository (line 13) to the iouRepository value in our parameter
        this.repository = iouRepository;
    }

    //implement methods in IOUservice interface
    public List<IOU> getAllIOUs(){
        return ious;
    }

     public IOU getIOU(UUID id){
        for(IOU iou : ious){
            if(iou.getID() == id){
                return iou;
            }

        }
        return null;
     }

     // adding new IOU to list
    public IOU createIOU(IOU iou){
        ious.add(iou);
        return iou;
        
    }

    public IOU updateIOU(UUID id, IOU updatedIOU){
        //create a loop to find IOU with id
        // Then update iou and replace it in the list 

        for(IOU iou: ious){
            if(iou.getID() == id){
                // get the position of the iou in the list. this is required so we can replace the iou in the next line
                int index = ious.indexOf(iou);
                // update iou and replace it in the list with the matching id
                ious.set(index, updatedIOU);
            }
        }
        return updatedIOU;
    }


    public void deleteIOU(UUID id){
        //enhanced for loop to loop through the list of ious
        for(IOU iou: ious){
            //get method to find if iou is equal to id
            if(iou.getID() == id){
                //if the iou matches the id
                //use remove method to delete iou
               ious.remove(iou); 
            }
        }
                

    }
    







    
    

}
