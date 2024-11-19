package lean.toc.manajerobackend.services.Lss_services.Test;

import lean.toc.manajerobackend.ManajeroBackendApplication;
import lean.toc.manajerobackend.models.Lss_models.Fivewhys.Fivewhys;
import lean.toc.manajerobackend.models.Lss_models.Fivewhys.Solution;
import lean.toc.manajerobackend.models.Lss_models.Kanbanboard.Card;
import lean.toc.manajerobackend.models.Lss_models.Kanbanboard.Kanban;
import lean.toc.manajerobackend.models.Lss_models.Kanbanboard.Priority;
import lean.toc.manajerobackend.models.Lss_models.Kanbanboard.Status;
import lean.toc.manajerobackend.repositories.Lss_repositories.CTQ.CtqRepository;
import lean.toc.manajerobackend.repositories.Lss_repositories.UserRepository;
import lean.toc.manajerobackend.repositories.Lss_repositories.CTQ.RequirementRepository;
import lean.toc.manajerobackend.repositories.Lss_repositories.FMEA.ActionItemRepository;
import lean.toc.manajerobackend.repositories.Lss_repositories.FMEA.FailureModeRepository;
import lean.toc.manajerobackend.repositories.Lss_repositories.FMEA.FmeaRepository;
import lean.toc.manajerobackend.repositories.Lss_repositories.FiveWhy.FiveWhysRepository;
import lean.toc.manajerobackend.repositories.Lss_repositories.FiveWhy.SolutionRepository;
import lean.toc.manajerobackend.repositories.Lss_repositories.FiveWhy.WhysRepository;
import lean.toc.manajerobackend.repositories.Lss_repositories.Kanban.CardRepository;
import lean.toc.manajerobackend.repositories.Lss_repositories.Kanban.KanbanRepository;
import lean.toc.manajerobackend.repositories.Lss_repositories.Prototype.FeedbackRepository;
import lean.toc.manajerobackend.repositories.Lss_repositories.Prototype.PrototypeImgRepository;
import lean.toc.manajerobackend.repositories.Lss_repositories.Prototype.PrototypeRepository;
import lean.toc.manajerobackend.repositories.Lss_repositories.SIPOC.*;
import lean.toc.manajerobackend.services.Lss_services.CTQ.CtqServiceImpl;
import lean.toc.manajerobackend.services.Lss_services.CTQ.RequirementServiceImpl;
import lean.toc.manajerobackend.services.Lss_services.FMEA.ActionItemServiceImpl;
import lean.toc.manajerobackend.services.Lss_services.FMEA.FailureModeServiceImpl;
import lean.toc.manajerobackend.services.Lss_services.FMEA.FmeaServiceImpl;
import lean.toc.manajerobackend.services.Lss_services.FiveWhysServiceImpl;
import lean.toc.manajerobackend.services.Lss_services.KanbanServiceImpl;
import lean.toc.manajerobackend.services.Lss_services.Prototype.FeedbackServiceImpl;
import lean.toc.manajerobackend.services.Lss_services.Prototype.PrototypeImgServiceImpl;
import lean.toc.manajerobackend.services.Lss_services.Prototype.PrototypeServiceImpl;
import lean.toc.manajerobackend.services.Lss_services.SipocServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;


@SpringBootTest(classes = ManajeroBackendApplication.class)
@ExtendWith(MockitoExtension.class)
public class Sprint2Test {

    @InjectMocks
    private FmeaServiceImpl fmeaService;
    @InjectMocks
    private FiveWhysServiceImpl fiveWhysService;

    @InjectMocks
    private FailureModeServiceImpl failureModeService;
    @InjectMocks
    private ActionItemServiceImpl actionItemService;
    @InjectMocks
    private PrototypeServiceImpl prototypeService;
    @InjectMocks
    private PrototypeImgServiceImpl prototypeImgService;
    @InjectMocks
    private FeedbackServiceImpl feedbackService;
    @Mock
    private PrototypeImgRepository prototypeImgRepository;
    @Mock
    private FiveWhysRepository fiveWhysRepository;
    @Mock
    private WhysRepository whysRepository;
    @Mock
    private PrototypeRepository prototypeRepository;
    @Mock
    private FeedbackRepository feedbackRepository;

    @Mock
    private FmeaRepository fmeaRepository;
    @Mock
    private FailureModeRepository failureModeRepository;
    @Mock
    private ActionItemRepository actionItemRepository;
    @Mock
    private RequirementRepository requirementRepository;
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private RequirementServiceImpl requirementService;
    @InjectMocks
    private CtqServiceImpl ctqService;
    @Mock
    private CtqRepository ctqRepository;
    @InjectMocks
    private SipocServiceImpl sipocService;


    @Mock
    private SipocRepository sipocRepository;
    @InjectMocks
    private KanbanServiceImpl kanbanService;
    @Mock
    private CardRepository cardRepository;

    @Mock
    private KanbanRepository kanbanRepository;
    @Mock
    private SolutionRepository solutionRepository;
    @Mock
private SupplierRepository supplierRepository;
    @Mock
private OutputRepository outputRepository;
    @Mock
private ProcessRepository processRepository;
    @Mock
private InputRepository inputRepository;
    @Mock
private CustomerRepository customerRepository;


    private Fivewhys fivewhys;
    private Solution solution;

    private Solution existingSolution;
    private Solution updatedSolution;

    private Kanban kanban;
    private Card card;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        kanban = new Kanban();
        kanban.setId_project("project1");
        kanban.setCards(new ArrayList<>());

        card = new Card();
        card.setId_card("card1");
        card.setTitle_card("Card Title");
        card.setDesciption_card("Card Description");
        card.setCreation_card(new Date());
        card.setPriority_card(Priority.High); // Adjust as necessary
        card.setStatus(Status.TODO); // Adjust as necessary
        // Initialize test data
        fivewhys = new Fivewhys();
        fivewhys.setId_fivewhys("1");
        fivewhys.setSolution_fivewhys(new ArrayList<>());

        solution = new Solution();
        solution.setId_solution("1");
        solution.setDescription_solution("New Solution");

        existingSolution = new Solution();
        existingSolution.setId_solution("1");
        existingSolution.setDescription_solution("Old Solution");

        updatedSolution = new Solution();
        updatedSolution.setId_solution("1");
        updatedSolution.setDescription_solution("Updated Solution");
    }
//////////////////////////////SIPOC*****************************
   /* @Test
    public void testCreateSipoc() {
        // Arrange
        String projectCharterId = "66a1016a1d25ce47a7a519e2";
        Sipoc sipoc = new Sipoc();
        sipoc.setAddDate(new Date());
        sipoc.setProcess_sipoc(Arrays.asList(new Processsipoc("1", "processTest")));
        sipoc.setCustomer_sipoc(Arrays.asList(new Customer("1", "customerTest")));
        sipoc.setSupplier_sipoc(Arrays.asList(new Supplier("1", "supplierTest")));
        sipoc.setOutput_sipoc(Arrays.asList(new Output("1", "outputTest")));
        sipoc.setInput_sipoc(Arrays.asList(new Input("1", "inputTest")));

        when(sipocRepository.save(Mockito.any(Sipoc.class))).thenReturn(sipoc);

        // Act
        Sipoc result = sipocService.createSipoc(projectCharterId, sipoc);

        // Assert
        Assertions.assertNotNull(result);
        Assertions.assertEquals(sipoc.getAddDate(), result.getAddDate());
        Assertions.assertEquals(sipoc.getInput_sipoc(), result.getInput_sipoc());
        Assertions.assertEquals(sipoc.getOutput_sipoc(), result.getOutput_sipoc());
        Assertions.assertEquals(sipoc.getCustomer_sipoc(), result.getCustomer_sipoc());
        Assertions.assertEquals(sipoc.getSupplier_sipoc(), result.getSupplier_sipoc());
        Assertions.assertEquals(sipoc.getProcess_sipoc(), result.getProcess_sipoc());

        System.out.println("Test validated");
    }*/
