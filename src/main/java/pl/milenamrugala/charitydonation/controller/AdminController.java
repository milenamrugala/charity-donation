package pl.milenamrugala.charitydonation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.milenamrugala.charitydonation.model.User;
import pl.milenamrugala.charitydonation.service.UserService;

import java.util.List;

@Controller
public class AdminController {
    private final UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list-users")
    public String listUsers(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "list-users";
    }

    @GetMapping("/list-users/update")
    public String updateForm(@RequestParam("id") Long id, Model model) {

        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "list-users-update";
    }

    @PostMapping("/list-users/update")
    public String saveForm(@ModelAttribute("user") User user) {
        userService.saveUser(user);

        return "redirect:/list-users";

    }

    @GetMapping("/list-users/delete")
    public String deleteUser(@RequestParam("id") Long id) {
        userService.deleteUserById(id);
        return "redirect:/list-users";
    }

    @GetMapping("/list-users/delete-confirm")
    public String confirmDeleteUser(@RequestParam("id") Long id, Model model) {
        model.addAttribute("id", id);
        return "user-delete-confirm";
    }
}
