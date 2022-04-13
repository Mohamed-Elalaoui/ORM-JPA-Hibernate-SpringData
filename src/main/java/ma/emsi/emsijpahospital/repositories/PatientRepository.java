package ma.emsi.emsijpahospital.repositories;

import ma.emsi.emsijpahospital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    Patient findByNom(String nom);
}