/*
    @Test
    void viewSipocByProjectCharterId() {
        // Arrange
        String projectCharterId = "66aab166d937de03e6a5bd78";
        Sipoc sipoc = new Sipoc("111", new Date(), projectCharterId,
                Arrays.asList(new Supplier("1", "supplierTest")),
                Arrays.asList(new Input("1", "inputTest")),
                Arrays.asList(new Processsipoc("1", "processTest")),
                Arrays.asList(new Output("1", "outputTest")),
                Arrays.asList(new Customer("1", "customerTest"))
        );

        Mockito.when(sipocRepository.findByIdproject(projectCharterId)).thenReturn(Optional.of(sipoc));

        // Act
        Sipoc result = sipocService.getSIPOCByProjectCharterId(projectCharterId);

        // Assert
        Assertions.assertNotNull(result);
        Assertions.assertEquals("111", result.getId_sipoc());
        Assertions.assertEquals("supplierTest", result.getSupplier_sipoc().get(0).getName());
        Assertions.assertEquals("inputTest", result.getInput_sipoc().get(0).getName());
        Assertions.assertEquals("processTest", result.getProcess_sipoc().get(0).getName());
        Assertions.assertEquals("outputTest", result.getOutput_sipoc().get(0).getName());
        Assertions.assertEquals("customerTest", result.getCustomer_sipoc().get(0).getName());

        System.out.println("viewSipocByProjectCharterId test validated");
        System.out.println(result);
    }
*/

  /*  @Test
    void testdeleteSipoc() {
        String sipocId = "111";
        Sipoc sipoc = new Sipoc(
                sipocId,
                new Date(),
                "66aab166d937de03e6a5bd78",
                Arrays.asList(new Supplier("1", "supplierTest")),
                Arrays.asList(new Input("1", "inputTest")),
                Arrays.asList(new Processsipoc("1", "processTest")),
                Arrays.asList(new Output("1", "outputTest")),
                Arrays.asList(new Customer("1", "customerTest"))
        );

        // Mocking repository responses
        Mockito.when(sipocRepository.findById(sipocId)).thenReturn(Optional.of(sipoc));
        // Act
        sipocService.deleteSipoc(sipocId);

        // Assert
        // Verify that deleteById was called for all related entities
        Mockito.verify(supplierRepository, Mockito.times(1)).deleteById("1");
        Mockito.verify(inputRepository, Mockito.times(1)).deleteById("1");
        Mockito.verify(processRepository, Mockito.times(1)).deleteById("1");
        Mockito.verify(outputRepository, Mockito.times(1)).deleteById("1");
        Mockito.verify(customerRepository, Mockito.times(1)).deleteById("1");

        // Verify that the deleteById was called for the Sipoc itself
        Mockito.verify(sipocRepository, Mockito.times(1)).deleteById(sipocId);

        System.out.println("deleteSipoc test validated");
    }
*/
    ///SUPPLIERS********************************
 /* @Test
  void addSupplier() {
      String sipocId = "111";
      Supplier newSupplier = new Supplier("2", "newSupplierTest");
      Sipoc existingSipoc = new Sipoc(
              sipocId,
              new Date(),
              "66aab166d937de03e6a5bd78",
              new ArrayList<>(Arrays.asList(new Supplier("1", "supplierTest"))),
              Arrays.asList(new Input("1", "inputTest")),
              Arrays.asList(new Processsipoc("1", "processTest")),
              Arrays.asList(new Output("1", "outputTest")),
              Arrays.asList(new Customer("1", "customerTest"))
      );
      // Prepare the expected result with the new supplier added
      List<Supplier> updatedSuppliers = new ArrayList<>(existingSipoc.getSupplier_sipoc());
      updatedSuppliers.add(newSupplier);
      Sipoc updatedSipoc = new Sipoc(
              sipocId,
              existingSipoc.getAddDate(),
              existingSipoc.getIdproject(),
              updatedSuppliers,
              existingSipoc.getInput_sipoc(),
              existingSipoc.getProcess_sipoc(),
              existingSipoc.getOutput_sipoc(),
              existingSipoc.getCustomer_sipoc()
      );
      // Mock repository responses
      Mockito.when(sipocRepository.findById(sipocId)).thenReturn(Optional.of(existingSipoc));
      Mockito.when(supplierRepository.save(newSupplier)).thenReturn(newSupplier);
      Mockito.when(sipocRepository.save(existingSipoc)).thenReturn(updatedSipoc);
      // Act
      Sipoc result = sipocService.addSupplier(sipocId, newSupplier);
      // Assert
      Assertions.assertNotNull(result, "The result should not be null");
      Assertions.assertTrue(result.getSupplier_sipoc().contains(newSupplier), "The new supplier should be in the list");
      Assertions.assertEquals(updatedSipoc.getSupplier_sipoc().size(), result.getSupplier_sipoc().size(), "The supplier list size should be correct");

      // Verify repository interactions
      Mockito.verify(supplierRepository, Mockito.times(1)).save(newSupplier);
      Mockito.verify(sipocRepository, Mockito.times(1)).findById(sipocId);
      Mockito.verify(sipocRepository, Mockito.times(1)).save(existingSipoc);

      System.out.println("addSupplier test validated");
  }
*/

    /*
  @Test
  void testRemoveSupplier() {
      // Arrange
      String sipocId = "111";
      String supplierId = "2";
      Supplier supplierToRemove = new Supplier(supplierId, "supplierToRemove");
      Sipoc existingSipoc = new Sipoc(
              sipocId,
              new Date(),
              "66aab166d937de03e6a5bd78",
              new ArrayList<>(Arrays.asList(
                      new Supplier("1", "existingSupplier1"),
                      supplierToRemove
              )),
              Arrays.asList(new Input("1", "inputTest")),
              Arrays.asList(new Processsipoc("1", "processTest")),
              Arrays.asList(new Output("1", "outputTest")),
              Arrays.asList(new Customer("1", "customerTest"))
      );
      // Mock repository responses
      Mockito.when(sipocRepository.findById(sipocId)).thenReturn(Optional.of(existingSipoc));
      Mockito.when(supplierRepository.findById(supplierId)).thenReturn(Optional.of(supplierToRemove));
      Mockito.when(sipocRepository.save(existingSipoc)).thenReturn(existingSipoc);

      // Act
      Sipoc result = sipocService.removeSupplier(sipocId, supplierId);

      // Assert
      Assertions.assertNotNull(result, "The result should not be null");
      Assertions.assertFalse(result.getSupplier_sipoc().contains(supplierToRemove), "The supplier should be removed from the list");
      System.out.println("removeSupplier test validated");
  }*/

  /*  @Test
    void testUpdateSupplier() {
        // Arrange
        String supplierId = "2";
        Supplier existingSupplier = new Supplier(supplierId, "oldSupplierName");
        Supplier updatedSupplier = new Supplier(supplierId, "newSupplierName");

        // Mock repository responses
        Mockito.when(supplierRepository.findById(supplierId)).thenReturn(Optional.of(existingSupplier));
        Mockito.when(supplierRepository.save(existingSupplier)).thenReturn(existingSupplier);

        // Act
        Supplier result = sipocService.updateSupplier(supplierId, updatedSupplier);

        // Assert
        Assertions.assertNotNull(result, "The result should not be null");
        Assertions.assertEquals(updatedSupplier.getName(), result.getName(), "The supplier name should be updated");

        // Verify repository interactions
        Mockito.verify(supplierRepository, Mockito.times(1)).findById(supplierId);
        Mockito.verify(supplierRepository, Mockito.times(1)).save(existingSupplier);

        System.out.println("updateSupplier test validated");
    }*/


    /*
    ///////////////////////////////////////INPUTS//***********************
  @Test
  void TestAddInput() {
      String sipocId = "111";
      Input newInput = new Input("2", "newInputTest");
      Sipoc existingSipoc = new Sipoc(
              sipocId,
              new Date(),
              "66aab166d937de03e6a5bd78",
              Arrays.asList(new Supplier("1", "SupplierTest")),
              new ArrayList<>(Arrays.asList(new Input("1", "inputTest"))),
              Arrays.asList(new Processsipoc("1", "processTest")),
              Arrays.asList(new Output("1", "outputTest")),
              Arrays.asList(new Customer("1", "customerTest"))
      );
      // Prepare the expected result with the new Input added
      List<Input> updatedInputs = new ArrayList<>(existingSipoc.getInput_sipoc());
      updatedInputs.add(newInput);
      Sipoc updatedSipoc = new Sipoc(
              sipocId,
              existingSipoc.getAddDate(),
              existingSipoc.getIdproject(),
              existingSipoc.getSupplier_sipoc(),
              updatedInputs,
              existingSipoc.getProcess_sipoc(),
              existingSipoc.getOutput_sipoc(),
              existingSipoc.getCustomer_sipoc()
      );
      // Mock repository responses
      Mockito.when(sipocRepository.findById(sipocId)).thenReturn(Optional.of(existingSipoc));
      Mockito.when(inputRepository.save(newInput)).thenReturn(newInput);
      Mockito.when(sipocRepository.save(existingSipoc)).thenReturn(updatedSipoc);
      // Act
      Sipoc result = sipocService.addInput(sipocId, newInput);
      // Assert
      Assertions.assertNotNull(result, "The result should not be null");
      Assertions.assertTrue(result.getInput_sipoc().contains(newInput));
      Assertions.assertEquals(updatedSipoc.getInput_sipoc().size(), result.getInput_sipoc().size());

      System.out.println("addInput test validated");
  }*/

  /*  @Test
    public void testUpdateInput() {
        // Initialize Mockito annotations
        MockitoAnnotations.openMocks(this);

        // Create test data
        Input existingInput = new Input();
        existingInput.setId_input("input1");
        existingInput.setName("Old Name");

        Input updatedInput = new Input();
        updatedInput.setId_input("input1");
        updatedInput.setName("New Name");

        // Mock repository methods
        when(inputRepository.findById("input1")).thenReturn(Optional.of(existingInput));
        when(inputRepository.save(existingInput)).thenReturn(existingInput);

        // Call the method under test
        Input result = sipocService.updateInput("input1", updatedInput);

        // Verify interactions and assert results
        verify(inputRepository).findById("input1");
        verify(inputRepository).save(existingInput);
        assertNotNull(result, "Updated input should not be null");
        assertEquals("New Name", result.getName(), "Input name should be updated");
    }*/
   /* @Test
    public void testRemoveInput() {
        // Initialize Mockito annotations
        MockitoAnnotations.openMocks(this);

        // Create test data
        Sipoc existingSipoc = new Sipoc();
        existingSipoc.setId_sipoc("sipoc1");

        Input inputToRemove = new Input();
        inputToRemove.setId_input("input1");
        inputToRemove.setName("Input to Remove");

        List<Input> inputList = new ArrayList<>();
        inputList.add(inputToRemove);
        existingSipoc.setInput_sipoc(inputList);

        // Mock repository methods
        when(sipocRepository.findById("sipoc1")).thenReturn(Optional.of(existingSipoc));
        when(inputRepository.findById("input1")).thenReturn(Optional.of(inputToRemove));
        when(sipocRepository.save(existingSipoc)).thenReturn(existingSipoc);
        doNothing().when(inputRepository).deleteById("input1");

        // Call the method under test
        Sipoc result = sipocService.removeInput("sipoc1", "input1");

        // Verify interactions and assert results
        verify(sipocRepository).findById("sipoc1");
        verify(inputRepository).findById("input1");
        verify(sipocRepository).save(existingSipoc);
        verify(inputRepository).deleteById("input1");

        assertNotNull(result, "Resulting Sipoc should not be null");
        assertTrue(result.getInput_sipoc().isEmpty());
    }*/

    ///////////////////////////////PROCESSES///////////////////////////////////////
   /* @Test
    public void testAddProcess() {
        // Initialize Mockito annotations
        MockitoAnnotations.openMocks(this);

        // Create test data
        Sipoc existingSipoc = new Sipoc();
        existingSipoc.setId_sipoc("sipoc1");

        Processsipoc newProcess = new Processsipoc();
        newProcess.setId_process(null); // Ensure ID is null for new processes

        List<Processsipoc> processList = new ArrayList<>();
        existingSipoc.setProcess_sipoc(processList);

        // Mock repository methods
        when(sipocRepository.findById("sipoc1")).thenReturn(Optional.of(existingSipoc));
        when(processRepository.save(newProcess)).thenReturn(newProcess);
        when(sipocRepository.save(existingSipoc)).thenReturn(existingSipoc);

        // Call the method under test
        Sipoc result = sipocService.addProcess("sipoc1", newProcess);

        // Verify interactions and assert results
        verify(sipocRepository).findById("sipoc1");
        verify(processRepository).save(newProcess);
        verify(sipocRepository).save(existingSipoc);

        assertNotNull(result, "Resulting Sipoc should not be null");
        assertTrue(result.getProcess_sipoc().contains(newProcess));
    }*/
  /*  @Test
    public void testRemoveProcess() {
        // Initialize Mockito annotations
        MockitoAnnotations.openMocks(this);

        // Create test data
        Sipoc existingSipoc = new Sipoc();
        existingSipoc.setId_sipoc("sipoc1");

        Processsipoc processToRemove = new Processsipoc();
        processToRemove.setId_process("process1");
        processToRemove.setName("Process to Remove");

        List<Processsipoc> processList = new ArrayList<>();
        processList.add(processToRemove);
        existingSipoc.setProcess_sipoc(processList);

        // Mock repository methods
        when(sipocRepository.findById("sipoc1")).thenReturn(Optional.of(existingSipoc));
        when(processRepository.findById("process1")).thenReturn(Optional.of(processToRemove));
        when(sipocRepository.save(existingSipoc)).thenReturn(existingSipoc);
        doNothing().when(processRepository).deleteById("process1");

        // Call the method under test
        Sipoc result = sipocService.removeProcess("sipoc1", "process1");

        // Verify interactions and assert results
        verify(sipocRepository).findById("sipoc1");
        verify(processRepository).findById("process1");
        verify(sipocRepository).save(existingSipoc);
        verify(processRepository).deleteById("process1");

        assertNotNull(result, "Resulting Sipoc should not be null");
        assertFalse(result.getProcess_sipoc().contains(processToRemove));
    }*/
  /*  @Test
    public void testUpdateProcess() {
        // Initialize Mockito annotations
        MockitoAnnotations.openMocks(this);

        // Create test data
        Processsipoc existingProcess = new Processsipoc();
        existingProcess.setId_process("process1");
        existingProcess.setName("Old Name");

        Processsipoc updatedProcess = new Processsipoc();
        updatedProcess.setId_process("process1");
        updatedProcess.setName("New Name");

        // Mock repository methods
        when(processRepository.findById("process1")).thenReturn(Optional.of(existingProcess));
        when(processRepository.save(existingProcess)).thenReturn(existingProcess);

        // Call the method under test
        Processsipoc result = sipocService.updateProcess("process1", updatedProcess);

        // Verify interactions and assert results
        verify(processRepository).findById("process1");
        verify(processRepository).save(existingProcess);

        assertNotNull(result, "Updated process should not be null");
        assertEquals("New Name", result.getName(), "Process name should be updated");
    }*/
