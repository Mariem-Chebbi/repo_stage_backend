package lean.toc.manajerobackend.services.pokerPlanning_grp2_services;


import jakarta.persistence.EntityNotFoundException;
import lean.toc.manajerobackend.models.pokerPlanning_grp2_models.Diagram;
import lean.toc.manajerobackend.repositories.pokerPlanning_grp2_repositories.DiagramRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class DiagramService {
    DiagramRepository diagramRepository ;

    public Diagram addDiagram(Diagram diagram) {
        return diagramRepository.save(diagram);
    }

    public List<Diagram> getAllDiagrams() {
        return diagramRepository.findAll();
    }

    public Diagram getDiagramById(String id) {
        return diagramRepository.findById(id).orElse(null);
    }

    public Diagram updateDiagram (Diagram diagram, String id) {
        Diagram existingDiagram = diagramRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity with id " + id + " not found"));
        existingDiagram.setStptitle(diagram.getStptitle());
        existingDiagram.setStpDescription(diagram.getStpDescription());
        return diagramRepository.save(existingDiagram);
    }
    public void deleteDiagram(String id) {
        diagramRepository.deleteById(id);
    }
}
