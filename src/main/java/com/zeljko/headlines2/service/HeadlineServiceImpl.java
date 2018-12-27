package com.zeljko.headlines2.service;

import com.zeljko.headlines2.entity.Headline;
import com.zeljko.headlines2.repository.HeadlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HeadlineServiceImpl implements HeadlineService {

    private HeadlineRepository headlineRepository;

    @Autowired
    public HeadlineServiceImpl(HeadlineRepository headlineRepository) {
        this.headlineRepository = headlineRepository;
    }

    @Override
    public void saveHeadline(Headline headline) {
        headlineRepository.save(headline);
    }

    @Override
    public Headline getHeadlineById(long id) {
        return headlineRepository.findById(id).get();
    }
}
