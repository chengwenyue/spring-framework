package cwy.demo.spring.entity;

/**
 * @author cwy-pc
 * @date 2019-07-19
 */
public class Employee {
    private String name;

    private float salary;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return name+":"+salary;
    }
}
