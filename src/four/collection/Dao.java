package four.collection;

import java.util.List;

public interface Dao<E> {
//    String URL = "jdbc:mysql://localhost:3306/store?autoReconnect=true&useSSL=false&allowPublicKeyRetrieval=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    String URL = "jdbc:mysql://localhost:3306/store?autoReconnect=true&useSSL=false&allowPublicKeyRetrieval=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    String USER = "root";
    String PASSWORD = "Januar@2022!";
    List<E> getAll();

    E get(long primaryKey);

    void create(E entity);

    E update(E entity);

    void delete(E entity);

}
