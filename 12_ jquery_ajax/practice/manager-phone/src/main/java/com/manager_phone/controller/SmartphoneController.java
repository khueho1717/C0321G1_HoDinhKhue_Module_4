package com.manager_phone.controller;


import com.manager_phone.model.entity.SmartPhone;
import com.manager_phone.model.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@RequestMapping("/smartphones")
@CrossOrigin
public class SmartphoneController {
    @Autowired
    private ISmartphoneService smartphoneService;

    @PostMapping
    public ResponseEntity<SmartPhone> createSmartphone(@RequestBody SmartPhone smartphone) {
        if (smartphone.getId()==null){
            smartphoneService.save(smartphone);
            return new ResponseEntity<>( HttpStatus.OK);
        }
        return new ResponseEntity<>(smartphoneService.save(smartphone), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Iterable<SmartPhone>> allPhones() {
        return new ResponseEntity<>(smartphoneService.findAll(), HttpStatus.OK);
    }
    @DeleteMapping("/{phoneId}")
    public ResponseEntity<SmartPhone> deleteSmartphone(@PathVariable Long phoneId) {
        Optional<SmartPhone> smartphoneOptional = smartphoneService.findById(phoneId);
        if (!smartphoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        smartphoneService.remove(phoneId);
        return new ResponseEntity<>(smartphoneOptional.get(), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{phoneId}")
    public ResponseEntity<SmartPhone> editSmartphonePage(@PathVariable Long phoneId) {
        Optional<SmartPhone> smartphone = smartphoneService.findById(phoneId);
        if (!smartphone.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(smartphone.get(), HttpStatus.OK);

    }
    
}