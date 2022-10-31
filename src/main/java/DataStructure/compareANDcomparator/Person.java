package DataStructure.compareANDcomparator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Data
@AllArgsConstructor
@ToString
public class Person implements Comparable<Person>{ // 对象实现Comparable接口，需要重写内部的abstract method

    private String name;
    private Integer age;

    @Override
    public int compareTo(Person person) {
        return name.compareTo(person.name);
        // return this.name - person.name;
    }

    /*
         Comparable 是一个接口，本身就已经支持自比较所需要要实现的接口。
         自定义类要在加入list容器后能够排序，也可以实现Comparable接口。
         在用Collections类的sort方法排序是若不指定Comparator，那就是以自然排序。所谓的自然排序就是实现Comparable接口设定的排序方法。
         若一个类实现了Comparable接口，则意味着该类支持排序，如String， Integer字就实现了Comparable接口，可以完成比较大小的操作
         一个已经实现comparable的类的对象或数据，可以通过Collections.sort(list) 或者 Arrays.sor(arr)实现排序。通过Collections.sort(list, Collections.reverseOrder())；对list进行倒序排列

     */

    public static void main(String[] args) {
        Person p1 = new Person("Austin", 26);
        Person p2 = new Person("Nicole", 23);

        List<Person> people = Arrays.asList(p1, p2);

        Collections.sort(people, new Comparator<Person>() { // 定义比较器 实现Comparator接口(内部传统写法或者lambda写法)
            @Override
            public int compare(Person p1, Person p2) {
                return p1.age < p2.age ? -1 : p1.age.equals(p2.age) ? 0 : 1;
            }
        });
    }
    /*
         Comparator是在集合外部实现排序，位于java.util下。Comparator接口包含了两个函数
         int compare(T o1, T o2);
         boolean equals(Object obj);



     */
}
