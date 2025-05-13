package com.chwesh.fotos.web;

import com.chwesh.fotos.service.PhotosService;
import com.chwesh.fotos.model.Photo;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.Collection;

@RestController
public class PhotosController {

    private final PhotosService photosService;

    public PhotosController(PhotosService photosService) {
        this.photosService = photosService;
    }

    @GetMapping("/")
    public String hello() {
        return "Hello World";
    }


    @GetMapping("/photos")
    public Iterable<Photo> get() {
        return photosService.getPhoto();
    }

    @GetMapping("/photos/{id}")
    public Photo get(@PathVariable Integer id) {
        Photo photo = photosService.getPhoto(id);
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

    return photo;
    }

    @DeleteMapping("/photos/delete/{id}")
    public void delete(@PathVariable Integer id) {
        photosService.remove(id);
    }

    @PostMapping("/photos")
    public Photo create(@RequestPart("data") MultipartFile file) throws IOException {
        return photosService.save(file.getOriginalFilename(),  file.getContentType(), file.getBytes());
    }

    @GetMapping("/photos/{id}/image")
    public ResponseEntity<byte[]> getPhotoImage(@PathVariable Integer id) {
        Photo photo = photosService.getPhoto(id);
        if (photo == null || photo.getData() == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType(photo.getContentType())); // e.g., image/jpeg
        headers.setContentLength(photo.getData().length);

        return new ResponseEntity<>(photo.getData(), headers, HttpStatus.OK);
    }
}
