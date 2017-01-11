package guitarshop;

import java.util.Map;

public class Presenter {

    public String present(Map<String, Object> reportDto) {
        return "<html><body><article>" +
            "<header><h1>Sales Report</h1></header>" +
            "<p>Total Sales: " +
            "</article></body></html>";
    }
}
