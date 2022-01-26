package ytApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin("*")
public class PlaylistVideoController {

    @Autowired
    private PlaylistVideoService playlistVideoService;


    public PlaylistVideoController(PlaylistVideoService playlistVideoService) {
        this.playlistVideoService = playlistVideoService;
    }


    @RequestMapping(
            method = RequestMethod.GET,
            value = "/videos",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<Video>> getAllVideos() {
        List<Video> videos = playlistVideoService.findAllVideos();

        return new ResponseEntity<List<Video>>(videos, HttpStatus.OK);
    }

    @RequestMapping(
            value="/playlist/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Playlist> getPlaylistById(@PathVariable("id") Integer id) {

        Playlist playlist = this.playlistVideoService.findOnePlaylist(id);


        if(playlist == null){
            return new ResponseEntity<Playlist>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Playlist>(playlist, HttpStatus.OK);

    }
//
//    @RequestMapping(
//            value="/videoSortedList/{id}",
//            method = RequestMethod.GET,
//            produces = MediaType.APPLICATION_JSON_VALUE
//    )
//    public ResponseEntity<Playlist> getSortedVideoList(@PathVariable("id") Integer id) {
//
//        Playlist playlist = this.playlistVideoService.findOnePlaylist(id);
//
//
//
//        if(playlist == null){
//            return new ResponseEntity<Playlist>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<Playlist>(playlist, HttpStatus.OK);
//
//    }


    @RequestMapping(
            value="/video/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Video> getVideoById(@PathVariable("id") Integer id) {

        Video video = this.playlistVideoService.findOneVideo(id);
        if(video == null){
            return new ResponseEntity<Video>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Video>(video, HttpStatus.OK);

    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/playlists",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<Playlist>> getAllPlaylists() {
        List<Playlist> playlists = playlistVideoService.findAllPlaylists();

        return new ResponseEntity<List<Playlist>>(playlists, HttpStatus.OK);
    }


    @RequestMapping(
            method = RequestMethod.GET,
            value = "/users",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = playlistVideoService.findAllUsers();
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/register",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<User> insertUser(@RequestBody User user) {


        User insertedUser = playlistVideoService.insertUser(user);
        return new ResponseEntity<User>(insertedUser, HttpStatus.OK);

    }

    @RequestMapping(
            value = "/postVideo",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Video> insertVideo(@RequestBody Video video) {


        Video insertedVideo = playlistVideoService.insertVideo(video);
        return new ResponseEntity<Video>(insertedVideo, HttpStatus.OK);

    }

    @RequestMapping(
            value = "/postPlaylist",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Playlist> insertPlaylist(@RequestBody Playlist playlist){


        Playlist insertedPlaylist = playlistVideoService.insertPlaylist(playlist);
        return new ResponseEntity<Playlist>(insertedPlaylist, HttpStatus.OK);

    }


    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/playlist/{id}"
    )
    public ResponseEntity<Playlist> deletePlaylist(@PathVariable("id") Integer id){

        this.playlistVideoService.deletePlaylist(id);
        return new ResponseEntity<Playlist>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/video/{id}"
    )
    public ResponseEntity<Video> deleteVideo(@PathVariable("id") Integer id){

        this.playlistVideoService.deleteVideo(id);
        return new ResponseEntity<Video>(HttpStatus.NO_CONTENT);
    }



    @RequestMapping(
            method = RequestMethod.PUT,
            value = "/playlist/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Playlist> updatePlaylist(@PathVariable("id") Integer id, @RequestBody Playlist playlist) throws Exception {
        Playlist onePlaylist = this.playlistVideoService.findOnePlaylist(id);

        if (onePlaylist == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        onePlaylist.setVideos(playlist.getVideos());


        Playlist updatePLaylist = this.playlistVideoService.updatePlaylist(onePlaylist);


        if (updatePLaylist == null) {
            return new ResponseEntity<Playlist>(
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(updatePLaylist,HttpStatus.OK);
    }



    @RequestMapping(
            value = "/insertVideoToPlaylist/{id}/{video_id}",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Playlist> insertVideoToplaylist(@PathVariable("id") Integer id,@PathVariable ("video_id") Integer idv) throws Exception {


        Playlist playlist = this.playlistVideoService.findOnePlaylist(id);
        Video oneVideo = this.playlistVideoService.findOneVideo(idv);



        playlist.getVideos().add(oneVideo);
        Playlist updatedPlaylist =this.playlistVideoService.updatePlaylist(playlist);


        return new ResponseEntity<Playlist>(updatedPlaylist, HttpStatus.OK);

    }

    @RequestMapping(
            method = RequestMethod.PUT,
            value = "/video/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Video> updateVideo(@PathVariable("id") Integer id, @RequestBody Video video) throws Exception {
        Video oneVideo = this.playlistVideoService.findOneVideo(id);

        if (oneVideo == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


        oneVideo.setName(video.getName());
        Video updateVideo = this.playlistVideoService.updateVideo(oneVideo);


        if (updateVideo == null) {
            return new ResponseEntity<Video>(
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(updateVideo,HttpStatus.OK);
    }



}



