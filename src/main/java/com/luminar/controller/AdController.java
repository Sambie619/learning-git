package com.luminar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luminar.entity.Ad;
import com.luminar.entity.Client;
import com.luminar.service.AdService;
import com.luminar.service.ClientService;

@Controller
@RequestMapping("/ads")
public class AdController {

    @Autowired
    private AdService adService;

    @Autowired
    private ClientService clientService;

    @GetMapping
    public String adsPage(Model model) {
        model.addAttribute("ads", adService.getAllAds());
        return "ads";
    }

    @GetMapping("/add")
    public String addAdPage(Model model) {
        model.addAttribute("ad", new Ad());
        model.addAttribute("clients", clientService.getAllClients());
        return "add-ad";
    }

    @PostMapping("/save")
    public String saveAd(@RequestParam("clientId") int clientId,
                         @RequestParam("title") String title,
                         @RequestParam("description") String description,
                         @RequestParam("imagePath") String imagePath) {

        // Find the client
        Client selectedClient = clientService.getAllClients()
                .stream()
                .filter(c -> c.getClientId() == clientId)
                .findFirst()
                .orElse(null);

        if (selectedClient != null) {
            Ad ad = new Ad(selectedClient, title, description, imagePath);
            adService.addAd(ad);
        }

        return "redirect:/ads";
    }
}
