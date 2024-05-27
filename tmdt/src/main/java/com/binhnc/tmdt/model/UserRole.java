package com.binhnc.tmdt.model;

import javax.persistence.*;

@Entity
@Table(name = "users_roles")
public class UserRole {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_user_id"))
    private User user;
    @ManyToOne
    @JoinColumn(name = "roleId", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_role_id"))
    private Role role;

    public UserRole() {
        super();
    }

    public UserRole(Long id, User user, Role role) {
        super();
        this.id = id;
        this.user = user;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}