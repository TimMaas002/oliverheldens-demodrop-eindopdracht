package nl.novi.maas.oliverheldens.demodrop.service;

import nl.novi.maas.oliverheldens.demodrop.domain.UploadForm;
import nl.novi.maas.oliverheldens.demodrop.exceptions.DatabaseErrorException;
import nl.novi.maas.oliverheldens.demodrop.exceptions.RecordNotFoundException;
import nl.novi.maas.oliverheldens.demodrop.repository.UploadFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UploadFormServiceImpl implements UploadFormService {

    @Autowired
    UploadFormRepository uploadFormRepository;

    @Override
    public List<UploadForm> getAllUploadForms() {
        return uploadFormRepository.findAll();
    }

    @Override
    public UploadForm getUploadFormById(long id) {
        if (uploadFormRepository.existsById(id)) {
            return uploadFormRepository.findById(id).orElse(null);
        }
        else {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public void deleteUploadForm(long id) {
        if (uploadFormRepository.existsById(id)) {
            uploadFormRepository.deleteById(id);
        }
        else {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public long saveUploadForm(UploadForm uploadForm) {
        UploadForm newUploadForm = uploadFormRepository.save(uploadForm);
        return newUploadForm.getId();
    }

    @Override
    public void updateUploadForm(long id, UploadForm uploadForm) {
        if (uploadFormRepository.existsById(id)) {
            try {
                UploadForm existingUploadForm = uploadFormRepository.findById(id).orElse(null);
                existingUploadForm.setArtist_name(uploadForm.getArtist_name());
                existingUploadForm.setEmail(uploadForm.getEmail());
                existingUploadForm.setSong_name(uploadForm.getSong_name());
//                existingUploadForm.setUpload_file(uploadForm.getUpload_file());
                existingUploadForm.setMessage(uploadForm.getMessage());
                uploadFormRepository.save(existingUploadForm);
            }
            catch (Exception ex) {
                throw new DatabaseErrorException();
            }
        }
        else {
            throw new RecordNotFoundException();
        }
    }
}
