package _05_IOSP;

import java.util.ArrayList;
import java.util.List;

public class UserManager {

    public static User createUser(String username, List<String> roles, List<String> groups) {
        System.out.println("Start creating user: " + username);
        var newRoles = new ArrayList<Role>();
        var newGroups = createGroups(groups);
        for (final String role : roles) {
            newRoles.add(createRole(role));
        }
        username = sanitizeName(username);
        var user = new User(username, newRoles, newGroups);
        System.out.println("User created: " + user);
        return user;
    }

    private static Role createRole(final String role) {
        return new Role(sanitizeName(role));
    }

    private static String sanitizeName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (name.length() > 20) {
            throw new IllegalArgumentException("Name cannot be longer than 20 characters");
        }
        return name.trim().toLowerCase();
    }

    private static List<Group> createGroups(List<String> groupNames) {
        return groupNames.stream()
                .filter(name -> name != null && !name.isBlank())
                .map(name -> sanitizeName(name))
                .map(Group::new)
                .toList();
    }
}






