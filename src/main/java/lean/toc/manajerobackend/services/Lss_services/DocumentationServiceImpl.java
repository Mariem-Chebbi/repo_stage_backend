package lean.toc.manajerobackend.services.Lss_services;
import lean.toc.manajerobackend.models.Lss_models.Documentation;
import lean.toc.manajerobackend.models.Lss_models.Image;
import lean.toc.manajerobackend.models.Lss_models.Section;
import lean.toc.manajerobackend.repositories.Lss_repositories.Documentation.DocumentationRepository;
import lean.toc.manajerobackend.repositories.Lss_repositories.Documentation.ImageRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@AllArgsConstructor
public class DocumentationServiceImpl {

    @Autowired
    private DocumentationRepository documentationRepository;

    @Autowired
    private ImageRepository imageRepository;

    public Documentation getDocumentationWithImagesBySection(Section section) {
        Documentation documentation = documentationRepository.findBySectiondocu(section);
        if (documentation != null) {
            List<Image> images = imageRepository.findByDocumentationIddocu(documentation.getIddocu());
            documentation.setImages(images);
        }
        return documentation;
    }

    @Transactional
    public Documentation addDocumentation(Documentation documentation) {
        documentation.setLastModifieddocu(new Date());
        return documentationRepository.save(documentation);
    }

    @Transactional
    public Documentation updateDocumentation(String id, Documentation updatedDoc) {
        Optional<Documentation> optionalDoc = documentationRepository.findById(id);
        if (optionalDoc.isPresent()) {
            Documentation doc = optionalDoc.get();

            // Update fields from updatedDoc
            doc.setSectiondocu(updatedDoc.getSectiondocu());
            doc.setContentdocu(updatedDoc.getContentdocu());
            doc.setTitle1(updatedDoc.getTitle1());
            doc.setTitle2(updatedDoc.getTitle2());
            doc.setContent1(updatedDoc.getContent1());
            doc.setContent2(updatedDoc.getContent2());
            doc.setTitle3(updatedDoc.getTitle3());
            doc.setContent3(updatedDoc.getContent3());
            doc.setTitle4(updatedDoc.getTitle4());
            doc.setContent4(updatedDoc.getContent4());
            doc.setTitle5(updatedDoc.getTitle5());

            doc.setContent5(updatedDoc.getContent5());
            doc.setTitle6(updatedDoc.getTitle6());

            doc.setContent6(updatedDoc.getContent6());
            doc.setTitle7(updatedDoc.getTitle7());
            doc.setContent7(updatedDoc.getContent7());
            doc.setContent8(updatedDoc.getContent8());


            // Set last modified date
            doc.setLastModifieddocu(new Date());

            // Save and return updated documentation
            return documentationRepository.save(doc);
        } else {
            throw new NoSuchElementException("Documentation not found with id: " + id);
        }
    }

    @Transactional
    public Image addImageToDocumentation(String docId, Image image) {
        Optional<Documentation> optionalDoc = documentationRepository.findById(docId);
        if (optionalDoc.isPresent()) {
            Documentation doc = optionalDoc.get();
            List<Image> images = doc.getImages();
            if (images == null) {
                images = new ArrayList<>();
                doc.setImages(images);
            }
            image.setDocumentation(doc);
            images.add(image);

            if (image.getId() == null || image.getId().isEmpty()) {
                image.setId(UUID.randomUUID().toString()); // Generate a random UUID as ID
            }

            documentationRepository.save(doc);
            return imageRepository.save(image);
        } else {
            throw new NoSuchElementException("Documentation not found with id: " + docId);
        }
    }

    public List<Image> getImagesByDocumentationId(String docId) {
        return imageRepository.findByDocumentationIddocu(docId);
    }

    @Transactional
    public void deleteImage(String imageId, String docId) {
        Optional<Documentation> optionalDoc = documentationRepository.findById(docId);
        if (optionalDoc.isPresent()) {
            Documentation doc = optionalDoc.get();
            // Remove image from documentation's list of images
            doc.getImages().removeIf(image -> image.getId().equals(imageId));
            documentationRepository.save(doc); // Save the updated documentation

            // Delete the image entity from the ImageRepository
            imageRepository.deleteById(imageId);
        } else {
            throw new NoSuchElementException("Documentation not found for docId: " + docId);
        }
    }
}
