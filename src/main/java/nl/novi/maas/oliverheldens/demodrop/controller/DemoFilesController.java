package nl.novi.maas.oliverheldens.demodrop.controller;

import nl.novi.maas.oliverheldens.demodrop.domain.DemoFiles;
import nl.novi.maas.oliverheldens.demodrop.payload.response.FileResponse;
import nl.novi.maas.oliverheldens.demodrop.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/files")
public class DemoFilesController {

    /**
    Onderdeel van de upload file. Hier wordt puur en alleen de file meegegeven aan de database met zijn meta data
     **/

    private final StorageService storageService;

    @Autowired
    public DemoFilesController(StorageService storageService) {
        this.storageService = storageService;
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file, Principal principal) {
        try {
            storageService.save(file);

            return ResponseEntity.status(HttpStatus.OK)
                    .body(String.format("File uploaded successfully: %s", file.getOriginalFilename()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(String.format("Could not upload the file: %s!", file.getOriginalFilename()));
        }
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping
    public List<FileResponse> list() {
        return storageService.getAllFiles()
                .stream()
                .map(this::mapToFileResponse)
                .collect(Collectors.toList());
    }

    private FileResponse mapToFileResponse(DemoFiles demoFiles) {
        String downloadURL = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/files/")
                .path(demoFiles.getId())
                .toUriString();
        FileResponse fileResponse = new FileResponse("","","",0,"","");
        fileResponse.setId(demoFiles.getId());
        fileResponse.setName(demoFiles.getName());
        fileResponse.setContenttype(demoFiles.getContentType());
        fileResponse.setSize(demoFiles.getSize());
        fileResponse.setUrl(downloadURL);

        return fileResponse;
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<String> getFile(@PathVariable String id) {
        Optional<DemoFiles> demoFilesOptional = StorageService.getFile(id);

        if (!demoFilesOptional.isPresent()) {
            return ResponseEntity.notFound()
                    .build();
        }

        DemoFiles demoFiles = demoFilesOptional.get();
        return ResponseEntity.ok()
                .body(demoFiles.getDirectory());
    }

}
