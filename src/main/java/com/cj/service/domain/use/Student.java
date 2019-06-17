package com.cj.service.domain.use;

/**
 * @author : chenjie
 * @date : 2019-05-25 9:31
 * @describe :
 */
public class Student {
    private String name;
    private Integer age;
    private Integer taller;

    public Student(String name, Integer age, Integer taller) {
        this.name = name;
        this.age = age;
        this.taller = taller;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getTaller() {
        return taller;
    }

    public void setTaller(Integer taller) {
        this.taller = taller;
    }
}
