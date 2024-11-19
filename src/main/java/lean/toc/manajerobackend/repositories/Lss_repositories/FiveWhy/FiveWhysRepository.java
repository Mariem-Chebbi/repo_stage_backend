package lean.toc.manajerobackend.repositories.Lss_repositories.FiveWhy;

import lean.toc.manajerobackend.models.Lss_models.Fivewhys.CategorieProblem;
import lean.toc.manajerobackend.models.Lss_models.Fivewhys.CategoryCount;
import lean.toc.manajerobackend.models.Lss_models.Fivewhys.Fivewhys;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface FiveWhysRepository extends MongoRepository<Fivewhys,String> {
    @Query("{ 'idproject': ?0 }")
    List<Fivewhys> findByProjectCharterId(String projectCharterId);
    @Aggregation(pipeline = {
            "{ $group: { _id: '$categorieProblem', count: { $sum: 1 } } }",
            "{ $sort: { count: -1 } }"
    })
    List<CategoryCount> countByCategory();

    long countByIdproject(String idproject);
    List<Fivewhys> findByIdproject(String idproject);

    @Query("{ 'idproject': ?0 }")
    Map<CategorieProblem, Long> countByCategorieProblem(String idproject);
}
