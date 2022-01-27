package ytApp;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
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
    @OneToMany(mappedBy = "playlist",cascade = CascadeType.ALL)
    @JsonManagedReference
    public List<PlayListVideo> videos;


    public Playlist(){

    }

    public Playlist(Integer id, String name, User user, List<PlayListVideo> videos) {
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

    public List<PlayListVideo> getVideos() {
        return videos;
    }

    public void setVideos(List<PlayListVideo> videos) {
        this.videos = videos;
    }


    public void addVideo(PlayListVideo video){
        if(this.videos ==null){
            this.videos = new ArrayList<>();
        }
        this.videos.add(video);
    }
    public int getVideoCount(){
        return videos.size();
    }


}
