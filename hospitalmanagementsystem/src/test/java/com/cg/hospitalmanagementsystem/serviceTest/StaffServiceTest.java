package com.cg.hospitalmanagementsystem.serviceTest;


import com.cg.hospitalmanagementsystem.entity.Nurse;
import com.cg.hospitalmanagementsystem.entity.Physician;
import com.cg.hospitalmanagementsystem.repository.DoctorRepository;
import com.cg.hospitalmanagementsystem.repository.NurseRepository;
import com.cg.hospitalmanagementsystem.service.imp.StaffServiceImp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class StaffServiceTest {

    @Mock
    private DoctorRepository doctorRepository;

    @Mock
    private NurseRepository nurseRepository;

    @InjectMocks
    private StaffServiceImp serviceImp;

    @Test
    public void doctorsShouldBeFetched(){
        Physician physician = new Physician();
        physician.setEmployeeId(1);
        physician.setName("John Dorian");
        physician.setPosition("Staff Internist");
        physician.setSsn(111111111);

        List<Physician> list = new ArrayList<>();
        list.add(physician);

        Mockito.when(doctorRepository.allPhysicians()).thenReturn(list);

        List<Physician> physicianList = doctorRepository.allPhysicians();

        Assertions.assertTrue(physicianList.size() != 0);
        Assertions.assertEquals("John Dorian", physicianList.get(0).getName());
    }


    @Test
    public void nurseShouldBeFetched(){

        Nurse nurse = new Nurse();
        nurse.setEmployeeId(101);
        nurse.setName("Carla Espinosa");
        nurse.setPosition("Head Nurse");
        nurse.setRegistered(Boolean.TRUE);
        nurse.setSsn(111111111);

        List<Nurse> list = new ArrayList<>();
        list.add(nurse);

        Mockito.when(nurseRepository.allNurses()).thenReturn(list);

        List<Nurse> nurses = nurseRepository.allNurses();

        Assertions.assertEquals("Carla Espinosa", nurses.get(0).getName());


    }
}
