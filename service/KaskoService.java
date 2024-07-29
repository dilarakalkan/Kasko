package com.example.sompo.service;
import com.example.sompo.repository.KaskoRepository;
import com.example.sompo.model.KaskoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class KaskoService {
    @Autowired
    private KaskoRepository kaskoRepository;
    public Iterable <KaskoModel> gettAllKaskos(){
        return kaskoRepository.findAll();
    }
    public KaskoModel saveKasko(KaskoModel kasko){
        return kaskoRepository.save(kasko);
    }
    public void deleteKasko(Long id){
        kaskoRepository.deleteById(id);
    }
    public KaskoModel getKaskoById(Long id){
        return kaskoRepository.findById(id).orElse(null);
    }
}
