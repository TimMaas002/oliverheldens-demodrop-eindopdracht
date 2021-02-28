package nl.novi.maas.oliverheldens.demodrop.service;

import nl.novi.maas.oliverheldens.demodrop.domain.UploadForm;
import nl.novi.maas.oliverheldens.demodrop.repository.UploadFormRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

@ExtendWith(SpringExtension.class)
public class UploadFormServiceImplTest {

    @InjectMocks
    UploadFormServiceImpl uploadFormServiceImpl;

    @Mock
    UploadFormRepository uploadFormRepository;

    @Mock
    UploadForm uploadForm;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        uploadForm = new UploadForm();
        uploadForm.setId(8);
        uploadForm.setArtist_name("oliver heldens");
        uploadForm.setEmail("oliverheldens@gmail.com");
        uploadForm.setSong_name("amazing song");
        uploadForm.setUpload_file("amazingsong.mp3");
        uploadForm.setMessage("This is a personal message");
    }

    @Test
    public void whenFindUploadFormById_ShouldReturnUploadForm() {

        Mockito
                .when(uploadFormRepository.existsById((long) 8))
                .thenReturn(true);

        Mockito
                .when(uploadFormRepository.findById((long) 8))
                .thenReturn(Optional.of(uploadForm));

        UploadForm uploadFormThroughService = uploadFormServiceImpl.getUploadFormById(8);

        Assertions.assertEquals(8L, uploadFormThroughService.getId());
    }

    @Test
    public void whenUpdateUploadForm_ShouldReturnUpdatedUpload() {

    }

}
