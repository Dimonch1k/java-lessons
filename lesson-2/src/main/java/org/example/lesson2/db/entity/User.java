package org.example.lesson2.db.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table( name = "users" )
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long      id;

  @Column(name = "name", nullable = false, columnDefinition = "VARCHAR(255)")
  private String name;

  @Column(name = "email", nullable = false, columnDefinition = "VARCHAR(255)", unique = true)
  private String email;

  @ManyToMany
  @JoinTable(
    name = "user_roles",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id")
  )
  @Builder.Default
  private Set<Role> roles = new HashSet<>();
}