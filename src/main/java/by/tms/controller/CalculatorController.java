package by.tms.controller;

import by.tms.entity.Operation;
import by.tms.entity.User;
import by.tms.service.CalculatorService;
import by.tms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class CalculatorController {

    private final UserService userService;
    private final CalculatorService calculatorService;

    @Autowired
    public CalculatorController(UserService userService, CalculatorService calculatorService) {
        this.userService = userService;
        this.calculatorService = calculatorService;
    }

    @GetMapping("/startpage")
    public String startpage() {
        return "startpage";
    }

    @GetMapping("/registration")
    public String registration(@ModelAttribute("newUser") User user) {
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@Valid @ModelAttribute("newUser") User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        if (userService.findByEmail(user.getEmail()).isEmpty()) {
            userService.register(user);
            return "startpage";
        }
        model.addAttribute("message", "User already exists");
        return "registration";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(String email, String password, HttpSession session, Model model) {
        Optional<User> byEmail = userService.findByEmail(email);
        if (byEmail.isPresent()) {
            if (byEmail.get().getPassword().equals(password)) {
                session.setAttribute("currentUser", byEmail.get());
            } else {
                model.addAttribute("message", "Wrong password");
                return "login";
            }
        } else {
            model.addAttribute("message", "No such user");
            return "login";
        }
        return "startpage";
    }


    @GetMapping("/calculator")
    public String calculator() {
        return "calculator";
    }

    @PostMapping("/calculator")
    public String calculator(@Valid Operation operation, Model model, HttpSession session, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return "calculator";
//        }
        User user = (User) session.getAttribute("currentUser");
        model.addAttribute("result", calculatorService.calculate(operation, user));
        return "calculator";
    }

    @GetMapping("/story")
    public String story(HttpSession session, Model model) {
        User user = (User) session.getAttribute("currentUser");
        model.addAttribute("operations", calculatorService.getOperationsByUser(user));
        return "story";
    }


    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "startpage";
    }
}
