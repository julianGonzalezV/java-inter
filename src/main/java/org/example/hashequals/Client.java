package org.example.hashequals;

import java.util.Objects;

public class Client {
    private String dni;
    private String name;
    private int age;

    public Client(String dni, String name, int age){
        this.dni = dni;
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return dni.equals(client.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }
}
