package ir.maktab.last.service.base;

import ir.maktab.last.entity.base.BaseEntity;

import java.io.Serializable;
import java.util.List;

public interface BaseService<E extends BaseEntity<ID> , ID extends Serializable> {

    E create(E e);

    E update(E e);

    void deleteById(ID id);

    void delete(E e);

    E findById(ID id);

    List<E> findAll();

}
