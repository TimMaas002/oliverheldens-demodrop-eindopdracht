package nl.novi.maas.oliverheldens.demodrop.service;

import nl.novi.maas.oliverheldens.demodrop.domain.UploadForm;

import java.util.List;

public interface UploadFormService {

    List<UploadForm> getAllUploadForms();

    UploadForm getUploadFormById(long id);

    void deleteUploadForm(long id);

    long saveUploadForm(UploadForm uploadForm);

    void updateUploadForm(long id, UploadForm uploadForm);
}