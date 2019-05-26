package com.car_repair_shop.car_repair.web.admin_controllers.user;

import com.car_repair_shop.car_repair.domain.Member;
import com.car_repair_shop.car_repair.exceptions.UserNotFoundException;
import com.car_repair_shop.car_repair.forms.user.SearchForm;
import com.car_repair_shop.car_repair.services.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserSearchController {
    private static final String SEARCH_FORM = "searchForm";

    @Autowired
    private MemberService memberService;

    @RequestMapping(value = "/admin/search-user", method = RequestMethod.GET)
    public String searchUser(Model model) {
        model.addAttribute(SEARCH_FORM, new SearchForm());
        return "/admin/user/search-user-view";
    }

    @RequestMapping(value = "/admin/search-user", method = RequestMethod.POST)
    public String searchUserPost(@ModelAttribute(SEARCH_FORM) SearchForm searchForm, RedirectAttributes redirectAttributes) {
        try {
            Member member = memberService.getMemberByVatOrMail(searchForm.getVat(),searchForm.getEmail());
            redirectAttributes.addFlashAttribute("member", member);

        } catch (UserNotFoundException userNotFound) {
            redirectAttributes.addFlashAttribute("errorMessage", userNotFound.getMessage());
        }

        return "redirect:/admin/search-user";
    }
}