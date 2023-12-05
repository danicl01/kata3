package software.ulpgc.kata3;

import java.util.List;
import java.util.Map;

public interface OrganizationProcessor {
    Map<String, Integer> process(List<Organization> organizations);

    interface EmployeeProcessor {
        List<Double> process(List<Organization> organizations);
    }
}
