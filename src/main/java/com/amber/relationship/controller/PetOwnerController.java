package com.amber.relationship.controller;


import com.amber.relationship.exceptions.PetOwnerException;
import com.amber.relationship.model.Pet;
import com.amber.relationship.model.PetOwner;
import com.amber.relationship.model.Vet;
import com.amber.relationship.repos.PetOwnerRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PetOwnerController {
    PetOwnerRepo petOwnerDao;
//    private String[] staticLocations = RESOURCE_LOCATIONS;

    public PetOwnerController(PetOwnerRepo petOwnerDao) {
        this.petOwnerDao = petOwnerDao;
    }

    //! ALL OWNERS
    @GetMapping("/pet-owners")
    public String showOwners(Model model){
        List<PetOwner> petOwners = petOwnerDao.findAll();
        model.addAttribute("petOwners", petOwners);
        return "owners";
    }

    //! OWNER BY ID
    @GetMapping("/pet-owner/{id}")
    public String getOwnerById(
            @PathVariable long id,
            Model model
    ) throws PetOwnerException {
        PetOwner petOwner = petOwnerDao.findById(id)
                .orElseThrow(()-> new PetOwnerException("User not found"));
        List<Pet> pets = petOwner.getPets();
        model.addAttribute("petOwner", petOwner);
        model.addAttribute("pets", pets);

        return "one-owner";
    }

    //! CREATE VET
    @GetMapping("/pet-owner/create/vet")
    public String showAddVet( Model model){
       List<PetOwner> owners = petOwnerDao.findAll();
        model.addAttribute("owners", owners);
        return "add-vet";
    }


    @PostMapping("/pet-owner/create/vet")
    public String addVet(
            @RequestParam String name,
            @RequestParam String phone,
            @RequestParam String owner,
            Model model
    ) {
        Long id = null;
        Boolean inValid = name.isEmpty() ||
                phone.isEmpty() ||
                owner.isEmpty() ;
        if(!inValid){
            PetOwner petOwner = findUserByUsername(owner);
            id = petOwner.getId();
            Vet vet = new Vet(name, phone, petOwner);
            petOwner.setVet(vet);
            petOwnerDao.save(petOwner);
        return "redirect:/pet-owner/"+ id;
        }
        return "redirect:/pet-owners";
    }

    //! FIND BY USERNAME
    private PetOwner findUserByUsername(String ownerName){
        PetOwner petOwner = new PetOwner();
        List<PetOwner> owners = petOwnerDao.findAll();
        for (PetOwner owner : owners) {
            if(owner.getName().equals(ownerName)) {
                petOwner.setId(owner.getId());
                petOwner.setName(owner.getName());
                petOwner.setEmail(owner.getEmail());
                petOwner.setPhoneNumber(owner.getPhoneNumber());
            }

        }
        return petOwner;
    }



}
