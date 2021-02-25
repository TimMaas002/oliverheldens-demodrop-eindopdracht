//package nl.novi.maas.oliverheldens.demodrop.service;
//
//import nl.novi.maas.oliverheldens.demodrop.domain.DemoFiles;
//import nl.novi.maas.oliverheldens.demodrop.repository.DemoFilesRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.util.StringUtils;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Stream;
//
//@Service
//public class StorageService {
//
//    private static DemoFilesRepository demoFilesRepository;
//
//    @Autowired
//    public StorageService(DemoFilesRepository demoFilesRepository) {
//        this.demoFilesRepository = demoFilesRepository;
//    }
//
////    public static String uploadDirectory = System.getProperty("user.dir") + "/FileUploads/";
//
//    public void save(MultipartFile file) throws IOException {
//
//        Path uploadDirectory = Paths.get(System.getProperty("user.dir") + "/FileUploads/");
//        Files.copy(file.getInputStream(), uploadDirectory.resolve(file.getOriginalFilename()));
//
//        DemoFiles fileEntity = new DemoFiles();
//        fileEntity.setName(StringUtils.cleanPath(file.getOriginalFilename()));
//        fileEntity.setContentType(file.getContentType());
////        fileEntity.setData(file.getBytes());
//        fileEntity.setDirectory(uploadDirectory + "/" + file.getOriginalFilename());
//        fileEntity.setSize(file.getSize());
//
//        demoFilesRepository.save(fileEntity);
//    }
//
//    public static Optional<DemoFiles> getFile(String id) {
//        return demoFilesRepository.findById(id);
//    }
//
//    public List<DemoFiles> getAllFiles() {
//        return demoFilesRepository.findAll();
//    }
//}