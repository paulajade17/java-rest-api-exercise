package com.cbfacademy.restapiexercise.ious;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties.Io;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

@RestController
@RequestMapping("api/ious")
public class IOUController {

    private final IOUService iouService;

    //only pass an interface not a concrete class
    @Autowired 
    public IOUController(IOUService iouService){
        this.iouService = iouService;
    }

   @GetMapping("/api/ious")
   public List<IOU> getAllIOUs(){
    return iouService.getAllIOUs();
   }

   @GetMapping("/api/ious/{id}")
   public IOU getIOUByID(@PathVariable UUID id) {
    return iouService.getIOU(id);
   }

   @PostMapping("/api/ious")
   public IOU createIOU(@RequestBody IOU iou){
    return iouService.createIOU(iou);
   } 

   @PutMapping("/api/ious/{id}")
   public IOU updateIOU(@PathVariable UUID id, @RequestBody IOU updatedIOU) {
    iouService.replaceIOUByID(id, updatedIOU);
    return updatedIOU;
   }
   
   @DeleteMapping("/api/ious/{id}")
   public void deleteIOU(UUID id){
    iouService.deleteIOU(id);
   }

}
    


    
