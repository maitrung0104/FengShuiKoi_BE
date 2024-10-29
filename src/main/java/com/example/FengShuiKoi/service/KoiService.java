package com.example.FengShuiKoi.service;

import com.example.FengShuiKoi.model.KoiRequest;
import com.example.FengShuiKoi.repos.KoiRepository;
import com.example.FengShuiKoi.entity.Koi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.UUID;

@Service
public class KoiService {

    @Autowired
    KoiRepository koiRepository;

    @Autowired
    AuthService authService;

    public Koi create(Koi koi) {
        koi.setAccount(authService.getCurrentAccount());
        return koiRepository.save(koi);
    }

    public List<Koi> getAll() {


        return koiRepository.findAll();
    }



    public Koi update(UUID id, KoiRequest koiRequest) {
        Koi koi = koiRepository.findById(id).orElseThrow();
        koi.setSpecies(koiRequest.getSpecies());
        koi.setColour(koiRequest.getColour());
        koi.setSize(koiRequest.getSize());
        koi.setAge(koiRequest.getAge());
        koi.setOrigin(koiRequest.getOrigin());
        koi.setElement(koiRequest.getElement());
        koi.setDescription(koiRequest.getDescription());
        koi.setPrice(koiRequest.getPrice());
        koi.setProductCode(koiRequest.getProductCode());
        koi.setImage(koiRequest.getImage());
        koi.setCreatedBy(koiRequest.getCreatedBy());

        return koiRepository.save(koi);




    }
    public void deleteKoi(UUID id) {
        koiRepository.deleteById(id);

    }
}

