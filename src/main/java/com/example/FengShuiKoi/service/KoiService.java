package com.example.FengShuiKoi.service;

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

        public Koi create(Koi product) {
            return koiRepository.save(product);
        }

        public List<Koi> getAll() {
            return koiRepository.findAll();
        }

        public Koi getProductById(UUID id) {
            return koiRepository.findKoiById(id);
        }

        public Koi update(UUID id, Koi product) {
            // implementation

            return null;
        }
        public void deleteKoi(UUID id) {
            // implementation
        }
    }

