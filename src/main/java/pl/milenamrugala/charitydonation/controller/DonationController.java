package pl.milenamrugala.charitydonation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.milenamrugala.charitydonation.model.Category;
import pl.milenamrugala.charitydonation.model.Donation;
import pl.milenamrugala.charitydonation.model.Institution;
import pl.milenamrugala.charitydonation.service.CategoryService;
import pl.milenamrugala.charitydonation.service.DonationService;
import pl.milenamrugala.charitydonation.service.InstitutionService;

import java.util.List;

@Controller
public class DonationController {

    private final DonationService donationService;
    private final CategoryService categoryService;
    private final InstitutionService institutionService;

    public DonationController(DonationService donationService, CategoryService categoryService, InstitutionService institutionService) {
        this.donationService = donationService;
        this.categoryService = categoryService;
        this.institutionService = institutionService;
    }

    @GetMapping("/donation")
    public String donation(Model model) {
        List<Category> categories = categoryService.getAllCategories();
        List<Institution> institutions = institutionService.getAllInstitutions();
        model.addAttribute("categories", categories);
        model.addAttribute("institutions", institutions);
        model.addAttribute("donation", new Donation());
        return "form";
    }

    @PostMapping("/donation")
    public String donationAction(Donation donation) {
        donationService.saveDonation(donation);
        return "redirect:/confirmation";
    }

    @GetMapping("/confirmation")
    public String confirmation() {
        return "form-confirmation";
    }
}
