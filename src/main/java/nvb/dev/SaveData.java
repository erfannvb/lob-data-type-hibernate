package nvb.dev;

import org.hibernate.Session;
import org.hibernate.engine.jdbc.BlobProxy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SaveData {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Data data = new Data();
        data.setName("Image File 2");
//        session.doWork(connection -> data.setFile(BlobProxy.generateProxy(getImage())));
        data.setFile(BlobProxy.generateProxy(getImage()));

        session.persist(data);
        session.getTransaction().commit();

    }

    private static byte[] getImage() {
        Path path = Paths.get("src/main/resources/images/img.jpg");
        byte[] data = null;
        try {
            data = Files.readAllBytes(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
