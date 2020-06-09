package cwy.demo.spring.entity;

import java.io.File;
import java.util.List;

/**
 * @author cwy-pc
 * @date 2019-07-19
 */
public class Company {
    private String name;
    private Employee managingDirector;

    private File file;

    private List<Employee> employeeList;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getManagingDirector() {
        return this.managingDirector;
    }

    public void setManagingDirector(Employee managingDirector) {
        this.managingDirector = managingDirector;
    }

//    @Override
//    public String toString() {
//        return name+"["+String.valueOf(managingDirector)+"]";
//    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
