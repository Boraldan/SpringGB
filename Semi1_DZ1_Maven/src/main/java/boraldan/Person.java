package boraldan;

import java.io.Serializable;
import java.util.Objects;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * Урок 1. Системы сборки Maven и Gradle для разработки Java приложений
 * <p>
 * Создать проект с использованием Maven или Gradle, добавить в него несколько зависимостей и написать код, использующий эти зависимости.
 * Задание:
 * 1. Создайте новый Maven или Gradle проект, следуя инструкциям из блока 1 или блока 2.
 * 2. Добавьте зависимости org.apache.commons:commons-lang3:3.12.0 и com.google.code.gson:gson:2.8.6.
 * 3. Создайте класс Person с полями firstName, lastName и age.
 * 4. Используйте библиотеку commons-lang3 для генерации методов toString, equals и hashCode.
 * 5. Используйте библиотеку gson для сериализации и десериализации объектов класса Person в формат JSON.
 */

@Getter
@Setter
public class Person {
    private String firstName;
    private String lastName;
    private Integer age;

    public Person(String firstName, String lastName, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return new EqualsBuilder().append(firstName, person.firstName)
                .append(lastName, person.lastName)
                .append(age, person.age)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(firstName).append(lastName).append(age).toHashCode();
    }

//    @Override
//    public String toString() {
//        return  ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
//    }


    @Override
    public String toString() {
        return "firstName=" + firstName +
                ", lastName='" + lastName +
                ", age=" + age;
    }
}
