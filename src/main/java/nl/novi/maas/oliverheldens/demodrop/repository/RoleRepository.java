package nl.novi.maas.oliverheldens.demodrop.repository;

import nl.novi.maas.oliverheldens.demodrop.domain.ERole;
import nl.novi.maas.oliverheldens.demodrop.domain.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Roles, Long> {

    Optional<Roles> findByName(ERole name);

}
