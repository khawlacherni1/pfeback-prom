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

import com.pfe.myschool.model.Etablissement;
import com.pfe.myschool.service.EtablissementService;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/api")
public class EtablissementController {
	 @Autowired
	    private EtablissementService etablissementService;
   	 @GetMapping("/etablissements/7")
	 public  int getCode() {
		 System.out.println("Get Numbers...");
		 int  x = etablissementService.nbre();
		 System.out.println(x);
		 if (x == 0)
		 {
			 return 0;
		 }
		 else
		 {
			 return etablissementService.max();
		 }
	    
	 }
	 
	 @GetMapping("/etablissements")
	    public List<Etablissement> list() {
		 System.out.println("Get all Etablissements...");
	             return etablissementService.getAll();
	   }
	 	 
	 @GetMapping("/etablissements/{id}")
	 public ResponseEntity<Etablissement> post(@PathVariable long id) {
	        Optional<Etablissement> eta = etablissementService.findById(id);
	        return eta.map(ResponseEntity::ok)
	                   .orElseGet(() -> ResponseEntity.notFound()
                                                  .build());
	    }
	 
	
	 @PostMapping("/etablissements")
	    public long save(@RequestBody Etablissement etablissement) {
		 
	        return etablissementService.save(etablissement);
	    }

	 @PutMapping("/etablissements")
	    public void update(@RequestBody Etablissement etablissement) {
	       
	            etablissementService.update(etablissement);
	      
	    }

	    @DeleteMapping("/etablissements/{id}")
	    public void delete(@PathVariable long id) {
	        etablissementService.delete(id);
	    }
	     
	  
}

