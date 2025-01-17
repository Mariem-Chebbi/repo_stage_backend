package lean.toc.manajerobackend.controllers.safe_controllers;

import lean.toc.manajerobackend.Exception.RessourceNotFound;
import lean.toc.manajerobackend.models.safe_models.Backlog;
import lean.toc.manajerobackend.services.safe_services.ServicesImp.BacklogServicesImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Backlog")
@RequiredArgsConstructor
@Slf4j
public class BacklogController {
  private final BacklogServicesImpl backlogServices;


 // @PostMapping(path = "/add")
  //public ResponseEntity<?> AjouterBacklog(@RequestBody Backlog backlog) {
 //try {
  //Backlog backlogToSave = backlogServices.addBacklog(backlog);
  //return new ResponseEntity<>(backlogToSave, HttpStatus.CREATED);
  // } catch (RessourceNotFound exception) {
  //   return new ResponseEntity<>(exception.getCause().getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
  // }
 // }
  @PutMapping(path = "/edit")
  public ResponseEntity<?> EditBacklog(@RequestBody  Backlog backlog) {
    try {
      Backlog backlogUpdated = backlogServices.updateBacklog(backlog);
      return new ResponseEntity<>(backlogUpdated, HttpStatus.OK);

    } catch (RessourceNotFound exception) {
      return new ResponseEntity<>("une chose mal passé" + exception.getCause().getMessage(), HttpStatus.NOT_FOUND);
    }


  }
@GetMapping(path = "/{id}")
  public ResponseEntity<?> getBacklogById(@PathVariable("id")String id){
    try {
      Backlog backlog=backlogServices.getBacklogById(id);
      return ResponseEntity.ok(backlog);

    }
    catch (RessourceNotFound e){
      return ResponseEntity.status( HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
}


}
