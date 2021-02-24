package nl.novi.maas.oliverheldens.demodrop.repository;

import nl.novi.maas.oliverheldens.demodrop.domain.Demo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoRepository extends JpaRepository<Demo, String> {

}