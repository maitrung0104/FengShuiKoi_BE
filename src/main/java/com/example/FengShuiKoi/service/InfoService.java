package com.example.FengShuiKoi.service;



import com.example.FengShuiKoi.entity.*;
import com.example.FengShuiKoi.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    //    public List<LakeDirection> getLakeDirectionsByElement(String elementName) {
//        Element element = elementRepository.findByName(elementName);
//        if (element == null) {
//            throw new RuntimeException("Element not found");
//        }
//
//        // Lấy danh sách mệnh phù hợp
//        List<Suitable> suitableElements = suitableElementRepository.findByElement(element);
//        List<LakeDirection> lakeDirections = new ArrayList<>();
//
//        for (Suitable suitableElement : suitableElements) {
//            // Lấy hướng hồ từ mệnh phù hợp
//            List<LakeDirection> directions = lakeDirectionRepository.findByElement(suitableElement.getSuitableElement());
//            lakeDirections.addAll(directions);
//        }
//
//        return lakeDirections;
//    }
//    public List<KoiFishPond> getKoiFishPondsByElement(String elementName) {
//        Element element = elementRepository.findByName(elementName);
//        if (element == null) {
//            throw new RuntimeException("Element not found");
//        }
//
//        // Lấy danh sách mệnh phù hợp
//        List<Suitable> suitableElements = suitableElementRepository.findByElement(element);
//        List<KoiFishPond> koiFishPonds = new ArrayList<>();
//
//        for (Suitable suitableElement : suitableElements) {
//            // Lấy hình dáng hồ từ mệnh phù hợp
//            List<KoiFishPond> ponds = koiFishPondRepository.findByElement(suitableElement.getSuitableElement());
//            koiFishPonds.addAll(ponds);
//        }
//
//        return koiFishPonds;
//    }
    public Map<String, Object> getLakeDirectionAndKoiFishPondByElement(String elementName) {
        Element element = elementRepository.findByName(elementName);
        if (element == null) {
            throw new RuntimeException("Element not found");
        }

        // Lấy danh sách mệnh phù hợp
        List<Suitable> suitableElements = suitableElementRepository.findByElement(element);

        // Lấy danh sách hướng hồ và hình dáng hồ
        Map<String, Object> result = new HashMap<>();
        result.put("lakeDirections", lakeDirectionRepository.findByElement(element));
        result.put("koiFishPonds", koiFishPondRepository.findByElement(element));

        return result;
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
