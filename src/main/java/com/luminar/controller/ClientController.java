package com.luminar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luminar.entity.Client;
import com.luminar.service.ClientService;

@Controller
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public String clientsPage(Model model) {
        model.addAttribute("clients", clientService.getAllClients());
        return "clients";
    }

    @GetMapping("/add")
    public String addClientPage(Model model) {
        model.addAttribute("client", new Client());
        return "add-client";
    }

    @PostMapping("/save")
    public String saveClient(@ModelAttribute Client client) {
        clientService.addClient(client);
        return "redirect:/clients";
    }
}

