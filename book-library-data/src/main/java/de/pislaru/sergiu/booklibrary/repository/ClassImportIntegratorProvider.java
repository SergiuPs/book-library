package de.pislaru.sergiu.booklibrary.repository;

import de.pislaru.sergiu.booklibrary.domain.projection.user.Password;
import de.pislaru.sergiu.booklibrary.domain.projection.user.PersonalDetails;
import io.hypersistence.utils.hibernate.type.util.ClassImportIntegrator;
import org.hibernate.integrator.spi.Integrator;
import org.hibernate.jpa.boot.spi.IntegratorProvider;

import java.util.List;

public class ClassImportIntegratorProvider implements IntegratorProvider {

    @Override
    public List<Integrator> getIntegrators() {
        return List.of(
                new ClassImportIntegrator(
                        List.of(
                                PersonalDetails.class,
                                Password.class
                        )
                )
        );
    }
}