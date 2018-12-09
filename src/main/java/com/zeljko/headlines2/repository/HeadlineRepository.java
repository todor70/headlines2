package com.zeljko.headlines2.repository;

import com.zeljko.headlines2.entity.Headline;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeadlineRepository extends CrudRepository<Headline, Long> {



}
