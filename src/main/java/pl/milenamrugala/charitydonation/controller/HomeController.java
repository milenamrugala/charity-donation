package pl.milenamrugala.charitydonation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.milenamrugala.charitydonation.model.Institution;
import pl.milenamrugala.charitydonation.service.DonationService;
import pl.milenamrugala.charitydonation.service.InstitutionService;

import java.util.List;

@Controller
public class HomeController {

    private final InstitutionService institutionService;
    private final DonationService donationService;

    public HomeController(InstitutionService institutionService, DonationService donationService) {
        this.institutionService = institutionService;
        this.donationService = donationService;
    }

    @RequestMapping("/")
    public String homeAction(Model model) {
        List<Institution> institutions = institutionService.findAll();
        int quantityOfBags = donationService.getQuantityOfBags();
        int quantityOfDonations = donationService.getQuantityOfDonations();
        model.addAttribute("institutions", institutions);
        model.addAttribute("quantityOfBags", quantityOfBags);
        model.addAttribute("quantityOfDonations", quantityOfDonations);
        return "index";
    }
}
