package lean.toc.manajerobackend.services.Lss_services.Test;

import lean.toc.manajerobackend.ManajeroBackendApplication;
import lean.toc.manajerobackend.repositories.Lss_repositories.CTQ.RequirementRepository;
import lean.toc.manajerobackend.repositories.Lss_repositories.FMEA.FmeaRepository;
import lean.toc.manajerobackend.repositories.Lss_repositories.FiveWhy.FiveWhysRepository;
import lean.toc.manajerobackend.repositories.Lss_repositories.Kanban.CardRepository;
import lean.toc.manajerobackend.repositories.Lss_repositories.Kanban.KanbanRepository;
import lean.toc.manajerobackend.services.Lss_services.CTQ.CtqServiceImpl;
import lean.toc.manajerobackend.services.Lss_services.CTQ.RequirementServiceImpl;
import lean.toc.manajerobackend.services.Lss_services.FMEA.FmeaServiceImpl;
import lean.toc.manajerobackend.services.Lss_services.FiveWhysServiceImpl;
import lean.toc.manajerobackend.services.Lss_services.KanbanServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ManajeroBackendApplication.class)
@ExtendWith(MockitoExtension.class)
public class Sprint3Test {
    @InjectMocks
    private FmeaServiceImpl fmeaService;

    @Mock
    private FmeaRepository fmeaRepository;
    @Mock
    private FiveWhysRepository fiveWhysRepository;
    @Mock
    private KanbanRepository kanbanRepository;
    @Mock
    private CardRepository cardRepository;
    @Mock
    private RequirementRepository requirementRepository;
    @InjectMocks
private RequirementServiceImpl requirementService;
    @InjectMocks
    private CtqServiceImpl ctqService;
    @InjectMocks
    private FiveWhysServiceImpl fiveWhysService;
    @InjectMocks
private KanbanServiceImpl kanbanService;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

   /* @Test
    void testCountFivewhysByProject() {
        // Arrange
        String projectId = "proj123";
        long expectedCount = 5;

        when(fiveWhysRepository.countByIdproject(projectId)).thenReturn(expectedCount);

        // Act
        long actualCount = fiveWhysService.countFivewhysByProject(projectId);

        // Assert
        assertEquals(expectedCount, actualCount, "The count of Five Whys should match the expected value.");
        verify(fiveWhysRepository, times(1)).countByIdproject(projectId);
        System.out.println(actualCount);
    }*/
   /*@Test
   void testCountFivewhysWithoutSolutionByProject() {
       String projectId = "proj123";
       // Fivewhys with solutions
       Fivewhys fw1 = new Fivewhys();
       fw1.setSolution_fivewhys(Arrays.asList(new Solution("1", "solution1")));

       // Fivewhys without solutions
       Fivewhys fw2 = new Fivewhys();
       fw2.setSolution_fivewhys(null);
       Fivewhys fw3 = new Fivewhys();
       fw3.setSolution_fivewhys(Collections.emptyList());
       // Another Fivewhys with solutions
       Fivewhys fw4 = new Fivewhys();
       fw4.setSolution_fivewhys(Arrays.asList(new Solution("2", "solution2")));
       List<Fivewhys> fivewhysList = Arrays.asList(fw1, fw2, fw3, fw4);
       when(fiveWhysRepository.findByIdproject(projectId)).thenReturn(fivewhysList);

       // Act
       long count = fiveWhysService.countFivewhysWithoutSolutionByProject(projectId);

       // Assert
       assertEquals(2, count, "The count of Five Whys without solutions should be 2.");
       verify(fiveWhysRepository, times(1)).findByIdproject(projectId);
       System.out.println(count);
   }
*/

