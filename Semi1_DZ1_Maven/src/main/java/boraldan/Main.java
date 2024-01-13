package boraldan;

import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.CompareToBuilder;

import java.util.*;


public class Main {
    public static void main(String[] args) {

        List<String> list= new ArrayList<>(Arrays.asList("1", "2", "3"));

        String listStr = StringUtils.join(list, ", ");
        System.out.println(listStr);


        Person person = new Person("Tom", "Soer", 15);
        Gson gson = new Gson();
        String gsonPerson = gson.toJson(person);
        System.out.println(gsonPerson);

        Person person2 = gson.fromJson(gsonPerson, Person.class);
        System.out.println(person2);

        // -------------
        List<String> stringList = Arrays.asList("car", "moto", null, "sun");
        try {
            Validate.noNullElements(stringList, "List should not contain null elements");
            System.out.println("List is valid");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка");
        }
        System.out.println("End");

        //-----------

        Person person3 = new Person("Alis", "Smit", 20);
        List<Person> personList = new ArrayList<>(Arrays.asList(person2,person3,person));
        Collections.sort(personList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return new CompareToBuilder().append(o1.getAge(), o2.getAge()).toComparison();
            }
        });
        System.out.println(personList);

    }
}