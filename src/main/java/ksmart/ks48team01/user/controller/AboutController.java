package ksmart.ks48team01.user.controller;

import ksmart.ks48team01.service.StoreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("userAboutController")
@RequestMapping("/user/about")
public class AboutController {

    private final StoreService storeService;

    public AboutController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping("/nuriService")
    public String aboutNuriService(Model model) {

        model.addAttribute("title", "서비스 | 누리컬쳐 서비스 소개");

        return "user/about/nuriService";
    }

    @GetMapping("/nuriCard")
    public String aboutNuriCard(Model model) {

        model.addAttribute("title", "서비스 | 문화누리카드 소개");

        return "user/about/nuriCard";
    }
}
