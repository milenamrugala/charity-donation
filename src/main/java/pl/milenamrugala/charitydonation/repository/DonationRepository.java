package pl.milenamrugala.charitydonation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.milenamrugala.charitydonation.model.Donation;

public interface DonationRepository extends JpaRepository<Donation, Long> {

}
