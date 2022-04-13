package ma.emsi.emsijpahospital.repositories;

import ma.emsi.emsijpahospital.entities.Patient;
import ma.emsi.emsijpahospital.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezVousRepository extends JpaRepository<RendezVous,String> {
}
