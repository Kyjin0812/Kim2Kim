package com.example.k2k_project.Controller;

import com.example.k2k_project.Data.LodgmentDto;
import com.example.k2k_project.Data.MemberDto;
import com.example.k2k_project.Entity.Board;
import com.example.k2k_project.Entity.Lodgment;
import com.example.k2k_project.Entity.Member;
import com.example.k2k_project.Entity.Search;
import com.example.k2k_project.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class K2KController {
    @Autowired
    private MemberService MemberService;
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
        return "index";
    }

    @GetMapping("/k2k/admin")
    public String Admin() {
        return "Main";
    }

    @GetMapping("/k2k/login")
    public String GoLogin() {
        return "login";
    }

    @GetMapping("/k2k/loginSuccess")
    public String SuccessLogin() {
        return "index_login";
    }

    @GetMapping("/k2k/logout_page")
    public String GoLogOut() {
        return "index";
    }

    @GetMapping("/k2k/Member/add")
    public String GoUser(Model model) {
        MemberDto user = new MemberDto();
        model.addAttribute("member", user);
        return "Member/AddUser";
    }

    @PostMapping("/k2k/Member/add")
    public String AddUser(MemberDto memberDto) {
        Member setMember = new Member();
        setMember.setName(memberDto.getName());
        setMember.setId(memberDto.getId());
        setMember.setPassword(memberDto.getPassword());
        setMember.setRegi_num(memberDto.getRegi_num());
        setMember.setPhone_num(memberDto.getPhone_num());
        setMember.setAddress(memberDto.getAddress());
        MemberService.saveUser(setMember);
        return "Main";
    }

    @GetMapping("/k2k/Lodgment/add")
    public String GoLodgment(Model model) {
        LodgmentDto lodgment = new LodgmentDto();
        model.addAttribute("lodgment", lodgment);
        return "Lodgment/AddLodgment";
    }

    @PostMapping("/k2k/Lodgment/add")
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

    @GetMapping("/k2k/Member/view")
    public String ShowUser(Model model) {
        List<Member> members = MemberService.findUsers();
        model.addAttribute("users", members);
        return "Member/ViewUser";
    }

    @GetMapping("/k2k/Member/view/{id}")
    public String View_UserInfo(@PathVariable String id, Model model) {
        Member member = MemberService.getUser(id);
        model.addAttribute("user", member);
        return "Member/ViewUserInfo";
    }

    @GetMapping("/k2k/Member/edit/{id}")
    public String GoEditUser(@PathVariable String id, Model model) {
        Member member = MemberService.getUser(id);
        model.addAttribute("user", member);
        return "Member/EditUser";
    }

    @PostMapping("/k2k/Member/edit/{id}")
    public String EditUser(@PathVariable String id, MemberDto memberDto) {
        MemberService.changeUser(id, memberDto);
        return "redirect:/k2k/Member/view";
    }

    @GetMapping("/k2k/Member/delete/{id}")
    public String DeletedUser(@PathVariable String id) {
        MemberService.deleteUser(id);
        return "redirect:/k2k/Member/view";
    }

    @GetMapping("/k2k/Lodgment/view")
    public String ShowLodgment(Model model) {
        List<Lodgment> lodgments = LodgmentService.findLodgments();
        model.addAttribute("lodgments", lodgments);
        return "Lodgment/ViewLodgment";
    }

    @GetMapping("/k2k/Lodgment/edit/{id}")
    public String GoEditLodgment(@PathVariable int id, Model model) {
        Lodgment lodgment = LodgmentService.getLodgment(id);
        model.addAttribute("lodgment", lodgment);
        return "Lodgment/EditLodgment";
    }

    @PostMapping("/k2k/Lodgment/edit/{id}")
    public String EditLodgment(@PathVariable int id, LodgmentDto lodgmentDto) {
        LodgmentService.changeLodgment(id, lodgmentDto);
        return "redirect:/k2k/Lodgment/view";
    }

    @GetMapping("/k2k/Lodgment/delete/{id}")
    public String DeletedLodgment(@PathVariable int id) {
        LodgmentService.deleteLodgment(id);
        return "redirect:/k2k/Lodgment/view";
    }

    @GetMapping("/k2k/Board/getBoardList")
    public String getBoardList(Model model,
                               @RequestParam(value = "page", defaultValue = "0") int page,
                               @RequestParam(value = "searchCondition", defaultValue = "") String searchCondition,
                               @RequestParam(value = "searchKeyword", defaultValue = "") String searchKeyword,
                               @RequestParam(value = "memberName", defaultValue = "") String memberName) {
        Page<Board> boardPage = BoardService.getBoardList(page, new Search(searchCondition, searchKeyword));

        model.addAttribute("searchCondition", searchCondition);
        model.addAttribute("searchKeyword", searchKeyword);
        model.addAttribute("memberName", memberName);

        model.addAttribute("boardList", boardPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", boardPage.getTotalPages());
        model.addAttribute("boardPage", boardPage);

        return "board";
    }
}
