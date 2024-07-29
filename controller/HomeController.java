package com.example.sompo.controller;

import com.example.sompo.model.KaskoModel;
import com.example.sompo.service.KaskoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
    @Autowired
    private KaskoService kaskoService;

    @GetMapping("/")
    public String getAllKaskos(Model model) {
        model.addAttribute("kaskoList", kaskoService.gettAllKaskos());
        model.addAttribute("kasko", new KaskoModel());
        return "index"; // Burada 'kasko' Thymeleaf template dosyasının adıdır, uzantı .html olmalı.
    }

    @PostMapping("/saveKasko")
    public String saveKasko(@ModelAttribute KaskoModel kasko) {
        kaskoService.saveKasko(kasko);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editKasko(@PathVariable Long id, Model model) {
        KaskoModel kasko = kaskoService.getKaskoById(id);
        model.addAttribute("kasko", kasko);
        return "index";
    }

    @GetMapping("/delete/{id}")
    public String deleteKasko(@PathVariable Long id) {
        kaskoService.deleteKasko(id);
        return "redirect:/";
    }
}
