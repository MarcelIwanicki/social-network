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

    public AppPost getPostById(long id) {

        int low = 0;
        int high = appPosts.size()-1;
        int mid = (low + high) / 2;

        while (low < high) {
            if (appPosts.get(mid).getId() == id) {
                return appPosts.get(mid);
            } else if (id < appPosts.get(mid).getId()) {
                high = mid;
            } else if (id > appPosts.get(mid).getId()) {
                low = mid;
            }
        }

        return null;
    }
}
