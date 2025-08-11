package _05_IOSP;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserManager {

    public static User createUser(String username, List<String> roles, List<String> groups) {
        System.out.println("Start creating user: " + username);

        var newGroups = createGroups(groups);
        var newRoles = createRoles(roles);
        var user = createUser(username, newRoles, newGroups);

        System.out.println("User created: " + user);
        return user;
    }

    private static ArrayList<Role> createRoles(final List<String> roles) {
        return roles.stream()
                .map(UserManager::sanitizeName)
                .map(Role::new)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private static User createUser(String username, final ArrayList<Role> newRoles, final List<Group> newGroups) {
        username = sanitizeName(username);
        return new User(username, newRoles, newGroups);
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
                .map(UserManager::sanitizeName)
                .map(Group::new)
                .toList();
    }
}






