package com.example.lzl.myapplication;

/**
 * describe：
 * <p>
 * author：lzl
 * <p>
 * date：16/7/8 下午5:22   ：
 */

public class User {

    private final String firstName;
    private final String lastName;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }
}
