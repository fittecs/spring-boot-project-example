package com.fittecs.sbpe.service;

import com.fittecs.sbpe.entity.Developer;
import com.fittecs.sbpe.repository.DeveloperRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MySQLService {

  @Autowired
  DeveloperRepository repository;

  public List<Developer> allMembers() {
    return repository.findAll();
  }
}
