package pl.sdacademy.spring.springdatatraining.person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findAllByName(String name);

    List<Person> findAllBySex(String sex);

    List<Person> findAllByLastNameAndSex(String name, String sex);

    List<Person> findAllByLastNameIgnoreCaseOrderByBirthDateAsc(String name);

    @Query(value = "select p from Person p where p.name = :name")
    List<Person> findMultiplePeopleByName(String name);


}
