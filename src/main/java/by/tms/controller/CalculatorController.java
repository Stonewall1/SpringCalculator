package by.tms.controller;

import by.tms.entity.User;
import by.tms.service.CalculatorService;
import by.tms.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/")
public class CalculatorController {

    private final RegistrationService registrationService;
    private final CalculatorService calculatorService;

    @Autowired
    public CalculatorController(RegistrationService registrationService, CalculatorService calculatorService) {
        this.registrationService = registrationService;
        this.calculatorService = calculatorService;
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(User user) {
        registrationService.register(user);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(String email, String password , Model model) {
        Optional<User> byEmail = registrationService.findByEmail(email);
        if(byEmail.isPresent()){
            model.addAttribute("currentUser" , byEmail.get());
            return "calculator";
        }
       return "redirect:/";
    }


    @GetMapping("/calculator")
    public String calculator(Double x1, Double x2, String operation, Model model) {
        return "calculator";
    }

    @GetMapping("/story")
    public String story() {
        return "story";
    }


    @GetMapping("/logout")
    public String logout() {
        return "redirect :/";
    }
}
