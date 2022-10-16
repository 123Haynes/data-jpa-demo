package com.example.datajpademo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;

public interface DemoRepository extends JpaRepository<DemoEntity, String> {

  @Modifying
  @Transactional
  int deleteByUpdatedBefore(ZonedDateTime threshold);
}
