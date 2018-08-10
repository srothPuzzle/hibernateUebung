package ch.puzzle.pfeedback.role.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Role {
    private String name;
    private String beschreibung;
}
