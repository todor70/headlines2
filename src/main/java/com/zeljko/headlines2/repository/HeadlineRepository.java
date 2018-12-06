package com.zeljko.headlines2.repository;

import com.zeljko.headlines2.domain.Headline;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HeadlineRepository extends CrudRepository<Headline, Long> {



}
