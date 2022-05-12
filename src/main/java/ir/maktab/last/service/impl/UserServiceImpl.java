package ir.maktab.last.service.impl;

import ir.maktab.last.entity.User;

import ir.maktab.last.service.UserService;
import ir.maktab.last.service.base.impl.BaseServiceImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseServiceImpl<User,Long, JpaRepository<User,Long>> implements UserService {

    public UserServiceImpl(JpaRepository<User, Long> repository) {
        super(repository);
    }
}
