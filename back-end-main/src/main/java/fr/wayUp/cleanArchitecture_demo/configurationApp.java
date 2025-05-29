package fr.wayUp.cleanArchitecture_demo;

import fr.wayUp.cleanArchitecture_demo.application.service.*;
import fr.wayUp.cleanArchitecture_demo.application.usecase.PrescriptionDetail.*;
import fr.wayUp.cleanArchitecture_demo.application.usecase.appointment.DeleteAppointmentUseCase;
import fr.wayUp.cleanArchitecture_demo.application.usecase.appointment.FindUnavailableSchedulesUseCase;
import fr.wayUp.cleanArchitecture_demo.application.usecase.appointment.GetListAppointmentUseCase;
import fr.wayUp.cleanArchitecture_demo.application.usecase.appointment.SaveAppointmentUseCase;
import fr.wayUp.cleanArchitecture_demo.application.usecase.clinic.*;
import fr.wayUp.cleanArchitecture_demo.application.usecase.consultation.*;
import fr.wayUp.cleanArchitecture_demo.application.usecase.medicalTest.*;
import fr.wayUp.cleanArchitecture_demo.application.usecase.medication.*;
import fr.wayUp.cleanArchitecture_demo.application.usecase.patient.*;
import fr.wayUp.cleanArchitecture_demo.application.usecase.pharmacy.*;
import fr.wayUp.cleanArchitecture_demo.application.usecase.pharmacyStock.*;
import fr.wayUp.cleanArchitecture_demo.application.usecase.prescription.*;
import fr.wayUp.cleanArchitecture_demo.application.usecase.service.*;
import fr.wayUp.cleanArchitecture_demo.application.usecase.serviceStaff.*;
import fr.wayUp.cleanArchitecture_demo.application.usecase.staff.*;
import fr.wayUp.cleanArchitecture_demo.domain.repository.*;
import  fr.wayUp.cleanArchitecture_demo.domain.repository.ClinicRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class configurationApp {

    @Bean
    public StaffService StaffService(
                                      SaveStaffUseCase saveStaffUseCase,
                                      GetListStaffUseCase getListStaffsUseCase,
                                      GetStaffUseCase getStaffUseCase,
                                      DeleteStaffUseCase deleteStaffUseCase,
                                      UpdateStaffUseCase updateStaffUseCase,
                                      FindStaffBySpecialtyUseCase findStaffByGradeUseCase)
    {
    return new StaffService(getListStaffsUseCase,getStaffUseCase,saveStaffUseCase,  deleteStaffUseCase, updateStaffUseCase, findStaffByGradeUseCase);
    }
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:4200")
                        .allowedMethods(".allowedMethods(\"GET\", \"POST\", \"PUT\", \"DELETE\", \"OPTIONS\")")
                        .allowedHeaders("*");
            }
        };
    }
    @Bean
    public SaveStaffUseCase saveStaffUseCase(StaffRepository staffJpaRepository){
        return new SaveStaffUseCase(staffJpaRepository);
    }
