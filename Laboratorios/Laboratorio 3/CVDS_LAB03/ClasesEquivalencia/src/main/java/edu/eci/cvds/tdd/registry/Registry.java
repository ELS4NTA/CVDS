package edu.eci.cvds.tdd.registry;

import java.util.ArrayList;

public class Registry {

    ArrayList<Person> persons = new ArrayList<Person>();

    public RegisterResult registerVoter(Person p) {
        int age = p.getAge();
        boolean isAlive = p.isAlive();
        RegisterResult result;
        RegisterResult isValid = RegisterResult.VALID;
        result = isValidAge(age);
        result = (result == isValid) ? isDeadPerson(isAlive, age): result;
        result = (result == isValid) ? isUnderAge(age) : result;
        result = (result == isValid) ? isDuplicated(p): result;
        if (result == isValid) {
            persons.add(p);
        }
        return result;
    }

    private RegisterResult isDuplicated(Person p) {
        for (Person person : persons) {
            if (person.getId() == p.getId()) {
                return RegisterResult.DUPLICATED;
            }
        }
        return RegisterResult.VALID;
    }

    private RegisterResult isUnderAge(int age) {
        return (0 < age && age < 18) ? RegisterResult.UNDERAGE : RegisterResult.VALID;
    }

    private RegisterResult isValidAge(int age) {
        return (age < 0) ?  RegisterResult.INVALID_AGE : RegisterResult.VALID;
    }

    private RegisterResult isDeadPerson(boolean isAlive, int age) {
        return (!isAlive || age > 130) ? RegisterResult.DEAD : RegisterResult.VALID;
    }

}
