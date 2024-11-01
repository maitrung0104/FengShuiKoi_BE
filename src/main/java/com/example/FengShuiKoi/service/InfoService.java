package com.example.FengShuiKoi.service;



import com.example.FengShuiKoi.entity.*;
import com.example.FengShuiKoi.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class InfoService {
    @Autowired
    ElementRepository elementRepository;
    @Autowired
    LakeDirectionRepository lakeDirectionRepository;
    @Autowired
    KoiFishPondRepository koiFishPondRepository;
    @Autowired
    SuitableElementRepository suitableElementRepository;
    @Autowired
    KoiRepository koiRepository;

    public List<String> getDirections(String elementName) {
        Element element = elementRepository.findByName(elementName);
        List<Suitable> suitableElements = suitableElementRepository.findByElement(element);
        Set<String> directions = new HashSet<>();

        for (Suitable suitable : suitableElements) {
            // Lấy hướng từ mệnh thích hợp
            List<LakeDirection> lakeDirections = lakeDirectionRepository.findByElement(suitable.getSuitableElement());
            for (LakeDirection direction : lakeDirections) {
                directions.add(direction.getDirection());
            }
        }

        return new ArrayList<>(directions);
    }

    public List<String> getShapes(String elementName) {
        Element element = elementRepository.findByName(elementName);
        List<Suitable> suitableElements = suitableElementRepository.findByElement(element);
        Set<String> shapes = new HashSet<>();

        for (Suitable suitable : suitableElements) {
            // Lấy hình dáng từ mệnh thích hợp
            List<KoiFishPond> koiShapes = koiFishPondRepository.findByElement(suitable.getSuitableElement());
            for (KoiFishPond shape : koiShapes) {
                shapes.add(shape.getShape());
            }
        }

        return new ArrayList<>(shapes);

    }
    public List<Koi> getKoiByElement (String elementName){
        Element element= elementRepository.findByName(elementName);
        if(element == null){
            throw new RuntimeException("Element not found");
        }
        List<Suitable> suitableElements= suitableElementRepository.findByElement(element);
        List<Koi> koiList = new ArrayList<>();
        for (Suitable suitable : suitableElements) {
            koiList.addAll(koiRepository.findByElement(suitable.getSuitableElement().getName()));
        }

        return koiList;
    }
}
