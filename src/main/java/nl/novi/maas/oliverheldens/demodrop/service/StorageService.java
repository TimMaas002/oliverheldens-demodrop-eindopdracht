package nl.novi.maas.oliverheldens.demodrop.service;

import nl.novi.maas.oliverheldens.demodrop.domain.DemoFiles;
import nl.novi.maas.oliverheldens.demodrop.repository.DemoFilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
public class StorageService {

    /**
     * Deze Service praat met de demoFiles. De public void save pakt hier alle meta data
     * uit de file die is geüpload en plaatst dit vervolgens in de juiste kolom
     * Daarnaast wordt de geüploade file ook geplaatst in de juiste map FileUploads
     */

    private static DemoFilesRepository demoFilesRepository;

    @Autowired
    public StorageService(DemoFilesRepository demoFilesRepository) {
        this.demoFilesRepository = demoFilesRepository;
    }


    public void save(MultipartFile file) throws IOException {

        Path uploadDirectory = Paths.get(System.getProperty("user.dir") + "/FileUploads/");
        Files.copy(file.getInputStream(), uploadDirectory.resolve(file.getOriginalFilename()));

        DemoFiles fileEntity = new DemoFiles();
        fileEntity.setName(StringUtils.cleanPath(file.getOriginalFilename()));
        fileEntity.setContentType(file.getContentType());
        fileEntity.setDirectory(uploadDirectory + "/" + file.getOriginalFilename());
        fileEntity.setSize(file.getSize());

        demoFilesRepository.save(fileEntity);
    }

    public static Optional<DemoFiles> getFile(String id) {
        return demoFilesRepository.findById(id);
    }

    public List<DemoFiles> getAllFiles() {
        return demoFilesRepository.findAll();
    }
}