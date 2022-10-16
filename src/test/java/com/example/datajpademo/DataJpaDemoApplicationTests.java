package com.example.datajpademo;

import static com.example.datajpademo.ZonedDateTimeConverter.BERLIN;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Optional;

@DataJpaTest
class DemoRepositoryTest {

  @Autowired
  private DemoRepository repository;

  private DemoEntity testEntity;

  private ZonedDateTime today;


  /**
   * Entfernen der Testdaten.
   */
  @AfterEach
  void tearDown() {

    repository.deleteAll();
  }

  @Test
  void test() {

    today = ZonedDateTime.now(BERLIN);

    testEntity = new DemoEntity();
    testEntity.setIdentificationString("test");
    testEntity.setUpdated(ZonedDateTime.now(ZoneId.of("Europe/Berlin")).minusDays(14L));

    repository.save(testEntity);

    int optionalData = repository.deleteByUpdatedBefore(
        ZonedDateTime.now(ZoneId.of("Europe/Berlin")).minusDays(10L));
  }
}
