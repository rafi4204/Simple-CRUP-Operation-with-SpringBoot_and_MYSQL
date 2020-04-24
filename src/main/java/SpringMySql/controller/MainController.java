package SpringMySql.controller;

import SpringMySql.model.User;
import SpringMySql.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
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

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public ModelAndView doSave(@RequestParam("name") String name, @RequestParam("age") int age, @RequestParam("gender") String gender) {
        ModelAndView mv = new ModelAndView("redirect:/");
        User user = new User(name,age,gender);
       userRepo.save(user);
        return mv;
    }
}
