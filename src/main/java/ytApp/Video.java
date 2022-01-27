package ytApp;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name  = "Video")
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public Integer id;
    public String name;

    public Video() {
    }

    public Video(Integer id, String name) {
        this.id = id;
        this.name = name;



    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
