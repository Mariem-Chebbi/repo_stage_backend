package lean.toc.manajerobackend.models.FDDG2_Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Demo")
public class Demo {
    @Id
    private String codeDemo;
    private String Title;
    private LocalDate createdAt;
    private String Introduction ;
    private String Objectives;
    private String What ;
    private String How ;
    private String Why ;
    private String WhatIf ;
    private String Advantages ;
    private String Disadvantages ;
    private String Roles ;
    private String LifeCycle;
    private Map<String, String> images;
}
