package fr.wayUp.cleanArchitecture_demo.application.service;

import fr.wayUp.cleanArchitecture_demo.application.usecase.serviceStaff.*;
import fr.wayUp.cleanArchitecture_demo.domain.model.ServiceStaff;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServiceStaffService {
    private final GetStaffSchedulesForServiceUseCase getStaffSchedulesForServiceUseCase;
    private final        GetListServicesStaffUseCase getListServicesStaffUseCase;
    private final SaveServiceStaffUseCase saveServiceStaffUseCase;
    private final DeleteServicesStaffUseCase deleteServicesStaffUseCase;
    private final GetStaffsByServiceIdUseCase getStaffsByServiceIdUseCase;
    private final FindStaffServiceIdUseCase findStaffServiceIdUseCase;
    public List<Object> findSchedulesForService(LocalDate date,
                                                          LocalDateTime currentDateTime,
                                                String staffId,
                                                String serviceId){
    return this.getStaffSchedulesForServiceUseCase.find(date,currentDateTime,staffId,serviceId);
    }
    public  List<ServiceStaff> findAllServiceStaff(){
    return this.getListServicesStaffUseCase.find();
    }
    public ServiceStaff createService(ServiceStaff serviceStaff){
    return  this.saveServiceStaffUseCase.create(serviceStaff);
    }
    public void delete(String id){ this.deleteServicesStaffUseCase.delete(id);}
    public List<String> findStaffByServiceId(String serviceId) {
        return  this.getStaffsByServiceIdUseCase.execute(serviceId);
    }
    public Optional<String> findStaffServiceId(String staffId, String serviceId){
        return this.findStaffServiceIdUseCase.execute(staffId,serviceId);
    }
}
