package ru.vlapin.springbootexperiment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static lombok.AccessLevel.PRIVATE;

@RepositoryRestResource
interface CatRepository extends JpaRepository<Cat, Long> {
}

@SpringBootApplication
public class SpringBootExperimentApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringBootExperimentApplication.class, args);
  }
}

@Getter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
class Cat {

  @Id
  @GeneratedValue
  Long id;

  String name;

  public Cat(String name) {
    this.name = name;
  }
}