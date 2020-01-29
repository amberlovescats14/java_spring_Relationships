package com.amber.relationship.controller;


import com.amber.relationship.model.PetOwner;
import com.amber.relationship.repos.PetOwnerRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PetOwnerController {
    PetOwnerRepo petOwnerDao;

    public PetOwnerController(PetOwnerRepo petOwnerDao) {
        this.petOwnerDao = petOwnerDao;
    }

    @GetMapping("/pet-owners")
    public String showOwners(Model model){
        List<PetOwner> petOwners = petOwnerDao.findAll();
        model.addAttribute("petOwners", petOwners);
        return "owners";
    }



}
