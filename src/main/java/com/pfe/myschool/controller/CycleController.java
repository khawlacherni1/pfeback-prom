package com.pfe.myschool.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.myschool.model.Cycle;
import com.pfe.myschool.service.CycleService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CycleController {
	 @Autowired
	    private CycleService cycleService;
   	 @GetMapping("/cycles/7")
	 public  int getCode() {
		 System.out.println("Get Numbers...");
		 int  x = cycleService.nbre();
		 System.out.println(x);
		 if (x == 0)
		 {
			 return 0;
		 }
		 else
		 {
			 return cycleService.max();
		 }
	    
	 }
	 
	 @GetMapping("/cycles")
	    public List<Cycle> list() {
		 System.out.println("Get all Cycles...");
	             return cycleService.getAll();
	   }
	 	 
	 @GetMapping("/cycles/{id}")
	 public ResponseEntity<Cycle> post(@PathVariable Long id) {
	        Optional<Cycle> cyc = cycleService.findById(id);
	        return cyc.map(ResponseEntity::ok)
	                   .orElseGet(() -> ResponseEntity.notFound()
                                                  .build());
	    }
	    
	 @PostMapping("/cycles")
	    public long save(@RequestBody Cycle cycle) {
		 
	        return cycleService.save(cycle);
	    }

	 @PutMapping("/cycles")
	    public void update( @RequestBody Cycle cycle) {
	       
	            cycleService.update(cycle);
	      
	    }

	    @DeleteMapping("/cycles/{id}")
	    public void delete(@PathVariable Long id) {
	        cycleService.delete(id);
	    }
	     
	  
}
