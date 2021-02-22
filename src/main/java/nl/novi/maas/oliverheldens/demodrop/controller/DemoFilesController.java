package nl.novi.maas.oliverheldens.demodrop.controller;

import nl.novi.maas.oliverheldens.demodrop.domain.DemoFiles;
import nl.novi.maas.oliverheldens.demodrop.payload.response.FileResponse;
import nl.novi.maas.oliverheldens.demodrop.service.DemoStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
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

    private final DemoStorageService demoStorageService;

    @Autowired
    public DemoFilesController(DemoStorageService demoStorageService) {
        this.demoStorageService = demoStorageService;
    }

    @PostMapping
    public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file, Principal principal) {
        try {
            demoStorageService.save(file);

            return ResponseEntity.status(HttpStatus.OK)
                    .body(String.format("File uploaded successfully: %s", file.getOriginalFilename()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(String.format("Could not upload the file: %s!", file.getOriginalFilename()));
        }
    }

    @GetMapping
    public List<FileResponse> list() {
        return demoStorageService.getAllFiles()
                .stream()
                .map(this::mapToFileResponse)
                .collect(Collectors.toList());
    }

    private FileResponse mapToFileResponse(DemoFiles demoFiles) {
        String downloadURL = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/files/")
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

    @GetMapping("/{id}")
    // ResponsEntity []byte = String
    public ResponseEntity<String> getFile(@PathVariable String id) {
        Optional<DemoFiles> demoFilesOptional = DemoStorageService.getFile(id);

        if (!demoFilesOptional.isPresent()) {
            return ResponseEntity.notFound()
                    .build();
        }

        DemoFiles demoFiles = demoFilesOptional.get();
        return ResponseEntity.ok()
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + demoFiles.getName() + "\"")
//                .contentType(MediaType.valueOf(demoFiles.getContentType()))
//                .body(demoFiles.getData());
                .body(demoFiles.getDirectory());
    }

}