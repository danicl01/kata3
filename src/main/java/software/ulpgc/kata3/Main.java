package software.ulpgc.kata3;

import java.io.File;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        OrganizationLoader loader = new TsvFileOrganizationLoader(new File("dataset.tsv"));
        List<Organization> organizations = loader.load();
        Map<String, Integer> barchart = new CountryOrganizationProcessor().process(organizations);

        /*
        for(String key: barchart.keySet()) {
            System.out.println(key + "=" + barchart.get(key));
        }

         */

        List<Double> employees = new EmployeeOrganizationProcessor().process(organizations);
        MainFrame frame = new MainFrame();
        frame.setVisible(true);
    }
}