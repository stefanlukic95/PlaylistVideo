package ytApp;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name  = "Playlist")
public class Playlist {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    public Integer id;
    public String name;
    @ElementCollection
    @OneToOne
    public User user;
    @ElementCollection
    @ManyToMany
    @MapsId("videosId")
    @JoinColumn(name = "playlist_id")
    public List<Video> videos;


    public Playlist(){

    }

    public Playlist(Integer id, String name, User user, List<Video> videos) {
        this.id = id;
        this.name = name;
        this.user = user;
        this.videos = videos;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }


}
