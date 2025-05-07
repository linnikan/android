package com.example.models;

import java.util.ArrayList;

public class ListEmployee {
    private ArrayList<Employee> employees;

    public ListEmployee() {
        employees=new ArrayList<>();
    }

    // Hàm gettter truy xuất để lấy giá trị của nó
    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    // Hàm settter truy xuất thay đổi giá trị của nó
    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }
    public void gen_dataset()
    {
        Employee e1=new Employee();
        e1.setId(1);
        e1.setName("Liny");
        e1.setEmail("liny@gmail.com");
        e1.setPhone("0238547622");
        e1.setUsername("linyliny");
        e1.setPassword("123123");
        employees.add(e1);

        Employee e2=new Employee();
        e2.setId(2);
        e2.setName("Panky");
        e2.setEmail("panky@gmail.com");
        e2.setPhone("0232356622");
        e2.setUsername("pankypanky");
        e2.setPassword("456456");
        employees.add(e2);

        Employee e3=new Employee();
        e3.setId(3);
        e3.setName("Anny");
        e3.setEmail("anny@gmail.com");
        e3.setPhone("0238539022");
        e3.setUsername("annyanny");
        e3.setPassword("789789");
        employees.add(e3);

        Employee e4=new Employee();
        e4.setId(4);
        e4.setName("Btran");
        e4.setEmail("btran@gmail.com");
        e4.setPhone("0498547622");
        e4.setUsername("btranbtran");
        e4.setPassword("987987");
        employees.add(e4);

        Employee e5=new Employee();
        e5.setId(5);
        e5.setName("Tiny");
        e5.setEmail("tiny@gmail.com");
        e5.setPhone("0238543332");
        e5.setUsername("tinytiny");
        e5.setPassword("743743");
        employees.add(e5);

    }
}
