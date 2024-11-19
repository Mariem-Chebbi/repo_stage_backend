package lean.toc.manajerobackend.services.Lss_services.Prototype;

import lean.toc.manajerobackend.models.Lss_models.Prototype.Feedback;
import lean.toc.manajerobackend.models.Lss_models.Prototype.Prototype;
import lean.toc.manajerobackend.models.Lss_models.Prototype.PrototypeImg;
import lean.toc.manajerobackend.repositories.Lss_repositories.Prototype.FeedbackRepository;
import lean.toc.manajerobackend.repositories.Lss_repositories.Prototype.PrototypeImgRepository;
import lean.toc.manajerobackend.repositories.Lss_repositories.Prototype.PrototypeRepository;
import lean.toc.manajerobackend.repositories.Lss_repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@AllArgsConstructor
public class PrototypeServiceImpl {
    @Autowired
    PrototypeRepository prototypeRepository;

    @Autowired
    PrototypeImgRepository prototypeImgRepository;

    @Autowired
    FeedbackRepository feedbackRepository;
    @Autowired
    UserRepository userRepository;



    public Prototype createPrototype(String projectId, Prototype prototype) {
        prototype.setIdproject(projectId);
        prototype.setArchive(false);
        prototype.setId(null);
        prototype.setFeedbacks(new ArrayList<>());
        prototype.setImages(new ArrayList<>());
        prototype.setDate_creation(new Date());
        return prototypeRepository.save(prototype);
    }

    @Transactional
    public Prototype updatePrototype(String id, Prototype updatedPrototype) {
        Optional<Prototype> optionalPrototype = prototypeRepository.findById(id);
        if (optionalPrototype.isPresent()) {
            Prototype prototype = optionalPrototype.get();
            prototype.setName(updatedPrototype.getName());
            prototype.setDescription(updatedPrototype.getDescription());

            // Set last modified date
            prototype.setLast_modif(new Date());
            // Save and return updated documentation
            return prototypeRepository.save(prototype);
        } else {
            throw new NoSuchElementException("prototype not found with id: " + id);
        }
    }
    public void deletePrototype(String id) {
        Optional<Prototype> optionalPrototype = prototypeRepository.findById(id);
        if (optionalPrototype.isPresent()) {
            Prototype exisitingProto = optionalPrototype.get();

            List<PrototypeImg> imgs = exisitingProto.getImages();
            for (PrototypeImg img : imgs) {
                prototypeImgRepository.deleteById(img.getId());
            }

            List<Feedback> feedbacks = exisitingProto.getFeedbacks();
            for (Feedback feedback : feedbacks) {
                feedbackRepository.deleteById(feedback.getId());
            }

            prototypeRepository.deleteById(id);
        }
    }
    public List<Prototype> getPrototypeByProjectCharterId(String projectCharterId) {
        return prototypeRepository.findByIdprojectAndArchive(projectCharterId,false);
    }
    public List<Prototype> getPrototypeArchived(String projectCharterId) {
        return prototypeRepository.findByIdprojectAndArchive(projectCharterId,true);
    }
    public Prototype archivePrototype(String PrototypeId) {
        Optional<Prototype> PrototypeOptional = prototypeRepository.findById(PrototypeId);

        if (PrototypeOptional.isPresent()) {
            Prototype existingPrototype = PrototypeOptional.get();

            existingPrototype.setArchive(true);

            return prototypeRepository.save(existingPrototype);
        }

        return null;
    }
    public Prototype UndoPrototype(String PrototypeId) {
        Optional<Prototype> PrototypeOptional = prototypeRepository.findById(PrototypeId);

        if (PrototypeOptional.isPresent()) {
            Prototype existingPrototype = PrototypeOptional.get();

            existingPrototype.setArchive(false);

            return prototypeRepository.save(existingPrototype);
        }

        return null;
    }


}
