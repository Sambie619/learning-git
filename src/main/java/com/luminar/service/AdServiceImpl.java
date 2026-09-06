package com.luminar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luminar.entity.Ad;
import com.luminar.repository.AdRepository;

@Service
public class AdServiceImpl implements AdService {

    @Autowired
    private AdRepository adRepository;

    @Override
    public void addAd(Ad ad) {
        adRepository.save(ad);
    }

    @Override
    public List<Ad> getAllAds() {
        return adRepository.findAll();
    }
}
