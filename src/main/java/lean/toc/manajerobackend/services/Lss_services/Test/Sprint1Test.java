package lean.toc.manajerobackend.services.Lss_services.Test;
import lean.toc.manajerobackend.ManajeroBackendApplication;
import lean.toc.manajerobackend.models.Lss_models.Documentation;
import lean.toc.manajerobackend.models.Lss_models.Image;
import lean.toc.manajerobackend.repositories.Lss_repositories.Documentation.DocumentationRepository;
import lean.toc.manajerobackend.repositories.Lss_repositories.Documentation.ImageRepository;
import lean.toc.manajerobackend.services.Lss_services.DocumentationServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = ManajeroBackendApplication.class)
@ExtendWith(MockitoExtension.class)
public class Sprint1Test {

    @InjectMocks
    DocumentationServiceImpl documentationService;

    @Mock
    DocumentationRepository documentationRepository;
    @Mock
    ImageRepository imageRepository;


    private Documentation doc;
    private Image imageToDelete;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        doc = new Documentation();
        doc.setIddocu("1111");
        imageToDelete = new Image("img1", "http://example.com/image1.jpg");
        List<Image> images = new ArrayList<>();
        images.add(imageToDelete);
        doc.setImages(images);

    }
/*
    @Test
    public void testaddDocumentation() {
        Documentation documentation=new Documentation();
        documentation.setContent1("content1");
        documentation.setContent2("content2");
        documentation.setContent3("content3");
        documentation.setContent4("content4");
        documentation.setContent5("content5");
        documentation.setTitle1("title1");
        documentation.setTitle2("title2");
        documentation.setTitle3("title3");
        documentation.setTitle4("title4");
        documentation.setTitle5("title5");
        documentation.setLastModifieddocu(new Date());
        when(documentationRepository.save(Mockito.any(Documentation.class))).thenReturn(documentation);
        Documentation result=documentationService.addDocumentation(documentation);

        // Assert
        Assertions.assertNotNull(result);
        Assertions.assertEquals(documentation.getContent1(), result.getContent1());
        Assertions.assertEquals(documentation.getContent2(), result.getContent2());
        Assertions.assertEquals(documentation.getContent3(), result.getContent3());
        Assertions.assertEquals(documentation.getContent4(), result.getContent4());
        Assertions.assertEquals(documentation.getTitle1(), result.getTitle1());
        Assertions.assertEquals(documentation.getTitle2(), result.getTitle2());
        Assertions.assertEquals(documentation.getTitle3(), result.getTitle3());
        Assertions.assertEquals(documentation.getTitle4(), result.getTitle4());
        Assertions.assertEquals(documentation.getLastModifieddocu(), result.getLastModifieddocu());

        System.out.println("Test validated");
    }*/
