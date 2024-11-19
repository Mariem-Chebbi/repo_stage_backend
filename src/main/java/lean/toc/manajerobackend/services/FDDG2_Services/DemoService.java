package lean.toc.manajerobackend.services.FDDG2_Services;

import lean.toc.manajerobackend.models.FDDG2_Entities.Demo;
import org.springframework.core.io.Resource;

import java.util.List;

public interface DemoService {
    public List<Demo> getAllDemo();
    public Demo AddDemo(Demo demo);
    public Demo EditDemo(Demo demo, String codeDemo);
    public String deleteDemo(String codeDemo);
    public Demo getOneDemo(String codeDemo);
    public Resource loadFileAsResource(String fileName);
}
