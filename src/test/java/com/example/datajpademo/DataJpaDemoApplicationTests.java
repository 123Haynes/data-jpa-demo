package com.example.datajpademo;

import static com.example.datajpademo.ZonedDateTimeConverter.BERLIN;
import static org.assertj.core.api.Assertions.assertThat;

import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@DataJpaTest
class DemoRepositoryTest {

  @Autowired
  private TestEntityManager entityManager;

  private DemoEntity testEntity;

  private ZonedDateTime today;


  @Test
  void test() {

    today = ZonedDateTime.now(BERLIN);

    testEntity = new DemoEntity();
    testEntity.setIdentificationString("test");
    testEntity.setUpdated(ZonedDateTime.now(ZoneId.of("Europe/Berlin")).minusDays(14L));

    entityManager.persist(testEntity);

    TypedQuery<DemoEntity> query = entityManager.getEntityManager().createQuery(
        "select d1_0 from DemoEntity d1_0 where d1_0.updated<?1", DemoEntity.class);
    DemoEntity demo = query.setParameter(1, today).getSingleResult();

    assertThat(demo.getUpdated()).isEqualTo(testEntity.getUpdated());

  }
}
