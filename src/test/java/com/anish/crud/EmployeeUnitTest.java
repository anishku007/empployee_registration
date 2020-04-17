package com.anish.crud;

import static org.assertj.core.api.Assertions.assertThat;
import com.anish.crud.entities.Employee;
import org.junit.Test;

public class EmployeeUnitTest {

    @Test
    public void whenCalledGetName_thenCorrect() {
        Employee employee = new Employee(1, "AS", "Gupta","M", "12/08/1992", "Dev");

        assertThat(employee.getFirstName()).isEqualTo("AS");
    }


    @Test
    public void whenCalledSetName_thenCorrect() {
        Employee employee = new Employee(1, "AS", "Gupta", "M", "12/08/1992", "Dev");

        employee.setFirstName("AS");

        assertThat(employee.getFirstName()).isEqualTo("AS");
    }

    @Test
    public void whenCalledToString_thenCorrect() {
        Employee employee = new Employee(1, "AS", "Gupta","M", "12/08/1992", "Dev");
        assertThat(employee.toString()).isNotEqualTo("Employee{id=1, name=AS, email=julie@domain.com}");
    }
}
