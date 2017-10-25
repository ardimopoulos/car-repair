package com.carRepair.carRepair.Web.AdminControllers.Repair;

import com.carRepair.carRepair.Converters.RepairConverter;
import com.carRepair.carRepair.Domain.Repair;
import com.carRepair.carRepair.Domain.Vehicle;
import com.carRepair.carRepair.Exceptions.Repair.RepairNotFoundException;
import com.carRepair.carRepair.Forms.Repair.RepairForm;
import com.carRepair.carRepair.Forms.User.SearchForm;
import com.carRepair.carRepair.Forms.Vehicle.VehicleForm;
import com.carRepair.carRepair.Repositories.RepairRepository;
import com.carRepair.carRepair.Services.Repair.RepairCreateService;
import com.carRepair.carRepair.Services.Repair.RepairService;
import com.carRepair.carRepair.Services.Vehicle.VehicleService;
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
import java.text.ParseException;

@Controller
public class RepairEditController {

    private static final String REPAIR_FORM = "repairForm";

    @Autowired
    private RepairService repairService;

    @Autowired
    private RepairCreateService repairCreateService;

    @Autowired
    private VehicleService vehicleService;

    @RequestMapping(value = "/admin/edit-repair", method = RequestMethod.GET)
    String getEditRepairView(Model model, @RequestParam(name = "id", required = false) String id,RedirectAttributes redirectAttributes){

        //TODO check id and show form, messages
        if(id != null ){
            try {
                long repairId = Long.valueOf(id);
                Repair repair = repairService.getRepair(repairId);
                RepairForm repairForm = new RepairForm(repair);

                String type = (repair.getType()) ? "long" : "short";
                String status = "";
                if(repair.getStatus() == 1){
                    status = "inProgress";
                }else if(repair.getStatus() == 2){
                    status = "completed";
                }else{
                    status = "pending";
                }

                model.addAttribute(type,"selected");
                model.addAttribute(status,"selected");
                model.addAttribute(REPAIR_FORM, repairForm);
            }catch(RepairNotFoundException ex){
                model.addAttribute("errorMessage", "Service with id: " + id + "not found");
            }catch(NumberFormatException e){
                model.addAttribute("errorMessage", "Service id must be number");
            }
        }

        return "/admin/repairs/edit-repair-view";
    }

    @RequestMapping(value = "/admin/edit-repair" ,  method = RequestMethod.POST)
    public String editRepair(@Valid @ModelAttribute(name = REPAIR_FORM) RepairForm repairForm, BindingResult bindingResult,
                             RedirectAttributes redirectAttributes){

        if(repairForm.getRepairId().equals("")){
            redirectAttributes.addFlashAttribute("errormessage", "Something went wrong");
            //redirectAttributes.addFlashAttribute(REPAIR_FORM, repairForm);
            return "redirect:/admin/edit-repair";
        }

        if(bindingResult.hasErrors()) {

            String type = (repairForm.getType().equals("true")) ? "long" : "short";
            String status = "";
            if(repairForm.getStatus().equals("1")){

                status = "inProgress";
            }else if(repairForm.getStatus().equals("2")){
                status = "completed";
            }else{
                status = "pending";
            }

            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.repairForm", bindingResult);
            redirectAttributes.addFlashAttribute(REPAIR_FORM, repairForm);
            redirectAttributes.addFlashAttribute( type, "selected");
            //redirectAttributes.addFlashAttribute( "errorMessage",  "ERROR MESSAGE");

            return "redirect:/admin/edit-repair";
        }


        //TODO Edit service Fuunctionality

        try {
            Vehicle vehicle = vehicleService.findByPlate(repairForm.getPlate());
            Repair repair = RepairConverter.builtRepairObject(repairForm);
            repair.setRepairId(Long.valueOf(repairForm.getRepairId()));
            repair.setVehicle(vehicle);
            repairCreateService.insertRepair(repair);
            redirectAttributes.addFlashAttribute("message", "Sucessful update!");
        }catch(ParseException e){
            redirectAttributes.addFlashAttribute("errormessage", "Invalid date format");
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("errormessage", "Something went wrong");
        }

        return "redirect:/admin/edit-repair";
    }

}
