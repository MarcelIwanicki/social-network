package com.sharing.overload.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "app_user")
@AllArgsConstructor
@NoArgsConstructor
public class AppUser {

    public enum Role {
        REGULAR_USER,
        SUPER_USER,
        MODERATOR,
        ADMIN
    }

    @Id
    @GeneratedValue
    @Getter
    @Column(name = "id")
    private long id;

    @Getter @Setter
    @Column(name = "role")
    private Role role;

    @Getter @Setter
    @Column(name = "username")
    private String username;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="app_user_board", referencedColumnName = "id")
    @Getter @Setter
    private AppUserBoard appUserBoard;

    public AppUser(Role role, String username) {
        this.role = role;
        this.username = username;
    }
}
