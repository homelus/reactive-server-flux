package study.reactive.domain;

import java.util.List;

import static java.util.Arrays.asList;

public class UserFactory {

    public static List<User> internalDummyUser() {
        User jun = new User();
        jun.setName("jun");
        jun.setLocation("seoul");
        jun.setAge(20);
        jun.setType("IN");

        User min = new User();
        min.setName("min");
        min.setLocation("seoul");
        min.setAge(19);
        min.setType("IN");

        return asList(jun, min);
    }

    public static List<User> externalDummyUser() {
        User hong = new User();
        hong.setName("hong");
        hong.setLocation("jeju");
        hong.setAge(30);
        hong.setType("EX");

        User kang = new User();
        kang.setName("kang");
        kang.setLocation("busan");
        kang.setAge(24);
        kang.setType("EX");

        return asList(hong, kang);
    }

    public static List<User> specialDummyUser() {
        User man = new User();
        man.setName("man");
        man.setLocation("seoul");
        man.setAge(23);
        man.setType("SP");

        User bae = new User();
        bae.setName("bae");
        bae.setLocation("busan");
        bae.setAge(24);
        bae.setType("SP");

        return asList(man, bae);
    }

}
