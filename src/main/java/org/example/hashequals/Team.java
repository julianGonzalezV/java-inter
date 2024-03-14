package org.example.hashequals;

/**
 * Just equals is implemented so it generates inconsistency
 */
class Team {

    String city;
    String department;

    public Team(String city, String department) {
        this.city = city;
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return city.equals(team.city) && department.equals(team.department);
    }

}
