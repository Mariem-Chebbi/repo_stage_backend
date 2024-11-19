package lean.toc.manajerobackend.controllers.safe_controllers;

import lean.toc.manajerobackend.models.safe_models.ProgramIncrement;
import lean.toc.manajerobackend.services.safe_services.ServicesImp.ProgramIncrementService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/program-increments")
@RequiredArgsConstructor
@Slf4j
public class ProgramIncrementController {

    @Autowired
    private ProgramIncrementService programIncrementService;

    // Create or Update Program Increment
    @PostMapping
    public ResponseEntity<ProgramIncrement> createOrUpdateProgramIncrement(@RequestBody ProgramIncrement programIncrement) {
        ProgramIncrement savedProgramIncrement = programIncrementService.createOrUpdateProgramIncrement(programIncrement);
        return new ResponseEntity<>(savedProgramIncrement, HttpStatus.CREATED);
    }

    // Get Program Increment by ID
    @GetMapping("/{id}")
    public ResponseEntity<ProgramIncrement> getProgramIncrementById(@PathVariable("id") String id) {
        Optional<ProgramIncrement> programIncrement = programIncrementService.getProgramIncrementById(id);
        return programIncrement.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Get all Program Increments
    @GetMapping
    public ResponseEntity<List<ProgramIncrement>> getAllProgramIncrements() {
        List<ProgramIncrement> programIncrements = programIncrementService.getAllProgramIncrements();
        return ResponseEntity.ok(programIncrements);
    }

    // Delete Program Increment by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProgramIncrement(@PathVariable("id") String id) {
        if (programIncrementService.getProgramIncrementById(id).isPresent()) {
            programIncrementService.deleteProgramIncrement(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
