package ir.maktab.last.service.base.impl;

import ir.maktab.last.entity.base.BaseEntity;
import ir.maktab.last.service.base.BaseService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;


public class BaseServiceImpl<E extends BaseEntity<ID>, ID extends Serializable
        , R extends JpaRepository<E, ID>> implements BaseService<E, ID> {

    private final R repository;

    public BaseServiceImpl(R repository) {
        this.repository = repository;
    }

    @Override
    public E create(E e) {
        return repository.save(e);
    }

    @Override
    public E update(E e) {
        return repository.save(e);
    }

    @Override
    public void deleteById(ID id) {
       repository.deleteById(id);
    }

    @Override
    public void delete(E e) {
         repository.delete(e);
    }

    @Override
    public E findById(ID id) {
        return repository.findById(id)
           .orElseThrow(() -> new IllegalArgumentException("Invalid  Id:" + id));
    }

    @Override
    public List<E> findAll() {
        return repository.findAll();
    }
}
