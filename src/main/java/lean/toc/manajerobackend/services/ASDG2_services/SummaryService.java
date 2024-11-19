package lean.toc.manajerobackend.services.ASDG2_services;


import lean.toc.manajerobackend.models.ASDG2_models.Summary;
import lean.toc.manajerobackend.repositories.ASDG2_repositories.SummaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SummaryService {
    @Autowired
    private SummaryRepository repository;

    public List<Summary> findAll() { return repository.findAll(); }
    public Summary findById(String id) { return repository.findById(id).orElse(null); }
    public Summary save(Summary summary) { return repository.save(summary); }
    public void deleteById(String id) { repository.deleteById(id); }
}

