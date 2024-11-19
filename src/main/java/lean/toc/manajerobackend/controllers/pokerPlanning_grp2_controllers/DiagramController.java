package lean.toc.manajerobackend.controllers.pokerPlanning_grp2_controllers;


import lean.toc.manajerobackend.models.pokerPlanning_grp2_models.Diagram;
import lean.toc.manajerobackend.services.pokerPlanning_grp2_services.DiagramService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class DiagramController {
    DiagramService diagramService;


    @PostMapping("/addDiagram")
    Diagram addDiagram(@RequestBody Diagram diagram) {
        return  diagramService.addDiagram(diagram);
    }


    @GetMapping("/getDiagrams")
    List<Diagram> getDiagrams(){
        return diagramService.getAllDiagrams();
    }

    @GetMapping("/getDiagrams/{id}")
    public Diagram getDiagramById(@PathVariable String id) {
        return diagramService.getDiagramById(id);
    }

    @PutMapping("/updateDiagram/{id}")
    public Diagram updateDiagram(@PathVariable String id, @RequestBody Diagram diagram) {
        return diagramService.updateDiagram(diagram, id);

    }

    @DeleteMapping("/deleteDiagram/{id}")
    void deleteDiagram(@PathVariable String id) {
        diagramService.deleteDiagram(id);
    }
}
