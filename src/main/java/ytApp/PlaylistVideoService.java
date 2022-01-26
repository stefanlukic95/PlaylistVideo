package ytApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaylistVideoService {

    @Autowired
    private PlaylistRepository playlistRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VideoRepository videoRepository;


    public List<Video> findAllVideos() {
        return videoRepository.findAll();
    }

    public Playlist findOnePlaylist(Integer id) {
        return playlistRepository.findById(id).orElse(null);
    }

    public List<Playlist> findAllPlaylists() {


        return playlistRepository.findAll();
    }

    public Video findOneVideo(Integer id) {
        return videoRepository.findById(id).orElse(null);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }


    public User insertUser(User u) {

        return userRepository.save(u);
    }

    public Video insertVideo(Video v) {

        return videoRepository.save(v);
    }

    public Playlist insertPlaylist(Playlist p) {

        return playlistRepository.save(p);
    }

    public void deletePlaylist(Integer id) {
        this.playlistRepository.deleteById(id);}

    public void deleteVideo(Integer id) {
        this.videoRepository.deleteById(id);}

     public Playlist updatePlaylist(Playlist p)throws Exception{

        return playlistRepository.save(p);
    }
    public Video updateVideo(Video v)throws Exception{
        return videoRepository.save(v);
    }



}
