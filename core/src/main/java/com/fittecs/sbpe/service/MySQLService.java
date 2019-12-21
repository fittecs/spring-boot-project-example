package com.fittecs.sbpe.service;

import com.fittecs.sbpe.entity.Member;
import com.fittecs.sbpe.repository.MemberRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MySQLService {

  @Autowired MemberRepository memberRepository;

  public List<Member> allMembers() {
    return memberRepository.findAll();
  }
}
