package co.unicauca.workflow.degree_project.domain.entities;

/**
 *
 * @author Ortega
 */
public interface IPasswordHasher {
     String hash(char[] rawPassword);
     boolean verify(char[] plainPassword, String hashedPassword);
}
