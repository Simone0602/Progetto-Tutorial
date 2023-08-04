package com.example.tutorial.controller;

import com.example.tutorial.model.Tutorial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.tutorial.repository.TutorialRepository;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/api")
public class TutorialController {

    @Autowired
    private TutorialRepository tutorialRepository;

    @PostMapping(path = "/tutorial")
    public ResponseEntity<Tutorial> addNewTutorial (@RequestBody Tutorial tutorial){

        Tutorial t = tutorialRepository.save(new Tutorial(tutorial.getTitle(), tutorial.getDescription(), tutorial.isPublished()));
        return new ResponseEntity<>(t, HttpStatus.CREATED);
        }

    @GetMapping(path = "/tutorials")
    public @ResponseBody List<Tutorial> getAllTutorial(){
        List<Tutorial> tutorial = new ArrayList<>();
        tutorial=tutorialRepository.findAll();
        return tutorial;
    }

    @DeleteMapping(path = "/tutorials/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable(name = "id") long id){
        if(tutorialRepository.existsById((int) id)) {
            tutorialRepository.deleteById((int) id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(path = "/tutorial/up/{id}")
    public ResponseEntity<Tutorial> updateById(@PathVariable(name= "id") long id, @RequestBody Tutorial tutorial){
        Tutorial t = tutorialRepository.findById((int) id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Tutorial Not Found with id = " + id));

        t.setTitle(tutorial.getTitle());
        t.setDescription(tutorial.getDescription());
        t.setPublished(tutorial.isPublished());

        return new ResponseEntity<>(tutorialRepository.save(t), HttpStatus.OK);
    }

}
