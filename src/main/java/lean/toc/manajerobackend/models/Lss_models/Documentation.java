package lean.toc.manajerobackend.models.Lss_models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Data
@Document(collection ="documentation")
@ToString
public class Documentation implements Serializable {
    @Id
    String iddocu;
    Section sectiondocu;
    String contentdocu;
    Date lastModifieddocu;
    String content1;
    String content2;
    String content3;
    String content4;
    String content5;
    String content6;
    String content7;
    String content8;
    String content9;
    String content10;
    String title1;
    String title2;
    String title3;
    String title4;
    String title5;
    String title6;
    String title7;

    @DBRef
    List<Image> images;

}
