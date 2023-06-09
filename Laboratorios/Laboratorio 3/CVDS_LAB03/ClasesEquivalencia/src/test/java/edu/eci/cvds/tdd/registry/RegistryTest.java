package edu.eci.cvds.tdd.registry;

import org.junit.Assert;
import org.junit.Test;

public class RegistryTest {

    private Registry registry = new Registry();

    @Test
    public void shouldBeDeadPersonWhenIsNotAlive() {
        // Arrange
        Person person = new Person("AngieDaniel", 123, 17, Gender.UNIDENTIFIED, false);
        // Act
        RegisterResult result = registry.registerVoter(person);
        // Assert
        Assert.assertEquals(RegisterResult.DEAD, result);
    }

    @Test
    public void shouldBeUnderagePersonWhenIsLessThan18yoAndHaveValidAgeRange() {
        // Arrange
        Person person = new Person("AngieDaniel", 123, 17, Gender.UNIDENTIFIED, true);
        // Act
        RegisterResult result = registry.registerVoter(person);
        // Assert
        Assert.assertEquals(RegisterResult.UNDERAGE, result);
    }

    @Test
    public void shouldBeValidAgePersonWhenIsOver18yoAndHaveValidAgeRange() {
        // Arrange
        Person person = new Person("AngieDaniel", 123, 19, Gender.UNIDENTIFIED, true);
        // Act
        RegisterResult result = registry.registerVoter(person);
        // Assert
        Assert.assertEquals(RegisterResult.VALID, result);
    }

    @Test
    public void shouldBeInvalidAgeWhenAgeIsNegative() {
        // Arrange
        Person person = new Person("AngieDaniel", 123, -17, Gender.UNIDENTIFIED, true);
        // Act
        RegisterResult result = registry.registerVoter(person);
        // Assert
        Assert.assertEquals(RegisterResult.INVALID_AGE, result);
    }

    @Test
    public void shouldBeDuplicatedPersonIdWhenExistOtherPersonWithThisId() {
        // Arrange
        Person person1 = new Person("AngieDaniel", 123, 20, Gender.UNIDENTIFIED, true);
        Person person2 = new Person("DanielAngie", 123, 20, Gender.UNIDENTIFIED, true);
        // Act
        registry.registerVoter(person1);
        RegisterResult result = registry.registerVoter(person2);
        // Assert
        Assert.assertEquals(RegisterResult.DUPLICATED, result);
    }

}
