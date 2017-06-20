package guitarshop;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class CategoryParser {

    public Map<String, Integer> countVolumesByCategory(final List<String> reportData) {
        return reportData
                .stream()
                .filter(this::isHeader)
                .map(this::toReportEntry)
                .collect(groupingBy(reportEntry -> , Collectors.counting()));
    }

    private boolean isHeader(final String line) {
        return line.equals("Time,Item,Category,Quantity,PriceEach");
    }

    private ReportEntry toReportEntry(final String line) {
        final String[] entries = line.split(",");
        return new ReportEntry(entries[2], Integer.parseInt(entries[3]));
    }

}
