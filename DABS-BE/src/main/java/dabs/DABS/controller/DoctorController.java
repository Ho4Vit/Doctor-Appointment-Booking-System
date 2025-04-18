package dabs.DABS.controller;


import dabs.DABS.model.Entity.Doctor;
import dabs.DABS.model.Response.ResponseData;
import dabs.DABS.model.request.RegisterDoctorForm;
import dabs.DABS.model.request.UpdateDoctorForm;
import dabs.DABS.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping("")
    public ResponseEntity<ResponseData<List<Doctor>>> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseData<Doctor>> getDoctorById(@PathVariable Long id) {
        return doctorService.getDoctorById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseData<Doctor>> updateDoctor(@PathVariable Long id, @RequestBody UpdateDoctorForm updatedDoctor) {
        return doctorService.updateDoctor(id,updatedDoctor);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseData<Doctor>> createDoctor(@RequestBody RegisterDoctorForm doctor) {
        return doctorService.addDoctor(doctor);
    }



}

