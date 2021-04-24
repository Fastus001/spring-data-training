package pl.sdacademy.spring.springdatatraining.person;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.sdacademy.spring.springdatatraining.csv.CsvFile;
import pl.sdacademy.spring.springdatatraining.csv.CsvLine;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
//@RequiredArgsConstructor
public class PersonReader {

//    private final PersonRepository repository;
    private static final String PERSON_CSV_FILE = "person.csv";

    public List<Person> read() {
        File personFile = new File(getClass().getClassLoader().getResource(PERSON_CSV_FILE).getFile());
        return this.readFromFile(personFile);
    }

    private List<Person> readFromFile(File fileName) {
        CsvFile csvLines = CsvFile.fromFile(fileName);
        List<Person> personCsvEntries = new ArrayList<>();
        long start = System.currentTimeMillis();
        for (CsvLine csvLine : csvLines) {
            personCsvEntries.add(new Person(csvLine));
        }
        long stop = System.currentTimeMillis();
        log.info("Converted " + personCsvEntries.size() + " in " + (stop - start) + " ms");
        return personCsvEntries;
    }
}
