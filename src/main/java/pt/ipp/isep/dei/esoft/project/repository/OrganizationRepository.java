package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Employee;
import pt.ipp.isep.dei.esoft.project.domain.Organization;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The OrganizationRepository class manages the storage and retrieval of organization information.
 * It provides methods to add, retrieve, and validate organizations.
 */
public class OrganizationRepository {

    private final List<Organization> organizations;

    /**
     * Constructs an OrganizationRepository object.
     */
    public OrganizationRepository() {
        organizations = new ArrayList<>();
    }

    /**
     * Retrieves the organization that employs the specified employee.
     *
     * @param employee the employee to search for
     * @return an Optional containing the organization employing the employee, or empty if not found
     */
    public Optional<Organization> getOrganizationByEmployee(Employee employee) {
        Optional<Organization> returnOrganization = Optional.empty();
        for (Organization organization : organizations) {
            if (organization.employs(employee)) {
                returnOrganization = Optional.of(organization.clone());
            }
        }
        return returnOrganization;
    }

    /**
     * Retrieves the organization containing an employee with the specified email.
     *
     * @param email the email address of the employee
     * @return an Optional containing the organization with the employee, or empty if not found
     */
    public Optional<Organization> getOrganizationByEmployeeEmail(String email) {
        Optional<Organization> returnOrganization = Optional.empty();
        for (Organization organization : organizations) {
            if (organization.anyEmployeeHasEmail(email)) {
                returnOrganization = Optional.of(organization);
            }
        }
        return returnOrganization;
    }

    /**
     * Adds an organization to the repository if it is valid.
     *
     * @param organization the organization to add
     * @return an Optional containing the added organization if successful, or empty otherwise
     */
    public Optional<Organization> add(Organization organization) {
        Optional<Organization> newOrganization = Optional.empty();
        boolean operationSuccess = false;

        if (validateOrganization(organization)) {
            newOrganization = Optional.of(organization.clone());
            operationSuccess = organizations.add(newOrganization.get());
        }

        if (!operationSuccess) {
            newOrganization = Optional.empty();
        }

        return newOrganization;
    }

    /**
     * Validates whether the organization is not already in the repository.
     *
     * @param organization the organization to validate
     * @return true if the organization is valid, false otherwise
     */
    private boolean validateOrganization(Organization organization) {
        return !organizations.contains(organization);
    }
}
