package pt.ipp.isep.dei.esoft.project.repository;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.Collaborator;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CollaboratorRepositoryTest {

    @Test
    void ensureCollaboratorRepositoryIsSingleton() {
        AgendaRepository instance1 = AgendaRepository.getInstance();
        AgendaRepository instance2 = AgendaRepository.getInstance();
        assertSame(instance1, instance2);
    }

    @Test
    void ensureCollaboratorIsAddedSuccessfully() {
        AgendaRepository collaboratorRepository = AgendaRepository.getInstance();
        Collaborator collaborator = new Collaborator("John Doe", "Rua do Rio","john@gmail.com","999999999","passaporte","BR661289", LocalDate.of(1980,7,28),LocalDate.of(2024,5,10),"jardineiro");
        collaboratorRepository.addCollaborator(collaborator);
        List<Collaborator> collaborators = collaboratorRepository.getCollaborators();
        assertTrue(collaborators.contains(collaborator));
    }

    @Test
    void ensureCollaboratorListIsMutable() {
        AgendaRepository collaboratorRepository = AgendaRepository.getInstance();
        assertDoesNotThrow(() -> collaboratorRepository.getCollaborators().add(new Collaborator("Jane Smith", "Rua da Vinha","jane@gmail.com","999999999","cartão de cidadão","88888888", LocalDate.of(1980,7,28),LocalDate.of(2024,5,10),"jardineiro")));
    }

}
