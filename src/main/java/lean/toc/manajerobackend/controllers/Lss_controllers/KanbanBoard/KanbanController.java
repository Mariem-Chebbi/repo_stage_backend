package lean.toc.manajerobackend.controllers.Lss_controllers.KanbanBoard;


import lean.toc.manajerobackend.models.Lss_models.Kanbanboard.Card;
import lean.toc.manajerobackend.models.Lss_models.Kanbanboard.Kanban;
import lean.toc.manajerobackend.services.Lss_services.KanbanServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/kanbanboard")
@AllArgsConstructor

public class KanbanController {
    @Autowired
    KanbanServiceImpl kanbanService;


    @GetMapping("/byProjectCharter/{projectCharterId}")
    public List<Kanban> getKanbanByProjectCharterId(@PathVariable String projectCharterId) {
        return kanbanService.getKanbanByProjectCharterId(projectCharterId);
    }
    @PostMapping("/add/{projectId}")
    public ResponseEntity<Kanban> addKanban(@PathVariable String projectId, @RequestBody Kanban kanban) {
        Kanban createdKanban = kanbanService.addKanban(projectId, kanban);
        return ResponseEntity.ok(createdKanban);
    }

    @DeleteMapping("/{kanbanId}")
    public void deleteKanban(@PathVariable String kanbanId) {
        kanbanService.deleteKanbans(kanbanId);
    }


    ///////CARD CORNER
    @PutMapping("/updateCard/{idcard}")
    public Card updateCard(@PathVariable String idcard, @RequestBody Card updatedCard) {
        updatedCard.setId_card(idcard);
        return kanbanService.updateCard(updatedCard);
    }

    @DeleteMapping("/remove/card/{kanbanId}/{cardId}")
    public ResponseEntity<Kanban> removeCard(@PathVariable String kanbanId, @PathVariable String cardId) {
        Kanban updatedKanban = kanbanService.removeCard(kanbanId, cardId);
        return ResponseEntity.ok(updatedKanban);
    }
    @PostMapping("/{id}/addTODOCard")
    public Kanban addTODOCard(@PathVariable String id, @RequestBody Card card) {
        return kanbanService.addTodoCard(id, card);
    }
    @PostMapping("/{id}/addPROGRESSCard")
    public Kanban addIncard(@PathVariable String id, @RequestBody Card card) {
        return kanbanService.addInprogressCard(id, card);
    } @PostMapping("/{id}/addDONECard")
    public Kanban addDonecard(@PathVariable String id, @RequestBody Card card) {
        return kanbanService.addDoneCard(id, card);
    }

    @GetMapping("/{kanbanId}/cards/todo")
    public List<Card> getTodoCardsByKanbanId(@PathVariable String kanbanId) {
        return   kanbanService.getTodoCardsByKanbanId(kanbanId);
    }
    @GetMapping("/{kanbanId}/cards/inprogress")
    public List<Card> getInprogressCardsByKanbanId(@PathVariable String kanbanId) {
        return   kanbanService.getInprogressCardsByKanbanId(kanbanId);
    }
    @GetMapping("/{kanbanId}/cards/done")
    public List<Card> getDoneCardsByKanbanId(@PathVariable String kanbanId) {
        return   kanbanService.getDoneCardsByKanbanId(kanbanId);
    }
    ///sprint3//
    @GetMapping("/{kanbanId}/progress")
    public ResponseEntity<Map<String, Object>> getKanbanProgress(@PathVariable String kanbanId) {
        Map<String, Object> progress = kanbanService.calculateKanbanProgress(kanbanId);
        return ResponseEntity.ok(progress);
    }
    @GetMapping("/status-percentages/{kanbanId}")
    public Map<String, Double> getCardStatusPercentages(@PathVariable String kanbanId) {
        return kanbanService.getCardStatusPercentages(kanbanId);
    }

    @GetMapping("/total-per-month/{kanbanId}")
    public Map<String, Double> getTotalCardsPerMonth(@PathVariable String kanbanId) {
        return kanbanService.getCardPercentagePerMonth(kanbanId);
    }

}
