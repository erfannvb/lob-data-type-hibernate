package nvb.dev;

import jakarta.persistence.*;

import java.sql.Blob;

@Entity
@Table(name = "tbl_data")
public class Data {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "data_id", nullable = false)
    private Long id;

    @Column(name = "data_name", nullable = false, length = 100)
    private String name;

    @Lob
    @Column(name = "data_file")
    private Blob file;

    public Data() {
    }

    public Data(String name, Blob file) {
        this.name = name;
        this.file = file;
    }

    public Data(Long id, String name, Blob file) {
        this.id = id;
        this.name = name;
        this.file = file;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Blob getFile() {
        return file;
    }

    public void setFile(Blob file) {
        this.file = file;
    }
}
