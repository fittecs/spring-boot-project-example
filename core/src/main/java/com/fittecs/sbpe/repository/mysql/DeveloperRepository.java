package com.fittecs.sbpe.repository.mysql;

import com.fittecs.sbpe.entity.mysql.Developer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeveloperRepository extends JpaRepository<Developer, Long> {}
