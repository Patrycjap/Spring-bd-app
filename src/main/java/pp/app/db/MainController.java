package pp.app.db;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pp.app.db.User.User;
import pp.app.db.User.UserRepository;

import java.util.List;

@Controller
public class MainController {

    private final UserRepository userRepository;

    public MainController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String homepage(Model model) {
        List<User> users = userRepository.findAll();
        User user = new User();
        model.addAttribute("users", users);
        model.addAttribute("user", user);
        return "home";
    }

    @PostMapping("/")
    public String addUser(User user) {
        userRepository.save(user);
        return "redirect:/";
    }
}