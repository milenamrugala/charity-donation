package pl.milenamrugala.charitydonation.service;

import org.springframework.stereotype.Service;
import pl.milenamrugala.charitydonation.model.Donation;
import pl.milenamrugala.charitydonation.repository.DonationRepository;

import java.util.List;

@Service
public class DonationService {

    private final DonationRepository donationRepository;

    public DonationService(DonationRepository donationRepository) {

        this.donationRepository = donationRepository;
    }

    public List<Donation> getAllDonations() {

        return donationRepository.findAll();
    }

    public Donation getDonationById(Long id) {
        return donationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Donation not found with id: " + id));
    }

    public Donation saveDonation(Donation donation) {
        return donationRepository.save(donation);
    }

    public void deleteDonation(Long id) {

        donationRepository.deleteById(id);
    }

    public int getQuantityOfBags() {
        try {
            return donationRepository.getQuantityOfBags();
        } catch (NullPointerException e) {
            return 0;
        }
    }

    public int getQuantityOfDonations() {
        return donationRepository.getQuantityOfDonations();
    }
}
