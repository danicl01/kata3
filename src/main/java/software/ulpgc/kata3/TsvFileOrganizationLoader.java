package software.ulpgc.kata3;

import java.io.*;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TsvFileOrganizationLoader implements OrganizationLoader{
    private final File file;

    public TsvFileOrganizationLoader(File file) {
        this.file = file;
    }

    @Override
    public List<Organization> load() {
        try {
            return load(new FileReader(file));
        } catch (IOException e) {
            return Collections.emptyList();
        }
    }

    private List<Organization> load(FileReader fileReader) throws IOException {
        return load(new BufferedReader(fileReader));
    }

    private List<Organization> load(BufferedReader bufferedReader) {
        return bufferedReader.lines().skip(1)
                .map(this::toOrganization)
                .collect(Collectors.toList());
    }

    private Organization toOrganization(String s) { return toOrganization(s.split("\t"));}

    private Organization toOrganization(String[] file) {
        return new Organization(
                file[0],
                file[1],
                file[2],
                file[3],
                file[4],
                Integer.parseInt(file[5]),
                file[6],
                Integer.parseInt(file[7])
        );
    }
}
