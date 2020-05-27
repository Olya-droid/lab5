package XmlManagers;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;

/**
 * Класс для адаптации даты к xml
 */

public class XmlDateAdapter extends XmlAdapter<String, LocalDate> {

    public LocalDate unmarshal(String v) throws Exception {
        return LocalDate.parse(v);
    }
    public String marshal(LocalDate v) throws Exception {
        return v.toString();
    }
}
