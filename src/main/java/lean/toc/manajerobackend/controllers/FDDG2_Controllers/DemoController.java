package lean.toc.manajerobackend.controllers.FDDG2_Controllers;

import lean.toc.manajerobackend.models.FDDG2_Entities.Demo;
import lean.toc.manajerobackend.services.FDDG2_Services.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController("DemoControllerFDDG2")
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/demo")
public class DemoController {
    @Autowired
    private DemoService demoService;

    private static final String UPLOAD_DIR = "uploads/";

    @PostMapping("/addDemo")
    public Demo addDemo(@RequestBody Demo demo){
        return demoService.AddDemo(demo);
    }

    @GetMapping("/getAllDemos")
    public List<Demo> getAllDemos(){
        return demoService.getAllDemo();
    }

    @GetMapping("/getOneDemo/{id}")
    public Demo getOneDemo(@PathVariable("id") String codeDemo){
        return demoService.getOneDemo(codeDemo);
    }

    @PutMapping("/editDemo/{id}")
    public Demo editDemo(@RequestBody Demo demo, @PathVariable("id") String codeDemo){
        return demoService.EditDemo(demo, codeDemo);
    }

    @DeleteMapping("/deleteDemo/{id}")
    public String deleteDemo(@PathVariable("id") String codeDemo){
        demoService.deleteDemo(codeDemo);
        return "Demo deleted successfully";
    }


    @PostMapping("/addDemoWithImages")
    public ResponseEntity<Demo> addDemoWithImages(@RequestParam Map<String, String> demoData,
                                                  @RequestParam Map<String, MultipartFile> images) {
        Demo demo = new Demo();
        demo.setTitle(demoData.get("title"));
        demo.setIntroduction(demoData.get("introduction"));
        demo.setObjectives(demoData.get("objectives"));
        demo.setWhat(demoData.get("what"));
        demo.setHow(demoData.get("how"));
        demo.setWhy(demoData.get("why"));
        demo.setWhatIf(demoData.get("whatIf"));
        demo.setAdvantages(demoData.get("advantages"));
        demo.setDisadvantages(demoData.get("disadvantages"));
        demo.setRoles(demoData.get("roles"));
        demo.setLifeCycle(demoData.get("lifeCycle"));

        Map<String, String> imagePaths = new HashMap<>();
        for (Map.Entry<String, MultipartFile> entry : images.entrySet()) {
            String attribute = entry.getKey();
            MultipartFile file = entry.getValue();

            if (!file.isEmpty()) {
                try {
                    // Generate a unique filename
                    String uniqueFilename = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
                    Path path = Paths.get("uploads", uniqueFilename);
                    Files.createDirectories(path.getParent()); // Ensure the directories exist
                    Files.write(path, file.getBytes());
                    imagePaths.put(attribute, uniqueFilename);
                } catch (IOException e) {
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
                }
            }
        }
        demo.setImages(imagePaths);
        Demo savedDemo = demoService.AddDemo(demo);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDemo);
    }

    @GetMapping("/download/{fileName}")
    public ResponseEntity<Resource> downloadFile(@PathVariable("fileName") String fileName) {
        Resource resource = demoService.loadFileAsResource(fileName);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

}
