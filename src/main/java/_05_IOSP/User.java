package _05_IOSP;

import java.util.List;

record User(String username, List<Role> roles, List<Group> groups) {
}
