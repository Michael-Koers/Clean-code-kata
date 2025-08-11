package _05_IOSP;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserManagerTest {

    @Test
    void testCreateUser_validInput() {
        List<String> roles = List.of("Admin", "User");
        List<String> groups = List.of("Developer", "Tester");
        User user = UserManager.createUser("JohnDoe", roles, groups);

        assertEquals("johndoe", user.username());
        assertEquals(2, user.roles().size());
        assertEquals("admin", user.roles().get(0).name());
        assertEquals("user", user.roles().get(1).name());
        assertEquals(2, user.groups().size());
        assertEquals("developer", user.groups().get(0).name());
        assertEquals("tester", user.groups().get(1).name());
    }

    @Test
    void testCreateUser_invalidUsername_null() {
        List<String> roles = List.of("Admin");
        List<String> groups = List.of("Developer");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            UserManager.createUser(null, roles, groups);
        });

        assertEquals("Name cannot be null or empty", exception.getMessage());
    }

    @Test
    void testCreateUser_invalidUsername_empty() {
        List<String> roles = List.of("Admin");
        List<String> groups = List.of("Developer");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            UserManager.createUser("   ", roles, groups);
        });

        assertEquals("Name cannot be null or empty", exception.getMessage());
    }

    @Test
    void testCreateUser_invalidUsername_tooLong() {
        List<String> roles = List.of("Admin");
        List<String> groups = List.of("Developer");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            UserManager.createUser("ThisUsernameIsWayTooLongToBeValid", roles, groups);
        });

        assertEquals("Name cannot be longer than 20 characters", exception.getMessage());
    }

    @Test
    void testCreateUser_rolesAndGroups_validInput() {
        List<String> roles = List.of("Admin", "User");
        List<String> groups = List.of("Developer", "Tester");
        User user = UserManager.createUser("JaneDoe", roles, groups);

        assertEquals(2, user.roles().size());
        assertEquals("admin", user.roles().get(0).name());
        assertEquals("user", user.roles().get(1).name());
        assertEquals(2, user.groups().size());
        assertEquals("developer", user.groups().get(0).name());
        assertEquals("tester", user.groups().get(1).name());
    }

    @Test
    void testCreateUser_rolesAndGroups_invalidRoles() {
        List<String> roles = new ArrayList<>();
        roles.add(null);
        List<String> groups = List.of("Developer");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            UserManager.createUser("JaneDoe", roles, groups);
        });

        assertEquals("Name cannot be null or empty", exception.getMessage());
    }

    @Test
    void testCreateUser_rolesAndGroups_invalidGroup() {
        List<String> roles = List.of("Admin", "User");
        List<String> groups = new ArrayList<>();
        groups.add(null);

        User user = UserManager.createUser("JaneDoe", roles, groups);

        assertEquals(2, user.roles().size());
        assertEquals("admin", user.roles().get(0).name());
        assertEquals("user", user.roles().get(1).name());
        assertEquals(0, user.groups().size());
    }
}
