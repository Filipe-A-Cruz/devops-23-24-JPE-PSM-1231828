package com.greglturnquist.payroll;

import org.springframework.validation.*;

public class EmployeeValidator implements Validator {
    public boolean supports(Class clazz) {
        return Employee.class.equals(clazz);
    }

    public void validate(Object obj, Errors e) {
        ValidationUtils.rejectIfEmptyOrWhitespace(e, "firstName", "firstName.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(e, "lastName", "lastName.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(e, "description", "description.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(e, "jobTitle", "jobTitle.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(e, "jobYears", "jobYears.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(e, "email", "email.empty");
        Employee employee = (Employee) obj;
        if (employee.getJobYears() < 0) {
            e.rejectValue("jobYears", "negativeValue");
        }
        if (!employee.getEmail().contains("@")) {
            e.rejectValue("email", "invalidEmail");
        }
    }
}