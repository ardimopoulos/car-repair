package com.carRepair.carRepair.Web.AdminControllers.Repair;

import com.carRepair.carRepair.Converters.RepairConverter;
import com.carRepair.carRepair.Domain.Repair;
import com.carRepair.carRepair.Domain.Vehicle;
import com.carRepair.carRepair.Exceptions.VehicleNotFoundException;
import com.carRepair.carRepair.Forms.Repair.RepairForm;
import com.carRepair.carRepair.Services.Repair.RepairService;
import com.carRepair.carRepair.Services.Vehicle.VehicleService;
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
public class RepairCreateController {

    private static final String REPAIR_FORM = "repairForm";

    @Autowired
    private RepairService repairService;

    @Autowired
    private VehicleService vehicleService;

    @RequestMapping(value = "/admin/create-repair" ,  method = RequestMethod.GET)
    public String getCreateServiceView(Model model, RepairForm repairForm){
        if(!model.containsAttribute(REPAIR_FORM)){
            model.addAttribute(REPAIR_FORM, new RepairForm());
        }
        return "/admin/repairs/create-repair-view";
    }

    @RequestMapping(value = "/admin/create-repair" ,  method = RequestMethod.POST)
    public String createService(@Valid @ModelAttribute(name = REPAIR_FORM) RepairForm repairForm,BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()) {
            String status = "";
            if(repairForm.getStatus().equals("1")){
                status = "inProgress";
            }else if(repairForm.getStatus().equals("2")){
                status = "completed";
            }else{
                status = "pending";
            }

            String type = (repairForm.getType().equals("true")) ? "long" : "short";

            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.repairForm", bindingResult);
            redirectAttributes.addFlashAttribute(REPAIR_FORM, repairForm);
            redirectAttributes.addFlashAttribute(type, "selected");
            redirectAttributes.addFlashAttribute(status,  "selected");
            redirectAttributes.addFlashAttribute( "errorMessage",  "Fill the fields bellow");
            return "redirect:/admin/create-repair";
        }

        try {
            Vehicle vehicle = vehicleService.getByPlate(repairForm.getPlate());
            Repair repair = RepairConverter.builtRepairObject(repairForm);
            repair.setVehicle(vehicle);
            repairService.insertRepair(repair);
            redirectAttributes.addFlashAttribute("message", "Repair is created for vehicle with plate: "+vehicle.getPlate());
        }catch (VehicleNotFoundException e){
            redirectAttributes.addFlashAttribute("errorMessage", "Vehicle with plate: "+repairForm.getPlate()+" not found");
            redirectAttributes.addFlashAttribute(REPAIR_FORM, repairForm);
        }catch(Exception e){
            redirectAttributes.addFlashAttribute("errorMessage", "Something went wrong. Please try again later");
        }
        return "redirect:/admin/create-repair";
    }

}
