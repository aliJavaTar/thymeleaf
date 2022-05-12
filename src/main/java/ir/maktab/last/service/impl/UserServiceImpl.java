package ir.maktab.last.service.impl;

import ir.maktab.last.entity.User;

import ir.maktab.last.repository.UserRepository;
import ir.maktab.last.service.UserService;
import ir.maktab.last.service.base.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, Long, JpaRepository<User, Long>> implements UserService {
    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(JpaRepository<User, Long> repository, UserRepository repository1) {
        super(repository);
        this.repository = repository1;
    }

    @Override
    public User findByUsername(String username) {
        return repository.findByUsername(username);
    }
}
