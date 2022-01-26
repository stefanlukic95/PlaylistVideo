package ytApp;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name  = "Video")
public class Video {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    public Integer id;
    public String name;
    public Integer counter;
    @ElementCollection
    @ManyToMany
    public List<Playlist> playlist;


    public Video(){
    }

    public Video(Integer id, String name, Integer counter,List<Playlist> playlist) {
        this.id = id;
        this.name = name;
        this.counter = this.counter;
        this.playlist  = playlist;
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

    public List<Playlist> getPlaylist() {
        return playlist;
    }

    public void setPlaylist(List<Playlist> playlist) {
        this.playlist = playlist;
    }
}
