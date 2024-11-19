package lean.toc.manajerobackend.controllers.pokerPlanning_grp2_controllers;


import lean.toc.manajerobackend.models.pokerPlanning_grp2_models.Demo;
import lean.toc.manajerobackend.services.pokerPlanning_grp2_services.DemoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class DemoController {
    DemoService demoService;

    @GetMapping("/getDemo")
    List<Demo> getDemo(){

        return demoService.retreiveDemo();
    }

    @PostMapping("/adddemo")
    Demo addDemo(@RequestBody Demo demo){

        return demoService.addDemo(demo);
    }
    @PutMapping("/updateDemo/{id}")
    public Demo updateDemo(@PathVariable String id, @RequestBody Demo demo) {
        return demoService.updateDemo(demo, id);

    }

    @DeleteMapping("/deletedemo/{id}")
    public void deletedemo(@PathVariable String id ){
        demoService.deleteDemo(id);
    }
}
