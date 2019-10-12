package com.sharing.overload.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "app_posts")
@NoArgsConstructor
@AllArgsConstructor
public class AppPost {

    @Id
    @GeneratedValue
    @Getter @Setter
    private long id;

    @Getter @Setter
    private String username;

    @Getter @Setter
    private String content;

    @Lob
    @Getter @Setter
    private byte[] image;

    @ManyToOne
    @JoinColumn(name = "board_id")
    @Setter
    private AppUserBoard board;

    public AppPost(String username, String content) {
        this.username = username;
        this.content = content;
    }
}
