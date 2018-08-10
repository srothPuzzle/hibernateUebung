package ch.puzzle.pfeedback.user.model;

import ch.puzzle.pfeedback.groupRole.model.GroupRole;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class User {

    private String name;
    private String vorname;
    private String email;
    private boolean admin;
    Set<GroupRole> groupRole;

}
