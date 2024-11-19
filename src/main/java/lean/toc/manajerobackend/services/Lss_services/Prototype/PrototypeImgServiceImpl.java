package lean.toc.manajerobackend.services.Lss_services.Prototype;

import lean.toc.manajerobackend.models.Lss_models.Prototype.Prototype;
import lean.toc.manajerobackend.models.Lss_models.Prototype.PrototypeImg;
import lean.toc.manajerobackend.repositories.Lss_repositories.Prototype.PrototypeImgRepository;
import lean.toc.manajerobackend.repositories.Lss_repositories.Prototype.PrototypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@AllArgsConstructor
public class PrototypeImgServiceImpl {

    @Autowired
    PrototypeImgRepository prototypeImgRepository;
    @Autowired
    PrototypeRepository prototypeRepository;
    ///////////////img//////////
    @Transactional
    public PrototypeImg addImageToPrototype(String idprototype, PrototypeImg  image) {
        Optional<Prototype> optionalPrototype = prototypeRepository.findById(idprototype);
        if (optionalPrototype.isPresent()) {
            Prototype prototype = optionalPrototype.get();
            List<PrototypeImg> images = prototype.getImages();
            if (images == null) {
                images = new ArrayList<>();
                prototype.setImages(images);
            }
            image.setPrototype(prototype);
            images.add(image);

            if (image.getId() == null || image.getId().isEmpty()) {
                image.setId(UUID.randomUUID().toString());
            }

            prototypeRepository.save(prototype);
            return prototypeImgRepository.save(image);
        } else {
            throw new NoSuchElementException("prot not found with id: " + idprototype);
        }
    }
    @Transactional
    public void deleteImage(String imageId, String idprototype) {
        Optional<Prototype> optionalPrototype = prototypeRepository.findById(idprototype);
        if (optionalPrototype.isPresent()) {
            Prototype prot = optionalPrototype.get();
            prot.getImages().removeIf(image -> image.getId().equals(imageId));
            prototypeRepository.save(prot);

            prototypeImgRepository.deleteById(imageId);
        } else {
            throw new NoSuchElementException("prot not found for docId: " + idprototype);
        }
    }

    public List<PrototypeImg> getImagesByPrototypeId(String prototypeId) {
        return prototypeImgRepository.findByPrototypeId(prototypeId);
    }

}
