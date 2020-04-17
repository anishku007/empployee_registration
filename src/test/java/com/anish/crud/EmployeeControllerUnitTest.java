package com.anish.crud;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.anish.crud.entities.Employee;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.anish.crud.controllers.EmployeeController;
import com.anish.crud.repositories.EmployeeRepository;

public class EmployeeControllerUnitTest {

    private static EmployeeController employeeController;
    private static EmployeeRepository mockedEmployeeRepository;
    private static BindingResult mockedBindingResult;
    private static Model mockedModel;

    @BeforeClass
    public static void setUpEmployeeControllerInstance() {
        mockedEmployeeRepository = mock(EmployeeRepository.class);
        mockedBindingResult = mock(BindingResult.class);
        mockedModel = mock(Model.class);
        employeeController = new EmployeeController(mockedEmployeeRepository);
    }

    @Test
    public void whenCalledSignUpForm_thenCorrect() {
        Employee employee = new Employee(1, "Ankit", "Kumar", "M", "12/08/1992", "Dev");

        assertThat(employeeController.showSignUpForm(employee)).isEqualTo("add-employee");
    }

    @Test
    public void whenCalledAddEmployeeAndValidEmployee_thenCorrect() {
        Employee employee = new Employee(1, "Ankit", "Kumar", "M", "12/08/1992", "Dev");

        when(mockedBindingResult.hasErrors()).thenReturn(false);

        assertThat(employeeController.addEmployee(employee, mockedBindingResult, mockedModel)).isEqualTo("index");
    }

    @Test
    public void whenCalledAddEmployeeAndInValidEmployee_thenCorrect() {
        Employee employee = new Employee(1, "Ankit", "Kumar", "M", "12/08/1992", "Dev");

        when(mockedBindingResult.hasErrors()).thenReturn(true);

        assertThat(employeeController.addEmployee(employee, mockedBindingResult, mockedModel)).isEqualTo("add-employee");
    }

    @Test
    public void whenCalledUpdateEmployee_thenCorrect() {
        Employee employee = new Employee(1, "Ankit", "Kumar", "M", "12/08/1992", "Dev");

        when(mockedBindingResult.hasErrors()).thenReturn(false);

        assertThat(employeeController.updateEmployee(1l, employee, mockedBindingResult, mockedModel)).isEqualTo("index");
    }

    @Test
    public void whenCalledUpdateEmployeeAndInValidEmployee_thenCorrect() {
        Employee employee = new Employee(1, "Ankit", "Kumar", "M", "12/08/1992", "Dev");

        when(mockedBindingResult.hasErrors()).thenReturn(true);

        assertThat(employeeController.updateEmployee(1l, employee, mockedBindingResult, mockedModel)).isEqualTo("update-employee");
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenCalledDeleteEmployee_thenIllegalArgumentException() {
        assertThat(employeeController.deleteEmployee(1l, mockedModel)).isEqualTo("index");
    }
}