/////////////////////////////////OUTPUT///////////////////////////////////
   /* @Test
    public void testAddOutput() {
        // Initialize Mockito annotations
        MockitoAnnotations.openMocks(this);

        // Create test data
        Sipoc existingSipoc = new Sipoc();
        existingSipoc.setId_sipoc("sipoc1");

        Output newOutput = new Output();
        newOutput.setId_output(null); // Ensure ID is null for new outputs

        List<Output> outputList = new ArrayList<>();
        existingSipoc.setOutput_sipoc(outputList);

        // Mock repository methods
        when(sipocRepository.findById("sipoc1")).thenReturn(Optional.of(existingSipoc));
        when(outputRepository.save(newOutput)).thenReturn(newOutput);
        when(sipocRepository.save(existingSipoc)).thenReturn(existingSipoc);

        // Call the method under test
        Sipoc result = sipocService.addOutput("sipoc1", newOutput);

        // Verify interactions and assert results
        verify(sipocRepository).findById("sipoc1");
        verify(outputRepository).save(newOutput);
        verify(sipocRepository).save(existingSipoc);

        assertNotNull(result, "Resulting Sipoc should not be null");
        assertTrue(result.getOutput_sipoc().contains(newOutput));
    }*/

  /* @Test
    public void testUpdateOutput() {
        // Initialize Mockito annotations
        MockitoAnnotations.openMocks(this);

        // Create test data
        Output existingOutput = new Output();
        existingOutput.setId_output("output1");
        existingOutput.setName("Old Name");

        Output updatedOutput = new Output();
        updatedOutput.setId_output("output1");
        updatedOutput.setName("New Name");

        // Mock repository methods
        when(outputRepository.findById("output1")).thenReturn(Optional.of(existingOutput));
        when(outputRepository.save(existingOutput)).thenReturn(existingOutput);

        // Call the method under test
        Output result = sipocService.updateOutput("output1", updatedOutput);

        // Verify interactions and assert results
        verify(outputRepository).findById("output1");
        verify(outputRepository).save(existingOutput);

        assertNotNull(result, "Updated output should not be null");
        assertEquals("New Name", result.getName(), "Output name should be updated");
    }*/

   /* @Test
    public void testRemoveOutput() {
        // Initialize Mockito annotations
        MockitoAnnotations.openMocks(this);

        // Create test data
        Sipoc existingSipoc = new Sipoc();
        existingSipoc.setId_sipoc("sipoc1");

        Output outputToRemove = new Output();
        outputToRemove.setId_output("output1");
        outputToRemove.setName("Output to Remove");

        List<Output> outputList = new ArrayList<>();
        outputList.add(outputToRemove);
        existingSipoc.setOutput_sipoc(outputList);

        // Mock repository methods
        when(sipocRepository.findById("sipoc1")).thenReturn(Optional.of(existingSipoc));
        when(outputRepository.findById("output1")).thenReturn(Optional.of(outputToRemove));
        when(sipocRepository.save(existingSipoc)).thenReturn(existingSipoc);
        doNothing().when(outputRepository).deleteById("output1");

        // Call the method under test
        Sipoc result = sipocService.removeOutput("sipoc1", "output1");

        // Verify interactions and assert results
        verify(sipocRepository).findById("sipoc1");
        verify(outputRepository).findById("output1");
        verify(sipocRepository).save(existingSipoc);
        verify(outputRepository).deleteById("output1");

        assertNotNull(result, "Resulting Sipoc should not be null");
        assertFalse(result.getOutput_sipoc().contains(outputToRemove));
    }*/

    ///////////////////////////////CUSTOMER/////////////////////////////////
   /* @Test
    public void testAddCustomer() {
        // Initialize Mockito annotations
        MockitoAnnotations.openMocks(this);

        // Create test data
        Sipoc existingSipoc = new Sipoc();
        existingSipoc.setId_sipoc("sipoc1");

        Customer newCustomer = new Customer();
        newCustomer.setId_customer(null); // Ensure ID is null for new customers

        List<Customer> customerList = new ArrayList<>();
        existingSipoc.setCustomer_sipoc(customerList);

        // Mock repository methods
        when(sipocRepository.findById("sipoc1")).thenReturn(Optional.of(existingSipoc));
        when(customerRepository.save(newCustomer)).thenReturn(newCustomer);
        when(sipocRepository.save(existingSipoc)).thenReturn(existingSipoc);

        // Call the method under test
        Sipoc result = sipocService.addCustomer("sipoc1", newCustomer);

        // Verify interactions and assert results
        verify(sipocRepository).findById("sipoc1");
        verify(customerRepository).save(newCustomer);
        verify(sipocRepository).save(existingSipoc);

        assertNotNull(result, "Resulting Sipoc should not be null");
        assertTrue(result.getCustomer_sipoc().contains(newCustomer));
    }*/

  /* @Test
    public void testUpdateCustomer() {
        // Initialize Mockito annotations
        MockitoAnnotations.openMocks(this);

        // Create test data
        Customer existingCustomer = new Customer();
        existingCustomer.setId_customer("customer1");
        existingCustomer.setName("Old Name");

        Customer updatedCustomer = new Customer();
        updatedCustomer.setId_customer("customer1");
        updatedCustomer.setName("New Name");

        // Mock repository methods
        when(customerRepository.findById("customer1")).thenReturn(Optional.of(existingCustomer));
        when(customerRepository.save(existingCustomer)).thenReturn(existingCustomer);

        // Call the method under test
        Customer result = sipocService.updateCustomer("customer1", updatedCustomer);

        // Verify interactions and assert results
        verify(customerRepository).findById("customer1");
        verify(customerRepository).save(existingCustomer);

        assertNotNull(result, "Updated customer should not be null");
        assertEquals("New Name", result.getName(), "Customer name should be updated");
    }
*/
   /* @Test
    public void testRemoveCustomer() {
        // Initialize Mockito annotations
        MockitoAnnotations.openMocks(this);

        // Create test data
        Sipoc existingSipoc = new Sipoc();
        existingSipoc.setId_sipoc("sipoc1");

        Customer customerToRemove = new Customer();
        customerToRemove.setId_customer("customer1");
        customerToRemove.setName("Customer to Remove");

        List<Customer> customerList = new ArrayList<>();
        customerList.add(customerToRemove);
        existingSipoc.setCustomer_sipoc(customerList);

        // Mock repository methods
        when(sipocRepository.findById("sipoc1")).thenReturn(Optional.of(existingSipoc));
        when(customerRepository.findById("customer1")).thenReturn(Optional.of(customerToRemove));
        when(sipocRepository.save(existingSipoc)).thenReturn(existingSipoc);
        doNothing().when(customerRepository).deleteById("customer1");

        // Call the method under test
        Sipoc result = sipocService.removeCustomer("sipoc1", "customer1");

        // Verify interactions and assert results
        verify(sipocRepository).findById("sipoc1");
        verify(customerRepository).findById("customer1");
        verify(sipocRepository).save(existingSipoc);
        verify(customerRepository).deleteById("customer1");

        assertNotNull(result, "Resulting Sipoc should not be null");
        assertFalse(result.getCustomer_sipoc().contains(customerToRemove));
    }*/
