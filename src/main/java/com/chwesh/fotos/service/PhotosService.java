package com.chwesh.fotos.service;

import com.chwesh.fotos.model.Photo;
import com.chwesh.fotos.repository.repository.PhotosRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class PhotosService {
    private final PhotosRepository photosRepository;


    public PhotosService(PhotosRepository photosRepository) {
        this.photosRepository = photosRepository;
    }

    /*private Map<String, Photo> db = new HashMap<>(){{
        put("1", new Photo("1", "hello.jpg"));
    }};*/

    public Iterable<Photo> getPhoto() {
        return photosRepository.findAll();
    }

    public Photo getPhoto(Integer id) {
        return photosRepository.findById(id).orElse(null);
    }

    public void remove(Integer id) {
        photosRepository.deleteById(id);
    }

    public Photo save(String fileName, String contentType, byte[] data) {
        Photo photo = new Photo();
        photo.setContentType(contentType);
        photo.setFileName(fileName);
        photo.setFileData(data);
        photosRepository.save(photo);
        return photo;
    }

}
