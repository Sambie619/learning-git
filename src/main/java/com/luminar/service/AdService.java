package com.luminar.service;

import java.util.List;

import com.luminar.entity.Ad;

public interface AdService {

    void addAd(Ad ad);

    List<Ad> getAllAds();
}
