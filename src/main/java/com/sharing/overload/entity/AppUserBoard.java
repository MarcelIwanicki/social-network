package com.sharing.overload.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "app_user_board")
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
    private String content;
}
