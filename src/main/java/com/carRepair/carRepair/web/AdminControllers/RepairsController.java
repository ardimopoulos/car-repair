package com.carRepair.carRepair.web.AdminControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RepairsController {

    // Selida Repair(Service)

    @RequestMapping(value = "/admin/service" ,  method = RequestMethod.GET)
    public String services(){

        //List<Services> services = findAll(); // Services

        return "admin/services/home";
    }

    @RequestMapping(value = "/admin/new-service" ,  method = RequestMethod.GET)
    public String createService(){

        //ServiceUserForm()
        return "admin/services/new_service";
    }

    @RequestMapping(value = "/admin/new-service" ,  method = RequestMethod.POST)
    public String createServicePost(){

        //save(Service service); // Service
        return "admin/service/new_service";
    }

    @RequestMapping(value = "/admin/update-service" ,  method = RequestMethod.GET)
    public String updateService(){

        //UpdateServiceForm()
        return "admin/services/update_service";
    }

    @RequestMapping(value = "/admin/update-service" ,  method = RequestMethod.POST)
    public String updateServicePost(){

        //save(Long id , Service service); // Service
        return "admin/service/update_service";
    }

    @RequestMapping(value = "/admin/delete-service" ,  method = RequestMethod.GET)
    public String deleteService(){

        //DeleteServiceForm()
        return "admin/services/delete_service";
    }

    @RequestMapping(value = "/admin/delete-service" ,  method = RequestMethod.POST)
    public String deleteServicePost(){

        //delete(Long id); // Service
        return "admin/service/delete_service";
    }

    @RequestMapping(value = "/admin/search-service" ,  method = RequestMethod.GET)
    public String searchService(){

        //SearchServiceForm()
        return "admin/services/search_service";
    }

    @RequestMapping(value = "/admin/search-service" ,  method = RequestMethod.POST)
    public String searchServicePost(){

        //Service service = findOne(Long id); // Service
        return "admin/service/search_service";
    }



}
