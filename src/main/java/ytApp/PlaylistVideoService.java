package ytApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class PlaylistVideoService {

    @Autowired
    private PlaylistRepository playlistRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VideoRepository videoRepository;

    @Autowired
    private PlayListVideoRepository playListVideoRepository;

    public List<Video> findAllVideos() {
        return videoRepository.findAll();
    }

    public Playlist getOrderedPlaylist(Integer id) {
         Playlist response = playlistRepository.findById(id).orElse(null);
         response.getVideos().sort(Comparator.comparing(PlayListVideo::getOrder));

         return response;
    }

    public PlayListVideo changePlaylistOrder(Integer id,PlayListVideo playListVideo) {
        PlayListVideo playlistToChange = playListVideoRepository.findById(id).orElse(null);

        playlistToChange.setOrder(playListVideo.getOrder());



        return playlistToChange;
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


    public void deletePlayListVideo(Integer id) {
        this.playListVideoRepository.deleteById(id);}

     public Playlist updatePlaylist(Playlist p)throws Exception{

        return playlistRepository.save(p);
    }
    public Video updateVideo(Video v)throws Exception {
        return videoRepository.save(v);
    }
        public Playlist insertVideoToPlayList(Integer videoId, Integer playlistId ) throws Exception{

        Playlist playlist = getOrderedPlaylist(playlistId);
        Video oneVideo = findOneVideo(videoId);


        PlayListVideo playListVideo = new PlayListVideo();
        playListVideo.setPlaylist(playlist);
        playListVideo.setVideo(oneVideo);
        playListVideo.setOrder(playlist.getVideoCount() +1);
        playlist.addVideo(playListVideo);


        return updatePlaylist(playlist);

    }



}
