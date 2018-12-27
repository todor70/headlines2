package com.zeljko.headlines2.service;

import com.zeljko.headlines2.entity.Headline;

public interface HeadlineService {

    void saveHeadline(Headline headline);

    Headline getHeadlineById(long id);
}
