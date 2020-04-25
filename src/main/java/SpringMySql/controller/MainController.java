package SpringMySql.controller;

import SpringMySql.model.User;
import SpringMySql.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @Autowired
    public UserRepo userRepo;


    @RequestMapping("/")
    public ModelAndView doHome() {
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("list", userRepo.findAll());
        return mv;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView doSave(@RequestParam("id") int id, @RequestParam("name") String name, @RequestParam("age") int age, @RequestParam("gender") String gender) {
        ModelAndView mv = new ModelAndView("redirect:/");
        if (id==-1) {
            User user = new User(name, age, gender);
            userRepo.save(user);
        } else {
            if(userRepo.findById(id).isPresent()) {
                User user = userRepo.findById(id).get();
                user.setAge(age);
                user.setName(name);
                user.setGender(gender);
                userRepo.save(user);
            }


        }


        return mv;
    }

    @RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
    public ModelAndView doShow(@PathVariable("id") int id) {
        ModelAndView mv = new ModelAndView("view");
        if (userRepo.findById(id).isPresent())
            mv.addObject("item", userRepo.findById(id).get());
        return mv;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView doDelete(@PathVariable("id") int id) {
        ModelAndView mv = new ModelAndView("redirect:/");
        userRepo.deleteById(id);
        return mv;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public ModelAndView doUpdate(@PathVariable("id") int id) {
        ModelAndView mv = new ModelAndView("update");
        if (userRepo.findById(id).isPresent())
            mv.addObject("item", userRepo.findById(id).get());
        return mv;
    }
}
