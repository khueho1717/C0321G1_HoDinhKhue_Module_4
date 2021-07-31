package com.manager_phone.controller;

import com.manager_phone.model.entity.SmartPhone;
import com.manager_phone.model.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/smartphones")
public class SmartphoneController {

    @Autowired
    ISmartphoneService smartphoneService;

    @PostMapping
    public ResponseEntity<SmartPhone> createSmartphone(@RequestBody SmartPhone smartPhone){
        if (smartPhone.getId()==null){
            return new ResponseEntity<>(smartphoneService.save(smartPhone), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(smartphoneService.save(smartPhone), HttpStatus.OK);

    }

    @GetMapping("/list")
    public ModelAndView getAllSmartphonePage(){
        ModelAndView modelAndView=new ModelAndView("/phones/list");
        modelAndView.addObject("smartphones",smartphoneService.findAll());
        return modelAndView;
    }

    @GetMapping
    public ResponseEntity<Iterable<SmartPhone>> allPhones() {
        return new ResponseEntity<>(smartphoneService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SmartPhone> deleteSmartphone(@PathVariable Long id) {
        Optional<SmartPhone> smartphoneOptional = smartphoneService.findById(id);
        if (!smartphoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        smartphoneService.remove(id);
        return new ResponseEntity<>(smartphoneOptional.get(), HttpStatus.NO_CONTENT);
    }
    @GetMapping("/{id}")
    public ResponseEntity<SmartPhone> loadFormEdit(@PathVariable Long id) {
        Optional<SmartPhone> smartPhone=smartphoneService.findById(id);
        if (!smartPhone.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(smartPhone.get(), HttpStatus.NO_CONTENT);
    }

}
