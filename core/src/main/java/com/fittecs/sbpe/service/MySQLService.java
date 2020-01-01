package com.fittecs.sbpe.service;

import com.fittecs.sbpe.entity.mysql.Developer;
import com.fittecs.sbpe.repository.mysql.DeveloperRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MySQLService {

  @Autowired DeveloperRepository repository;

  public List<Developer> allDevelopers() {
    return repository.findAll();
  }
}
