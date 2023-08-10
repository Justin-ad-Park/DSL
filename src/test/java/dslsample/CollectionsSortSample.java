package dslsample;

import org.junit.jupiter.api.Test;

import java.util.*;

public class CollectionsSortSample {
    List<Person> persons = Arrays.asList(new Person(45, "Justin")
            , new Person(29, "Herry")
            , new Person(17, "Suji")
            , new Person(17, "Anna")
            , new Person(17, "Terry")
    );

    public record Person(int age, String name) {
        @Override
        public String toString() {
            return this.name + " : " + this.age;
        }
    }

    void CollectionsPrint() {
        persons.forEach(System.out::println);
    }

    @Test
    void CollectionsSort1() {
        Collections.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.age - p2.age;
            }
        });

        CollectionsPrint();

    }

    @Test
    void CollectionsSort2() {
        Collections.sort(persons, (p1, p2) -> p1.age - p2.age);

        CollectionsPrint();
    }

    @Test
    void CollectionsSort3() {
        Collections.sort(persons, Comparator.comparing(p->p.age));

        CollectionsPrint();
    }

    @Test
    void CollectionsSort4() {
        Collections.sort(persons, Comparator.comparing(Person::age));

        CollectionsPrint();
    }

    @Test
    void CollectionsSortWithReverse() {
        Collections.sort(persons, Comparator.comparing(Person::age).reversed());

        CollectionsPrint();
    }

    @Test
    void CollectionsSortThenComparing() {
        Collections.sort(persons, Comparator.comparing(Person::age).thenComparing(Person::name));

        CollectionsPrint();
    }

}

