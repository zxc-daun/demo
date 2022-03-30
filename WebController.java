package kz.narxoz.springrestapp.controller;

import kz.narxoz.springrestapp.model.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class WebController {

    private static List<User> users = new ArrayList<>();

    private static int ID = 1;

    @GetMapping("/")
    public String showUserList(Model model) {
        model.addAttribute("users", users);
        return "index";
    }

    @PostMapping("/adduser")
    public String createUser(@ModelAttribute User user){
        addUser(user);
        return "redirect:/";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") int id, User user) {
        updateUser(user);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/signup")
    public String showSignUpForm(User user) {
        return "add-user";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        User user = getById(id);
        model.addAttribute("user", user);
        return "update-user";
    }

    private static void deleteById(int id) {
       users.remove(getById(id));
    }

    private static void addUser(User newUser) {
        users.add(new User(ID++, newUser.getName(), newUser.getSurname()));
    }

    private static void updateUser(User updateUser) {
        int index = users.indexOf(getById(updateUser.getId()));

        users.get(index).setName(updateUser.getName());
        users.get(index).setSurname(updateUser.getSurname());
    }

    private static User getById(int id) {
        return users.stream().filter(user -> user.getId() == id).collect(Collectors.toList()).get(0);
    }
}
