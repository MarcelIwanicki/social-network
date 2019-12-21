package com.sharing.overload;

import com.sharing.overload.controller.RestUserController;
import com.sharing.overload.entity.AppUser;
import com.sharing.overload.service.AppUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.Arrays;
import java.util.List;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(RestUserController.class)
public class AppUserRestControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private AppUserService service;

    @Test
    public void givenUsers_whenGetUsers_thenReturnJsonArray() throws Exception {
        AppUser bob = new AppUser(AppUser.Role.REGULAR_USER, "bob");

        List<AppUser> allUsers = Arrays.asList(bob);

        given(service.getAllUsers()).willReturn(allUsers);

        mvc.perform(get("/rest/users")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect((ResultMatcher) jsonPath("$[0].username", is(bob.getUsername())));
    }
}
