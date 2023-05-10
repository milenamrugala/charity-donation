package pl.milenamrugala.charitydonation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.milenamrugala.charitydonation.model.Donation;

public interface DonationRepository extends JpaRepository<Donation, Long> {

    @Query("SELECT SUM(d.quantity) FROM Donation d")
    Integer getQuantityOfBags();

    @Query("SELECT COUNT(d) FROM Donation d")
    Integer getQuantityOfDonations();

}
