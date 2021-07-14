package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import services.DictionaryService;

@Controller
public class DictionaryController {
    @Autowired
    DictionaryService service;
    @GetMapping("/")
    public String showForm() {
        return "dictionary";
    }
    @GetMapping("/dictionary")
    public String getDictionary(@RequestParam String english, Model model) {
        String vn = service.findWord(english);
        model.addAttribute("eng", english);
        model.addAttribute("vn", vn);
        return "dictionary";
    }

}
