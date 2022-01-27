package ytApp;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "PlayListVideo")
public class PlayListVideo {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    public Integer id;

    @ManyToOne
    @JoinColumn(name = "video_id")
    public Video video;


    @ManyToOne
    @JoinColumn(name ="playlist_id")
    @JsonBackReference
    public Playlist playlist;

    public int sortOrder;


    public PlayListVideo(){

    }

    public PlayListVideo(Integer id, Video video, Playlist playlist, int sortOrder) {
        this.id = id;
        this.video = video;
        this.playlist = playlist;
        this.sortOrder = sortOrder;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

    public int getOrder() {
        return sortOrder;
    }

    public void setOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }
}
