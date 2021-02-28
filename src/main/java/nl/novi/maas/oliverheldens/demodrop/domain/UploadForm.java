package nl.novi.maas.oliverheldens.demodrop.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "upload_form")
public class UploadForm {

    /**
     Middels dit domain wordt er gekeken of de informatie voor het uploadform goed is geplaatst
     Hierna wordt het doorgegeven aan de service
     **/

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "native"
    )
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    @Column(columnDefinition = "serial")
    private long id;
    private String artist_name;
    private String email;
    private String song_name;
    private String upload_file; // misschien veranderd deze nog naar een ander type?
    private String message;

    public UploadForm() {

    }

    public UploadForm(String artist_name, String email) {
        this.artist_name = artist_name;
        this.email = email;
    }

    public UploadForm(String artist_name, String song_name, String message) {
        this.artist_name = artist_name;
        this.song_name = song_name;
        this.message = message;
    }

    public UploadForm(String artist_name, String song_name, String message, String upload_file) {
        this.artist_name = artist_name;
        this.song_name = song_name;
        this.message = message;
        this.upload_file = upload_file;
    }

    public UploadForm(Long id, String artist_name, String song_name, String message, String upload_file) {
        this.id = id;
        this.artist_name = artist_name;
        this.song_name = song_name;
        this.message = message;
        this.upload_file = upload_file;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getArtist_name() {
        return artist_name;
    }

    public void setArtist_name(String artist_name) {
        this.artist_name = artist_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSong_name() {
        return song_name;
    }

    public void setSong_name(String song_name) {
        this.song_name = song_name;
    }

    public String getUpload_file() {
        return upload_file;
    }

    public void setUpload_file(String upload_file) {
        this.upload_file = upload_file;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}