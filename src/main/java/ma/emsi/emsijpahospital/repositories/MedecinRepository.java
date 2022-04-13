package ma.emsi.emsijpahospital.repositories;

import ma.emsi.emsijpahospital.entities.Medecin;
import ma.emsi.emsijpahospital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin,Long> {
    Medecin findByNom(String nom);
}
