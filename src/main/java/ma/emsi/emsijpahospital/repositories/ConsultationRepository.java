package ma.emsi.emsijpahospital.repositories;

import ma.emsi.emsijpahospital.entities.Consultation;
import ma.emsi.emsijpahospital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {
}
