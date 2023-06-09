package edu.eci.cvds.backingbean;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CONFIGURATION")
public class GameConfiguration {
    
    @Id
    @Column(name = "PROPIEDAD")
    private String property;

    @Column(name = "VALOR")
    private String value;

    public GameConfiguration() {}
    
    public GameConfiguration(String property, String value) {
        this.property = property;
        this.value = value;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        GameConfiguration other = (GameConfiguration) obj;
        return Objects.equals(property, other.property) &&
            Objects.equals(value, other.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(property, value);
    }

    @Override
    public String toString() {
        return String.format("%s: %s k", property, value);
    }
    

}