   /* @Test
    void testCountByCategorieProblem() {
        // Arrange
        String projectId = "proj123";

        Fivewhys fw1 = new Fivewhys();
        fw1.setCategorieProblem(CategorieProblem.HR);

        Fivewhys fw2 = new Fivewhys();
        fw2.setCategorieProblem(CategorieProblem.HR);

        Fivewhys fw3 = new Fivewhys();
        fw3.setCategorieProblem(CategorieProblem.Strategic);

        List<Fivewhys> fivewhysList = Arrays.asList(fw1, fw2, fw3);

        when(fiveWhysRepository.findByIdproject(projectId)).thenReturn(fivewhysList);

        // Expected result
        Map<String, Long> expectedCounts = new HashMap<>();
        expectedCounts.put("HR", 2L);
        expectedCounts.put("Strategic", 1L);

        // Act
        Map<String, Long> actualCounts = fiveWhysService.countByCategorieProblem(projectId);

        // Assert
        assertEquals(expectedCounts, actualCounts, "The category counts should match the expected values.");
        verify(fiveWhysRepository, times(1)).findByIdproject(projectId);
        System.out.println(actualCounts);
    }*/
  /* @Test
   void testCalculateKanbanProgress() {
       // Arrange
       String kanbanId = "kanban123";

       // Mock data
       List<Card> cards = Arrays.asList(
               new Card("1", Status.TODO),
               new Card("2", Status.INPROGRESS),
               new Card("3", Status.DONE),
               new Card("4", Status.INPROGRESS),
               new Card("5", Status.TODO)
       );
       when(cardRepository.findCardsByKanbanIdkanban(kanbanId)).thenReturn(cards);
       Map<String, Object> progressMap = kanbanService.calculateKanbanProgress(kanbanId);
       // Assert
       assertNotNull(progressMap);
       assertTrue(progressMap.containsKey("progress"));
       Double progress = (Double) progressMap.get("progress");
       assertNotNull(progress);
       int totalCards = cards.size();
       long todoCount = cards.stream().filter(card -> card.getStatus() == Status.TODO).count();
       long inProgressCount = cards.stream().filter(card -> card.getStatus() == Status.INPROGRESS).count();
       long doneCount = cards.stream().filter(card -> card.getStatus() == Status.DONE).count();

       double expectedProgress = totalCards > 0 ? ((todoCount * 0 + inProgressCount * 0.5 + doneCount * 1) * 100.0 / totalCards) : 0.0;

       assertEquals(expectedProgress, progress, 0.01, "Calculated progress should match the expected value");
       System.out.println(expectedProgress);
   }
*/
  /* @Test
   void testCountActionItemsPerFailureMode() {
       // Arrange
       String projectCharterId = "project123";

       // Create sample ActionItems
       ActionItem actionItem1 = new ActionItem("1", false); // not archived
       ActionItem actionItem2 = new ActionItem("2", true); // archived
       ActionItem actionItem3 = new ActionItem("3", false); // not archived

       // Create sample FailureModes
       FailureMode failureMode1 = new FailureMode("fm1", "Failure Mode 1", Arrays.asList(actionItem1, actionItem2));
       FailureMode failureMode2 = new FailureMode("fm2", "Failure Mode 2", Collections.singletonList(actionItem3));

       // Create sample Fmea and ensure failureModes is initialized
       Fmea fmea1 = new Fmea("fmea1",projectCharterId, "FMEA 1",  Arrays.asList(new FailureMode("fm1", "Failure Mode 1", Arrays.asList(new ActionItem("3", false)))), false);



       Mockito.when(fmeaRepository.findByProjectCharterIdAndArchive(projectCharterId,false)).thenReturn(Arrays.asList(fmea1));

       // Act
       Map<String, Map<String, Long>> result = fmeaService.countActionItemsPerFailureMode(projectCharterId);

       // Assert
       Assertions.assertNotNull(result);
       assertEquals(1, result.size(), "Result map should have one FMEA entry");

       System.out.println(" test validated");
       System.out.println(result);

   }
*/
  /* @Test
   void testCalculateIsMetPercentageByProjectCharterId() {
       // Arrange
       String projectCharterId = "project123";

       // Create sample Ctq instances
       Ctq ctq1 = new Ctq("ctq1", "CTQ 1", true); // Met
       Ctq ctq2 = new Ctq("ctq2", "CTQ 2", false); // Not Met
       Ctq ctq3 = new Ctq("ctq3", "CTQ 3", true); // Met

       // Create sample Requirement instances
       Requirement req1 = new Requirement("req1", "Requirement 1", projectCharterId, Arrays.asList(ctq1, ctq2));
       Requirement req2 = new Requirement("req2", "Requirement 2", projectCharterId, Collections.singletonList(ctq3));

       // Mock repository to return the list of Requirements
       when(requirementRepository.findByProjectid(projectCharterId)).thenReturn(Arrays.asList(req1, req2));

       // Act
       Map<String, Double> result = ctqService.calculateIsMetPercentageByProjectCharterId(projectCharterId);

       // Assert
       Map<String, Double> expected = new HashMap<>();
       expected.put("Requirement 1", 50.0); // 1 out of 2 CTQs met
       expected.put("Requirement 2", 100.0); // 1 out of 1 CTQs met

       assertEquals(expected, result, "The calculated percentages should match the expected values.");
       System.out.println(result);
   }*/
    /*
    @Test
   public void testCalculateDefectRateByProjectCharterId() {
       // Prepare mock data
       Ctq ctq1 = new Ctq("ctq1", "CTQ 1", true);
       Ctq ctq2 = new Ctq("ctq2", "CTQ 2", false);
       Ctq ctq3 = new Ctq("ctq3", "CTQ 3", false);

       Requirement req1 = new Requirement("req1", "Requirement 1", "projectCharterId", Arrays.asList(ctq1, ctq2));
       Requirement req2 = new Requirement("req2", "Requirement 2", "projectCharterId", Collections.singletonList(ctq3));

       List<Requirement> mockRequirements = Arrays.asList(req1, req2);

       // Mock the repository method
       when(requirementRepository.findByProjectid("projectCharterId")).thenReturn(mockRequirements);

       // Call the method under test
       double defectRate = ctqService.calculateDefectRateByProjectCharterId("projectCharterId");

       // Verify the result
       // Total CTQs = 3, Defective CTQs = 2, so Defect Rate = 2 / 3 ≈ 0.6667
       assertEquals(0.6667, defectRate, 0.01);
       System.out.println(defectRate);
   }*/

