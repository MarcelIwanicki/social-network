package com.sharing.overload;

import com.sharing.overload.entity.AppUser;
import com.sharing.overload.repository.AppUserRepository;
import com.sharing.overload.service.AppUserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class AppUserServiceIntegrationTest {

    @TestConfiguration
    static class AppUserServiceTestContextConfiguration {

        @Bean
        public AppUserService appUserService() {
            return new AppUserService();
        }
    }

    @Autowired
    private AppUserService appUserService;

    @MockBean
    private AppUserRepository appUserRepository;

    @Before
    public void setUp() {
        AppUser bob = new AppUser(AppUser.Role.REGULAR_USER, "bob");

        Mockito.when(appUserRepository.findAppUserByUsername(bob.getUsername()))
                .thenReturn(bob);
    }

    @Test
    public void whenValidUsername_thenAppUserShouldBeFound() {
        String name = "bob";
        AppUser found = appUserService.findByUsername(name);

        assertThat(found.getUsername()).isEqualTo(name);
    }
}
