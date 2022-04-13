package ma.emsi.emsijpahospital.service;

import ma.emsi.emsijpahospital.entities.Consultation;
import ma.emsi.emsijpahospital.entities.Medecin;
import ma.emsi.emsijpahospital.entities.Patient;
import ma.emsi.emsijpahospital.entities.RendezVous;

public interface IHospitalService {
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRDV(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);
}
