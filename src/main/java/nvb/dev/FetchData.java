package nvb.dev;

import org.hibernate.Session;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Blob;
import java.sql.SQLException;

public class FetchData {
    public static void main(String[] args) throws SQLException, IOException {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Data data = session.get(Data.class, 1L);
        System.out.println(data.getId() + " : " + data.getName());

        Blob image = data.getFile();
        InputStream inputStream = image.getBinaryStream();
        Files.copy(inputStream, Paths.get("outputImages/" + data.getName() + ".jpg"),
                StandardCopyOption.REPLACE_EXISTING);

        session.getTransaction().commit();

    }
}
