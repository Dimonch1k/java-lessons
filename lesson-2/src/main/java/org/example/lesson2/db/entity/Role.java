package org.example.lesson2.db.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table( name = "roles" )
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Role
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long      id;

  @Column( name = "name", nullable = false, columnDefinition = "VARCHAR(255)" )
  private String name;

  @OneToMany(mappedBy = "role")
  @Builder.Default
  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  @JsonIgnore
  private Set<User> users = new HashSet<>();
}