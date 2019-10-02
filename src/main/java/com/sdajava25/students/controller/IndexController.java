package com.sdajava25.students.controller;

import com.sdajava25.students.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path = "/demo/")
public class IndexController {

    @RequestMapping(path = "/index", method = RequestMethod.GET)
    public String wyswietlMojaStroneHelloWorldTySpringu(){
        return "strona-hello";
    }

    @GetMapping("/hello")
    public String wyswietlHello(){
        return "strona-hello";
    }

    @GetMapping("/helloTo")  //helloTo?imie=Pawel
    public String wyswietlHelloTo1(Model model,
                                  @RequestParam(name = "imie", required = false) String parameterImie){
        model.addAttribute("atrybutImie", parameterImie);

        return "strona-hello-to";
    }


    // /helloMyBaby/Pawel
    @GetMapping("/helloMyBaby/{babyName}")
    public String wyswietlHelloTo(Model model,
                                  @PathVariable(name = "babyName") String variable){
        model.addAttribute("atrybutImie", variable);

        return "strona-hello-to";
    }

}
