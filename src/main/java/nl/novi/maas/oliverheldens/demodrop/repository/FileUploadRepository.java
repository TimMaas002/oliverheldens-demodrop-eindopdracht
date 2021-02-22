package nl.novi.maas.oliverheldens.demodrop.repository;

import nl.novi.maas.oliverheldens.demodrop.domain.FileUpload;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileUploadRepository extends JpaRepository<FileUpload, Long> {

}