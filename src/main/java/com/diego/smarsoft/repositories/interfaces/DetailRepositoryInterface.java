package com.diego.smarsoft.repositories.interfaces;

import com.diego.smarsoft.models.entities.Detail;

import java.util.List;

public interface DetailRepositoryInterface {
    List<Detail> getAll();
    Detail save(Detail detail);
}