@Bean
public FindStaffBySpecialtyUseCase findStaffByGradeUseCase(StaffRepository staffJpaRepository){
    return new FindStaffBySpecialtyUseCase(staffJpaRepository);
    }
    @Bean
    public GetListStaffUseCase getListStaffsUseCase(StaffRepository staffJpaRepository){
        return new GetListStaffUseCase(staffJpaRepository);
    }

    @Bean
    public GetStaffUseCase getStaffUseCase(StaffRepository StaffJpaRepository){
        return new GetStaffUseCase(StaffJpaRepository);
    }
    @Bean
    public DeleteStaffUseCase deleteStaffUseCase(StaffRepository StaffJpaRepository){
        return new DeleteStaffUseCase(StaffJpaRepository);
    }
    @Bean
    public UpdateStaffUseCase  updateStaffUseCase(GetStaffUseCase getStaffUseCase, StaffRepository staffRepository){
        return new UpdateStaffUseCase(getStaffUseCase,staffRepository);
    }

    //pharmacy
    @Bean
    public PharmacyService pharmacyService(
            UpdatePharmacyUseCase updatePharmacyUseCase ,
            DeletePharmacyUseCase deletePharmacyUseCase,
            SavePharmacyUseCase savePharmacyUseCase,
            GetPharmacyUseCase getPharmacyUseCase,
            GetListPharmaciesUseCase getListPharmaciesUseCase){
        return   new PharmacyService(deletePharmacyUseCase,savePharmacyUseCase, getPharmacyUseCase, getListPharmaciesUseCase, updatePharmacyUseCase);
    }
    @Bean
    public DeletePharmacyUseCase deletePharmacyUseCase(PharmacyRepository pharmacyRepository){
        return  new DeletePharmacyUseCase(pharmacyRepository) ;
    }
    @Bean
    public SavePharmacyUseCase savePharmacyUseCase(PharmacyRepository pharmacyRepository){
        return  new SavePharmacyUseCase(pharmacyRepository) ;
    }
    @Bean
    public GetPharmacyUseCase getPharmacyUseCase(PharmacyRepository pharmacyRepository){
        return  new GetPharmacyUseCase(pharmacyRepository) ;
    }
    @Bean
    public GetListPharmaciesUseCase getListPharmaciesUseCase(PharmacyRepository pharmacyRepository){
        return  new GetListPharmaciesUseCase(pharmacyRepository) ;
    }
    @Bean
    public UpdatePharmacyUseCase updatePharmacyUseCase(PharmacyRepository pharmacyRepository , GetPharmacyUseCase getPharmacyUseCase){
        return new UpdatePharmacyUseCase( getPharmacyUseCase , pharmacyRepository);
    }

    //Service
    @Bean
    public ServiceService ServiceService(
            GetServiceUseCase getServiceUseCase,
            GetListServicesUseCase getListServicesUseCase,
            DeleteServiceUseCase deleteServiceUseCase,
            SaveServiceUseCase saveServiceUseCase,
            UpdateServiceUseCase updateServiceUseCase,
            GetServicesByClinicIdUseCase getServicesByClinicIdUseCase) {
        return new ServiceService(getServiceUseCase,getListServicesUseCase,deleteServiceUseCase,saveServiceUseCase, updateServiceUseCase, getServicesByClinicIdUseCase);
    }
    @Bean
    public SaveServiceUseCase saveServiceUseCase(ServiceRepository serviceJpaRepository){
        return new   SaveServiceUseCase(serviceJpaRepository);
    }
    @Bean
    public GetServicesByClinicIdUseCase  getServicesByClinicIdUseCase(ServiceRepository serviceJpaRepository){
        return new   GetServicesByClinicIdUseCase(serviceJpaRepository);
    }

    @Bean
    public GetListServicesUseCase getListServicesUseCase(ServiceRepository serviceJpaRepository){
        return new GetListServicesUseCase(serviceJpaRepository);
    }

    @Bean
    public GetServiceUseCase getServiceUseCase(ServiceRepository ServiceJpaRepository){
        return new GetServiceUseCase(ServiceJpaRepository);
    }
    @Bean
    public DeleteServiceUseCase deleteServiceUseCase(ServiceRepository ServiceJpaRepository){
        return new DeleteServiceUseCase(ServiceJpaRepository);
    }
    @Bean
    public UpdateServiceUseCase updateServiceUseCase(ServiceRepository serviceJpaRepository, GetServiceUseCase getServiceUseCase, GetStaffUseCase getStaffUseCase){
        return new UpdateServiceUseCase(serviceJpaRepository,getServiceUseCase,getStaffUseCase);
    }
    //patient
    @Bean
    public PatientService patientService(SavePatientUseCase savePatientUseCase,
                                         GetListPatientsUseCase getListPatientsUseCase,
                                         GetPatientUseCase getPatientUseCase,
                                         UpdatePatientUseCase updatePatientUseCase,
                                         DeletePatientUseCase deletePatientUseCase) {
        return new PatientService(savePatientUseCase, getListPatientsUseCase, getPatientUseCase,deletePatientUseCase,updatePatientUseCase);
    }
    @Bean
    public SavePatientUseCase savePatientUseCase(PatientRepository patientRepository) {
        return new SavePatientUseCase(patientRepository);
    }  @Bean
    public GetListPatientsUseCase getListPatientsUseCase(PatientRepository patientRepository) {
        return new GetListPatientsUseCase(patientRepository);
    }
    @Bean
    public GetPatientUseCase getPatientUseCase(PatientRepository patientRepository) {
        return new GetPatientUseCase(patientRepository);
    }
    @Bean
    public UpdatePatientUseCase updatePatientUseCase(PatientRepository patientRepository) {
        return new UpdatePatientUseCase(patientRepository);
    }
    @Bean
    public DeletePatientUseCase deletePatientUseCase(PatientRepository patientRepository) {
        return new DeletePatientUseCase(patientRepository);
    }
    //Clinic




    @Bean
    public ClinicService clinicService(SaveClinicUseCase saveClinicUseCase,
                                       GetListClinicsUseCase getListClinicsUseCase,
                                       GetByIdClinicsUseCase getByIdClinicsUseCase,
                                       UpdateClinicsUseCase updateClinicsUseCase,
                                        DeleteClinicsUseCase deleteClinicsUseCase) {
        return new ClinicService(saveClinicUseCase, getListClinicsUseCase,getByIdClinicsUseCase,updateClinicsUseCase,deleteClinicsUseCase);
    }


    @Bean
    public SaveClinicUseCase saveClinicUseCase(ClinicRepository clinicRepository) {
        return new SaveClinicUseCase(clinicRepository);
    }

    @Bean
    public GetListClinicsUseCase getListClinicsUseCase(ClinicRepository clinicRepository) {
        return new GetListClinicsUseCase(clinicRepository);
    }
    @Bean
    public GetByIdClinicsUseCase getByIdClinicsUseCase(ClinicRepository clinicRepository) {
        return  new GetByIdClinicsUseCase(clinicRepository);
    }
    @Bean
    public UpdateClinicsUseCase updateClinicsUseCase(ClinicRepository clinicRepository) {
        return new UpdateClinicsUseCase(clinicRepository);
    }
    @Bean
    public DeleteClinicsUseCase deleteClinicsUseCase(ClinicRepository clinicRepository) {
        return new DeleteClinicsUseCase(clinicRepository);
    }
    //ServiceStaff
    @Bean
    public ServiceStaffService serviceStaffService(GetStaffSchedulesForServiceUseCase getStaffSchedulesForService, GetListServicesStaffUseCase getListServicesStaffUseCase, SaveServiceStaffUseCase saveServiceStaffUseCase, DeleteServicesStaffUseCase deleteServicesStaffUseCase, GetStaffsByServiceIdUseCase getStaffsByServiceIdUseCase, FindStaffServiceIdUseCase findStaffServiceIdUseCase){
        return new ServiceStaffService(getStaffSchedulesForService,getListServicesStaffUseCase, saveServiceStaffUseCase,deleteServicesStaffUseCase,getStaffsByServiceIdUseCase,findStaffServiceIdUseCase);

    }
    @Bean
    public GetStaffSchedulesForServiceUseCase getStaffSchedulesForService(ServiceStaffRepository serviceStaffRepository){
        return new GetStaffSchedulesForServiceUseCase(serviceStaffRepository);
    }
    @Bean
    public  GetListServicesStaffUseCase getListServicesStaffUseCase(ServiceStaffRepository serviceStaffRepository){
        return  new GetListServicesStaffUseCase(serviceStaffRepository);
    }
    @Bean
    public SaveServiceStaffUseCase saveServiceStaffUseCase(ServiceStaffRepository serviceStaffRepository){
        return  new SaveServiceStaffUseCase(serviceStaffRepository);
    }
    @Bean
    public DeleteServicesStaffUseCase deleteServicesStaffUseCase(ServiceStaffRepository serviceStaffRepository){
        return  new DeleteServicesStaffUseCase(serviceStaffRepository);
    }
    @Bean
    public GetStaffsByServiceIdUseCase getStaffsByServiceIdUseCase(ServiceStaffRepository serviceStaffRepository){
        return  new GetStaffsByServiceIdUseCase(serviceStaffRepository);
    }
    @Bean
    public  FindStaffServiceIdUseCase findStaffServiceIdUseCase(ServiceStaffRepository serviceStaffRepository){
        return  new FindStaffServiceIdUseCase(serviceStaffRepository);
    }
    //-------------------------Appointment
    @Bean
    public AppointmentService appointmentService(DeleteAppointmentUseCase deleteAppointmentUseCase,
                              SaveAppointmentUseCase saveAppointmentUseCase,
                              GetListAppointmentUseCase getListAppointmentUseCase,
                                                 FindUnavailableSchedulesUseCase findUnavailableSchedulesUseCase) {
        return new AppointmentService(deleteAppointmentUseCase,saveAppointmentUseCase,findUnavailableSchedulesUseCase,getListAppointmentUseCase);

    }
    @Bean
    public DeleteAppointmentUseCase deleteAppointmentUseCase(AppointmentRepository appointmentRepository){
        return  new DeleteAppointmentUseCase(appointmentRepository);
    }
    @Bean
    public SaveAppointmentUseCase saveAppointmentUseCase(AppointmentRepository appointmentRepository){
        return  new SaveAppointmentUseCase(appointmentRepository);
    }
    @Bean
    public GetListAppointmentUseCase getListAppointmentUseCase(AppointmentRepository appointmentRepository){
        return  new GetListAppointmentUseCase(appointmentRepository);
    }
    @Bean
    public   FindUnavailableSchedulesUseCase findUnavailableSchedulesUseCase(AppointmentRepository appointmentRepository){
        return  new FindUnavailableSchedulesUseCase(appointmentRepository);
    }
