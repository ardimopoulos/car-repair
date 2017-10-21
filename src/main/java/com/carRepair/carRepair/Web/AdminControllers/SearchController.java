package com.carRepair.carRepair.Web.AdminControllers;

import com.carRepair.carRepair.Domain.Member;
import com.carRepair.carRepair.Exceptions.UserNotFoundException;
import com.carRepair.carRepair.Forms.SearchForm;
import com.carRepair.carRepair.Forms.UserForm;
import com.carRepair.carRepair.Services.SearchService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class SearchController {

    private static final String SEARCH_FORM = "searchForm";
    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(SearchController.class);

    @Autowired
    private SearchService searchService;


    @RequestMapping(value = "/admin/search-user", method = RequestMethod.GET)
    public String searchUser(Model model){

        if(!model.containsAttribute(SEARCH_FORM)){
            model.addAttribute(SEARCH_FORM, new SearchForm());
        }

        return "/admin/user/search-user";
    }

    @RequestMapping(value = "/admin/search-user", method = RequestMethod.POST)
    public String searchUserPost(@Valid @ModelAttribute(SEARCH_FORM)
                                SearchForm searchForm,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("bindingResult", bindingResult);
            redirectAttributes.addFlashAttribute(SEARCH_FORM, searchForm);
            logger.error(String.format("%s Validation Errors present: ", bindingResult.getErrorCount()));
            return "redirect:/admin/search-user";
        }

        try {
            Member member = searchService.getMemberByVatOrMail(searchForm.getVat(), searchForm.getEmail());
            redirectAttributes.addFlashAttribute("member" , member);
        }catch(UserNotFoundException userNotFound){
            System.out.println("Controller : User not Found " + userNotFound);
            redirectAttributes.addFlashAttribute("errorMessage" , "Can t find the user");
        }
        return "redirect:/admin/search-user";
    }
}
