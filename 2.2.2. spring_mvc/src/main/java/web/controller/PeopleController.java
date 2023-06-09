package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.dao.DAO;
import web.dao.HibernateDAO;
import web.model.User;

@Controller
@RequestMapping("/")
public class PeopleController {

    @Autowired
    private DAO dao;

    @GetMapping("/")
    public String allPeople(Model model) {
        model.addAttribute("people", dao.allPeople());
        return "/allPeople";
    }

    @GetMapping("/new")
    public String newPerson(Model model) {
        model.addAttribute("user", new User());
        return "/new";
    }

    @PostMapping
    public String create(@ModelAttribute("user") User user) {
        dao.save(user);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", dao.personById(id));
        return "/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        dao.update(id, user);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        dao.delete(id);
        return "redirect:/";
    }
}