    /*@Test
    public void testGetCardStatusPercentages() {
        // Create a Kanban object
        Kanban kanban = new Kanban("kanban1", "project1", "Test Kanban", new Date(),null);

        // Create Cards with different statuses
        Card card1 = new Card("1", "Card 1", "Description 1", new Date(), Priority.High, Status.TODO, kanban);
        Card card2 = new Card("2", "Card 2", "Description 2", new Date(), Priority.High, Status.INPROGRESS, kanban);
        Card card3 = new Card("3", "Card 3", "Description 3", new Date(), Priority.High, Status.DONE, kanban);
        Card card4 = new Card("4", "Card 4", "Description 4", new Date(), Priority.High, Status.TODO, kanban);

        // Ensure all cards are correctly linked to the Kanban
        kanban.setCards(Arrays.asList(card1, card2, card3, card4));

        // Mock the repository method to return the cards
        when(cardRepository.findByKanbanIdkanban("kanban1")).thenReturn(kanban.getCards());

        // Call the method under test
        Map<String, Double> result = kanbanService.getCardStatusPercentages("kanban1");

        // Debug prints
        System.out.println("Result Map: " + result);

        // Verify the results
        assertEquals(50.00, result.get("TODO"));
        assertEquals(25.00, result.get("INPROGRESS"));
        assertEquals(25.00, result.get("DONE"));
    }
*/
  /*  @Test
    public void testGetCardPercentagePerMonth() {
        // Create a Kanban object
        Kanban kanban = new Kanban("kanban1", "project1", "Test Kanban", new Date(), null);

        // Create cards with different creation dates
        Card card1 = new Card("1", "Card 1", "Description 1", Date.from(LocalDate.of(2023, 7, 10)
                .atStartOfDay(ZoneId.systemDefault()).toInstant()), Priority.High, Status.TODO, kanban);
        Card card2 = new Card("2", "Card 2", "Description 2", Date.from(LocalDate.of(2023, 7, 20)
                .atStartOfDay(ZoneId.systemDefault()).toInstant()), Priority.High, Status.INPROGRESS, kanban);
        Card card3 = new Card("3", "Card 3", "Description 3", Date.from(LocalDate.of(2023, 8, 5)
                .atStartOfDay(ZoneId.systemDefault()).toInstant()), Priority.High, Status.DONE, kanban);
        Card card4 = new Card("4", "Card 4", "Description 4", Date.from(LocalDate.of(2023, 8, 15)
                .atStartOfDay(ZoneId.systemDefault()).toInstant()), Priority.High, Status.TODO, kanban);

        // Ensure all cards are correctly linked to the Kanban
        kanban.setCards(Arrays.asList(card1, card2, card3, card4));

        // Mock the repository method to return the cards
        when(cardRepository.findByKanbanIdkanban("kanban1")).thenReturn(kanban.getCards());

        // Call the method under test
        Map<String, Double> result = kanbanService.getCardPercentagePerMonth("kanban1");

        // Debug prints
        System.out.println("Result Map: " + result);

        // Verify the results
        assertEquals(50.0, result.get("2023-7")); // 2 out of 4 cards in July
        assertEquals(50.0, result.get("2023-8")); // 2 out of 4 cards in August
    }

*/
}
