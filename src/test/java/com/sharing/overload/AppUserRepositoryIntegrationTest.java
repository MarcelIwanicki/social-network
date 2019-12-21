package com.sharing.overload;

import com.sharing.overload.entity.AppUser;
import com.sharing.overload.repository.AppUserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AppUserRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AppUserRepository userRepository;

    @Test
    public void whenFindByName_thenReturnEmployee() {
        AppUser bob = new AppUser(AppUser.Role.REGULAR_USER, "bob");
        entityManager.persist(bob);
        entityManager.flush();

        AppUser found = userRepository.findAppUserByUsername("bob");

        assertThat(found.getUsername()).isEqualTo(bob.getUsername());
    }
}
