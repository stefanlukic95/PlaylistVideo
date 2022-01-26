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
    @ElementCollection
    @ManyToMany
    @MapsId("videoId")
    @JoinColumn(name = "video_id")
    public List<Playlist> playlists;

    public Video() {
    }

    public Video(Integer id, String name,List<Playlist> playlists) {
        this.id = id;
        this.name = name;
        this.playlists=playlists;


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

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<Playlist> playlists) {
        this.playlists = playlists;
    }
}
