package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertMoneyController {
    @GetMapping("/")
    public String showcConvertController(){
        return "convert";
    }

    @GetMapping("/convert")
    public String convertController(@RequestParam int usd,Model model){
        double usdConvert=usd;
        double vnd=usdConvert*23000;
        model.addAttribute("usd",usdConvert);
        model.addAttribute("vnd",vnd);
        return "convert";
    }
}
