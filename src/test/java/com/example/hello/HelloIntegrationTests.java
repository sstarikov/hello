package com.example.hello;

import com.example.hello.model.Hello;
import com.example.hello.repository.HelloRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import static org.assertj.core.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.sql.Date;

@RunWith(SpringRunner.class)
@DataJpaTest
public class HelloIntegrationTests {

    @Autowired
    private HelloRepository helloRepository;

    @Test
    public void whenFindByName_thenReturnUser() {
        // given
        long millis=System.currentTimeMillis();
        Date date=new Date(millis);
        Hello hello = new Hello("testuser", date);
        helloRepository.save(hello);

        // when
        Hello found = helloRepository.findByName(hello.getName());

        // then
        assertThat(found.getName())
                .isEqualTo(hello.getName());
    }
}
