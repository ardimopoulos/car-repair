package com.carRepair.carRepair.web.admin_controllers.repair;

import com.carRepair.carRepair.converters.RepairConverter;
import com.carRepair.carRepair.domain.Repair;
import com.carRepair.carRepair.domain.Vehicle;
import com.carRepair.carRepair.exceptions.RepairNotFoundException;
import com.carRepair.carRepair.forms.repair.RepairForm;
import com.carRepair.carRepair.services.repair.RepairService;
import com.carRepair.carRepair.services.vehicle.VehicleService;
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
    private VehicleService vehicleService;

    @RequestMapping(value = "/admin/edit-repair", method = RequestMethod.GET)
    String getEditRepairView(Model model, @RequestParam(name = "id", required = false) String id,RedirectAttributes redirectAttributes){

        //TODO check id and show form, messages
        if(id != null ){
            try {
                long repairId = Long.valueOf(id);
                Repair repair = repairService.getRepair(repairId);
                RepairForm repairForm = new RepairForm(repair);

                String type = (repair.isType()) ? "long" : "short";
                String status;

                if (repair.getStatus() == 1) {
                    status = "inProgress";

                } else if (repair.getStatus() == 2) {
                    status = "completed";

                } else {
                    status = "pending";
                }

                model.addAttribute(type,"selected");
                model.addAttribute(status,"selected");
                model.addAttribute(REPAIR_FORM, repairForm);

            } catch (RepairNotFoundException ex) {
                model.addAttribute("errorMessage", "Service with id: " + id + "not found");

            } catch (NumberFormatException e) {
                model.addAttribute("errorMessage", "Service id must be number");
            }
        }

        return "/admin/repairs/edit-repair-view";
    }

    @RequestMapping(value = "/admin/edit-repair" ,  method = RequestMethod.POST)
    public String editRepair(@Valid @ModelAttribute(name = REPAIR_FORM) RepairForm repairForm, BindingResult bindingResult,
                             RedirectAttributes redirectAttributes){

        if (repairForm.getRepairId().equals("")) {
            redirectAttributes.addFlashAttribute("errormessage", "Something went wrong");
            return "redirect:/admin/edit-repair";
        }

        if (bindingResult.hasErrors()) {
            String type = (repairForm.getType().equals("true")) ? "long" : "short";
            String status;

            if (repairForm.getStatus().equals("1")) {
                status = "inProgress";

            } else if (repairForm.getStatus().equals("2")) {
                status = "completed";

            } else {
                status = "pending";
            }

            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.repairForm", bindingResult);
            redirectAttributes.addFlashAttribute(REPAIR_FORM, repairForm);
            redirectAttributes.addFlashAttribute( type, "selected");
            redirectAttributes.addFlashAttribute( status,  "selected");

            return "redirect:/admin/edit-repair";
        }

        try {
            Vehicle vehicle = vehicleService.getByPlate(repairForm.getPlate());
            Repair repair = RepairConverter.builtRepairObject(repairForm);
            repair.setRepairId(Long.valueOf(repairForm.getRepairId()));
            repair.setVehicle(vehicle);
            repairService.insertRepair(repair);
            redirectAttributes.addFlashAttribute("message", "Successful update!");

        } catch (ParseException e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Invalid date format");

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            redirectAttributes.addFlashAttribute(REPAIR_FORM, repairForm);
        }

        return "redirect:/admin/edit-repair";
    }

}
