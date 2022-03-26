package by.polyanski.springcrud.dao;

import by.polyanski.springcrud.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT; // спосод для динамической генерации Id, который будет увеличивать его на 1
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Tom"));
        people.add(new Person(++PEOPLE_COUNT, "Bob"));
        people.add(new Person(++PEOPLE_COUNT, "Mike"));
        people.add(new Person(++PEOPLE_COUNT, "Katy"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person){
        person.setId(++PEOPLE_COUNT); // спосод для динамической генерации Id, который будет увеличивать его на 1
        people.add(person);
    }

    public void  update(int id, Person updatedPerson) {
        Person personToBeUpdate = show(id);
        personToBeUpdate.setName(updatedPerson.getName());
    }

    public  void delete(int id){
        people.removeIf(p -> p.getId() == id);
    }
}