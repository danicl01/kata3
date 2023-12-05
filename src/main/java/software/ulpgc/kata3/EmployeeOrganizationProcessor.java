package software.ulpgc.kata3;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeOrganizationProcessor implements OrganizationProcessor.EmployeeOrganizationProcessor{
    @Override
    public List<Double> process(List<Organization> organizations) {
        return organizations.stream()
                .map(Organization::getEmployee)
                .map(Double::valueOf)
                .collect(Collectors.toList());
    }
}
