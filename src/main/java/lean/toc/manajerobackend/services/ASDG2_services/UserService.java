package lean.toc.manajerobackend.services.ASDG2_services;


import lean.toc.manajerobackend.models.ASDG2_models.User;

import lean.toc.manajerobackend.repositories.ASDG2_repositories.ASDUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private ASDUserRepository ASDUserRepository;

    public User createUser(User user) {
        return ASDUserRepository.save(user);
    }

    public User getUser(String id) {
        return ASDUserRepository.findById(id).orElseThrow();
    }

    public List<User> getAllUsers() {
        return ASDUserRepository.findAll();
    }
    // additional service methods, if needed
}
