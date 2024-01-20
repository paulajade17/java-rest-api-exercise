package com.cbfacademy.restapiexercise.ious;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IOUController {
    public IOUService iouService; 

    //pass in an interface not a concrete class.
    //Interfaces describes things
    public IOUController(IOUService iouService){
        this.iouService = iouService;

       //Get all IOUs method
       @GetMapping
       public List<IOU> getAllIOUS() {
        return iouService.getAllIOUs();
    }




    }
}
