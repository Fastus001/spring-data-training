package pl.sdacademy.spring.springdatatraining.person;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import pl.sdacademy.spring.springdatatraining.csv.CsvLine;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Accessors(chain = true)
@Data
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String lastName;
    private String sex;
    private LocalDate birthDate;

    public Person(CsvLine line) {
        id = Long.parseLong(line.getElementAt(0));
        name = line.getElementAt(1);
        lastName = line.getElementAt(2);
        sex = line.getElementAt(3);
        birthDate = LocalDate.parse(line.getElementAt(4));
    }
}
