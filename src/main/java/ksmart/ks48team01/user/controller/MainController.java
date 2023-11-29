package ksmart.ks48team01.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("userMainController")
@RequestMapping("/user")
public class MainController {



	@GetMapping(value = {"", "/"})
	public String userMainPage(Model model) {

		model.addAttribute("title", "메인페이지 - 누리컬쳐");
		
		return "user/main";
	}

}
