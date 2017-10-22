package com.carRepair.carRepair.Web.AdminControllers;

import com.carRepair.carRepair.Domain.Member;
import com.carRepair.carRepair.Exceptions.UserNotFoundException;
import com.carRepair.carRepair.Forms.SearchForm;
import com.carRepair.carRepair.Services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SearchController {

    private static final String SEARCH_FORM = "searchForm";


    @Autowired
    private MemberService memberService;


    @RequestMapping(value = "/admin/search-user", method = RequestMethod.GET)
    public String searchUser(Model model){

        if(model.containsAttribute("member")){

        }

        model.addAttribute(SEARCH_FORM, new SearchForm());
        return "/admin/user/search-user";
    }

    @RequestMapping(value = "/admin/search-user", method = RequestMethod.POST)
    public String searchUserPost(Model model , @ModelAttribute(SEARCH_FORM) SearchForm searchForm, RedirectAttributes redirectAttributes){
        Member member = null;
        try {
            member = memberService.getMemberByVatOrMail(searchForm.getVat(),searchForm.getEmail());
        }catch(UserNotFoundException userNotFound){
            System.out.println("User not Found controller" + userNotFound);
            redirectAttributes.addFlashAttribute("errormessage", "No results");
            return "redirect:/admin/search-user";
        }

        redirectAttributes.addFlashAttribute("errormessage", "yeaaah");
        redirectAttributes.addFlashAttribute("member", member);
        return "redirect:/admin/search-user";
    }
}
