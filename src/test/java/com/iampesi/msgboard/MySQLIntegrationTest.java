package com.iampesi.msgboard;

// test that we can get a connection to the database

import com.iampesi.msgboard.repository.UserRepository;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("local")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MySQLIntegrationTest {
    
    @Autowired
    UserRepository userRepository;
    
    @Test
    void testMySQL() {
        long countBefore = userRepository.count();
        assertThat(countBefore).isGreaterThan(0);
    }
}