/*
    @Test
void testGetDocumentationWithImagesBySection() {
    Date date = new Date(124, 0, 1); // Year is 1900 + 124 = 2024, Month is 0-based, so January is 0
    List<Image> img = Arrays.asList(new Image("111", "url1"), new Image("122", "url2"));
    Documentation documentation = new Documentation(
            "1111", Section.HOW, "content", date,
            "content1", "content2", "content3", "content4",
            "content5", "content6", "content7", "content8",
            "content9", "content10", "title1", "title2",
            "title3", "title4", "title5", "title6", "title7",
            img
    );

    when(imageRepository.findByDocumentationIddocu("1111")).thenReturn(img);
    when(documentationService.getDocumentationWithImagesBySection(Section.HOW)).thenReturn(documentation);
    // Act
    Documentation result = documentationService.getDocumentationWithImagesBySection(Section.HOW);
    // Assert
    Assertions.assertNotNull(result);
    Assertions.assertEquals("1111", result.getIddocu());
    Assertions.assertEquals("content", result.getContentdocu());
    Assertions.assertEquals(date, result.getLastModifieddocu());
    Assertions.assertEquals("content1", result.getContent1());
    Assertions.assertEquals("content2", result.getContent2());
    Assertions.assertEquals("content3", result.getContent3());
    Assertions.assertEquals("content4", result.getContent4());
    Assertions.assertEquals("content5", result.getContent5());
    Assertions.assertEquals("content6", result.getContent6());
    Assertions.assertEquals("content7", result.getContent7());
    Assertions.assertEquals("content8", result.getContent8());
    Assertions.assertEquals("content9", result.getContent9());
    Assertions.assertEquals("content10", result.getContent10());
    Assertions.assertEquals("title1", result.getTitle1());
    Assertions.assertEquals("title2", result.getTitle2());
    Assertions.assertEquals("title3", result.getTitle3());
    Assertions.assertEquals("title4", result.getTitle4());
    Assertions.assertEquals("title5", result.getTitle5());
    Assertions.assertEquals("title6", result.getTitle6());
    Assertions.assertEquals("title7", result.getTitle7());
    Assertions.assertEquals("url1", result.getImages().get(0).getUrl());
    Assertions.assertEquals("url2", result.getImages().get(1).getUrl());

    System.out.println("test validated");
    System.out.println(result);
}
*/
    /*
@Test
void testUpdateDocumentation() {
    String docId = "1111";
    Date originalDate = new Date(123, 0, 1); // January 1, 2023
    Documentation existingDoc = new Documentation(
            docId, Section.HOW, "originalContent", originalDate,
            "originalContent1", "originalContent2", "originalContent3", "originalContent4",
            "originalContent5", "originalContent6", "originalContent7", "originalContent8",
            "originalContent9", "originalContent10", "originalTitle1", "originalTitle2",
            "originalTitle3", "originalTitle4", "originalTitle5", "originalTitle6", "originalTitle7",
            null // No images in this test
    );
    Documentation updatedDoc = new Documentation(
            docId, Section.WHAT, "updatedContent", new Date(),
            "updatedContent1", "updatedContent2", "updatedContent3", "updatedContent4",
            "updatedContent5", "updatedContent6", "updatedContent7", "updatedContent8",
            "originalContent9", "originalContent10", "updatedTitle1", "updatedTitle2",
            "updatedTitle3", "updatedTitle4", "updatedTitle5", "updatedTitle6", "updatedTitle7",
            null // No images in this test
    );
    when(documentationRepository.findById(docId)).thenReturn(Optional.of(existingDoc));
    when(documentationRepository.save(any(Documentation.class))).thenReturn(updatedDoc);
    // Act
    Documentation result = documentationService.updateDocumentation(docId, updatedDoc);
    // Assert
    Assertions.assertNotNull(result);
    Assertions.assertEquals("updatedContent", result.getContentdocu());
    Assertions.assertEquals("updatedContent1", result.getContent1());
    Assertions.assertEquals("updatedTitle1", result.getTitle1());
    Assertions.assertEquals(Section.WHAT, result.getSectiondocu());
    // Check if the last modified date is within a recent time frame (e.g., within the last minute)
    Instant now = Instant.now();
    assertTrue(result.getLastModifieddocu().toInstant().isAfter(now.minus(1, ChronoUnit.MINUTES)));
    assertTrue(result.getLastModifieddocu().toInstant().isBefore(now.plus(1, ChronoUnit.MINUTES)));

    verify(documentationRepository, times(1)).findById(docId);
    verify(documentationRepository, times(1)).save(any(Documentation.class));
    System.out.println(result);
}*/
    /*
@Test
void testAddImageToDocumentation() {
    // Arrange
    String docId = "1112";
    String imageId = UUID.randomUUID().toString();
    Documentation doc = new Documentation();
    doc.setIddocu(docId);
    doc.setImages(new ArrayList<>()); // Start with an empty image list

    Image newImage = new Image();
    newImage.setUrl("http://example.com/image.jpg");

    when(documentationRepository.findById(docId)).thenReturn(Optional.of(doc));
    when(imageRepository.save(any(Image.class))).thenAnswer(invocation -> {
        Image img = invocation.getArgument(0);
        img.setId(imageId);
        return img;
    });
    when(documentationRepository.save(any(Documentation.class))).thenReturn(doc);
    // Act
    Image result = documentationService.addImageToDocumentation(docId, newImage);
    // Assert
    Assertions.assertNotNull(result);
    Assertions.assertEquals(imageId, result.getId());
    Assertions.assertEquals("http://example.com/image.jpg", result.getUrl());
    Assertions.assertEquals(doc, result.getDocumentation());

    verify(documentationRepository, times(1)).findById(docId);
    verify(documentationRepository, times(1)).save(doc);
    verify(imageRepository, times(1)).save(newImage);
    System.out.println(result);
}*/
/*
@Test
void testGetImagesByDocumentationId() {
    // Arrange
    String docId = "1111";
    Image image1 = new Image("img1", "http://example.com/image1.jpg");
    Image image2 = new Image("img2", "http://example.com/image2.jpg");
    List<Image> images = Arrays.asList(image1, image2);

    when(imageRepository.findByDocumentationIddocu(docId)).thenReturn(images);

    // Act
    List<Image> result = documentationService.getImagesByDocumentationId(docId);

    // Assert
    Assertions.assertNotNull(result);
    Assertions.assertEquals(2, result.size());
    assertTrue(result.contains(image1));
    assertTrue(result.contains(image2));

    verify(imageRepository, times(1)).findByDocumentationIddocu(docId);
    System.out.println(result);
}*/
    // Setup initial data


  /*  @Test
    void testDeleteImageSuccess() {
        // Arrange

        String imageId = "img1";
        String docId = "1111";

        when(documentationRepository.findById(docId)).thenReturn(Optional.of(doc));
        doNothing().when(imageRepository).deleteById(imageId);

        // Act
        documentationService.deleteImage(imageId, docId);

        // Assert
        assertTrue(doc.getImages().isEmpty());
        verify(documentationRepository, times(1)).save(doc);
        verify(imageRepository, times(1)).deleteById(imageId);
    }

*/
}