/////////////////////////REQUIREMENT/CTQS**********************************
   /* @Test
    public void testAddCtq() {
        // Create a Requirement with an existing CTQ list
        Requirement requirement = new Requirement("1", "Test Requirement", "project1", new ArrayList<>());

        // Create a new CTQ to be added
        Ctq newCtq = new Ctq(null, "New CTQ", false, null);

        // Mock the repository methods
        when(requirementRepository.findById("1")).thenReturn(Optional.of(requirement));
        when(ctqRepository.save(any(Ctq.class))).thenAnswer(invocation -> {
            Ctq savedCtq = invocation.getArgument(0);
            savedCtq.setId("newCtqId");  // Simulate the setting of an ID upon saving
            return savedCtq;
        });
        when(requirementRepository.save(any(Requirement.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // Call the method under test
        Requirement updatedRequirement = ctqService.addCtq("1", newCtq);

        // Verify interactions
        verify(ctqRepository, times(1)).save(any(Ctq.class));
        verify(requirementRepository, times(1)).save(any(Requirement.class));

        // Verify that the returned Requirement object contains the new CTQ
        assertNotNull(updatedRequirement);
        assertEquals(1, updatedRequirement.getCtqs().size());
        assertEquals("New CTQ", updatedRequirement.getCtqs().get(0).getDescription());
        assertEquals("newCtqId", updatedRequirement.getCtqs().get(0).getId());
        assertEquals(requirement, updatedRequirement.getCtqs().get(0).getRequirement());
        assertFalse(updatedRequirement.getCtqs().get(0).isMet());
        System.out.println();
    }
*/
   /* @Test
    public void testUpdateCtq() {
        // Create an existing CTQ
        Ctq existingCtq = new Ctq("ctqId1", "Old Description", true, null);

        // Create an updated CTQ with a new description
        Ctq updatedCtq = new Ctq(null, "New Description", true, null);

        // Mock the repository methods
        when(ctqRepository.findById("ctqId1")).thenReturn(Optional.of(existingCtq));
        when(ctqRepository.save(any(Ctq.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // Call the method under test
        Ctq result = ctqService.updateCtq("ctqId1", updatedCtq);

        // Verify interactions
        verify(ctqRepository, times(1)).findById("ctqId1");
        verify(ctqRepository, times(1)).save(existingCtq);

        // Assert the result
        assertNotNull(result);
        assertEquals("New Description", result.getDescription());
        assertEquals("ctqId1", result.getId());  // Ensure the ID remains the same
    }
*/
  /*  @Test
    public void testRemoveCtq() {
        // Create a Ctq and a Requirement containing that Ctq
        Ctq ctq = new Ctq("ctqId1", "Sample Ctq", true, null);
        List<Ctq> ctqList = new ArrayList<>();
        ctqList.add(ctq);

        Requirement requirement = new Requirement("reqId1", "Sample Requirement", "projectId", ctqList);

        // Mock the repository methods
        when(requirementRepository.findById("reqId1")).thenReturn(Optional.of(requirement));
        when(ctqRepository.findById("ctqId1")).thenReturn(Optional.of(ctq));

        // Perform the removal
        Requirement updatedRequirement = ctqService.removeCtq("reqId1", "ctqId1");

        // Verify that the Ctq was removed from the Requirement
        verify(requirementRepository, times(1)).save(requirement);
        verify(ctqRepository, times(1)).deleteById("ctqId1");

        // Assertions
        assertNotNull(updatedRequirement);
        assertTrue(updatedRequirement.getCtqs().isEmpty()); // Ensure the Ctq was removed
        assertFalse(updatedRequirement.getCtqs().contains(ctq)); // Verify Ctq is not in the list anymore
    }
*/
  /*  @Test
    public void testGetCtqByReq() {
        // Create a list of Ctqs associated with a requirement ID
        String requirementId = "reqId1";
        List<Ctq> ctqs = Arrays.asList(
                new Ctq("ctqId1", "Description 1", true, null),
                new Ctq("ctqId2", "Description 2", false, null)
        );

        // Mock the ctqRepository to return the list of Ctqs when findByRequirementId is called
        when(ctqRepository.findByRequirementId(requirementId)).thenReturn(ctqs);

        // Call the method under test
        List<Ctq> result = ctqService.getCtqByReq(requirementId);

        // Assertions
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("ctqId1", result.get(0).getId());
        assertEquals("ctqId2", result.get(1).getId());

        // Verify that the repository method was called once
        verify(ctqRepository, times(1)).findByRequirementId(requirementId);
    }
*/
  /*  @Test
    public void testValidateCtq_WhenCtqExists() {
        // Arrange
        String ctqId = "ctqId1";
        Ctq ctq = new Ctq(ctqId, "Test Ctq", false, null);

        // Mocking the repository to return the CTQ when findById is called
        when(ctqRepository.findById(ctqId)).thenReturn(Optional.of(ctq));

        // Mocking the repository to save the updated CTQ
        when(ctqRepository.save(any(Ctq.class))).thenReturn(ctq);

        // Act
        Ctq result = ctqService.ValidateCtq(ctqId);

        // Assert
        assertNotNull(result);
        assertTrue(result.isMet()); // Check if the 'isMet' field is set to true
        verify(ctqRepository, times(1)).findById(ctqId);
        verify(ctqRepository, times(1)).save(ctq);
    }*/
   /* @Test
    public void testUnvalidateCtq_WhenCtqExists() {
        // Arrange
        String ctqId = "ctqId1";
        Ctq ctq = new Ctq(ctqId, "Test Ctq", true, null);

        // Mocking the repository to return the CTQ when findById is called
        when(ctqRepository.findById(ctqId)).thenReturn(Optional.of(ctq));

        // Mocking the repository to save the updated CTQ
        when(ctqRepository.save(any(Ctq.class))).thenReturn(ctq);

        // Act
        Ctq result = ctqService.UnvalidateCtq(ctqId);

        // Assert
        assertNotNull(result);
        assertFalse(result.isMet()); // Check if the 'isMet' field is set to false
        verify(ctqRepository, times(1)).findById(ctqId);
        verify(ctqRepository, times(1)).save(ctq);
    }
*/
 /*   @Test
    public void testAddRequirement_WithCtqs() {
        // Arrange
        String projectCharterId = "projectCharterId1";
        Requirement requirement = new Requirement();
        requirement.setDescription("New Requirement");
        requirement.setCtqs(new ArrayList<>(Arrays.asList(
                new Ctq(null, "Ctq 1", false, null),
                new Ctq(null, "Ctq 2", false, null)
        )));

        // Mocking the requirementRepository to return the saved requirement
        when(requirementRepository.save(any(Requirement.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // Mocking the ctqRepository to save CTQs
        when(ctqRepository.save(any(Ctq.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // Act
        Requirement result = requirementService.addRequirement(requirement, projectCharterId);

        // Assert
        assertNotNull(result);
        assertEquals(projectCharterId, result.getProjectid());
        assertEquals(2, result.getCtqs().size());
        assertTrue(result.getCtqs().stream().allMatch(ctq -> ctq.getId() == null && !ctq.isMet()));

        // Verify that the repositories were called
        verify(requirementRepository, times(2)).save(any(Requirement.class));
        verify(ctqRepository, times(2)).save(any(Ctq.class));
    }
*/
 /*   @Test
    public void testGetRequirementsByProjectId_ValidId() {
        // Arrange
        String projectCharterId = "validProjectCharterId";
        List<Requirement> expectedRequirements = Arrays.asList(
                new Requirement("req1", "Requirement 1", projectCharterId, new ArrayList<>()),
                new Requirement("req2", "Requirement 2", projectCharterId, new ArrayList<>())
        );

        // Mocking the requirementRepository to return the expected requirements
        when(requirementRepository.findByProjectid(projectCharterId)).thenReturn(expectedRequirements);

        // Act
        List<Requirement> actualRequirements = requirementService.getRequirementsByProjectId(projectCharterId);

        // Assert
        assertNotNull(actualRequirements);
        assertEquals(expectedRequirements.size(), actualRequirements.size());
        assertTrue(actualRequirements.containsAll(expectedRequirements));

        // Verify that the repository method was called with the correct ID
        verify(requirementRepository, times(1)).findByProjectid(projectCharterId);
    }*/
   /* @Test
    public void testDeleteRequirement_WithCtqs() {
        // Arrange
        String requirementId = "requirementId";
        Requirement requirement = new Requirement(requirementId, "Requirement Description", "projectCharterId", Arrays.asList(
                new Ctq("ctq1", "Ctq 1", false, null),
                new Ctq("ctq2", "Ctq 2", false, null)
        ));

        // Mocking the repository methods
        when(requirementRepository.findById(requirementId)).thenReturn(Optional.of(requirement));
        doNothing().when(ctqRepository).deleteById(anyString());
        doNothing().when(requirementRepository).deleteById(anyString());

        // Act
        requirementService.deleteRequirement(requirementId);

        // Assert
        // Verify that ctqRepository.deleteById was called for each Ctq
        verify(ctqRepository, times(2)).deleteById(anyString());

        // Verify that requirementRepository.deleteById was called once
        verify(requirementRepository, times(1)).deleteById(requirementId);
    }*/
  /*  @Test
    public void testUpdateRequirement_WithNewCtqs() {
        // Arrange
        String requirementId = "requirementId";
        Requirement existingRequirement = new Requirement(requirementId, "Old Description", "projectCharterId", Arrays.asList(
                new Ctq("ctq1", "Ctq 1", false, null)
        ));

        Requirement updatedRequirement = new Requirement(requirementId, "New Description", "projectCharterId", Arrays.asList(
                new Ctq("ctq2", "Ctq 2", false, null),
                new Ctq("ctq3", "Ctq 3", false, null)
        ));

        // Mocking repository methods
        when(requirementRepository.findById(requirementId)).thenReturn(Optional.of(existingRequirement));
        when(ctqRepository.save(any(Ctq.class))).thenAnswer(invocation -> invocation.getArguments()[0]); // Mock save to return the argument
        when(requirementRepository.save(any(Requirement.class))).thenAnswer(invocation -> invocation.getArguments()[0]);

        // Act
        Requirement result = requirementService.updateRequirement(updatedRequirement);

        // Assert
        assertNotNull(result);
        assertEquals("New Description", result.getDescription());
        assertEquals(2, result.getCtqs().size());
        assertTrue(result.getCtqs().stream().anyMatch(ctq -> ctq.getId().equals("ctq2")));
        assertTrue(result.getCtqs().stream().anyMatch(ctq -> ctq.getId().equals("ctq3")));

        verify(requirementRepository, times(1)).findById(requirementId);
        verify(ctqRepository, times(2)).save(any(Ctq.class));
        verify(requirementRepository, times(1)).save(existingRequirement);
    }
*/
    /////////FMEA FAILURE MODE AND ACTION ITEMS/////////////////////////////////////////////////
    /*@Test
    public void testCreateFmea() {
        // Arrange
        String projectCharterId = "projectCharterId";
        Fmea newFmea = new Fmea();
        newFmea.setTitle("New FMEA");
        newFmea.setDescription("Description of new FMEA");

        Fmea savedFmea = new Fmea();
        savedFmea.setId("fmeaId");
        savedFmea.setTitle("New FMEA");
        savedFmea.setDescription("Description of new FMEA");
        savedFmea.setProjectCharterId(projectCharterId);
        savedFmea.setArchive(false);
        savedFmea.setCreatedDate(new Date());
        savedFmea.setFailureModes(new ArrayList<>());

        when(fmeaRepository.save(any(Fmea.class))).thenReturn(savedFmea);

        // Act
        Fmea result = fmeaService.createFmea(newFmea, projectCharterId);

        // Assert
        assertNotNull(result);
        assertEquals("New FMEA", result.getTitle());
        assertEquals("Description of new FMEA", result.getDescription());
        assertEquals(projectCharterId, result.getProjectCharterId());
        assertFalse(result.getArchive());
        assertNotNull(result.getCreatedDate());
        assertTrue(result.getFailureModes().isEmpty());

        verify(fmeaRepository, times(1)).save(any(Fmea.class));
    }
*/
  /*  @Test
    public void testGetFmeasByProjectCharterId() {
        // Arrange
        String projectCharterId = "projectCharterId";
        Fmea fmea1 = new Fmea();
        fmea1.setId("fmeaId1");
        fmea1.setTitle("FMEA 1");
        fmea1.setProjectCharterId(projectCharterId);
        fmea1.setArchive(false);

        Fmea fmea2 = new Fmea();
        fmea2.setId("fmeaId2");
        fmea2.setTitle("FMEA 2");
        fmea2.setProjectCharterId(projectCharterId);
        fmea2.setArchive(false);

        List<Fmea> fmeas = Arrays.asList(fmea1, fmea2);

        when(fmeaRepository.findByProjectCharterIdAndArchive(projectCharterId, false)).thenReturn(fmeas);

        // Act
        List<Fmea> result = fmeaService.getFmeasByProjectCharterId(projectCharterId);

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(result.stream().allMatch(fmea -> !fmea.getArchive())); // Ensure all Fmeas are non-archived
        assertTrue(result.stream().allMatch(fmea -> fmea.getProjectCharterId().equals(projectCharterId)));

        verify(fmeaRepository, times(1)).findByProjectCharterIdAndArchive(projectCharterId, false);
    }
*/
  /*  @Test
    public void testGetArchivedFmeas() {
        // Arrange
        String projectCharterId = "projectCharterId";
        Fmea fmea1 = new Fmea();
        fmea1.setId("fmeaId1");
        fmea1.setTitle("Archived FMEA 1");
        fmea1.setProjectCharterId(projectCharterId);
        fmea1.setArchive(true);

        Fmea fmea2 = new Fmea();
        fmea2.setId("fmeaId2");
        fmea2.setTitle("Archived FMEA 2");
        fmea2.setProjectCharterId(projectCharterId);
        fmea2.setArchive(true);

        List<Fmea> archivedFmeas = Arrays.asList(fmea1, fmea2);

        when(fmeaRepository.findByProjectCharterIdAndArchive(projectCharterId, true)).thenReturn(archivedFmeas);

        // Act
        List<Fmea> result = fmeaService.getarchivedFmeas(projectCharterId);

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(result.stream().allMatch(fmea -> fmea.getArchive())); // Ensure all Fmeas are archived
        assertTrue(result.stream().allMatch(fmea -> fmea.getProjectCharterId().equals(projectCharterId)));

        verify(fmeaRepository, times(1)).findByProjectCharterIdAndArchive(projectCharterId, true);
    }
*/
  /*  @Test
    public void testDeleteFmea_Success() {
        // Arrange
        String fmeaId = "fmeaId";
        String actionItemId = "actionItemId";

        ActionItem ai = new ActionItem();
        ai.setId(actionItemId);

        FailureMode fm = new FailureMode();
        fm.setId(fmeaId);
        fm.setActionItems(Collections.singletonList(ai));

        Fmea fmea = new Fmea();
        fmea.setId(fmeaId);
        fmea.setFailureModes(Collections.singletonList(fm));

        // Mock repository responses
        when(fmeaRepository.findById(fmeaId)).thenReturn(Optional.of(fmea));

        // Act
        fmeaService.deleteFmea(fmeaId);

        // Assert
         verify(fmeaRepository, times(1)).deleteById(fmeaId);
    }

*/
  /*  @Test
    void updateFmea_Success() {
        // Arrange
        String fmeaId = "fmeaId";
        Date oldDate = new Date(0); // A fixed old date for comparison
        Fmea existingFmea = new Fmea(fmeaId, "Project1", "Old Title", null, false);
        existingFmea.setUpdatedDate(oldDate); // Set old date

        Fmea updatedFmea = new Fmea(fmeaId, "Project1", "New Title", null, false);
        updatedFmea.setCreatedDate(new Date());

        when(fmeaRepository.findById(fmeaId)).thenReturn(Optional.of(existingFmea));
        when(fmeaRepository.save(existingFmea)).thenReturn(existingFmea);

        // Act
        Fmea result = fmeaService.updateFmea(updatedFmea);

        // Assert
        assertNotNull(result);
        assertEquals("New Title", result.getTitle());
        assertNotEquals(oldDate, result.getUpdatedDate()); // Check if date is updated
        verify(fmeaRepository, times(1)).findById(fmeaId);
        verify(fmeaRepository, times(1)).save(existingFmea);
    }
*/
   /* @Test
    void archiveFMEA_Success() {
        // Arrange
        String fmeaId = "fmeaId";
        Fmea fmea = new Fmea();
        fmea.setId(fmeaId);
        fmea.setArchive(false);

        FailureMode failureMode = new FailureMode();
        failureMode.setId("failureModeId");
        failureMode.setArchive(false);

        ActionItem actionItem = new ActionItem();
        actionItem.setId("actionItemId");
        actionItem.setArchive(false);

        failureMode.setActionItems(List.of(actionItem));
        fmea.setFailureModes(List.of(failureMode));

        when(fmeaRepository.findById(fmeaId)).thenReturn(Optional.of(fmea));
        when(fmeaRepository.save(any(Fmea.class))).thenReturn(fmea);
        when(failureModeRepository.save(any(FailureMode.class))).thenReturn(failureMode);
        when(actionItemRepository.save(any(ActionItem.class))).thenReturn(actionItem);

        // Act
        Fmea result = fmeaService.archiveFMEA(fmeaId);

        // Assert
        assertTrue(result.getArchive()); // Fmea should be archived
        for (FailureMode fm : result.getFailureModes()) {
            assertTrue(fm.getArchive()); // FailureModes should be archived
            for (ActionItem ai : fm.getActionItems()) {
                assertTrue(ai.getArchive()); // ActionItems should be archived
            }
        }

        verify(fmeaRepository).findById(fmeaId);
        verify(fmeaRepository).save(result);
        verify(failureModeRepository).save(failureMode);
        verify(actionItemRepository).save(actionItem);
    }*/
   /* @Test
    void unarchiveFMEA() {
        // Arrange
        String fmeaId = "fmeaId";
        Fmea fmea = new Fmea();
        fmea.setId(fmeaId);
        fmea.setArchive(true);

        FailureMode failureMode = new FailureMode();
        failureMode.setId("failureModeId");
        failureMode.setArchive(true);

        ActionItem actionItem = new ActionItem();
        actionItem.setId("actionItemId");
        actionItem.setArchive(true);

        failureMode.setActionItems(List.of(actionItem));
        fmea.setFailureModes(List.of(failureMode));

        when(fmeaRepository.findById(fmeaId)).thenReturn(Optional.of(fmea));
        when(fmeaRepository.save(any(Fmea.class))).thenReturn(fmea);
        when(failureModeRepository.save(any(FailureMode.class))).thenReturn(failureMode);
        when(actionItemRepository.save(any(ActionItem.class))).thenReturn(actionItem);

        // Act
        Fmea result = fmeaService.unarchiveFMEA(fmeaId);

        // Assert
        assertFalse(result.getArchive()); // Fmea should be unarchived
        for (FailureMode fm : result.getFailureModes()) {
            assertFalse(fm.getArchive()); // FailureModes should be unarchived
            for (ActionItem ai : fm.getActionItems()) {
                assertFalse(ai.getArchive()); // ActionItems should be unarchived
            }
        }

        verify(fmeaRepository).findById(fmeaId);
        verify(fmeaRepository).save(result);
        verify(failureModeRepository).save(failureMode);
        verify(actionItemRepository).save(actionItem);
    }*/

   /* @Test
    void testGetFailuresByFmea() {
        // Arrange
        String fmeaId = "fmeaId";
        FailureMode fm1 = new FailureMode();
        fm1.setId("fm1");
        FailureMode fm2 = new FailureMode();
        fm2.setId("fm2");

        List<FailureMode> expectedFailureModes = List.of(fm1, fm2);
        when(failureModeRepository.findByFmea_IdAndArchive(fmeaId, false)).thenReturn(expectedFailureModes);

        // Act
        List<FailureMode> result = failureModeService.getFailuresByFmea(fmeaId);

        // Assert
        assertEquals(expectedFailureModes, result);
    }*/
 /*  @Test
   void testAddFailureMode() {
       // Arrange
       String fmeaId = "fmeaId";
       Fmea existingFmea = new Fmea();
       existingFmea.setId(fmeaId);
       existingFmea.setFailureModes(new ArrayList<>());

       FailureMode newFailureMode = new FailureMode();
       newFailureMode.setId(null); // Set to null to indicate it's a new entity

       when(fmeaRepository.findById(fmeaId)).thenReturn(Optional.of(existingFmea));
       when(failureModeRepository.save(any(FailureMode.class))).thenAnswer(invocation -> invocation.getArgument(0));
       when(fmeaRepository.save(any(Fmea.class))).thenAnswer(invocation -> invocation.getArgument(0));

       // Act
       Fmea updatedFmea = failureModeService.addFailureMode(fmeaId, newFailureMode);

       // Assert
       assertEquals(1, updatedFmea.getFailureModes().size());
       assertEquals(newFailureMode, updatedFmea.getFailureModes().get(0));
       verify(failureModeRepository).save(newFailureMode);
       verify(fmeaRepository).save(existingFmea);
   }*/
 /*  @Test
   void testUpdateFailureMode() {
       // Arrange
       String failureModeId = "failureModeId";
       FailureMode existingFailureMode = new FailureMode();
       existingFailureMode.setId(failureModeId);
       existingFailureMode.setDescription("Old Description");
       existingFailureMode.setSeverity(1);
       existingFailureMode.setOccurrence(2);
       existingFailureMode.setDetection(3);
       existingFailureMode.setTitle("Old Title");
       existingFailureMode.setRpn(6); // Old RPN

       FailureMode updatedFailureMode = new FailureMode();
       updatedFailureMode.setDescription("New Description");
       updatedFailureMode.setSeverity(4);
       updatedFailureMode.setOccurrence(5);
       updatedFailureMode.setDetection(6);
       updatedFailureMode.setTitle("New Title");
       updatedFailureMode.setRpn(120); // New RPN, but it should be recalculated

       when(failureModeRepository.findById(failureModeId)).thenReturn(Optional.of(existingFailureMode));
       when(failureModeRepository.save(any(FailureMode.class))).thenAnswer(invocation -> invocation.getArgument(0));

       // Act
       FailureMode result = failureModeService.updateFailureMode(failureModeId, updatedFailureMode);

       // Assert
       assertEquals("New Description", result.getDescription());
       assertEquals(4, result.getSeverity());
       assertEquals(5, result.getOccurrence());
       assertEquals(6, result.getDetection());
       assertEquals("New Title", result.getTitle());
       assertEquals(120, result.getRpn()); // Assuming RPN is updated as per the given value

       verify(failureModeRepository).save(existingFailureMode);
   }*/
 /*  @Test
   void testRemoveFailureMode_Success() {
       // Arrange
       String fmeaId = "fmeaId";
       String failureModeId = "failureModeId";

       Fmea existingFmea = new Fmea();
       existingFmea.setId(fmeaId);
       List<FailureMode> failureModes = new ArrayList<>();
       FailureMode failureMode = new FailureMode();
       failureMode.setId(failureModeId);
       List<ActionItem> actionItems = new ArrayList<>();
       ActionItem actionItem = new ActionItem();
       actionItem.setId("actionItemId");
       actionItems.add(actionItem);
       failureMode.setActionItems(actionItems);
       failureModes.add(failureMode);
       existingFmea.setFailureModes(failureModes);

       when(fmeaRepository.findById(fmeaId)).thenReturn(Optional.of(existingFmea));
       when(failureModeRepository.findById(failureModeId)).thenReturn(Optional.of(failureMode));

       // Act
       Fmea result = failureModeService.removeFailureMode(fmeaId, failureModeId);

       // Assert
       assertEquals(fmeaId, result.getId());
       assertEquals(0, result.getFailureModes().size());
       verify(actionItemRepository).deleteById("actionItemId");
       verify(failureModeRepository).deleteById(failureModeId);
       verify(fmeaRepository).save(existingFmea);
   }*/

   /* @Test
    void testAddActionItem() {
        // Arrange
        String failureModeId = "failureModeId";
        FailureMode existingFm = new FailureMode();
        existingFm.setId(failureModeId);
        existingFm.setActionItems(new ArrayList<>());

        ActionItem actionItem = new ActionItem();
        actionItem.setId(null);
        actionItem.setStatus(Status_Action.TODO);
        actionItem.setArchive(false);
        actionItem.setFailureMode(existingFm);

        when(failureModeRepository.findById(failureModeId)).thenReturn(Optional.of(existingFm));
        when(actionItemRepository.save(actionItem)).thenReturn(actionItem);
        when(failureModeRepository.save(existingFm)).thenReturn(existingFm);

        // Act
        FailureMode result = actionItemService.addActionItem(failureModeId, actionItem);

        // Assert
        assertEquals(failureModeId, result.getId());
        assertEquals(1, result.getActionItems().size());
        assertEquals(actionItem, result.getActionItems().get(0));
    }
*/
   /*@Test
   void testGetArchivedActionsByFm() {
       // Arrange
       String failureModeId = "failureModeId";
       ActionItem archivedActionItem1 = new ActionItem();
       ActionItem archivedActionItem2 = new ActionItem();
       List<ActionItem> archivedActionItems = Arrays.asList(archivedActionItem1, archivedActionItem2);

       when(actionItemRepository.findByFailureModeIdAndArchive(failureModeId, true)).thenReturn(archivedActionItems);

       // Act
       List<ActionItem> result = actionItemService.getArchivedActionsByFm(failureModeId);

       // Assert
       assertEquals(2, result.size());
       assertEquals(archivedActionItems, result);
   }*/
    /*@Test
    void testGetActionsByFm() {
        // Arrange
        String failureModeId = "failureModeId";
        ActionItem actionItem1 = new ActionItem();
        ActionItem actionItem2 = new ActionItem();
        List<ActionItem> actionItems = Arrays.asList(actionItem1, actionItem2);

        when(actionItemRepository.findByFailureModeIdAndArchive(failureModeId, false)).thenReturn(actionItems);

        // Act
        List<ActionItem> result = actionItemService.getActionsByFm(failureModeId);

        // Assert
        assertEquals(2, result.size());
        assertEquals(actionItems, result);
    }*/

   /* @Test
    void testArchiveActionItem() {
        // Arrange
        String actionItemId = "actionItemId";
        ActionItem actionItem = new ActionItem();
        actionItem.setId(actionItemId);
        actionItem.setArchive(false);

        when(actionItemRepository.findById(actionItemId)).thenReturn(Optional.of(actionItem));
        when(actionItemRepository.save(actionItem)).thenReturn(actionItem);

        // Act
        ActionItem result = actionItemService.archiveActionItem(actionItemId);

        // Assert
        assertEquals(true, result.getArchive());
        verify(actionItemRepository).save(result);
    }*/
  /*  @Test
    void testUnarchiveActionItem() {
        // Arrange
        String actionItemId = "actionItemId";
        ActionItem actionItem = new ActionItem();
        actionItem.setId(actionItemId);
        actionItem.setArchive(true);

        when(actionItemRepository.findById(actionItemId)).thenReturn(Optional.of(actionItem));
        when(actionItemRepository.save(actionItem)).thenReturn(actionItem);

        // Act
        ActionItem result = actionItemService.unarchiveActionItem(actionItemId);

        // Assert
        assertEquals(false, result.getArchive());
        verify(actionItemRepository).save(result);
    }*/
  /* @Test
   void testUpdateActionItem() {
       // Arrange
       String actionItemId = "actionItemId";
       ActionItem existingActionItem = new ActionItem();
       existingActionItem.setId(actionItemId);
       existingActionItem.setDescription("Old Description");
       existingActionItem.setDueDate(null);
       existingActionItem.setTitle("Old Title");
       existingActionItem.setStatus(null);

       ActionItem updatedActionItem = new ActionItem();
       updatedActionItem.setDescription("New Description");
       updatedActionItem.setDueDate(null);
       updatedActionItem.setTitle("New Title");
       updatedActionItem.setStatus(null);

       when(actionItemRepository.findById(actionItemId)).thenReturn(Optional.of(existingActionItem));
       when(actionItemRepository.save(existingActionItem)).thenReturn(existingActionItem);

       // Act
       ActionItem result = actionItemService.updateActionItem(actionItemId, updatedActionItem);

       // Assert
       assertEquals("New Description", result.getDescription());
       assertEquals("New Title", result.getTitle());
       verify(actionItemRepository).save(existingActionItem);
   }*/
   /* @Test
    void testRemoveActionItem() {
        // Arrange
        String failureModeId = "failureModeId";
        String actionItemId = "actionItemId";

        FailureMode existingFailureMode = new FailureMode();
        existingFailureMode.setId(failureModeId);
        existingFailureMode.setActionItems(new ArrayList<>());

        ActionItem actionItemToRemove = new ActionItem();
        actionItemToRemove.setId(actionItemId);

        existingFailureMode.getActionItems().add(actionItemToRemove);

        when(failureModeRepository.findById(failureModeId)).thenReturn(Optional.of(existingFailureMode));
        when(actionItemRepository.findById(actionItemId)).thenReturn(Optional.of(actionItemToRemove));

        // Act
        FailureMode result = actionItemService.removeActionItem(failureModeId, actionItemId);

        // Assert
        assertEquals(0, result.getActionItems().size());
        verify(actionItemRepository).deleteById(actionItemId);
        verify(failureModeRepository).save(result);
    }*/

    //////////////////////////PROTOTYPES and FEEDBACK////////////////////////
  /* @Test
   void testCreatePrototype() {
       // Arrange
       String projectId = "projectId";
       Prototype prototype = new Prototype();
       prototype.setName("Prototype Name");
       prototype.setDescription("Prototype Description");

       Prototype savedPrototype = new Prototype();
       savedPrototype.setId("newId");
       savedPrototype.setIdproject(projectId);
       savedPrototype.setName("Prototype Name");
       savedPrototype.setDescription("Prototype Description");
       savedPrototype.setDate_creation(new Date());
       savedPrototype.setArchive(false);
       savedPrototype.setFeedbacks(new ArrayList<>());
       savedPrototype.setImages(new ArrayList<>());

       when(prototypeRepository.save(any(Prototype.class))).thenReturn(savedPrototype);

       // Act
       Prototype result = prototypeService.createPrototype(projectId, prototype);

       // Assert
       assertEquals(projectId, result.getIdproject());
       assertEquals("Prototype Name", result.getName());
       assertEquals("Prototype Description", result.getDescription());
       assertEquals(false, result.getArchive());
       assertEquals(savedPrototype.getDate_creation(), result.getDate_creation());
       verify(prototypeRepository).save(prototype);
   }*/
  /* @Test
   void testUpdatePrototype() {
       // Arrange
       String id = "prototypeId";
       Prototype existingPrototype = new Prototype();
       existingPrototype.setId(id);
       existingPrototype.setName("Old Name");
       existingPrototype.setDescription("Old Description");
       existingPrototype.setLast_modif(null);

       Prototype updatedPrototype = new Prototype();
       updatedPrototype.setName("New Name");
       updatedPrototype.setDescription("New Description");

       Prototype savedPrototype = new Prototype();
       savedPrototype.setId(id);
       savedPrototype.setName("New Name");
       savedPrototype.setDescription("New Description");
       savedPrototype.setLast_modif(new Date());

       when(prototypeRepository.findById(id)).thenReturn(Optional.of(existingPrototype));
       when(prototypeRepository.save(existingPrototype)).thenReturn(savedPrototype);

       // Act
       Prototype result = prototypeService.updatePrototype(id, updatedPrototype);

       // Assert
       assertEquals("New Name", result.getName());
       assertEquals("New Description", result.getDescription());
       assertNotNull(result.getLast_modif());
       verify(prototypeRepository).save(existingPrototype);
   }*/
    /*@Test
    void testDeletePrototype() {
        // Arrange
        String id = "prototypeId";
        Prototype prototype = new Prototype();
        prototype.setId(id);

        PrototypeImg img1 = new PrototypeImg();
        img1.setId("img1Id");
        PrototypeImg img2 = new PrototypeImg();
        img2.setId("img2Id");

        Feedback feedback1 = new Feedback();
        feedback1.setId("feedback1Id");
        Feedback feedback2 = new Feedback();
        feedback2.setId("feedback2Id");

        prototype.setImages(List.of(img1, img2));
        prototype.setFeedbacks(List.of(feedback1, feedback2));

        when(prototypeRepository.findById(id)).thenReturn(Optional.of(prototype));

        // Act
        prototypeService.deletePrototype(id);

        // Assert
        verify(prototypeImgRepository).deleteById("img1Id");
        verify(prototypeImgRepository).deleteById("img2Id");
        verify(feedbackRepository).deleteById("feedback1Id");
        verify(feedbackRepository).deleteById("feedback2Id");
        verify(prototypeRepository).deleteById(id);
    }*/
 /*  @Test
   void testGetPrototypeByProjectCharterId() {
       // Arrange
       String projectCharterId = "projectCharterId";
       List<Prototype> prototypes = new ArrayList<>();
       Prototype prototype1 = new Prototype();
       prototype1.setId("id1");
       Prototype prototype2 = new Prototype();
       prototype2.setId("id2");
       prototypes.add(prototype1);
       prototypes.add(prototype2);

       when(prototypeRepository.findByIdprojectAndArchive(projectCharterId, false)).thenReturn(prototypes);

       // Act
       List<Prototype> result = prototypeService.getPrototypeByProjectCharterId(projectCharterId);

       // Assert
       assertEquals(2, result.size());
       assertTrue(result.contains(prototype1));
       assertTrue(result.contains(prototype2));
       verify(prototypeRepository).findByIdprojectAndArchive(projectCharterId, false);
   }*/
  /*  @Test
    void testGetPrototypeArchived() {
        // Arrange
        String projectCharterId = "projectCharterId";
        List<Prototype> prototypes = new ArrayList<>();
        Prototype prototype1 = new Prototype();
        prototype1.setId("id1");
        Prototype prototype2 = new Prototype();
        prototype2.setId("id2");
        prototypes.add(prototype1);
        prototypes.add(prototype2);

        when(prototypeRepository.findByIdprojectAndArchive(projectCharterId, true)).thenReturn(prototypes);

        // Act
        List<Prototype> result = prototypeService.getPrototypeArchived(projectCharterId);

        // Assert
        assertEquals(2, result.size());
        assertTrue(result.contains(prototype1));
        assertTrue(result.contains(prototype2));
        verify(prototypeRepository).findByIdprojectAndArchive(projectCharterId, true);
    }*/
  /* @Test
   void testArchivePrototype() {
       // Arrange
       String prototypeId = "prototypeId";
       Prototype prototype = new Prototype();
       prototype.setId(prototypeId);
       prototype.setArchive(false);

       when(prototypeRepository.findById(prototypeId)).thenReturn(Optional.of(prototype));
       when(prototypeRepository.save(prototype)).thenReturn(prototype);

       // Act
       Prototype result = prototypeService.archivePrototype(prototypeId);

       // Assert
       assertNotNull(result);
       assertTrue(result.getArchive());
       verify(prototypeRepository).findById(prototypeId);
       verify(prototypeRepository).save(prototype);
   }*/
   /* @Test
    void testUndoPrototype() {
        // Arrange
        String prototypeId = "prototypeId";
        Prototype prototype = new Prototype();
        prototype.setId(prototypeId);
        prototype.setArchive(true);

        when(prototypeRepository.findById(prototypeId)).thenReturn(Optional.of(prototype));
        when(prototypeRepository.save(prototype)).thenReturn(prototype);

        // Act
        Prototype result = prototypeService.UndoPrototype(prototypeId);

        // Assert
        assertNotNull(result);
        assertFalse(result.getArchive());
        verify(prototypeRepository).findById(prototypeId);
        verify(prototypeRepository).save(prototype);
    }
*/
/*   @Test
   void testAddImageToPrototype() {
       // Arrange
       String prototypeId = "prototypeId";
       Prototype prototype = new Prototype();
       prototype.setId(prototypeId);
       prototype.setImages(new ArrayList<>());

       PrototypeImg image = new PrototypeImg();
       image.setId(null); // Simulate a new image

       when(prototypeRepository.findById(prototypeId)).thenReturn(Optional.of(prototype));
       when(prototypeImgRepository.save(image)).thenReturn(image);
       when(prototypeRepository.save(prototype)).thenReturn(prototype);

       // Act
       PrototypeImg result = prototypeImgService.addImageToPrototype(prototypeId, image);

       // Assert
       assertNotNull(result);
       assertEquals(prototypeId, result.getPrototype().getId());
       assertEquals(image.getId(), result.getId());
       verify(prototypeRepository).findById(prototypeId);
       verify(prototypeImgRepository).save(image);
       verify(prototypeRepository).save(prototype);
   }*/
   /* @Test
    void testDeleteImage() {
        // Arrange
        String prototypeId = "prototypeId";
        String imageId = "imageId";
        Prototype prototype = new Prototype();
        prototype.setId(prototypeId);
        PrototypeImg image = new PrototypeImg();
        image.setId(imageId);

        List<PrototypeImg> images = new ArrayList<>();
        images.add(image);
        prototype.setImages(images);

        when(prototypeRepository.findById(prototypeId)).thenReturn(Optional.of(prototype));
        doNothing().when(prototypeImgRepository).deleteById(imageId);
        when(prototypeRepository.save(prototype)).thenReturn(prototype);

        // Act
        prototypeImgService.deleteImage(imageId, prototypeId);

        // Assert
        assertFalse(prototype.getImages().contains(image));
        verify(prototypeRepository).findById(prototypeId);
        verify(prototypeImgRepository).deleteById(imageId);
        verify(prototypeRepository).save(prototype);
    }
*/
  /* @Test
   void testGetImagesByPrototypeId() {
       // Arrange
       String prototypeId = "prototypeId";
       List<PrototypeImg> images = new ArrayList<>();
       images.add(new PrototypeImg());

       when(prototypeImgRepository.findByPrototypeId(prototypeId)).thenReturn(images);

       // Act
       List<PrototypeImg> result = prototypeImgService.getImagesByPrototypeId(prototypeId);

       // Assert
       assertNotNull(result);
       assertEquals(images.size(), result.size());
       verify(prototypeImgRepository).findByPrototypeId(prototypeId);
       System.out.println(result);
   }*/
   /*@Test
   void testAddFeedback() {
       // Arrange
       String prototypeId = "prototypeId";
       String userId = "userId";
       Prototype prototype = new Prototype();
       prototype.setId(prototypeId);
       prototype.setFeedbacks(new ArrayList<>());

       User user = new User();
       user.setId(userId);

       Feedback feedback = new Feedback();
       feedback.setId(null); // Simulate a new feedback

       when(prototypeRepository.findById(prototypeId)).thenReturn(Optional.of(prototype));
       when(userRepository.findById(userId)).thenReturn(Optional.of(user));
       when(prototypeRepository.save(prototype)).thenReturn(prototype);
       when(feedbackRepository.save(feedback)).thenReturn(feedback);

       // Act
       Feedback result = feedbackService.addFeedback(prototypeId, userId, feedback);

       // Assert
       System.out.println("Feedback added: " + result);
       assertNotNull(result);
       assertEquals(userId, result.getUser().getId());
       assertEquals(prototypeId, result.getPrototype().getId());
       verify(prototypeRepository).findById(prototypeId);
       verify(userRepository).findById(userId);
       verify(prototypeRepository).save(prototype);
       verify(feedbackRepository).save(feedback);
   }*/
   /* @Test
    void testGetFeedbackByPrototypeId() {
        // Arrange
        String prototypeId = "prototypeId";
        List<Feedback> feedbacks = new ArrayList<>();
        feedbacks.add(new Feedback());

        when(feedbackRepository.findByPrototypeId(prototypeId)).thenReturn(feedbacks);

        // Act
        List<Feedback> result = feedbackService.getFeedbackByPrototypeId(prototypeId);

        // Assert
        System.out.println("Feedbacks retrieved: " + result);
        assertNotNull(result);
        assertEquals(feedbacks.size(), result.size());
        verify(feedbackRepository).findByPrototypeId(prototypeId);
    }
*/
    ///////////////FIVEWHYS//////////////////////////////////
   /*@Test
   public void testAddFivewhys() {
       // Given
       String projectCharterId = "project123";
       Fivewhys fivewhys = new Fivewhys();
       fivewhys.setProblem_statement("Problem");
       fivewhys.setWhys(Arrays.asList(new Why("1", "Answer1"), new Why("2", "Answer2")));
       fivewhys.setId_fivewhys(null); // Ensure ID is not set

       Fivewhys savedFivewhys = new Fivewhys();
       savedFivewhys.setId_fivewhys("fivewhys123");
       savedFivewhys.setWhys(fivewhys.getWhys());

       when(fiveWhysRepository.save(any(Fivewhys.class))).thenReturn(savedFivewhys);
       when(whysRepository.save(any(Why.class))).thenAnswer(invocation -> invocation.getArgument(0));

       // When
       Fivewhys result = fiveWhysService.addFivewhys(fivewhys, projectCharterId);

       // Then
       assertNotNull(result);
       assertEquals("fivewhys123", result.getId_fivewhys());
       assertEquals("Answer2", result.getRoot_cause_fivewhys());
       verify(fiveWhysRepository).save(fivewhys);
       verify(whysRepository, times(2)).save(any(Why.class));
   }*/
    /*@Test
    public void testGetFivewhysByProjectCharterId() {
        // Given
        String projectCharterId = "project123";
        Fivewhys fivewhys1 = new Fivewhys();
        fivewhys1.setId_fivewhys("fivewhys1");

        Fivewhys fivewhys2 = new Fivewhys();
        fivewhys2.setId_fivewhys("fivewhys2");

        List<Fivewhys> fivewhysList = Arrays.asList(fivewhys1, fivewhys2);
        when(fiveWhysRepository.findByProjectCharterId(projectCharterId)).thenReturn(fivewhysList);

        // When
        List<Fivewhys> result = fiveWhysService.getFivewhysByProjectCharterId(projectCharterId);

        // Then
        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(result.contains(fivewhys1));
        assertTrue(result.contains(fivewhys2));
        verify(fiveWhysRepository).findByProjectCharterId(projectCharterId);
    }*/

   /* @Test
    public void testDeleteFivewhys() {
        // Given
        String fivewhysId = "fivewhys123";

        // Create a Fivewhys object with associated Why and Solution objects
        Why why1 = new Why("why1", "Answer1");
        Why why2 = new Why("why2", "Answer2");

        Solution solution1 = new Solution("solution1", "Solution1");
        Solution solution2 = new Solution("solution2", "Solution2");

        Fivewhys fivewhys = new Fivewhys();
        fivewhys.setId_fivewhys(fivewhysId);
        fivewhys.setWhys(Arrays.asList(why1, why2));
        fivewhys.setSolution_fivewhys(Arrays.asList(solution1, solution2));

        when(fiveWhysRepository.findById(fivewhysId)).thenReturn(Optional.of(fivewhys));

        // When
        fiveWhysService.deleteFivewhys(fivewhysId);

        // Then
        verify(whysRepository).delete(why1);
        verify(whysRepository).delete(why2);
        verify(solutionRepository).delete(solution1);
        verify(solutionRepository).delete(solution2);
        verify(fiveWhysRepository).delete(fivewhys);
    }*/
   /*@Test
   public void testUpdateFivewhys() {
       // Given
       String fivewhysId = "fivewhys123";

       Fivewhys existingFivewhys = new Fivewhys();
       existingFivewhys.setId_fivewhys(fivewhysId);
       existingFivewhys.setProblem_statement("Old Problem");
       existingFivewhys.setCategorieProblem( CategorieProblem.HR);

       List<Why> oldWhys = Arrays.asList(new Why("why1", "Old Answer"));
       existingFivewhys.setWhys(oldWhys);

       List<Solution> oldSolutions = Arrays.asList(new Solution("sol1", "Old Solution"));
       existingFivewhys.setSolution_fivewhys(oldSolutions);

       Fivewhys updatedFivewhys = new Fivewhys();
       updatedFivewhys.setId_fivewhys(fivewhysId);
       updatedFivewhys.setProblem_statement("New Problem");
       updatedFivewhys.setCategorieProblem(CategorieProblem.HR);
       updatedFivewhys.setWhys(Arrays.asList(new Why("why2", "New Answer")));
       updatedFivewhys.setSolution_fivewhys(Arrays.asList(new Solution("sol2", "New Solution")));

       when(fiveWhysRepository.findById(fivewhysId)).thenReturn(Optional.of(existingFivewhys));
       when(fiveWhysRepository.save(any(Fivewhys.class))).thenAnswer(invocation -> invocation.getArgument(0));
       when(whysRepository.save(any(Why.class))).thenAnswer(invocation -> invocation.getArgument(0));
       when(solutionRepository.save(any(Solution.class))).thenAnswer(invocation -> invocation.getArgument(0));

       // When
       Fivewhys result = fiveWhysService.updateFivewhys(updatedFivewhys);

       // Then
       assertNotNull(result);
       assertEquals("New Problem", result.getProblem_statement());
       assertEquals("New Answer", result.getRoot_cause_fivewhys()); // Based on the last Why's answer
       verify(fiveWhysRepository).save(existingFivewhys);
       verify(whysRepository).save(any(Why.class));
       verify(solutionRepository).save(any(Solution.class));
   }*/
 /*  @Test
   public void testGetParetoData() {
       // Given
       List<CategoryCount> counts = Arrays.asList(
               new CategoryCount(CategorieProblem.Financial, 10),
               new CategoryCount(CategorieProblem.Operational, 20),
               new CategoryCount(CategorieProblem.HR, 30)
       );

       when(fiveWhysRepository.countByCategory()).thenReturn(counts);

       // When
       List<ParetoData> result = fiveWhysService.getParetoData();

       // Then
       assertNotNull(result);
       assertEquals(3, result.size());

       // Check first item
       ParetoData first = result.get(0);
       assertEquals(CategorieProblem.Financial, first.getCategory());
       assertEquals(10, first.getCount());
       assertEquals(16.67, first.getCumulativePercentage(), 0.01);

       // Check second item
       ParetoData second = result.get(1);
       assertEquals(CategorieProblem.Operational, second.getCategory());
       assertEquals(20, second.getCount());
       assertEquals(50.00, second.getCumulativePercentage(), 0.01);

       // Check third item
       ParetoData third = result.get(2);
       assertEquals(CategorieProblem.HR, third.getCategory());
       assertEquals(30, third.getCount());
       assertEquals(100.00, third.getCumulativePercentage(), 0.01);
   }*/
  /* @Test
   public void testAddSolution() {
       // Given
       when(fiveWhysRepository.findById("1")).thenReturn(Optional.of(fivewhys));
       when(solutionRepository.save(solution)).thenReturn(solution);
       when(fiveWhysRepository.save(fivewhys)).thenReturn(fivewhys);

       // When
       Fivewhys result = fiveWhysService.addSolution("1", solution);

       // Then
       assertNotNull(result);
       assertEquals(1, result.getSolution_fivewhys().size());
       assertEquals(solution, result.getSolution_fivewhys().get(0));
       verify(fiveWhysRepository).findById("1");
       verify(solutionRepository).save(solution);
       verify(fiveWhysRepository).save(fivewhys);
   }
*/
   /* @Test
    public void testUpdateSolution() {
        // Given
        when(solutionRepository.findById("1")).thenReturn(Optional.of(existingSolution));
        when(solutionRepository.save(existingSolution)).thenReturn(existingSolution);

        // When
        Solution result = fiveWhysService.updateSolution("1", updatedSolution);

        // Then
        assertNotNull(result);
        assertEquals("Updated Solution", result.getDescription_solution());
        verify(solutionRepository).findById("1");
        verify(solutionRepository).save(existingSolution);
    }*/
    /////////////////////////////////KANBAN BOARD and CARDS/////////////////
  /* @Test
   public void testAddKanban() {
       // Given
       when(kanbanRepository.save(any(Kanban.class))).thenReturn(kanban);

       // When
       Kanban result = kanbanService.addKanban("project1", kanban);

       // Then
       assertNotNull(result);
       assertEquals("project1", result.getId_project());
       verify(kanbanRepository).save(kanban);
   }*/
  /* @Test
   public void testGetKanbanByProjectCharterId() {
       // Given
       List<Kanban> kanbans = Arrays.asList(kanban);
       when(kanbanRepository.findById_project("project1")).thenReturn(kanbans);

       // When
       List<Kanban> result = kanbanService.getKanbanByProjectCharterId("project1");

       // Then
       assertNotNull(result);
       assertEquals(1, result.size());
       assertEquals(kanban, result.get(0));
       verify(kanbanRepository).findById_project("project1");
   }
*/
  /* @Test
   public void testDeleteKanbans() {
       // Initialize Mockito annotations
       MockitoAnnotations.openMocks(this);

       // Create test data
       Kanban kanban = new Kanban();
       kanban.setIdkanban("kanban1");
       kanban.setId_project("project1");
       kanban.setCreation_date(new Date());

       Card card = new Card();
       card.setId_card("card1");
       card.setTitle_card("Card Title");
       card.setDesciption_card("Card Description");
       card.setCreation_card(new Date());
       card.setPriority_card(Priority.High); // Adjust as necessary
       card.setStatus(Status.TODO); // Adjust as necessary

       List<Card> cards = new ArrayList<>();
       cards.add(card);
       kanban.setCards(cards);

       // Mock repository methods
       when(kanbanRepository.findById("kanban1")).thenReturn(Optional.of(kanban));

       // Call the method under test
       kanbanService.deleteKanbans("kanban1");

       // Verify interactions
       verify(kanbanRepository).findById("kanban1");
       verify(cardRepository).delete(card);
       verify(kanbanRepository).delete(kanban);
   }*/
  /* @Test
   public void testUpdateCard() {
       // Initialize Mockito annotations
       MockitoAnnotations.openMocks(this);

       // Create test data
       Card existingCard = new Card();
       existingCard.setId_card("card1");
       existingCard.setTitle_card("Old Title");
       existingCard.setDesciption_card("Old Description");
       existingCard.setPriority_card(Priority.High);
       existingCard.setStatus(Status.TODO);

       Card updatedCard = new Card();
       updatedCard.setId_card("card1");
       updatedCard.setTitle_card("New Title");
       updatedCard.setDesciption_card("New Description");
       updatedCard.setPriority_card(Priority.Low);
       updatedCard.setStatus(Status.INPROGRESS);

       // Mock repository methods
       when(cardRepository.findById("card1")).thenReturn(Optional.of(existingCard));
       when(cardRepository.save(any(Card.class))).thenReturn(updatedCard);

       // Call the method under test
       Card result = kanbanService.updateCard(updatedCard);

       // Verify interactions and assert results
       verify(cardRepository).findById("card1");
       verify(cardRepository).save(updatedCard);
       assertEquals("New Title", result.getTitle_card());
       assertEquals("New Description", result.getDesciption_card());
       assertEquals(Priority.Low, result.getPriority_card());
       assertEquals(Status.INPROGRESS, result.getStatus());
   }*/
  /* @Test
   public void testRemoveCard() {
       // Initialize Mockito annotations
       MockitoAnnotations.openMocks(this);

       // Create test data
       Kanban kanban = new Kanban();
       kanban.setIdkanban("kanban1");
       kanban.setId_project("project1");
       kanban.setCreation_date(new Date());

       Card cardToRemove = new Card();
       cardToRemove.setId_card("card1");

       List<Card> cards = new ArrayList<>();
       cards.add(cardToRemove);
       kanban.setCards(cards);

       // Mock repository methods
       when(kanbanRepository.findById("kanban1")).thenReturn(Optional.of(kanban));
       when(cardRepository.findById("card1")).thenReturn(Optional.of(cardToRemove));

       // Call the method under test
       Kanban updatedKanban = kanbanService.removeCard("kanban1", "card1");

       // Verify interactions and assert results
       verify(kanbanRepository).findById("kanban1");
       verify(cardRepository).findById("card1");
       verify(kanbanRepository).save(kanban);
       verify(cardRepository).deleteById("card1");

       assertTrue(updatedKanban.getCards().isEmpty());
   }
*/
  /* @Test
   public void testAddDoneCard() {
       // Initialize Mockito annotations
       MockitoAnnotations.openMocks(this);

       // Create test data
       Kanban kanban = new Kanban();
       kanban.setIdkanban("kanban1");
       kanban.setId_project("project1");
       kanban.setCreation_date(new Date());

       Card newCard = new Card();
       newCard.setTitle_card("New Card");
       newCard.setDesciption_card("Description");
       newCard.setPriority_card(Priority.Moderate);
       newCard.setStatus(Status.DONE);

       List<Card> cards = new ArrayList<>();
       kanban.setCards(cards);

       // Mock repository methods
       when(kanbanRepository.findById("kanban1")).thenReturn(Optional.of(kanban));
       when(kanbanRepository.save(any(Kanban.class))).thenReturn(kanban);
       when(cardRepository.save(any(Card.class))).thenReturn(newCard);

       // Call the method under test
       Kanban updatedKanban = kanbanService.addDoneCard("kanban1", newCard);

       // Verify interactions and assert results
       verify(kanbanRepository).findById("kanban1");
       verify(cardRepository).save(newCard);
       verify(kanbanRepository).save(kanban);

       assertEquals(1, updatedKanban.getCards().size(), "Card list should contain one card after adding");
       assertEquals(Status.DONE, updatedKanban.getCards().get(0).getStatus(), "Card status should be DONE");
   }
*/
  /* @Test
   public void testAddTodoCard() {
       // Initialize Mockito annotations
       MockitoAnnotations.openMocks(this);

       // Create test data
       Kanban kanban = new Kanban();
       kanban.setIdkanban("kanban1");
       kanban.setId_project("project1");
       kanban.setCreation_date(new Date());

       Card newCard = new Card();
       newCard.setTitle_card("New Todo Card");
       newCard.setDesciption_card("Description");
       newCard.setPriority_card(Priority.Moderate);
       newCard.setStatus(Status.TODO);

       List<Card> cards = new ArrayList<>();
       kanban.setCards(cards);

       // Mock repository methods
       when(kanbanRepository.findById("kanban1")).thenReturn(Optional.of(kanban));
       when(kanbanRepository.save(any(Kanban.class))).thenReturn(kanban);
       when(cardRepository.save(any(Card.class))).thenReturn(newCard);

       // Call the method under test
       Kanban updatedKanban = kanbanService.addTodoCard("kanban1", newCard);

       // Verify interactions and assert results
       verify(kanbanRepository).findById("kanban1");
       verify(cardRepository).save(newCard);
       verify(kanbanRepository).save(kanban);

       assertEquals(1, updatedKanban.getCards().size(), "Card list should contain one card after adding");
       assertEquals(Status.TODO, updatedKanban.getCards().get(0).getStatus(), "Card status should be TODO");
   }*/
  /* @Test
   public void testAddInprogressCard() {
       // Initialize Mockito annotations
       MockitoAnnotations.openMocks(this);

       // Create test data
       Kanban kanban = new Kanban();
       kanban.setIdkanban("kanban2");
       kanban.setId_project("project2");
       kanban.setCreation_date(new Date());

       Card newCard = new Card();
       newCard.setTitle_card("New Inprogress Card");
       newCard.setDesciption_card("Description");
       newCard.setPriority_card(Priority.High);
       newCard.setStatus(Status.INPROGRESS);

       List<Card> cards = new ArrayList<>();
       kanban.setCards(cards);

       // Mock repository methods
       when(kanbanRepository.findById("kanban2")).thenReturn(Optional.of(kanban));
       when(kanbanRepository.save(any(Kanban.class))).thenReturn(kanban);
       when(cardRepository.save(any(Card.class))).thenReturn(newCard);

       // Call the method under test
       Kanban updatedKanban = kanbanService.addInprogressCard("kanban2", newCard);

       // Verify interactions and assert results
       verify(kanbanRepository).findById("kanban2");
       verify(cardRepository).save(newCard);
       verify(kanbanRepository).save(kanban);

       assertEquals(1, updatedKanban.getCards().size(), "Card list should contain one card after adding");
       assertEquals(Status.INPROGRESS, updatedKanban.getCards().get(0).getStatus(), "Card status should be INPROGRESS");
   }*/
  /* @Test
   public void testGetTodoCardsByKanbanId() {
       // Initialize Mockito annotations
       MockitoAnnotations.openMocks(this);

       // Create test data
       Card todoCard1 = new Card();
       todoCard1.setId_card("card1");
       todoCard1.setTitle_card("Todo Card 1");
       todoCard1.setStatus(Status.TODO);

       Card todoCard2 = new Card();
       todoCard2.setId_card("card2");
       todoCard2.setTitle_card("Todo Card 2");
       todoCard2.setStatus(Status.TODO);

       List<Card> todoCards = new ArrayList<>();
       todoCards.add(todoCard1);
       todoCards.add(todoCard2);

       // Mock repository methods
       when(cardRepository.findCardsByKanbanIdkanbanAndStatus("kanban1", Status.TODO)).thenReturn(todoCards);

       // Call the method under test
       List<Card> result = kanbanService.getTodoCardsByKanbanId("kanban1");

       // Verify interactions and assert results
       verify(cardRepository).findCardsByKanbanIdkanbanAndStatus("kanban1", Status.TODO);
       assertEquals(2, result.size(), "Should return two TODO cards");
       assertEquals(Status.TODO, result.get(0).getStatus(), "Card status should be TODO");
       assertEquals(Status.TODO, result.get(1).getStatus(), "Card status should be TODO");
   }
*/
   /*@Test
   public void testGetInprogressCardsByKanbanId() {
       // Initialize Mockito annotations
       MockitoAnnotations.openMocks(this);

       // Create test data
       Card inprogressCard1 = new Card();
       inprogressCard1.setId_card("card1");
       inprogressCard1.setTitle_card("Inprogress Card 1");
       inprogressCard1.setStatus(Status.INPROGRESS);

       Card inprogressCard2 = new Card();
       inprogressCard2.setId_card("card2");
       inprogressCard2.setTitle_card("Inprogress Card 2");
       inprogressCard2.setStatus(Status.INPROGRESS);

       List<Card> inprogressCards = new ArrayList<>();
       inprogressCards.add(inprogressCard1);
       inprogressCards.add(inprogressCard2);

       // Mock repository methods
       when(cardRepository.findCardsByKanbanIdkanbanAndStatus("kanban1", Status.INPROGRESS)).thenReturn(inprogressCards);

       // Call the method under test
       List<Card> result = kanbanService.getInprogressCardsByKanbanId("kanban1");

       // Verify interactions and assert results
       verify(cardRepository).findCardsByKanbanIdkanbanAndStatus("kanban1", Status.INPROGRESS);
       assertEquals(2, result.size(), "Should return two INPROGRESS cards");
       assertEquals(Status.INPROGRESS, result.get(0).getStatus(), "Card status should be INPROGRESS");
       assertEquals(Status.INPROGRESS, result.get(1).getStatus(), "Card status should be INPROGRESS");
   }
*/
  /* @Test
   public void testGetDoneCardsByKanbanId() {
       // Initialize Mockito annotations
       MockitoAnnotations.openMocks(this);

       // Create test data
       Card doneCard1 = new Card();
       doneCard1.setId_card("card1");
       doneCard1.setTitle_card("Done Card 1");
       doneCard1.setStatus(Status.DONE);

       Card doneCard2 = new Card();
       doneCard2.setId_card("card2");
       doneCard2.setTitle_card("Done Card 2");
       doneCard2.setStatus(Status.DONE);

       List<Card> doneCards = new ArrayList<>();
       doneCards.add(doneCard1);
       doneCards.add(doneCard2);

       // Mock repository methods
       when(cardRepository.findCardsByKanbanIdkanbanAndStatus("kanban1", Status.DONE)).thenReturn(doneCards);

       // Call the method under test
       List<Card> result = kanbanService.getDoneCardsByKanbanId("kanban1");

       // Verify interactions and assert results
       verify(cardRepository).findCardsByKanbanIdkanbanAndStatus("kanban1", Status.DONE);
       assertEquals(2, result.size(), "Should return two DONE cards");
       assertEquals(Status.DONE, result.get(0).getStatus(), "Card status should be DONE");
       assertEquals(Status.DONE, result.get(1).getStatus(), "Card status should be DONE");
   }*/
}
