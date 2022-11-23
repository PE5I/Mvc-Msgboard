package com.iampesi.msgboard.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;
    private String password;
    private String location;
    private LocalDate dateJoin;
    
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "user")
    private List<Post> posts;

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "user")
    private List<Comment> comments;

    public User() {
    }
    
    public User(String username, String password) {
        this.username = username;
        this.password = password;

    }
    
    public User(String username, String email, String password, String location, LocalDate dateJoin) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.location = location;
        this.dateJoin = dateJoin;
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    
    @Override
    public String toString() {
        return "User{" +
                   "id=" + id +
                   ", username='" + username + '\'' +
                   ", email='" + email + '\'' +
                   ", password='" + password + '\'' +
                   ", location='" + location + '\'' +
                   ", dateJoin=" + dateJoin +
                   ", posts=" + posts +
                   ", comments=" + comments +
                   '}';
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getLocation() {
        return location;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }
    
    public LocalDate getDateJoin() {
        return dateJoin;
    }
    
    public void setDateJoin(LocalDate dateJoin) {
        this.dateJoin = dateJoin;
    }
    
    public List<Post> getPosts() {
        return posts;
    }
    
    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
    
    public List<Comment> getComments() {
        return comments;
    }
    
    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
