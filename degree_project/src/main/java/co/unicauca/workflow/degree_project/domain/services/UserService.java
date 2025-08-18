package co.unicauca.workflow.degree_project.domain.services;

import co.unicauca.workflow.degree_project.access.IUserRepository;
import co.unicauca.workflow.degree_project.domain.entities.*;
import co.unicauca.workflow.degree_project.presentation.dtos.RegisterUserDTO;
import jakarta.validation.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class UserService implements IRegistrationService {

    private final IUserRepository repo;
    private final IPasswordHasher hasher;
    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    public UserService(IUserRepository repo, IPasswordHasher hasher) {
        this.repo = repo;
        this.hasher = hasher;
    }

    @Override
    public RegistrationResult register(RegisterUserDTO dto) {

        if (dto == null) {
            return RegistrationResult.fail("Datos de registro vacíos");
        }

        Set<ConstraintViolation<RegisterUserDTO>> v = validator.validate(dto);
        if (!v.isEmpty()) {
            Map<String, String> fe = new LinkedHashMap<>();
            for (var e : v) {
                fe.putIfAbsent(e.getPropertyPath().toString(), e.getMessage());
            }
            return RegistrationResult.fail("Errores de validación", fe);
        }

        String email = dto.getEmail().trim().toLowerCase();

        if (repo.existsByEmail(email)) {
            return RegistrationResult.fail("El email ya está registrado.", Map.of("email", "El email ya está registrado."));
        }

        String hash = hasher.hash(dto.getPassword().toCharArray());

        User u = new User(
                dto.getNombres().trim(),
                dto.getApellidos().trim(),
                (dto.getCelular() == null || dto.getCelular().isBlank()) ? null : dto.getCelular().trim(),
                dto.getPrograma(),
                dto.getRol(),
                email,
                hash
        );

        boolean ok = repo.save(u);
        return ok ? RegistrationResult.ok(u.getId())
                : RegistrationResult.fail("No se pudo guardar el usuario.");
    }
}
