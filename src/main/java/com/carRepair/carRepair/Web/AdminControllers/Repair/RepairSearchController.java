package com.carRepair.carRepair.Web.AdminControllers.Repair;

import com.carRepair.carRepair.Domain.Repair;
import com.carRepair.carRepair.Exceptions.DateParseException;
import com.carRepair.carRepair.Exceptions.RepairNotFoundException;
import com.carRepair.carRepair.Forms.Repair.RepairSearchForm;
import com.carRepair.carRepair.Services.Repair.RepairService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class RepairSearchController {
    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(RepairSearchController.class);
    private static final String REPAIR_SEARCH_FORM = "repairSearchForm";

    @Autowired
    private RepairService repairService;

    @RequestMapping(value = "/admin/search-repair", method = RequestMethod.GET)
    public String searchRepair(Model model){

        if(!model.containsAttribute(REPAIR_SEARCH_FORM)){
            model.addAttribute(REPAIR_SEARCH_FORM, new RepairSearchForm());
        }

        return "/admin/repairs/search-repair-view";
    }

    @RequestMapping(value = "/admin/search-repair", method = RequestMethod.POST)
    public String searchRepairPost(@Valid @ModelAttribute(REPAIR_SEARCH_FORM)
                                               RepairSearchForm repairSearchForm,
                                   BindingResult bindingResult,
                                   RedirectAttributes redirectAttributes,
                                   @RequestParam("button") String button){


        if(button.equals("Search Vat")){
            try {
                List<Repair> repairs = repairService.getByVat(repairSearchForm.getVat());
                redirectAttributes.addFlashAttribute("repairs", repairs);
            }catch(RepairNotFoundException repairNotFound){redirectAttributes.addFlashAttribute("errorMessage", repairNotFound.getMessage()); }

        }else if(button.equals("Search Plate")){
            try{
            List<Repair> repairs = repairService.getByPlate(repairSearchForm.getPlate());
            redirectAttributes.addFlashAttribute("repairs" , repairs);
        }catch(RepairNotFoundException repairNotFound){redirectAttributes.addFlashAttribute("errorMessage", repairNotFound.getMessage()); }

        }else if(button.equals("Search Date")){
            try{
                List<Repair> repairs = repairService.getByRepairDate(repairSearchForm.getDate());
                redirectAttributes.addFlashAttribute("repairs" , repairs);
        }catch(RepairNotFoundException repairNotFound) {
                redirectAttributes.addFlashAttribute("errorMessage", repairNotFound.getMessage());
        }catch(DateParseException dateParseException){
                redirectAttributes.addFlashAttribute("errorMessage", dateParseException.getMessage());
            }

        }else if(button.equals("Search Between")){
            try{
            List<Repair> repairs = repairService.getByBetweenRepairDates(repairSearchForm.getStartDate() ,repairSearchForm.getBeforeDate() );
            redirectAttributes.addFlashAttribute("repairs" , repairs);
            }catch(RepairNotFoundException repairNotFound){redirectAttributes.addFlashAttribute("errorMessage", repairNotFound.getMessage()); }
            catch(DateParseException dateParseException){redirectAttributes.addFlashAttribute("errorMessage", dateParseException.getMessage()); }
        }else{
            redirectAttributes.addFlashAttribute("errorMessage", "Press the button");
        }

        return "redirect:/admin/search-repair";
    }

}
