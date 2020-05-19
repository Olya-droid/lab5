package Routes;

import Generators.DateGenerator;
import Generators.IDGenerator;

import java.util.ArrayList;
import java.time.LocalDate;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
/**
 * Класс-коллекция
 */
public class Collection {

    @XmlElement
    public static ArrayList<Route> Routes;

    private LocalDate initializationDate;

    /**
     * Конструктор коллекии
     */
    public Collection(){
        this.Routes = new ArrayList<>();
        this.initializationDate = DateGenerator.generateCurrentDate();
    }

    /**
     * Метод для получения даты
     * @return LocalDate
     */
    public LocalDate getInitializationDate() {
        return initializationDate;
    }


    /**
     * Метод поиска элемента по id
     * @param id id
     * @return элемент коллекции
     */
    public Route searchById(long id) {
        for (Route r : Routes) {
            if (r.getId().equals(id))
                return r;
        }
        return null;
    }

    /**
     * Метод для создания уникального id
     * @return уникальный id (дщтп)
     */
    public long generateUniqueID() {
        long id;
        do {
            id = IDGenerator.generateNewID();
        } while (this.searchById(id) != null);
        return id;
    }

}
