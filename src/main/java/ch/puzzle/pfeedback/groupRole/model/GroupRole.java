package ch.puzzle.pfeedback.groupRole.model;

import ch.puzzle.pfeedback.group.model.Group;
import ch.puzzle.pfeedback.user.model.User;
import ch.puzzle.pfeedback.role.model.Role;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GroupRole {

    private User user;
    private Group group;
    private Role role;


}
