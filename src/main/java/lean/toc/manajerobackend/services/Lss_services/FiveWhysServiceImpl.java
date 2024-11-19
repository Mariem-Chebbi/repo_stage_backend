package lean.toc.manajerobackend.services.Lss_services;

import lean.toc.manajerobackend.models.Lss_models.Fivewhys.*;
import lean.toc.manajerobackend.repositories.Lss_repositories.FiveWhy.FiveWhysRepository;
import lean.toc.manajerobackend.repositories.Lss_repositories.FiveWhy.SolutionRepository;
import lean.toc.manajerobackend.repositories.Lss_repositories.FiveWhy.WhysRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@AllArgsConstructor

@Service
public class FiveWhysServiceImpl {
    @Autowired
    FiveWhysRepository fiveWhysRepository;
    @Autowired
    WhysRepository whysRepository;
    @Autowired
    private SolutionRepository solutionRepository;


    public Fivewhys addSolution(String id, Solution solution) {
        // Retrieve the Fivewhys object only once
        Fivewhys existingFive = fiveWhysRepository.findById(id).orElse(null);
        if (existingFive != null) {
            solution.setId_solution(null);
            solution.setFivewhys(existingFive); // Set the relationship
            solutionRepository.save(solution);
            existingFive.getSolution_fivewhys().add(solution);
            return fiveWhysRepository.save(existingFive);
        }
        return null;
    }

    public Solution updateSolution(String soluId, Solution updatedSolu) {
        Optional<Solution> SoluOptional = solutionRepository.findById(soluId);
        if (SoluOptional.isPresent()) {
            Solution existingSolu = SoluOptional.get();
            existingSolu.setDescription_solution(updatedSolu.getDescription_solution());
            return solutionRepository.save(existingSolu);
        }
        return null;
    }
    public Fivewhys addFivewhys(Fivewhys fivewhys, String projectCharterId) {
        fivewhys.setIdproject(projectCharterId);

        // Save the Fivewhys object first to generate its ID
        fivewhys.setId_fivewhys(null);
        fivewhys.setAddDate(new Date());
        Fivewhys savedFivewhys = fiveWhysRepository.save(fivewhys);

        // Save the Why objects with the generated Fivewhys ID
        List<Why> whys = fivewhys.getWhys();
        for (Why why : whys) {
            why.setId_why(null);
            why.setFivewhys(savedFivewhys);
            whysRepository.save(why);
        }

        // Set the root cause from the answer of the last Why
        if (!whys.isEmpty()) {
            String rootCause = whys.get(whys.size() - 1).getAnswer_why();
            savedFivewhys.setRoot_cause_fivewhys(rootCause);
        }

        // Save the Fivewhys object again with updated whys and root cause
        return fiveWhysRepository.save(savedFivewhys);
    }

    public List<Fivewhys> getFivewhysByProjectCharterId(String projectCharterId) {
        return fiveWhysRepository.findByProjectCharterId(projectCharterId);
    }
    public void deleteFivewhys(String fivewhysId) {
        // Find the Fivewhys document
        Fivewhys fivewhys = fiveWhysRepository.findById(fivewhysId).orElse(null);
        if (fivewhys != null) {
            // Delete associated Why documents
            for (Why why : fivewhys.getWhys()) {
                whysRepository.delete(why);
            }
            for (Solution solution:fivewhys.getSolution_fivewhys()){

                solutionRepository.delete(solution);
            }
            // Delete the Fivewhys document
            fiveWhysRepository.delete(fivewhys);
        }
    }
    public Fivewhys updateFivewhys(Fivewhys updatedFivewhys) {
        // Fetch the existing Fivewhys document
        Fivewhys existingFivewhys = fiveWhysRepository.findById(updatedFivewhys.getId_fivewhys()).orElse(null);

        if (existingFivewhys != null) {
            // Update the Fivewhys document with new values
            existingFivewhys.setProblem_statement(updatedFivewhys.getProblem_statement());
            existingFivewhys.setCategorieProblem(updatedFivewhys.getCategorieProblem());

            // Save the new or updated Why documents and set the relationship
            List<Why> newWhys = updatedFivewhys.getWhys();
            for (Why updatedWhy : newWhys) {
                updatedWhy.setFivewhys(existingFivewhys);
                whysRepository.save(updatedWhy);
            }

            // Set the root cause from the last Why's answer
            if (!newWhys.isEmpty()) {
                String rootCause = newWhys.get(newWhys.size() - 1).getAnswer_why();
                existingFivewhys.setRoot_cause_fivewhys(rootCause);
            }

            List<Solution> newSolu = updatedFivewhys.getSolution_fivewhys();
            for (Solution updatedsolu : newSolu) {
                updatedsolu.setFivewhys(existingFivewhys);
                solutionRepository.save(updatedsolu);
            }
            // Update the Fivewhys document with new Why documents
            existingFivewhys.setWhys(newWhys);
            existingFivewhys.setSolution_fivewhys(newSolu);

            // Save the updated Fivewhys document
            return fiveWhysRepository.save(existingFivewhys);
        } else {
            throw new RuntimeException("Fivewhys not found with ID: " + updatedFivewhys.getId_fivewhys());
        }
    }
    public List<ParetoData> getParetoData() {
        List<CategoryCount> counts = fiveWhysRepository.countByCategory();
        long total = counts.stream().mapToLong(CategoryCount::getCount).sum();

        List<ParetoData> paretoDataList = new ArrayList<>();
        long cumulativeCount = 0;

        for (CategoryCount count : counts) {
            cumulativeCount += count.getCount();
            double cumulativePercentage = (double) cumulativeCount / total * 100;
            ParetoData paretoData = new ParetoData(count.get_id(), count.getCount(), cumulativePercentage);
            paretoDataList.add(paretoData);
        }

        return paretoDataList;
    }


    public long countFivewhysByProject(String projectId) {
        return fiveWhysRepository.countByIdproject(projectId);
    }
    public long countFivewhysWithoutSolutionByProject(String projectId) {
        List<Fivewhys> fivewhysList = fiveWhysRepository.findByIdproject(projectId);
        return fivewhysList.stream()
                .filter(fw -> fw.getSolution_fivewhys() == null || fw.getSolution_fivewhys().isEmpty())
                .count();
    }
    public Map<String, Long> countByCategorieProblem(String idproject) {
        List<Fivewhys> fivewhysList = fiveWhysRepository.findByIdproject(idproject);

        // Initialize a map to hold the counts
        Map<String, Long> categoryCounts = new HashMap<>();

        // Count occurrences of each category
        for (Fivewhys fivewhys : fivewhysList) {
            String category = fivewhys.getCategorieProblem().name();
            categoryCounts.put(category, categoryCounts.getOrDefault(category, 0L) + 1);
        }

        return categoryCounts;
    }

    // Format the data for radar chart
    public Map<String, Object> getRadarChartData(String idproject) {
        Map<String, Long> counts = countByCategorieProblem(idproject);

        // Convert the counts to a format suitable for radar chart
        Map<String, Object> radarData = new HashMap<>();
        radarData.put("labels", counts.keySet());
        radarData.put("data", counts.values());

        return radarData;
    }
}