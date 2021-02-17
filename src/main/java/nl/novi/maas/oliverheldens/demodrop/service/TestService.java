package nl.novi.maas.oliverheldens.demodrop.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    // Wanneer je wilt praten met de /api/test/{naam} endpoint moet je zijn ingelogd en een specifieke role hebben.

    public String generatePublicContent() {
        return "Public Content.";
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public String generateUserContent() {
        return "User Content.";
    }

    @PreAuthorize("hasRole('ADMIN')")
    public String generateAdminContent() {
        return "Admin Board.";
    }

}
