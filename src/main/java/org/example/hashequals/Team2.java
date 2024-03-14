package org.example.hashequals;

import java.util.Objects;

/**
 * Just equals is implemented so it generates inconsistency
 */
class Team2 {

    String city;
    String department;

    public Team2(String city, String department) {
        this.city = city;
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team2 team = (Team2) o;
        return city.equals(team.city) && department.equals(team.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, department);
    }
}
