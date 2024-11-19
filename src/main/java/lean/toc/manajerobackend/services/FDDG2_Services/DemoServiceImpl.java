package lean.toc.manajerobackend.services.FDDG2_Services;

import lean.toc.manajerobackend.models.FDDG2_Entities.Demo;
import lean.toc.manajerobackend.repositories.FDDG2_Repositories.IDemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

@Service
public class DemoServiceImpl implements DemoService{
    @Autowired
    IDemoRepository iDemoRepository;
    @Value("${file.upload-dir}")
    String uploadDir;
    @Override
    public List<Demo> getAllDemo() {
        return iDemoRepository.findAll();
    }

    @Override
    public Demo AddDemo(Demo demo) {
        demo.setCreatedAt(LocalDate.now());
        return iDemoRepository.save(demo);
    }

    @Override
    public Demo EditDemo(Demo demo, String codeDemo) {
        Demo newDemo= iDemoRepository.findDemoByCodeDemo(codeDemo);
        newDemo.setTitle(demo.getTitle());
        newDemo.setIntroduction(demo.getIntroduction());
        newDemo.setObjectives(demo.getObjectives());
        newDemo.setWhat(demo.getWhat());
        newDemo.setHow(demo.getHow());
        newDemo.setWhy(demo.getWhy());
        newDemo.setWhatIf(demo.getWhatIf());
        newDemo.setAdvantages(demo.getAdvantages());
        newDemo.setDisadvantages(demo.getDisadvantages());
        newDemo.setRoles(demo.getRoles());
        newDemo.setLifeCycle(demo.getLifeCycle());
        return iDemoRepository.save(newDemo);
    }
    @Override
    public String deleteDemo(String codeDemo) {

        iDemoRepository.deleteById(codeDemo);
        return "deleted successfully";
    }

    @Override
    public Demo getOneDemo(String codeDemo) {
        return iDemoRepository.findDemoByCodeDemo(codeDemo);
    }


    @Override
    public Resource loadFileAsResource(String fileName) {
        try {
            Path filePath = Paths.get(uploadDir).resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());

            if (resource.exists()) {
                return resource;
            } else {
                throw new RuntimeException("File not found: " + fileName);
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("File not found: " + fileName, e);
        }
    }

}
