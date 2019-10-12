package com.sharing.overload.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "app_user_boards")
@AllArgsConstructor
@NoArgsConstructor
public class AppUserBoard {

    @Id
    @GeneratedValue
    @Getter
    @Column(name = "id")
    private long id;

    @OneToOne(mappedBy = "appUserBoard")
    @Getter @Setter
    private AppUser appUser;

    @Getter @Setter
    private String header;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "board")
    private List<AppPost> appPosts = new ArrayList<>();

    public void addPost(@NotNull AppPost post) {
        appPosts.add(post);
        post.setBoard(this);
    }
}
