package com.example.sompo.repository;

import com.example.sompo.model.KaskoModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface KaskoRepository extends CrudRepository<KaskoModel,Long> {
}
