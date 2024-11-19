package lean.toc.manajerobackend.services.safe_services.IServices;


import lean.toc.manajerobackend.models.safe_models.Backlog;

import java.util.List;

public interface IBacklogService {
  Backlog addBacklog(Backlog backlog);
  Backlog updateBacklog(Backlog backlog);
  Backlog getBacklogById(String id);
  void deleteBacklog(String id);
  List<Backlog> AllBacklog();

}
