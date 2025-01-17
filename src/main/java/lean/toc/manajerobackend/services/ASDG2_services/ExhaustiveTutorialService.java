package lean.toc.manajerobackend.services.ASDG2_services;


import lean.toc.manajerobackend.models.ASDG2_models.ExhaustiveTutorial;
import lean.toc.manajerobackend.repositories.ASDG2_repositories.ExhaustiveTutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ExhaustiveTutorialService {
    @Autowired
    private ExhaustiveTutorialRepository repository;

    public List<ExhaustiveTutorial> findAll() { return repository.findAll(); }
    public ExhaustiveTutorial findById(String id) { return repository.findById(id).orElse(null); }
    public ExhaustiveTutorial save(ExhaustiveTutorial exhaustiveTutorial) { return repository.save(exhaustiveTutorial); }
    public void deleteById(String id) { repository.deleteById(id); }
}

