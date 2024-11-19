package lean.toc.manajerobackend.controllers.FDDG2_Controllers;

import lean.toc.manajerobackend.models.FDDG2_Entities.WorkSpace;
import lean.toc.manajerobackend.services.FDDG2_Services.WorkSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/WorkSpace")
public class WorkSpaceController {
    @Autowired
    WorkSpaceService workSpaceService;

    @GetMapping("/getAllWS")
    public List<WorkSpace> workSpaceList (){
        return workSpaceService.getAllWorkSpace();
    }
    @PostMapping("/addWS")
    public WorkSpace addWS(@RequestBody WorkSpace workSpace){
        return workSpaceService.AddWorkSpace(workSpace);
    }
    @PostMapping("/editWS/{id}")
    public WorkSpace EditWS(@RequestBody WorkSpace workSpace,@PathVariable ("id") String codeWS){
        return workSpaceService.EditWorkSpace(workSpace,codeWS);

    }
    @GetMapping("/getWs/{id}")
    public WorkSpace getOneWS(@PathVariable("id") String codeWS){
        return workSpaceService.getOneWorkSpace(codeWS);
    }
    @DeleteMapping("/deleteWS/{id}")
    public String  deleteWS(@PathVariable("id") String codeWS){
        workSpaceService.deleteWorkSpace(codeWS);
        return "Work Space deleted successfully";
    }
    @GetMapping("/getUserWS/{id}")
    public List<WorkSpace> getUserWorkspace(@PathVariable("id") String id){
        return workSpaceService.getUserWorkspace(id);
    }

}
