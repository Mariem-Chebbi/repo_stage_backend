package lean.toc.manajerobackend.models.Lss_models.Sipoc;

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
@Document(collection ="sipoc")
@ToString
public class Sipoc implements Serializable {
    @Id
    String id_sipoc;
    Date addDate;
    String idproject;

    @DBRef
    List<Supplier> supplier_sipoc;

    @DBRef
    List<Input> input_sipoc;

    @DBRef
    List<Processsipoc> process_sipoc;

    @DBRef
    List<Output> output_sipoc;

    @DBRef
    List<Customer> customer_sipoc;
}
