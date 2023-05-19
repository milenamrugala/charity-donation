package pl.milenamrugala.charitydonation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.milenamrugala.charitydonation.model.Institution;
import pl.milenamrugala.charitydonation.service.InstitutionService;

import java.util.List;

@Controller
public class InstitutionController {
    private final InstitutionService institutionService;

    @Autowired
    public InstitutionController(InstitutionService institutionService) {
        this.institutionService = institutionService;
    }

    @GetMapping("/list-institutions")
    public String listInstitutions(Model model) {
        List<Institution> institutions = institutionService.findAll();
        model.addAttribute("institutions", institutions);
        return "list-institutions";
    }

    @GetMapping("/list-institutions/update")
    public String updateForm(@RequestParam("id") Long id, Model model) {

        Institution institution = institutionService.getInstitutionById(id);
        model.addAttribute("institution", institution);
        return "list-institutions-update";
    }

    @PostMapping("/list-institutions/update")
    public String saveForm(@ModelAttribute("user") Institution institution) {
        institutionService.saveInstitution(institution);

        return "redirect:/list-institutions";

    }

    @GetMapping("/list-institutions/delete")
    public String deleteInstitution(@RequestParam("id") Long id) {
        institutionService.deleteInstitutionById(id);
        return "redirect:/list-institutions";
    }

    @GetMapping("/list-institutions/delete-confirm")
    public String confirmDeleteInstitution(@RequestParam("id") Long id, Model model) {
        model.addAttribute("id", id);
        return "institution-delete-confirm";
    }

}
