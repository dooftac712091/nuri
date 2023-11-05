package ksmart.ks48team01.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("userAboutController")
@RequestMapping("/user/about")
public class AboutController {

    @GetMapping(value = "/nuriService")
    public String aboutNuriService(Model model) {

        return "user/about/nuriService";
    }

    @GetMapping(value = "/nuriStore")
    public String aboutNuriStore(Model model) {

        return "user/about/nuriStore";
    }

    @GetMapping(value = "/nuriCard")
    public String aboutNuriCard(Model model) {

        return "user/about/nuriCard";
    }
}
