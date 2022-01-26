package ytApp;

import javax.persistence.*;

@Entity
@Table(name  = "Video")
public class Video {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    public Integer id;
    public String name;
    public Integer counter;


    public Video(){
    }

    public Video(Integer id, String name, Integer counter) {
        this.id = id;
        this.name = name;
        this.counter = this.counter;
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

    public Integer getCounter() {
        return counter;
    }

    public void setCounter(Integer counter) {
        this.counter = counter;
    }
}
