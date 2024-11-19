package lean.toc.manajerobackend.services.FDDG2_Services;

import lean.toc.manajerobackend.models.FDDG2_Entities.WorkSpace;
import lean.toc.manajerobackend.repositories.FDDG2_Repositories.IWorkSpaceRepository;
import lean.toc.manajerobackend.repositories.FDDG2_Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class WorkSpaceServicelmpl implements WorkSpaceService{
    @Autowired
    IWorkSpaceRepository iWorkSpaceRepository;
    @Autowired
    UserRepository userRepository;
    @Override
    public List<WorkSpace> getAllWorkSpace() {
        return iWorkSpaceRepository.findAll();
    }

    @Override
    public List<WorkSpace> getUserWorkspace(String id) {
        return iWorkSpaceRepository.findWorkSpaceByUserId(id);
    }

    @Override
    public WorkSpace AddWorkSpace(WorkSpace WS) {
       WS.setDate(LocalDate.now());
        return iWorkSpaceRepository.save(WS);
    }

    @Override
    public WorkSpace EditWorkSpace(WorkSpace WS, String codeSW) {
        WorkSpace newWS =iWorkSpaceRepository.findWorkSpaceByCodeWS(codeSW);
        newWS.setName(WS.getName());
        newWS.setDomain(WS.getDomain());
        return iWorkSpaceRepository.save(newWS);
    }

    @Override
    public void deleteWorkSpace(String codeWS) {
        iWorkSpaceRepository.deleteById(codeWS);

    }

    @Override
    public WorkSpace getOneWorkSpace(String codeWS) {
        return iWorkSpaceRepository.findWorkSpaceByCodeWS(codeWS);
    }
}
