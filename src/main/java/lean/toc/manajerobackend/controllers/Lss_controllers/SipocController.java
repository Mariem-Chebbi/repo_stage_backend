package lean.toc.manajerobackend.controllers.Lss_controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lean.toc.manajerobackend.models.Lss_models.Sipoc.*;
import lean.toc.manajerobackend.services.Lss_services.SipocServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RequestMapping("/api/leansixsigma/sipoc")

@AllArgsConstructor
@RestController
@Tag(name = "sipoc Management")
public class SipocController {

    @Autowired
    SipocServiceImpl sipocService;



    @GetMapping("/{projectCharterId}/bypro")
    public Sipoc getSIPOC(@PathVariable String projectCharterId) {
        return sipocService.getSIPOCByProjectCharterId(projectCharterId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sipoc> getSipocById(@PathVariable String id) {
        Optional<Sipoc> sipocOptional = sipocService.getSipocById(id);
        if (sipocOptional.isPresent()) {
            return ResponseEntity.ok(sipocOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{projectCharterId}")
    public Sipoc createSipoc(@PathVariable String projectCharterId, @RequestBody Sipoc sipoc) {
        return sipocService.createSipoc(projectCharterId, sipoc);
    }



    @DeleteMapping("/{id}")
    public void deleteSipoc(@PathVariable String id) {
        sipocService.deleteSipoc(id);
    }

    //SUPPLIERS CORNER
    @PostMapping("/{id}/addSupplier")
    public Sipoc addSupplier(@PathVariable String id, @RequestBody Supplier supplier) {
        return sipocService.addSupplier(id, supplier);
    }
    @PutMapping("/updateSupplier/{supplierId}")
    public Supplier updateSupplier(@PathVariable String supplierId, @RequestBody Supplier supplier) {
        return sipocService.updateSupplier(supplierId, supplier);
    }

    @DeleteMapping("/{id}/removeSupplier/{supplierId}")
    public Sipoc removeSupplier(@PathVariable String id, @PathVariable String supplierId) {
        return sipocService.removeSupplier(id, supplierId);
    }

    //INPUTS CORNER
    @PostMapping("/{id}/addInput")
    public Sipoc addInput(@PathVariable String id, @RequestBody Input input) {
        return sipocService.addInput(id, input);
    }
    @PutMapping("/updateInput/{inputId}")
    public Input updateInput(@PathVariable String inputId, @RequestBody Input input) {
        return sipocService.updateInput(inputId, input);
    }

    @DeleteMapping("/{id}/removeInput/{inputId}")
    public Sipoc removeInput(@PathVariable String id, @PathVariable String inputId) {
        return sipocService.removeInput(id, inputId);
    }
    //Processes CORNER
    @PostMapping("/{id}/addProcess")
    public Sipoc addProcess(@PathVariable String id, @RequestBody Processsipoc processsipoc) {
        return sipocService.addProcess(id, processsipoc);
    }
    @PutMapping("/updateProcess/{processId}")
    public Processsipoc updateProcess(@PathVariable String processId, @RequestBody Processsipoc processsipoc) {
        return sipocService.updateProcess(processId, processsipoc);
    }

    @DeleteMapping("/{id}/removeProcess/{processId}")
    public Sipoc removeProcess(@PathVariable String id, @PathVariable String processId) {
        return sipocService.removeProcess(id, processId);
    }
    //OUTPUTS CORNER
    @PostMapping("/{id}/addOutput")
    public Sipoc addOutput(@PathVariable String id, @RequestBody Output output) {
        return sipocService.addOutput(id, output);
    }

    @PutMapping("/updateOutput/{outputId}")
    public Output updateOutput(@PathVariable String outputId, @RequestBody Output output) {
        return sipocService.updateOutput(outputId, output);
    }
    @DeleteMapping("/{id}/removeOutput/{OutputId}")
    public Sipoc removeOutput(@PathVariable String id, @PathVariable String OutputId) {
        return sipocService.removeOutput(id, OutputId);
    }
    //Customers CORNER
    @PostMapping("/{id}/addCustomer")
    public Sipoc addCustomer(@PathVariable String id, @RequestBody Customer customer) {
        return sipocService.addCustomer(id, customer);
    }

    @PutMapping("/updateCustomer/{customerId}")
    public Customer updateCustomer(@PathVariable String customerId, @RequestBody Customer customer) {
        return sipocService.updateCustomer(customerId, customer);
    }
    @DeleteMapping("/{id}/removeCustomer/{customerId}")
    public Sipoc removeCustomer(@PathVariable String id, @PathVariable String customerId) {
        return sipocService.removeCustomer(id, customerId);
    }
    ///sprint3
    @GetMapping("/{id}/countSuppliers")
    public long countSuppliers(@PathVariable("id") String sipocId) {
        return sipocService.countSuppliersBySipocId(sipocId);
    }

    @GetMapping("/{id}/countInputs")
    public long countInputs(@PathVariable("id") String sipocId) {
        return sipocService.countInputsBySipocId(sipocId);
    }

    @GetMapping("/{id}/countProcesses")
    public long countProcesses(@PathVariable("id") String sipocId) {
        return sipocService.countProcessesBySipocId(sipocId);
    }

    @GetMapping("/{id}/countOutputs")
    public long countOutputs(@PathVariable("id") String sipocId) {
        return sipocService.countOutputsBySipocId(sipocId);
    }

    @GetMapping("/{id}/countCustomers")
    public long countCustomers(@PathVariable("id") String sipocId) {
        return sipocService.countCustomersBySipocId(sipocId);
    }
}
