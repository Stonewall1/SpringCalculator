package by.tms.controller;

import by.tms.dto.UserDto;
import by.tms.entity.User;
import by.tms.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/profile")
    public String profile() {
        return "profile";
    }

    @GetMapping("/editProfile")
    public String editProfile( @ModelAttribute("newUser") UserDto userDto) {
        return "editProfile";
    }

    @PostMapping("/editProfile")
    public String editProfile(@Valid @ModelAttribute("newUser") UserDto userDto , BindingResult bindingResult, HttpServletRequest req, HttpSession session) {
        if(bindingResult.hasErrors()){
            return "editProfile";
        }
        Long id = ((User) req.getSession().getAttribute("currentUser")).getId();
        User updatedUser = userService.updateUser(id ,userDto.getName() , userDto.getPassword());
        session.setAttribute("currentUser" , updatedUser);
        return "redirect:/user/profile";
    }

    //    @GetMapping("/story")
//    public String story(HttpSession session, Model model) {
//        User user = (User) session.getAttribute("currentUser");
//        model.addAttribute("operations", calculatorService.getOperationsByUserId(user));
//        return "story";
//    }
}
