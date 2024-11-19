package lean.toc.manajerobackend.services.Lss_services;


import lean.toc.manajerobackend.models.Lss_models.Kanbanboard.Card;
import lean.toc.manajerobackend.models.Lss_models.Kanbanboard.Kanban;
import lean.toc.manajerobackend.models.Lss_models.Kanbanboard.Status;
import lean.toc.manajerobackend.repositories.Lss_repositories.Kanban.CardRepository;
import lean.toc.manajerobackend.repositories.Lss_repositories.Kanban.KanbanRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class KanbanServiceImpl {
    @Autowired
    KanbanRepository kanbanRepository;
    @Autowired
    CardRepository cardRepository;


    //KANBAN CORNER
    public Kanban addKanban(String projectId, Kanban kanban) {
        kanban.setId_project(projectId);
        kanban.setIdkanban(null);
        kanban.setCreation_date(new Date());
        kanban.setCards(new ArrayList<>());

        return kanbanRepository.save(kanban);


    }

    public List<Kanban> getKanbanByProjectCharterId(String projectCharterId) {
        return kanbanRepository.findById_project(projectCharterId);
    }

    public void deleteKanbans(String kanbanId) {
        // Find the Fivewhys document
        Kanban kanban = kanbanRepository.findById(kanbanId).orElse(null);
        if (kanban != null) {
            // Delete associated card documents
            for (Card card : kanban.getCards()) {
                cardRepository.delete(card);
            }
            // Delete the Fivewhys document
            kanbanRepository.delete(kanban);
        }
    }

/////*****************************//CARD CORNER******************************************************//
    public Card updateCard(Card updatedCard) {
        if (updatedCard.getId_card() != null) {
            // Update existing card
            Card existingCard = cardRepository.findById(updatedCard.getId_card()).orElse(null);
            if (existingCard != null) {
                existingCard.setTitle_card(updatedCard.getTitle_card());
                existingCard.setDesciption_card(updatedCard.getDesciption_card());
                existingCard.setPriority_card(updatedCard.getPriority_card());
                existingCard.setStatus(updatedCard.getStatus());
                return cardRepository.save(existingCard);
            } else {
                throw new RuntimeException("Card not found with ID: " + updatedCard.getId_card());
            }
        } else {
            throw new RuntimeException("Card ID is required for update.");
        }
    }
    public Kanban removeCard(String kanbanId, String cardId) {
        Optional<Kanban> kanbanOptional = kanbanRepository.findById(kanbanId);
        if (kanbanOptional.isPresent()) {
            Kanban existingKanban = kanbanOptional.get();
            Card cardToRemove = cardRepository.findById(cardId).orElse(null);
            if (cardToRemove != null) {
                // Remove the card from the Kanban's card list
                existingKanban.getCards().removeIf(card -> card.getId_card().equals(cardId));
                // Save the updated Kanban
                kanbanRepository.save(existingKanban);
                // Delete the card from the card repository
                cardRepository.deleteById(cardId);
                return existingKanban;
            } else {
                throw new RuntimeException("Card not found with ID: " + cardId);
            }
        } else {
            throw new RuntimeException("Kanban not found with ID: " + kanbanId);
        }
    }
    public Kanban addDoneCard(String id, Card card) {
        Kanban kanban=kanbanRepository.findById(id).orElse(null);
        if (kanban!=null) {
            card.setId_card(null);
            card.setCreation_card(new Date());
            card.setStatus(Status.DONE);
            card.setKanban(kanban);
            cardRepository.save(card);
            kanban.getCards().add(card);
            return kanbanRepository.save(kanban);
        }
        return null;
    }
    public Kanban addTodoCard(String id, Card card) {
        Kanban kanban=kanbanRepository.findById(id).orElse(null);
        if (kanban!=null) {
            card.setId_card(null);
            card.setCreation_card(new Date());
            card.setStatus(Status.TODO);
            card.setKanban(kanban);
            cardRepository.save(card);
            kanban.getCards().add(card);
            return kanbanRepository.save(kanban);
        }
        return null;
    }   public Kanban addInprogressCard(String id, Card card) {
        Kanban kanban=kanbanRepository.findById(id).orElse(null);
        if (kanban!=null) {
            card.setId_card(null);
            card.setCreation_card(new Date());
            card.setStatus(Status.INPROGRESS);
            card.setKanban(kanban);
            cardRepository.save(card);
            kanban.getCards().add(card);
            return kanbanRepository.save(kanban);
        }
        return null;
    }
    public List<Card> getTodoCardsByKanbanId(String kanbanId) {
        return cardRepository.findCardsByKanbanIdkanbanAndStatus(kanbanId, Status.TODO);
    }
    public List<Card> getInprogressCardsByKanbanId(String kanbanId) {
        return cardRepository.findCardsByKanbanIdkanbanAndStatus(kanbanId, Status.INPROGRESS);
    }
    public List<Card> getDoneCardsByKanbanId(String kanbanId) {
        return cardRepository.findCardsByKanbanIdkanbanAndStatus(kanbanId, Status.DONE);
    }
    //////////////////////SPRINT3/////////////////////
    public Map<String, Object> calculateKanbanProgress(String kanbanId) {
        List<Card> allCards = cardRepository.findCardsByKanbanIdkanban(kanbanId);

        int totalCards = allCards.size();
        long todoCount = allCards.stream().filter(card -> card.getStatus() == Status.TODO).count();
        long inProgressCount = allCards.stream().filter(card -> card.getStatus() == Status.INPROGRESS).count();
        long doneCount = allCards.stream().filter(card -> card.getStatus() == Status.DONE).count();

        double progress = totalCards > 0 ? ((todoCount * 0 + inProgressCount * 0.5 + doneCount * 1) * 100.0 / totalCards) : 0.0;

        Map<String, Object> progressMap = new HashMap<>();
        progressMap.put("progress", progress);

        return progressMap;
    }

    public Map<String, Double> getCardStatusPercentages(String kanbanId) {
        // Fetch cards by Kanban ID
        List<Card> kanbanCards = cardRepository.findByKanbanIdkanban(kanbanId);

        long totalCards = kanbanCards.size();
        if (totalCards == 0) {
            throw new IllegalStateException("No cards available for the specified Kanban.");
        }

        // Initialize the map with all statuses
        Map<String, Long> countByStatus = new HashMap<>();
        for (Status status : Status.values()) {
            countByStatus.put(status.name(), 0L);
        }

        // Group cards by their status and count them
        kanbanCards.stream()
                .filter(card -> card.getStatus() != null) // Ensure no null statuses are processed
                .forEach(card -> countByStatus.put(card.getStatus().name(), countByStatus.get(card.getStatus().name()) + 1));

        // Calculate the percentage for each status and round to two decimal places
        return countByStatus.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> {
                            double percentage = (entry.getValue() * 100.0) / totalCards;
                            return BigDecimal.valueOf(percentage)
                                    .setScale(2, RoundingMode.HALF_UP)
                                    .doubleValue();
                        }
                ));
    }

    //
    public Map<String, Double> getCardPercentagePerMonth(String kanbanId) {
        List<Card> cards = cardRepository.findByKanbanIdkanban(kanbanId);

        // Calculate total number of cards
        int totalCards = cards.size();

        // Group cards by year and month
        Map<String, Long> cardsPerMonth = cards.stream()
                .collect(Collectors.groupingBy(card -> {
                    LocalDate creationDate = card.getCreation_card().toInstant()
                            .atZone(ZoneId.systemDefault())
                            .toLocalDate();
                    return creationDate.getYear() + "-" + creationDate.getMonthValue();
                }, Collectors.counting()));

        // Calculate percentage for each month
        Map<String, Double> percentagePerMonth = new HashMap<>();
        for (Map.Entry<String, Long> entry : cardsPerMonth.entrySet()) {
            percentagePerMonth.put(entry.getKey(), (entry.getValue() * 100.0) / totalCards);
        }

        return percentagePerMonth;
    }
}
