package com.example.demojsp.repository;

import com.example.demojsp.domain.Entity1;
import com.example.demojsp.domain.Entity2;
import com.example.demojsp.domain.Entity3;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class Entity1RepositoryTest {

    @Autowired
    Entity1Repository entity1Repository;

    @Autowired
    Entity2Repository entity2Repository;
    @Autowired
    Entity3Repository entity3Repository;

    @Test
    @Transactional
    void saveTest() {
        Long id = 10L;
        Entity1 entity1 = new Entity1();
        entity1.setId(id);
        entity1.setName("ENTITY1");

        Entity2 entity2 = new Entity2();
        entity2.setValue("VAL-ENTITY2");
        entity2.setEntity1(entity1);
        entity2Repository.save(entity2);

        Entity3 entity3 = new Entity3();
        entity3.setValue("VAL-ENTITY3");
        entity3.setEntity1(entity1);
        entity3Repository.save(entity3);


        assertThat(entity2Repository.getOne(id))
                .isNotNull()
                .extracting("entity1")
                .isNotNull()
                .extracting("name")
                .isEqualTo("ENTITY1");

        assertThat(entity3Repository.getOne(id))
                .isNotNull()
                .extracting("entity1")
                .isNotNull()
                .extracting("name")
                .isEqualTo("ENTITY1");

    }

    @Test
    @Transactional
    void saveTest2() {
        Long id = 10L;
        Entity1 entity1 = new Entity1();
        entity1.setId(id);
        entity1.setName("ENTITY1");
//        entity1Repository.save(entity1);

        Entity2 entity2 = new Entity2();
        entity2.setValue("VAL-ENTITY2");
        entity2.setEntity1(entity1);
//        entity2Repository.save(entity2);
        entity1.setEntity2(entity2);

        Entity3 entity3 = new Entity3();
        entity3.setValue("VAL-ENTITY3");
        entity3.setEntity1(entity1);
//        entity3Repository.save(entity3);
        entity1.setEntity3(entity3);

        entity1Repository.save(entity1);

        Entity1 one = entity1Repository.getOne(id);
        assertThat(entity1Repository.getOne(id))
                .isNotNull()
                .extracting("entity2")
                .isNotNull()
                .extracting("value")
                .isEqualTo("VAL-ENTITY2");

        assertThat(entity2Repository.getOne(id))
                .isNotNull()
                .extracting("entity1")
                .isNotNull()
                .extracting("name")
                .isEqualTo("ENTITY1");

        assertThat(entity3Repository.getOne(id))
                .isNotNull()
                .extracting("entity1")
                .isNotNull()
                .extracting("name")
                .isEqualTo("ENTITY1");

    }

}