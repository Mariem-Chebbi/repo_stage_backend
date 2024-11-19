package lean.toc.manajerobackend.services.ASDG2_services;


import lean.toc.manajerobackend.models.ASDG2_models.HowToImplement;
import lean.toc.manajerobackend.repositories.ASDG2_repositories.HowToImplementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HowToImplementService {
    @Autowired
    private HowToImplementRepository repository;

    public List<HowToImplement> findAll() { return repository.findAll(); }
    public HowToImplement findById(String id) { return repository.findById(id).orElse(null); }
    public HowToImplement save(HowToImplement howToImplement) { return repository.save(howToImplement); }
    public void deleteById(String id) { repository.deleteById(id); }
}

