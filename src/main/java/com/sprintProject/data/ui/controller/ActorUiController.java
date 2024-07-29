package com.sprintProject.data.ui.controller;
import com.sprintProject.data.entity.Actor;
import com.sprintProject.data.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/ui/actors")
public class ActorUiController {

     @Autowired
    private ActorService actorService;

 

    @GetMapping("/all")

    public String getAllActors(Model model) {

        List<Actor> actors = actorService.getAllActors();

        model.addAttribute("actors", actors);

        return "allActors";

    }

 

    @GetMapping("/view/{actorId}")

    public String getActorById(Model model, @PathVariable("actorId") int actorId) {

        Actor actor = actorService.getActorById(actorId);

        model.addAttribute("actor", actor);

        return "viewActor";

    }

 

    @GetMapping("actors/add")

    public String getAddActorForm(Model model) {

        Actor newActor = new Actor();

        model.addAttribute("newActor", newActor);

        return "addActor";

    }

 

    @PostMapping("/add")

    public String addActor(@ModelAttribute("newActor") Actor actor) {

        actorService.addActor(actor);

        return "redirect:/api/ui/actors/all";
    }

 

    @GetMapping("/update/{actorId}")

    public String getUpdateActorForm(Model model, @PathVariable("actorId") int actorId) {

        Actor actor = actorService.getActorById(actorId);

        model.addAttribute("updatedActor", actor);

        return "updateActor";

    }

 
    

    @PostMapping("/update/{actorId}")
    

    public String updateActor(@ModelAttribute("updatedActor") Actor actor, @PathVariable("actorId") int actorId) {

        actorService.updateFirstNameOfActor(actorId, actor);

        return "redirect:/api/ui/actors/all";

    }

 

    @GetMapping("/delete/{actorId}")

    public String deleteActor(@PathVariable("actorId") int actorId) {

        actorService.deleteActorByactor_id(actorId);

        return "redirect:/actors/all";

    }

}

 
