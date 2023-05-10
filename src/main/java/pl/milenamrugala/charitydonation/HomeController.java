package pl.milenamrugala.charitydonation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.milenamrugala.charitydonation.model.Institution;
import pl.milenamrugala.charitydonation.service.InstitutionService;

import java.util.List;

@Controller
public class HomeController {

    private final InstitutionService institutionService;

    public HomeController(InstitutionService institutionService) {
        this.institutionService = institutionService;
    }


    @RequestMapping("/")
    public String homeAction(Model model) {
        List<Institution> institutions = institutionService.findAll();
        model.addAttribute("institutions", institutions);
        return "index";
    }
}
