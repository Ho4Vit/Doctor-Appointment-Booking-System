package dabs.DABS.controller;

import dabs.DABS.model.request.ServiceRequest;
import dabs.DABS.model.Response.ServiceResponse;
import dabs.DABS.service.IServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ServiceController {
    private final IServiceService serviceService;

    @GetMapping("/all")
    public ResponseEntity<List<ServiceResponse>> getAllServices() {
        return ResponseEntity.ok(serviceService.getAllServices());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceResponse> getServiceById(@PathVariable Long id) {
        return ResponseEntity.ok(serviceService.getServiceById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<ServiceResponse> createService(@RequestBody ServiceRequest serviceRequest) {
        return ResponseEntity.ok(serviceService.createService(serviceRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceResponse> updateService(
            @PathVariable Long id,
            @RequestBody ServiceRequest serviceRequest
    ) {
        return ResponseEntity.ok(serviceService.updateService(id, serviceRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteService(@PathVariable Long id) {
        serviceService.deleteService(id);
        return ResponseEntity.ok("Service deleted successfully");
    }
}
