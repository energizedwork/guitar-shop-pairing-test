package uw;

import java.io.Writer;
import java.util.List;

public interface Reporter {
    void process(List<Model.Sale> sales, Writer writer);
}
