package lean.toc.manajerobackend.repositories.Lss_repositories.SIPOC;

import lean.toc.manajerobackend.models.Lss_models.Sipoc.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CustomerRepository extends MongoRepository<Customer,String> {
}
