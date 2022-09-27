package com.joysbrightt.musicrendering.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

import java.util.List;

import java.util.Set;

@Entity
@Table(name = "users")
@Validated
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users")
    @SequenceGenerator(name = "user", initialValue =1 )
    @Column(name ="user_id", nullable = false)
    private Long id;
    @NotBlank
    @NotNull
    private String firstName;

    @NotBlank
    @NotNull
    private String lastName;

    @NotBlank
    @NotNull
    @Column(unique = true)
    @Email
    private String email;

    @NotBlank
    @NotNull
    private String password;

    @NotBlank
    @NotNull
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-YY")
    private LocalDate dob;


    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-YY")
    private LocalDate dateJoined;

    private String genre;
    private boolean isVerified;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Favourite> favourite;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Downloads> downloads;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Recent> recents;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    private List<UserPlaylist> userPlaylists;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Songs> songs;


     @Enumerated(value = EnumType.STRING)
    private AccountStatus accountStatus;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Role> roles;

    public User(String admin, String user, String s, String password, Roletype roleAdmin) {

    }



    @Override
    public String toString(){
        return "User{" +
                "id=" +id +", " +
                "` " +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" +email +'\'' +'}';
    }

    public void addRole(Role role){
        this.roles.add(role);
    }


}
