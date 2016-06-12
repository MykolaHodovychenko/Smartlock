package ua.opu.smartlock.model;

public class Key {

    public String name;
    public String phone;
    public KeySchedule schedule;

    public Key(String name, String phone, KeySchedule schedule) {
        this.name = name;
        this.phone = phone;
        this.schedule = schedule;
    }
}
