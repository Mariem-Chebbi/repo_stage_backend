package lean.toc.manajerobackend.services.Lss_services;

import lean.toc.manajerobackend.models.Lss_models.Sipoc.*;
import lean.toc.manajerobackend.repositories.Lss_repositories.SIPOC.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class SipocServiceImpl {

    @Autowired
    SipocRepository sipocRepository;
    @Autowired
    SupplierRepository supplierRepository;
    @Autowired
    InputRepository inputRepository;
    @Autowired
    OutputRepository outputRepository;
    @Autowired
    ProcessRepository processRepository;
    @Autowired
    CustomerRepository customerRepository;

    public Optional<Sipoc> getSipocById(String id) {
        return sipocRepository.findById(id);
    }
    public Sipoc getSIPOCByProjectCharterId(String projectCharterId) {
        return sipocRepository.findByIdproject(projectCharterId)
                .orElse(null);
    }

    public Sipoc createSipoc(String projectCharterId, Sipoc sipoc) {
        // Initialize the Sipoc object
        sipoc.setId_sipoc(null); // Ensure the ID is set to null so that the database generates a new one
        sipoc.setIdproject(projectCharterId);
        sipoc.setAddDate(new Date());
        sipoc.setSupplier_sipoc(new ArrayList<>()); // Initialize with empty lists if you expect to add elements later
        sipoc.setInput_sipoc(new ArrayList<>());
        sipoc.setProcess_sipoc(new ArrayList<>());
        sipoc.setOutput_sipoc(new ArrayList<>());
        sipoc.setCustomer_sipoc(new ArrayList<>());

        // Save to the repository
        return sipocRepository.save(sipoc);
    }

    public void deleteSipoc(String id) {
        Optional<Sipoc> sipocOptional = sipocRepository.findById(id);
        if (sipocOptional.isPresent()) {
            Sipoc existingSipoc = sipocOptional.get();

            // Delete all related suppliers
            List<Supplier> suppliers = existingSipoc.getSupplier_sipoc();
            for (Supplier supplier : suppliers) {
                supplierRepository.deleteById(supplier.getId_supplier());
            }

            // Delete all related inputs
            List<Input> inputs = existingSipoc.getInput_sipoc();
            for (Input input : inputs) {
                inputRepository.deleteById(input.getId_input());
            }

            // Delete all related processes
            List<Processsipoc> processes = existingSipoc.getProcess_sipoc();
            for (Processsipoc processs : processes) {
                processRepository.deleteById(processs.getId_process());
            }

            // Delete all related outputs
            List<Output> outputs = existingSipoc.getOutput_sipoc();
            for (Output output : outputs) {
                outputRepository.deleteById(output.getId_output());
            }

            // Delete all related customers
            List<Customer> customers = existingSipoc.getCustomer_sipoc();
            for (Customer customer : customers) {
                customerRepository.deleteById(customer.getId_customer());
            }

            // Finally, delete the SIPOC document itself
            sipocRepository.deleteById(id);
        }
    }


    //SUPPLIERS CORNER
    public Sipoc addSupplier(String id, Supplier supplier) {
        Optional<Sipoc> sipocOptional = sipocRepository.findById(id);
        if (sipocOptional.isPresent()) {
            Sipoc existingSipoc = sipocOptional.get();
            supplier.setId_supplier(null); // Clear the ID if set
            supplierRepository.save(supplier);  // Save supplier if not already saved
            existingSipoc.getSupplier_sipoc().add(supplier);
            return sipocRepository.save(existingSipoc);
        }
        return null;
    }

    public Supplier updateSupplier(String supplierId, Supplier updatedSupplier) {
        Optional<Supplier> supplierOptional = supplierRepository.findById(supplierId);
        if (supplierOptional.isPresent()) {
            Supplier existingSupplier = supplierOptional.get();
            existingSupplier.setName(updatedSupplier.getName()); // Update the name
            return supplierRepository.save(existingSupplier);
        }
        return null;
    }
    public Sipoc removeSupplier(String id, String supplierId) {
        Optional<Sipoc> sipocOptional = sipocRepository.findById(id);
        if (sipocOptional.isPresent()) {
            Sipoc existingSipoc = sipocOptional.get();
            Supplier supplierToRemove = supplierRepository.findById(supplierId).orElse(null);
            if (supplierToRemove != null) {
                existingSipoc.getSupplier_sipoc().remove(supplierToRemove);
                sipocRepository.save(existingSipoc);
                supplierRepository.deleteById(supplierId); // Delete supplier from the database
                return existingSipoc;
            }
        }
        return null;
    }
    //INPUTS CORNER
    public Sipoc addInput(String id, Input input) {
        Optional<Sipoc> sipocOptional = sipocRepository.findById(id);
        if (sipocOptional.isPresent()) {
            Sipoc existingSipoc = sipocOptional.get();
            input.setId_input(null);
            inputRepository.save(input);
            existingSipoc.getInput_sipoc().add(input);
            return sipocRepository.save(existingSipoc);
        }
        return null;
    }
    public Input updateInput(String inputId, Input updatedInput) {
        Optional<Input> InputOptional = inputRepository.findById(inputId);
        if (InputOptional.isPresent()) {
            Input existingInput = InputOptional.get();
            existingInput.setName(updatedInput.getName());
            return inputRepository.save(existingInput);
        }
        return null;
    }
    public Sipoc removeInput(String id, String inputId) {
        Optional<Sipoc> sipocOptional = sipocRepository.findById(id);
        if (sipocOptional.isPresent()) {
            Sipoc existingSipoc = sipocOptional.get();
            Input inputToRemove = inputRepository.findById(inputId).orElse(null);
            if (inputToRemove != null) {
                existingSipoc.getInput_sipoc().remove(inputToRemove);
                sipocRepository.save(existingSipoc);
                inputRepository.deleteById(inputId);
                return existingSipoc;
            }
        }
        return null;
    }
    //Processes CORNER
    public Sipoc addProcess(String id, Processsipoc processsipoc) {
        Optional<Sipoc> sipocOptional = sipocRepository.findById(id);
        if (sipocOptional.isPresent()) {
            Sipoc existingSipoc = sipocOptional.get();
            processsipoc.setId_process(null);
            processRepository.save(processsipoc);
            existingSipoc.getProcess_sipoc().add(processsipoc);
            return sipocRepository.save(existingSipoc);
        }
        return null;
    }

    public Processsipoc updateProcess(String ProcessId, Processsipoc updatedProcess) {
        Optional<Processsipoc> ProcessOptional = processRepository.findById(ProcessId);
        if (ProcessOptional.isPresent()) {
            Processsipoc existingProcess = ProcessOptional.get();
            existingProcess.setName(updatedProcess.getName());
            return processRepository.save(existingProcess);
        }
        return null;
    }
    public Sipoc removeProcess(String id, String processId) {
        Optional<Sipoc> sipocOptional = sipocRepository.findById(id);
        if (sipocOptional.isPresent()) {
            Sipoc existingSipoc = sipocOptional.get();
            Processsipoc processToRemove = processRepository.findById(processId).orElse(null);
            if (processToRemove != null) {
                existingSipoc.getProcess_sipoc().remove(processToRemove);
                sipocRepository.save(existingSipoc);
                processRepository.deleteById(processId);
                return existingSipoc;
            }
        }
        return null;
    }
    //OUTPUTS CORNER
    public Sipoc addOutput(String id, Output output) {
        Optional<Sipoc> sipocOptional = sipocRepository.findById(id);
        if (sipocOptional.isPresent()) {
            Sipoc existingSipoc = sipocOptional.get();
            output.setId_output(null);
            outputRepository.save(output);
            existingSipoc.getOutput_sipoc().add(output);
            return sipocRepository.save(existingSipoc);
        }
        return null;
    }

    public Output updateOutput(String outputId, Output updatedOuput) {
        Optional<Output> OutputOptional = outputRepository.findById(outputId);
        if (OutputOptional.isPresent()) {
            Output existingOutput = OutputOptional.get();
            existingOutput.setName(updatedOuput.getName());
            return outputRepository.save(existingOutput);
        }
        return null;
    }
    public Sipoc removeOutput(String id, String outputId) {
        Optional<Sipoc> sipocOptional = sipocRepository.findById(id);
        if (sipocOptional.isPresent()) {
            Sipoc existingSipoc = sipocOptional.get();
            Output OutputToRemove = outputRepository.findById(outputId).orElse(null);
            if (OutputToRemove != null) {
                existingSipoc.getOutput_sipoc().remove(OutputToRemove);
                sipocRepository.save(existingSipoc);
                outputRepository.deleteById(outputId);
                return existingSipoc;
            }
        }
        return null;
    }

    //Customers CORNER
    public Sipoc addCustomer(String id, Customer customer) {
        Optional<Sipoc> sipocOptional = sipocRepository.findById(id);
        if (sipocOptional.isPresent()) {
            Sipoc existingSipoc = sipocOptional.get();
            customer.setId_customer(null);
            customerRepository.save(customer);
            existingSipoc.getCustomer_sipoc().add(customer);
            return sipocRepository.save(existingSipoc);
        }
        return null;
    }
    public Customer updateCustomer(String CustomerId, Customer updatedCustomer) {
        Optional<Customer> CustomerOptional = customerRepository.findById(CustomerId);
        if (CustomerOptional.isPresent()) {
            Customer existingCustomer = CustomerOptional.get();
            existingCustomer.setName(updatedCustomer.getName());
            return customerRepository.save(existingCustomer);
        }
        return null;
    }
    public Sipoc removeCustomer(String id, String customerId) {
        Optional<Sipoc> sipocOptional = sipocRepository.findById(id);
        if (sipocOptional.isPresent()) {
            Sipoc existingSipoc = sipocOptional.get();
            Customer CustomerToRemove = customerRepository.findById(customerId).orElse(null);
            if (CustomerToRemove != null) {
                existingSipoc.getCustomer_sipoc().remove(CustomerToRemove);
                sipocRepository.save(existingSipoc);
                customerRepository.deleteById(customerId);
                return existingSipoc;
            }
        }
        return null;
    }
    public long countSuppliersBySipocId(String sipocId) {
        Sipoc sipoc = sipocRepository.findById(sipocId).orElse(null);
        if (sipoc != null) {
            return sipoc.getSupplier_sipoc().size();
        }
        return 0;
    }
    public long countInputsBySipocId(String sipocId) {
        Sipoc sipoc = sipocRepository.findById(sipocId).orElse(null);
        if (sipoc != null) {
            return sipoc.getInput_sipoc().size();
        }
        return 0;
    }

    public long countProcessesBySipocId(String sipocId) {
        Sipoc sipoc = sipocRepository.findById(sipocId).orElse(null);
        if (sipoc != null) {
            return sipoc.getProcess_sipoc().size();
        }
        return 0;
    }

    public long countOutputsBySipocId(String sipocId) {
        Sipoc sipoc = sipocRepository.findById(sipocId).orElse(null);
        if (sipoc != null) {
            return sipoc.getOutput_sipoc().size();
        }
        return 0;
    }

    public long countCustomersBySipocId(String sipocId) {
        Sipoc sipoc = sipocRepository.findById(sipocId).orElse(null);
        if (sipoc != null) {
            return sipoc.getCustomer_sipoc().size();
        }
        return 0;
    }
}
