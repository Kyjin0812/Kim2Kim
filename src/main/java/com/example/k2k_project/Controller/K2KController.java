package com.example.k2k_project.Controller;

import com.example.k2k_project.Data.LodgmentDto;
import com.example.k2k_project.Data.UserDto;
import com.example.k2k_project.Entity.Lodgment;
import com.example.k2k_project.Entity.User;
import com.example.k2k_project.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class K2KController {
    @Autowired
    private UserService UserService;
    @Autowired
    private BoardService BoardService;
    @Autowired
    private CommentService CommentService;
    @Autowired
    private GradeService GradeService;
    @Autowired
    private LodgmentService LodgmentService;
    @Autowired
    private ReservationService ReservationService;

    @GetMapping("/k2k")
    public String Main() {
        return "Main";
    }

    @GetMapping("/k2k/addUser")
    public String GoUser(Model model) {
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "AddUser";
    }

    @PostMapping("/k2k/addUser")
    public String AddUser(UserDto userDto) {
        User setUser = new User();
        setUser.setName(userDto.getName());
        setUser.setId(userDto.getId());
        setUser.setPassword(userDto.getPassword());
        setUser.setRegi_num(userDto.getRegi_num());
        setUser.setType(userDto.getType());
        setUser.setPhone_num(userDto.getPhone_num());
        setUser.setAddress(userDto.getAddress());
        UserService.saveUser(setUser);
        return "Main";
    }

    @GetMapping("/k2k/addLodgment")
    public String GoLodgment(Model model) {
        LodgmentDto lodgment = new LodgmentDto();
        model.addAttribute("lodgment", lodgment);
        return "AddLodgment";
    }

    @PostMapping("/k2k/addLodgment")
    public String AddLodgment(LodgmentDto lodgmentDto) {
        System.out.println(lodgmentDto);
        Lodgment setLodgment = new Lodgment();
        setLodgment.setName(lodgmentDto.getName());
        setLodgment.setType(lodgmentDto.getType());
        setLodgment.setPhone_num(lodgmentDto.getPhone_num());
        setLodgment.setRegion_do(lodgmentDto.getRegion_do());
        setLodgment.setRegion_district(lodgmentDto.getRegion_district());
        setLodgment.setRoom_num(lodgmentDto.getRoom_num());
        LodgmentService.saveLodgment(setLodgment);
        return "Main";
    }

    @GetMapping("/k2k/viewUsers")
    public String ShowUser(Model model) {
        List<User> users = UserService.findUsers();
        model.addAttribute("users", users);
        return "ViewUser";
    }

    @GetMapping("/k2k/viewUsers/{id}")
    public String View_UserInfo(@PathVariable String id, Model model) {
        User user = UserService.getUser(id);
        model.addAttribute("user", user);
        return "ViewUserInfo";
    }

    @GetMapping("/k2k/editUser/{id}")
    public String GoEditUser(@PathVariable String id, Model model) {
        User user = UserService.getUser(id);
        model.addAttribute("user", user);
        return "EditUser";
    }

    @PostMapping("/k2k/editUser/{id}")
    public String EditUser(@PathVariable String id, UserDto userDto) {
        UserService.changeUser(id, userDto);
        return "redirect:/k2k/viewUsers";
    }

    @GetMapping("/k2k/deleteUser/{id}")
    public String DeletedUser(@PathVariable String id) {
        UserService.deleteUser(id);
        return "redirect:/k2k/viewUsers";
    }

    @GetMapping("/k2k/viewLodgments")
    public String ShowLodgment(Model model) {
        List<Lodgment> lodgments = LodgmentService.findLodgments();
        model.addAttribute("lodgments", lodgments);
        return "ViewLodgment";
    }

    @GetMapping("/k2k/editLodgment/{id}")
    public String GoEditLodgment(@PathVariable int id, Model model) {
        Lodgment lodgment = LodgmentService.getLodgment(id);
        model.addAttribute("lodgment", lodgment);
        return "EditLodgment";
    }

    @PostMapping("/k2k/editLodgment/{id}")
    public String EditLodgment(@PathVariable int id, LodgmentDto lodgmentDto) {
        LodgmentService.changeLodgment(id, lodgmentDto);
        return "redirect:/k2k/viewLodgments";
    }

    @GetMapping("/k2k/deleteLodgment/{id}")
    public String DeletedLodgment(@PathVariable int id) {
        LodgmentService.deleteLodgment(id);
        return "redirect:/k2k/viewLodgments";
    }
}
