package com.zipcodewilmington.phonebook;

import java.util.*;


public class PhoneBook {

    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> phonebook) {
     this.phonebook = phonebook;
        }


    public PhoneBook() {
        this(new LinkedHashMap<>());
    }


    public void add(String name, String phoneNumber) {
        List<String> list = new ArrayList<>();
        list.add(phoneNumber);
        phonebook.put(name,list);
    }

    public void addAll(String name, String... phoneNumbers) {
        List<String> list = new ArrayList<>();
        for (String phoneNumber : phoneNumbers) {
            list.add(phoneNumber);
        }
        phonebook.put(name, list);
    }



    public void remove(String name) {
        phonebook.remove(name);
    }

    public boolean hasEntry(String name) {
        return phonebook.containsKey(name);
    }

    public boolean hasEntry(String name, String phoneNumber) {
        if (phonebook.containsKey(name)) {
            List<String> numbers = phonebook.get(name);
            return numbers.contains(phoneNumber);
        } else {
            return false;
        }
    }


    public List<String> lookup(String name) {
        if (phonebook.containsKey(name)) {
            return phonebook.get(name);
        } else {
            return new ArrayList<String>();
        }
    }


    public String reverseLookup(String phoneNumber) {
        for (Map.Entry<String, List<String>> entry : phonebook.entrySet()) {

            List<String> numbers = entry.getValue();
            if (numbers.contains(phoneNumber)) {
                return entry.getKey();
            }
        }
        return null;
    }


    public List<String> getAllContactNames() {
        List<String> contactNames = new ArrayList<>();
        for (String name : phonebook.keySet()) {
            contactNames.add(name);
        }
        return contactNames;
    }




    public Map<String, List<String>> getMap() {
        return phonebook;

    }


}
