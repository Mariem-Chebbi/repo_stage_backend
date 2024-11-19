package lean.toc.manajerobackend.controllers.ASDG2_controller;

import lean.toc.manajerobackend.models.ASDG2_models.Introduction;
import lean.toc.manajerobackend.services.ASDG2_services.IntroductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/introductions")
public class IntroductionController {
    @Autowired
    private IntroductionService service;

    @GetMapping
    public List<Introduction> findAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public Introduction findById(@PathVariable String id) { return service.findById(id); }
    @PostMapping
    public Introduction createIntroduction(@RequestBody Introduction introduction) {
        return service.save(introduction);
    }

    @PutMapping("/{id}")
    public Introduction updateIntroduction(@PathVariable String id, @RequestBody Introduction introduction) {
        return service.updateIntroduction(id, introduction);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id) { service.deleteById(id); }
}
