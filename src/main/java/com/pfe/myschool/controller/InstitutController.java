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

import com.pfe.myschool.model.Institut;
import com.pfe.myschool.service.InstitutService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class InstitutController {
	 @Autowired
	    private InstitutService institutService;
   
	 @GetMapping("/instituts")
	    public List<Institut> list() {
		 System.out.println("Get all Instituts...");
	             return institutService.getAll();
	   }
	 @GetMapping("/instituts/7")
	 public  int getCode() {
		 System.out.println("Get Numbers...");
		 int  x = institutService.nbre();
		 System.out.println(x);
		 if (x == 0)
		 {
			 return 0;
		 }
		 else
		 {
			 return institutService.max();
		 }
	    
	 }

	 @GetMapping("/instituts/{id}")
	 public ResponseEntity<Institut> post(@PathVariable long id) {
	        Optional<Institut> ins = institutService.findById(id);
	        return ins.map(ResponseEntity::ok)
	                   .orElseGet(() -> ResponseEntity.notFound()
                                                  .build());
	    }
	    
	 @PostMapping("/instituts")
	    public long save(@RequestBody Institut institut) {
		 
	        return institutService.save(institut);
	    }

	 @PutMapping("/instituts")
	    public void update( @RequestBody Institut institut) {
	       
	            institutService.save(institut);
	      
	    }

	    @DeleteMapping("/instituts/{id}")
	    public void delete(@PathVariable long id) {
	        institutService.delete(id);
	    }
	     
	  
}

