package com.lp.store.controllers;

import com.lp.store.entities.LongPlay;
import com.lp.store.repositories.LongPlayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

@Controller
public class LongPlayController {
	
	private final LongPlayRepository longPlayRepository;
	
	@Autowired
    public LongPlayController(LongPlayRepository longPlayRepository) {
        this.longPlayRepository = longPlayRepository;
    }
     
    @GetMapping("/signup")
    public String showSignUpForm(LongPlay longPlay) {
        return "add-lp";
    }
     
    @PostMapping("/addlp")
    public String addLongPlay(@Valid LongPlay longPlay, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-lp";
        }
         
        longPlayRepository.save(longPlay);
        model.addAttribute("lps", longPlayRepository.findAll());
        return "index";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        LongPlay longPlay = longPlayRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid long play Id:" + id));
        model.addAttribute("longPlay", longPlay); //
        return "update-lp";
    }
    @PostMapping("/update/{id}")
    public String updateLongPlay(@PathVariable("id") long id, @Valid LongPlay longPlay,
                                 BindingResult result, Model model) {
        if (result.hasErrors()) {
            longPlay.setId(id);
            return "update-lp";
        }
             
        longPlayRepository.save(longPlay);
        model.addAttribute("lps", longPlayRepository.findAll());
        return "index";
    }
         
    @GetMapping("/delete/{id}")
    public String deleteLongPlay(@PathVariable("id") long id, Model model) {
        LongPlay longPlay = longPlayRepository.findById(id)
          .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        longPlayRepository.delete(longPlay);
        model.addAttribute("lps", longPlayRepository.findAll());
        return "index";
    }

}
