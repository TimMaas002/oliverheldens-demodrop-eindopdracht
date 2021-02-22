package nl.novi.maas.oliverheldens.demodrop.service;

import nl.novi.maas.oliverheldens.demodrop.domain.FileUpload;
import nl.novi.maas.oliverheldens.demodrop.exceptions.DatabaseErrorException;
import nl.novi.maas.oliverheldens.demodrop.exceptions.RecordNotFoundException;
import nl.novi.maas.oliverheldens.demodrop.repository.FileUploadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class FileUploadService {

    @Autowired
    private FileUploadRepository fileUploadRepository;

    public static String uploadDirectory = System.getProperty("user.dir") + "/FileUploads/";

    public void uploadFile(MultipartFile file) throws IOException {
        file.transferTo(new File(uploadDirectory + file.getOriginalFilename()));
    }
}