package lean.toc.manajerobackend.controllers.Lss_controllers.Prototype;

import lean.toc.manajerobackend.models.Lss_models.Prototype.Prototype;
import lean.toc.manajerobackend.services.Lss_services.Prototype.PrototypeServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/prototype")

@AllArgsConstructor
public class PrototypeController {

    @Autowired
    private PrototypeServiceImpl prototypeService;

    @PostMapping("/create/{projectId}")
    public Prototype createPrototype(@PathVariable String projectId, @RequestBody Prototype prototype) {
        return prototypeService.createPrototype(projectId, prototype);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Prototype> updatePrototype(
            @PathVariable String id,
            @RequestBody Prototype prototype) {
        try {
            Prototype updatePrototype = prototypeService.updatePrototype(id, prototype);
            return new ResponseEntity<>(updatePrototype, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public void deletePrototype(@PathVariable String id) {
        prototypeService.deletePrototype(id);
    }

    @GetMapping("/{projectCharterId}/all")
    public List<Prototype> getPrototypes(@PathVariable String projectCharterId) {
        return prototypeService.getPrototypeByProjectCharterId(projectCharterId);
    }

    @GetMapping("/{projectCharterId}/allArchived")
    public List<Prototype> getArchivedPrototypes(@PathVariable String projectCharterId) {
        return prototypeService.getPrototypeArchived(projectCharterId);
    }
    @PutMapping("/archive/{id}")
    public Prototype archivePrototype(
            @PathVariable String id) {
        return prototypeService.archivePrototype(id);
    }
    @PutMapping("/undo/{id}")
    public Prototype undoPrototype(
            @PathVariable String id) {
        return prototypeService.UndoPrototype(id);
    }

}