//---------------------Consultation
@Bean
public ConsultationService consultationService(CreateConsultationUseCase createConsultationUseCase,
                                               GetConsultationUseCase getConsultationUseCase,
                                               GetAllConsultationsUseCase getAllConsultationsUseCase,
                                               UpdateConsultationUseCase updateConsultationUseCase,
                                               DeleteConsultationUseCase deleteConsultationUseCase){
    return new ConsultationService(createConsultationUseCase, getAllConsultationsUseCase, getConsultationUseCase, updateConsultationUseCase, deleteConsultationUseCase);

}
    @Bean
    public CreateConsultationUseCase createConsultationUseCase(ConsultationRepository consultationRepository)
    {
        return new CreateConsultationUseCase(consultationRepository);
    }

    @Bean
    public GetAllConsultationsUseCase getAllConsultationsUseCase(ConsultationRepository consultationRepository)
    {
        return new GetAllConsultationsUseCase(consultationRepository);
    }
    @Bean
    public GetConsultationUseCase getConsultationUseCase(ConsultationRepository consultationRepository)
    {
        return new GetConsultationUseCase(consultationRepository);
    }
    @Bean
    public UpdateConsultationUseCase updateConsultationUseCase(ConsultationRepository consultationRepository)
    {
        return new UpdateConsultationUseCase(consultationRepository);
    }
    @Bean
    public DeleteConsultationUseCase deleteConsultationUseCase(ConsultationRepository consultationRepository)
    {
        return new DeleteConsultationUseCase(consultationRepository);
    }



    //------------------------MedicalTestService
    @Bean
    public MedicalTestService medicalTestService(
            CreateMedicalTestUseCase createUseCase,
            GetMedicalTestUseCase getUseCase,
            GetAllMedicalTestsUseCase getAllUseCase,
            UpdateMedicalTestUseCase updateUseCase,
            DeleteMedicalTestUseCase deleteUseCase)
    {
        return new MedicalTestService(createUseCase, getUseCase, getAllUseCase, updateUseCase, deleteUseCase);
    }

    @Bean
    public CreateMedicalTestUseCase createMedicalTestUseCase(MedicalTestRepository medicalTestRepository) {
        return new CreateMedicalTestUseCase(medicalTestRepository);
    }

    @Bean
    public GetMedicalTestUseCase getMedicalTestUseCase(MedicalTestRepository medicalTestRepository) {
        return new GetMedicalTestUseCase(medicalTestRepository);
    }

    @Bean
    public GetAllMedicalTestsUseCase getAllMedicalTestsUseCase(MedicalTestRepository medicalTestRepository) {
        return new GetAllMedicalTestsUseCase(medicalTestRepository);
    }

    @Bean
    public UpdateMedicalTestUseCase updateMedicalTestUseCase(
            MedicalTestRepository medicalTestRepository)
    {
        return new UpdateMedicalTestUseCase( medicalTestRepository);
    }

    @Bean
    public DeleteMedicalTestUseCase deleteMedicalTestUseCase(MedicalTestRepository medicalTestRepository) {
        return new DeleteMedicalTestUseCase(medicalTestRepository);
    }
    //-----------------Medication


        @Bean
        public MedicationService medicationService(
                CreateMedicationUseCase createUseCase,
                GetMedicationUseCase getUseCase,
                GetAllMedicationsUseCase getAllUseCase,
                UpdateMedicationUseCase updateUseCase,
                DeleteMedicationUseCase deleteUseCase) {
            return new MedicationService(createUseCase, getUseCase, getAllUseCase, updateUseCase, deleteUseCase);
        }

        @Bean
        public CreateMedicationUseCase createMedicationUseCase(MedicationRepository medicationRepository) {
            return new CreateMedicationUseCase(medicationRepository);
        }

        @Bean
        public GetMedicationUseCase getMedicationUseCase(MedicationRepository medicationRepository) {
            return new GetMedicationUseCase(medicationRepository);
        }

        @Bean
        public GetAllMedicationsUseCase getAllMedicationsUseCase(MedicationRepository medicationRepository) {
            return new GetAllMedicationsUseCase(medicationRepository);
        }

        @Bean
        public UpdateMedicationUseCase updateMedicationUseCase(
                MedicationRepository medicationRepository) {
            return new UpdateMedicationUseCase( medicationRepository);
        }

        @Bean
        public DeleteMedicationUseCase deleteMedicationUseCase(MedicationRepository medicationRepository) {
            return new DeleteMedicationUseCase(medicationRepository);
        }
        //------------------------ PharmacyStock
    @Bean
    public PharmacyStockService pharmacyStockService(
            CreatePharmacyStockUseCase createUseCase,
            GetPharmacyStockUseCase getUseCase,
            GetAllPharmacyStocksUseCase getAllUseCase,
            UpdatePharmacyStockUseCase updateUseCase,
            DeletePharmacyStockUseCase deleteUseCase) {
        return new PharmacyStockService(createUseCase, getUseCase, getAllUseCase, updateUseCase, deleteUseCase);
    }

    @Bean
    public CreatePharmacyStockUseCase createPharmacyStockUseCase(PharmacyStockRepository pharmacyStockRepository) {
        return new CreatePharmacyStockUseCase(pharmacyStockRepository);
    }

    @Bean
    public GetPharmacyStockUseCase getPharmacyStockUseCase(PharmacyStockRepository pharmacyStockRepository) {
        return new GetPharmacyStockUseCase(pharmacyStockRepository);
    }

    @Bean
    public GetAllPharmacyStocksUseCase getAllPharmacyStocksUseCase(PharmacyStockRepository pharmacyStockRepository) {
        return new GetAllPharmacyStocksUseCase(pharmacyStockRepository);
    }

    @Bean
    public UpdatePharmacyStockUseCase updatePharmacyStockUseCase(PharmacyStockRepository pharmacyStockRepository) {
        return new UpdatePharmacyStockUseCase(pharmacyStockRepository);
    }

    @Bean
    public DeletePharmacyStockUseCase deletePharmacyStockUseCase(PharmacyStockRepository pharmacyStockRepository) {
        return new DeletePharmacyStockUseCase(pharmacyStockRepository);
    }

   //------------------------ PrescriptionDetail
    @Bean
    public PrescriptionDetailService prescriptionDetailService(
            CreatePrescriptionDetailUseCase createUseCase,
            GetPrescriptionDetailUseCase getUseCase,
            GetAllPrescriptionDetailsUseCase getAllUseCase,
            UpdatePrescriptionDetailUseCase updateUseCase,
            DeletePrescriptionDetailUseCase deleteUseCase) {
        return new PrescriptionDetailService(createUseCase, getUseCase, getAllUseCase, updateUseCase, deleteUseCase);
    }

    @Bean
    public CreatePrescriptionDetailUseCase createPrescriptionDetailUseCase(PrescriptionDetailRepository prescriptionDetailRepository) {
        return new CreatePrescriptionDetailUseCase(prescriptionDetailRepository);
    }

    @Bean
    public GetPrescriptionDetailUseCase getPrescriptionDetailUseCase(PrescriptionDetailRepository prescriptionDetailRepository) {
        return new GetPrescriptionDetailUseCase(prescriptionDetailRepository);
    }

    @Bean
    public GetAllPrescriptionDetailsUseCase getAllPrescriptionDetailsUseCase(PrescriptionDetailRepository prescriptionDetailRepository) {
        return new GetAllPrescriptionDetailsUseCase(prescriptionDetailRepository);
    }

    @Bean
    public UpdatePrescriptionDetailUseCase updatePrescriptionDetailUseCase(PrescriptionDetailRepository prescriptionDetailRepository) {
        return new UpdatePrescriptionDetailUseCase(prescriptionDetailRepository);
    }

    @Bean
    public DeletePrescriptionDetailUseCase deletePrescriptionDetailUseCase(PrescriptionDetailRepository prescriptionDetailRepository) {
        return new DeletePrescriptionDetailUseCase(prescriptionDetailRepository);
    }
    //------------------------ Prescription
    @Bean
    public PrescriptionService prescriptionService(
            CreatePrescriptionUseCase createPrescriptionUseCase,
            GetPrescriptionUseCase getPrescriptionUseCase,
            GetAllPrescriptionsUseCase getAllPrescriptionsUseCase,
            UpdatePrescriptionUseCase updatePrescriptionUseCase,
            DeletePrescriptionUseCase deletePrescriptionUseCase) {
        return new PrescriptionService(
                createPrescriptionUseCase,
                getPrescriptionUseCase,
                getAllPrescriptionsUseCase,
                updatePrescriptionUseCase,
                deletePrescriptionUseCase
        );
    }

    @Bean
    public CreatePrescriptionUseCase createPrescriptionUseCase(PrescriptionRepository prescriptionRepository) {
        return new CreatePrescriptionUseCase(prescriptionRepository);
    }

    @Bean
    public GetPrescriptionUseCase getPrescriptionUseCase(PrescriptionRepository prescriptionRepository) {
        return new GetPrescriptionUseCase(prescriptionRepository);
    }

    @Bean
    public GetAllPrescriptionsUseCase getAllPrescriptionsUseCase(PrescriptionRepository prescriptionRepository) {
        return new GetAllPrescriptionsUseCase(prescriptionRepository);
    }

    @Bean
    public UpdatePrescriptionUseCase updatePrescriptionUseCase(PrescriptionRepository prescriptionRepository) {
        return new UpdatePrescriptionUseCase(prescriptionRepository);
    }

    @Bean
    public DeletePrescriptionUseCase deletePrescriptionUseCase(PrescriptionRepository prescriptionRepository) {
        return new DeletePrescriptionUseCase(prescriptionRepository);
    }
}
