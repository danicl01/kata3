package software.ulpgc.kata3;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CountryOrganizationProcessor implements OrganizationProcessor {

    @Override
    public Map<String, Integer> process(List<Organization> organizations) {
        return organizations.stream()
                .collect(Collectors.toMap(Organization::getCountry, v->1, Integer::sum));
    }
}
