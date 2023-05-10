package org.example;

import java.util.ArrayList;

public class CreateHuman {
    public ArrayList<Human> getHumans() {
        ArrayList<Human> humans = new ArrayList<Human>();
        humans.add(createHumanFirst());
        humans.add(createHumanTheard());
        humans.add(createHumanSecond());
        return humans;
    }

    private Human createHumanFirst() {
        Address address = new Address();
        Human human = new Human();
        try {
            address.setCity("Dnipr");
        } catch (AddressException e) {
            e.printStackTrace();
        }

        try {
            address.setStreet("Temoshenko");
        } catch (AddressException e) {
            e.printStackTrace();
        }
        try {
            address.setHouseNumber("1a");
        } catch (AddressException e) {
            e.printStackTrace();
        }

        try {
            human.setAddress(address);
        } catch (AddressException e) {
            e.printStackTrace();
        }
        try {
            human.setName("Natasha");
        } catch (HumanException e) {
            e.printStackTrace();
        }

        try {
            human.setSurname("Zoloyareva");
        } catch (HumanException e) {
            e.printStackTrace();
        }
        human.setAge(19);
        return human;
    }

    private Human createHumanSecond() {
        Address address = new Address();
        Human human = new Human();
        try {
            address.setCity("Harkiv");
        } catch (AddressException e) {
            e.printStackTrace();
        }

        try {
            address.setStreet("Zarichn");
        } catch (AddressException e) {
            e.printStackTrace();
        }
        try {
            address.setHouseNumber("35");
        } catch (AddressException e) {
            e.printStackTrace();
        }

        try {
            human.setAddress(address);
        } catch (AddressException e) {
            e.printStackTrace();
        }
        try {
            human.setName("Masha");
        } catch (HumanException e) {
            e.printStackTrace();
        }

        try {
            human.setSurname("Zoloyareva");
        } catch (HumanException e) {
            e.printStackTrace();
        }
        human.setAge(30);
        return human;
    }

    private Human createHumanTheard() {
        Address address = new Address();
        Human human = new Human();
        try {
            address.setCity("Mucolaiv");
        } catch (AddressException e) {
            e.printStackTrace();
        }

        try {
            address.setStreet("Mury");
        } catch (AddressException e) {
            e.printStackTrace();
        }
        try {
            address.setHouseNumber("55");
        } catch (AddressException e) {
            e.printStackTrace();
        }

        try {
            human.setAddress(address);
        } catch (AddressException e) {
            e.printStackTrace();
        }
        try {
            human.setName("Any");
        } catch (HumanException e) {
            e.printStackTrace();
        }

        try {
            human.setSurname("Tsivka");
        } catch (HumanException e) {
            e.printStackTrace();
        }
        human.setAge(16);
        return human;
    }

}
