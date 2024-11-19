package lean.toc.manajerobackend.services.FDDG2_Services;

import lean.toc.manajerobackend.models.FDDG2_Entities.WorkSpace;

import java.util.List;

public interface WorkSpaceService {
    public List<WorkSpace> getAllWorkSpace();
    public List<WorkSpace> getUserWorkspace(String id);
    public WorkSpace AddWorkSpace(WorkSpace WS);
    public WorkSpace EditWorkSpace(WorkSpace WS, String codeDemo);
    public void deleteWorkSpace(String codeWS);
    public WorkSpace getOneWorkSpace(String codeWS);

}
