package ma.emsi.emsijpahospital;

import ma.emsi.emsijpahospital.entities.*;
import ma.emsi.emsijpahospital.repositories.MedecinRepository;
import ma.emsi.emsijpahospital.repositories.PatientRepository;
import ma.emsi.emsijpahospital.repositories.RendezVousRepository;
import ma.emsi.emsijpahospital.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class EmsiJpaHospitalApplication {

    public static void main(String[] args) {

        SpringApplication.run(EmsiJpaHospitalApplication.class, args);
    }

    @Bean
    CommandLineRunner start(IHospitalService HospitalService, PatientRepository patientRepository, RendezVousRepository rendezVousRepository, MedecinRepository medecinRepository){
        return args -> {
            Stream.of("Mohamed","Hassan","Najat")
                    .forEach((name->{
                        Patient patient = new Patient();
                        patient.setNom(name);
                        patient.setDateNaissance(new Date());
                        patient.setMalade(false);
                        HospitalService.savePatient(patient);
                    }));

            Stream.of("Salim","Omar","Salma")
                    .forEach((name->{
                        Medecin medecin = new Medecin();
                        medecin.setNom(name);
                        medecin.setEmail(name+"@gmail.com");
                        medecin.setSpécialité(Math.random()>0.5?"Cardiologie":"Ophtalmologie");
                        HospitalService.saveMedecin(medecin);
                    }));

            Patient patient = patientRepository.findById(1L).orElse(null);
            Patient patient1 = patientRepository.findByNom("Mohamed");

            Medecin medecin = medecinRepository.findByNom("Salma");

            RendezVous rendezVous = new RendezVous();
            rendezVous.setDate(new Date());
            rendezVous.setStatus(StatusRDV.PENDING);
            rendezVous.setMedecin(medecin);
            rendezVous.setPatient(patient);
            RendezVous savedRDV = HospitalService.saveRDV(rendezVous);
            System.out.println(savedRDV.getId());

            RendezVous rendezVous1 = rendezVousRepository.findAll().get(0);
            Consultation consultation  = new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRendezVous(rendezVous1);
            consultation.setRapport("Rapport de la consultation ........");
            HospitalService.saveConsultation(consultation);
        };
    }

}
