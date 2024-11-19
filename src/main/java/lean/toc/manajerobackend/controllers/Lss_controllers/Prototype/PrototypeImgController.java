package lean.toc.manajerobackend.controllers.Lss_controllers.Prototype;

import lean.toc.manajerobackend.models.Lss_models.Prototype.PrototypeImg;
import lean.toc.manajerobackend.services.Lss_services.Prototype.PrototypeImgServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/ImagePrototype")
@AllArgsConstructor
public class PrototypeImgController {

    @Autowired
    PrototypeImgServiceImpl prototypeImgService;

    @PostMapping("/{idprototype}/images")
    public ResponseEntity<PrototypeImg> addImageToprot(@PathVariable String idprototype, @RequestBody PrototypeImg image) {
        try {
            PrototypeImg savedImage = prototypeImgService.addImageToPrototype(idprototype, image);
            return new ResponseEntity<>(savedImage, HttpStatus.CREATED);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{imageId}/{idprototype}")
    public ResponseEntity<Void> deleteImage(@PathVariable String imageId, @PathVariable String idprototype) {
        try {
            prototypeImgService.deleteImage(imageId, idprototype);
            return ResponseEntity.noContent().build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/{idprototype}/images")
    public List<PrototypeImg> getImagesByProtoId(@PathVariable String idprototype) {
        return prototypeImgService.getImagesByPrototypeId(idprototype);
    }
}
