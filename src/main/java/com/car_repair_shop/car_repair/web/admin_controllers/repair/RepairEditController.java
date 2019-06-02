package com.car_repair_shop.car_repair.web.admin_controllers.repair;

import com.car_repair_shop.car_repair.converters.RepairConverter;
import com.car_repair_shop.car_repair.domain.Repair;
import com.car_repair_shop.car_repair.domain.Vehicle;
import com.car_repair_shop.car_repair.exceptions.RepairNotFoundException;
import com.car_repair_shop.car_repair.forms.repair.RepairForm;
import com.car_repair_shop.car_repair.services.repair.RepairService;
import com.car_repair_shop.car_repair.services.vehicle.VehicleService;
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

import static com.car_repair_shop.car_repair.enums.RepairStatus.*;
import static com.car_repair_shop.car_repair.properties.Constants.ERROR_MESSAGE;

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

                if (repair.getStatus() == IN_PROGRESS.value()) {
                    status = IN_PROGRESS.toString();

                } else if (repair.getStatus() == 2) {
                    status = COMPLETED.toString();

                } else {
                    status = PENDING.toString();
                }

                model.addAttribute(type,"selected");
                model.addAttribute(status,"selected");
                model.addAttribute(REPAIR_FORM, repairForm);

            } catch (RepairNotFoundException ex) {
                model.addAttribute(ERROR_MESSAGE, "Service with id: " + id + "not found");

            } catch (NumberFormatException e) {
                model.addAttribute(ERROR_MESSAGE, "Service id must be number");
            }
        }

        return "/admin/repairs/edit-repair-view";
    }

    @RequestMapping(value = "/admin/edit-repair" ,  method = RequestMethod.POST)
    public String editRepair(@Valid @ModelAttribute(name = REPAIR_FORM) RepairForm repairForm, BindingResult bindingResult,
                             RedirectAttributes redirectAttributes){

        if ("".equals(repairForm.getRepairId())) {
            redirectAttributes.addFlashAttribute("errormessage", "Something went wrong");
            return "redirect:/admin/edit-repair";
        }

        if (bindingResult.hasErrors()) {
            String type = ("true".equals(repairForm.getType())) ? "long" : "short";
            String status;

            int repairStatus = Integer.parseInt(repairForm.getStatus());

            if (repairStatus == IN_PROGRESS.value()) {
                status = IN_PROGRESS.toString();

            } else if (repairStatus == COMPLETED.value()) {
                status = COMPLETED.toString();

            } else {
                status = PENDING.toString();
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
            redirectAttributes.addFlashAttribute(ERROR_MESSAGE, "Invalid date format");

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute(ERROR_MESSAGE, e.getMessage());
            redirectAttributes.addFlashAttribute(REPAIR_FORM, repairForm);
        }

        return "redirect:/admin/edit-repair";
    }

}
