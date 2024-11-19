package lean.toc.manajerobackend.controllers.Lss_controllers;

import lean.toc.manajerobackend.models.Lss_models.Documentation;
import lean.toc.manajerobackend.models.Lss_models.Image;
import lean.toc.manajerobackend.models.Lss_models.Section;
import lean.toc.manajerobackend.services.Lss_services.DocumentationServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/documentation")

@AllArgsConstructor

public class DocumentationController {
    @Autowired
    DocumentationServiceImpl documentationService;

    @GetMapping("/why")
    public ResponseEntity<Documentation> getWhyDocumentation() {
        return getDocumentationWithImagesResponse(Section.WHY);
    }

    @GetMapping("/what")
    public ResponseEntity<Documentation> getWhatDocumentation() {
        return getDocumentationWithImagesResponse(Section.WHAT);
    }

    @GetMapping("/how")
    public ResponseEntity<Documentation> getHowDocumentation() {
        return getDocumentationWithImagesResponse(Section.HOW);
    }

    @GetMapping("/whatif")
    public ResponseEntity<Documentation> getWhatIfDocumentation() {
        return getDocumentationWithImagesResponse(Section.WHATIF);
    }

    public ResponseEntity<Documentation> getDocumentationWithImagesResponse(Section section) {
        try {
            Documentation documentation = documentationService.getDocumentationWithImagesBySection(section);
            if (documentation != null) {
                return ResponseEntity.ok(documentation);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Documentation> updateDocumentation(
            @PathVariable String id,
            @RequestBody Documentation updatedDoc) {
        try {
            Documentation updatedDocumentation = documentationService.updateDocumentation(id, updatedDoc);
            return new ResponseEntity<>(updatedDocumentation, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<Documentation> addDocumentation(@RequestBody Documentation documentation) {
        Documentation savedDoc = documentationService.addDocumentation(documentation);
        return new ResponseEntity<>(savedDoc, HttpStatus.CREATED);
    }



    @PostMapping("/{docId}/images")
    public ResponseEntity<Image> addImageToDocumentation(@PathVariable String docId, @RequestBody Image image) {
        try {
            Image savedImage = documentationService.addImageToDocumentation(docId, image);
            return new ResponseEntity<>(savedImage, HttpStatus.CREATED);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{docId}/images")
    public ResponseEntity<List<Image>> getImagesByDocumentationId(@PathVariable String docId) {
        List<Image> images = documentationService.getImagesByDocumentationId(docId);
        return new ResponseEntity<>(images, HttpStatus.OK);
    }

    @DeleteMapping("/{imageId}/{docId}")
    public ResponseEntity<Void> deleteImage(@PathVariable String imageId, @PathVariable String docId) {
        try {
            documentationService.deleteImage(imageId, docId);
            return ResponseEntity.noContent().build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
