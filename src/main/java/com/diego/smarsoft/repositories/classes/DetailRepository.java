package com.diego.smarsoft.repositories.classes;

import com.diego.smarsoft.models.entities.Detail;
import com.diego.smarsoft.repositories.crud.DetailCrudRepository;
import com.diego.smarsoft.repositories.interfaces.DetailRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DetailRepository implements DetailRepositoryInterface {
    @Autowired
    private DetailCrudRepository detailCrudRepository;


    @Override
    public List<Detail> getAll() {
        return (List<Detail>) detailCrudRepository.findAll();
    }

    @Override
    public Detail save(Detail detail) {
        return detailCrudRepository.save(detail);
    }
}
