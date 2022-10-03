package com.cydeo.streampractice.practice;

import com.cydeo.streampractice.model.*;
import com.cydeo.streampractice.service.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class Practice {

    public static CountryService countryService;
    public static DepartmentService departmentService;
    public static EmployeeService employeeService;
    public static JobHistoryService jobHistoryService;
    public static JobService jobService;
    public static LocationService locationService;
    public static RegionService regionService;

    public Practice(CountryService countryService, DepartmentService departmentService,
                    EmployeeService employeeService, JobHistoryService jobHistoryService,
                    JobService jobService, LocationService locationService,
                    RegionService regionService) {

        Practice.countryService = countryService;
        Practice.departmentService = departmentService;
        Practice.employeeService = employeeService;
        Practice.jobHistoryService = jobHistoryService;
        Practice.jobService = jobService;
        Practice.locationService = locationService;
        Practice.regionService = regionService;

    }

    // You can use the services above for all the CRUD (create, read, update, delete) operations.
    // Above services have all the required methods.
    // Also, you can check all the methods in the ServiceImpl classes inside the service.impl package, they all have explanations.

    // Display all the employees
    public static List<Employee> getAllEmployees() {
        return employeeService.readAll();
    }

    // Display all the countries
    public static List<Country> getAllCountries() {
        return countryService.readAll();

    }

    // Display all the departments
    public static List<Department> getAllDepartments() {

        return departmentService.readAll();
    }

    // Display all the jobs
    public static List<Job> getAllJobs() {

        return jobService.readAll();
    }

    // Display all the locations
    public static List<Location> getAllLocations() {

        return locationService.readAll();
    }

    // Display all the regions
    public static List<Region> getAllRegions() {

        return regionService.readAll();
    }

    // Display all the job histories
    public static List<JobHistory> getAllJobHistories() {
        return jobHistoryService.readAll();
    }

    // Display all the employees' first names
    public static List<String> getAllEmployeesFirstName() {
        return employeeService.readAll().stream()
                .map(Employee::getFirstName)
                .collect(Collectors.toList());
    }

    // Display all the countries' names
    public static List<String> getAllCountryNames() {
        return countryService.readAll().stream()
                .map(Country::getCountryName)
                .collect(Collectors.toList());
    }

    // Display all the departments' managers' first names
    public static List<String> getAllDepartmentManagerFirstNames() {

        return departmentService.readAll().stream()
                .map(department -> department.getManager().getFirstName())
                .collect(Collectors.toList());
    }

    // Display all the departments where manager name of the department is 'Steven'
    public static List<Department> getAllDepartmentsWhichManagerFirstNameIsSteven() {
        return departmentService.readAll().stream()
                .filter(department -> department.getManager().getFirstName().equals("Steven"))
                .collect(Collectors.toList());
    }

    // Display all the departments where postal code of the location of the department is '98199'
    public static List<Department> getAllDepartmentsWhereLocationPostalCodeIs98199() {
        return departmentService.readAll().stream()
                .filter(department -> department.getLocation().getPostalCode().equals("98199"))
                .collect(Collectors.toList());
    }

    // Display the region of the IT department
    public static Region getRegionOfITDepartment() throws Exception {
        return departmentService.readAll().stream()
                .filter(department -> department.getDepartmentName().equals("IT"))
                .map(department -> department.getLocation().getCountry().getRegion())
                .findAny().get();
    }

    // Display all the departments where the region of department is 'Europe'
    public static List<Department> getAllDepartmentsWhereRegionOfCountryIsEurope() {
        return departmentService.readAll().stream()
                .filter(department -> department.getLocation().getCountry().getRegion().getRegionName().equals("Europe"))
                .collect(Collectors.toList());
    }

    // Display if there is any employee with salary less than 1000. If there is none, the method should return true
    public static boolean checkIfThereIsNoSalaryLessThan1000() {

        return employeeService.readAll().stream()
                .map(Employee::getSalary)
                .noneMatch(salary -> salary < 1000);
    }

    // Check if the salaries of all the employees in IT department are greater than 2000 (departmentName: IT)
    public static boolean checkIfThereIsAnySalaryGreaterThan2000InITDepartment() {
        return employeeService.readAll().stream()
                .filter(department -> department.getDepartment().equals("IT"))
                .noneMatch(salary -> salary.getSalary()>2000);

    }

    // Display all the employees whose salary is less than 5000
    public static List<Employee> getAllEmployeesWithLessSalaryThan5000() {
        return employeeService.readAll().stream()
                .filter(salary -> salary.getSalary()<5000)
                .collect(Collectors.toList());

    }

    // Display all the employees whose salary is between 6000 and 7000
    public static List<Employee> getAllEmployeesSalaryBetween() {
        return employeeService.readAll().stream()
                .filter(salary -> salary.getSalary() > 6000 && salary.getSalary() < 7000)
                .collect(Collectors.toList());
    }

    // Display the salary of the employee Grant Douglas (lastName: Grant, firstName: Douglas)
    public static Long getGrantDouglasSalary() throws Exception {

        return employeeService.readAll().stream()
                .filter(employee -> employee.getLastName().equals("Grant") && employee.getFirstName().equals("Douglas"))
                .findAny().get().getSalary();

    }

    // Display the maximum salary an employee gets
    public static Long getMaxSalary() throws Exception {
        return employeeService.readAll().stream()
                .mapToLong(Employee::getSalary)
                .max().getAsLong();
    }

    // Display the employee(s) who gets the maximum salary
    public static List<Employee> getMaxSalaryEmployee() {
        return employeeService.readAll().stream()
                .max(Comparator.comparing(Employee::getSalary)).stream()
                .collect(Collectors.toList());
    }

    // Display the max salary employee's job
    public static Job getMaxSalaryEmployeeJob() throws Exception {
        return employeeService.readAll().stream()
                .max(Comparator.comparing(Employee::getSalary)).stream()
                .map(Employee::getJob).findFirst().get();
    }

    // Display the max salary in Americas Region
    public static Long getMaxSalaryInAmericasRegion() throws Exception {
        return employeeService.readAll().stream()
                .filter(region -> region.getDepartment().getLocation().getCountry().getRegion().getRegionName().equals("Americas"))
                .max(Comparator.comparing(Employee::getSalary)).get().getSalary();

    }

    // Display the second maximum salary an employee gets
    public static Long getSecondMaxSalary() throws Exception {
        return employeeService.readAll().stream()
                .map(Employee::getSalary)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .reduce(Long::max)
                .orElseThrow();
    }

    // Display the employee(s) who gets the second maximum salary
//    public static List<Employee> getSecondMaxSalaryEmployee() {
//        return employeeService.readAll().stream()
//                .sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(1).collect(Collectors.toList());
//
//    }

    // Display the minimum salary an employee gets
    public static Long getMinSalary() throws Exception {
        return employeeService.readAll().stream()
                .min(Comparator.comparingDouble(Employee::getSalary)).get().getSalary();
    }

    // Display the employee(s) who gets the minimum salary
    public static List<Employee> getMinSalaryEmployee() {
        return  employeeService.readAll().stream()
                .min(Comparator.comparing(Employee::getSalary)).stream()
                .collect(Collectors.toList());
    }

    // Display the second minimum salary an employee gets
    public static Long getSecondMinSalary() throws Exception {
        return employeeService.readAll().stream()
                .sorted(Comparator.comparing(Employee::getSalary))
                .skip(1)
                .findFirst().orElseThrow(()-> new Exception("No salary found")).getSalary();
    }

    // Display the employee(s) who gets the second minimum salary
    public static List<Employee> getSecondMinSalaryEmployee() {
        return employeeService.readAll().stream()
                .filter(i->{try {
                    return i.getSalary().equals(getSecondMinSalary());
                }catch (Exception e){
                    throw new RuntimeException(e);
                }
                }).collect(Collectors.toList());
    }

    // Display the average salary of the employees
    public static Double getAverageSalary() {

        return employeeService.readAll().stream()
                .mapToDouble(Employee::getSalary).average().orElse(0.0);

    }

    // Display all the employees who are making more than average salary
    public static List<Employee> getAllEmployeesAboveAverage() {
        return employeeService.readAll().stream()
                .filter(employee -> employee.getSalary() > getAverageSalary()).collect(Collectors.toList());
    }

    // Display all the employees who are making less than average salary
    public static List<Employee> getAllEmployeesBelowAverage() {
        return employeeService.readAll().stream()
                .filter(employee -> employee.getSalary() < getAverageSalary())
                .collect(Collectors.toList());
    }

    // Display all the employees separated based on their department id number
    public static Map<Long, List<Employee>> getAllEmployeesForEachDepartment() {
        return employeeService.readAll().stream()
                .collect(Collectors.groupingBy(dep -> dep.getDepartment().getId()));
    }

    // Display the total number of the departments
    public static Long getTotalDepartmentsNumber() {
        return departmentService.readAll().stream()
                .map(Department::getDepartmentName)
                .count();
    }

    // Display the employee whose first name is 'Alyssa' and manager's first name is 'Eleni' and department name is 'Sales'
    public static Employee getEmployeeWhoseFirstNameIsAlyssaAndManagersFirstNameIsEleniAndDepartmentNameIsSales() throws Exception {
        return employeeService.readAll().stream()
                .filter(a-> a.getFirstName().equals("Alyssa")&& a.getManager().getFirstName().equals("Eleni")&&
                        a.getDepartment().getDepartmentName().equals("Sales")).findFirst()
                .orElseThrow(()-> new Exception("No Employee found"));
    }

//     Display all the job histories in ascending order by start date fad
//    public static List<JobHistory> getAllJobHistoriesInAscendingOrder() {
//        return jobHistoryService.readAll().stream()
//                .sorted(Comparator.comparing(JobHistory::getStartDate))
//                .collect(Collectors.toList());
//    }

    // Display all the job histories in descending order by start date
    public static List<JobHistory> getAllJobHistoriesInDescendingOrder() {
       return jobHistoryService.readAll().stream()
                .sorted(Comparator.comparing(JobHistory::getStartDate).reversed())
                .collect(Collectors.toList());
    }

    // Display all the job histories where the start date is after 01.01.2005
    public static List<JobHistory> getAllJobHistoriesStartDateAfterFirstDayOfJanuary2005() {
        return jobHistoryService.readAll().stream()
                .filter(f-> f.getStartDate().isAfter(LocalDate.of(2006,01,01)))
                .collect(Collectors.toList());
    }

    // Display all the job histories where the end date is 31.12.2007 and the job title of job is 'Programmer'
    public static List<JobHistory> getAllJobHistoriesEndDateIsLastDayOfDecember2007AndJobTitleIsProgrammer() {
        return jobHistoryService.readAll().stream()
                .filter(f -> f.getEndDate().equals(LocalDate.of(2007,12,31)))
                .filter(f -> f.getJob().getJobTitle().equals("Programmer"))
                .collect(Collectors.toList());
    }

    // Display the employee whose job history start date is 01.01.2007 and job history end date is 31.12.2007 and department's name is 'Shipping'
    public static Employee getEmployeeOfJobHistoryWhoseStartDateIsFirstDayOfJanuary2007AndEndDateIsLastDayOfDecember2007AndDepartmentNameIsShipping() throws Exception {
        return jobHistoryService.readAll().stream()
                .filter(f -> f.getStartDate().equals(LocalDate.of(2007,01,01)))
                .filter(f -> f.getEndDate().equals(LocalDate.of(2007,12,31)))
                .filter(dep -> dep.getDepartment().getDepartmentName().equals("Shipping"))
                .map(jobHistory -> jobHistory.getEmployee())
                .findFirst().get();


    }

    // Display all the employees whose first name starts with 'A'
    public static List<Employee> getAllEmployeesFirstNameStartsWithA() {
        return employeeService.readAll().stream()
                .filter(f -> f.getFirstName().startsWith("A"))
                .collect(Collectors.toList());
    }

    // Display all the employees whose job id contains 'IT'
    public static List<Employee> getAllEmployeesJobIdContainsIT() {
        //TODO Implement the method
        return new ArrayList<>();
    }

    // Display the number of employees whose job title is programmer and department name is 'IT'
    public static Long getNumberOfEmployeesWhoseJobTitleIsProgrammerAndDepartmentNameIsIT() {
        //TODO Implement the method
        return 1L;
    }

    // Display all the employees whose department id is 50, 80, or 100
    public static List<Employee> getAllEmployeesDepartmentIdIs50or80or100() {
        //TODO Implement the method
        return new ArrayList<>();
    }

    // Display the initials of all the employees
    // Note: You can assume that there is no middle name
    public static List<String> getAllEmployeesInitials() {
        //TODO Implement the method
        return new ArrayList<>();
    }

    // Display the full names of all the employees
    public static List<String> getAllEmployeesFullNames() {
        //TODO Implement the method
        return new ArrayList<>();
    }

    // Display the length of the longest full name(s)
    public static Integer getLongestNameLength() throws Exception {
        //TODO Implement the method
        return 1;
    }

    // Display the employee(s) with the longest full name(s)
    public static List<Employee> getLongestNamedEmployee() {
        //TODO Implement the method
        return new ArrayList<>();
    }

    // Display all the employees whose department id is 90, 60, 100, 120, or 130
    public static List<Employee> getAllEmployeesDepartmentIdIs90or60or100or120or130() {
        //TODO Implement the method
        return new ArrayList<>();
    }

    // Display all the employees whose department id is NOT 90, 60, 100, 120, or 130
    public static List<Employee> getAllEmployeesDepartmentIdIsNot90or60or100or120or130() {
        //TODO Implement the method
        return new ArrayList<>();
    }

}
