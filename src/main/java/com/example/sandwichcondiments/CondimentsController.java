package com.example.sandwichcondiments;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/home")
public class CondimentsController {

    private List<String> listcondiments = new ArrayList<>();
    @GetMapping()
    public String home(Model model) {
        model.addAttribute("condiments", listcondiments);
        return "condiments";
    }

    @PostMapping(value = "/save")
    public String save(@RequestParam (name = "condiment", required = false) ArrayList<String> condiments) {
        if (condiments != null) {
            this.listcondiments = condiments;
        }
        return "redirect:/home";
    }


}
