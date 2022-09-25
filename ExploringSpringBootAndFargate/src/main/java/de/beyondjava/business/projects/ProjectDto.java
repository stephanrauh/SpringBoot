package de.beyondjava.business.projects;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public record ProjectDto(
        @NotBlank(message = "Your project needs a name.")
        @Size(min = 3, max = 30)
        String name,

        @NotBlank(message = "Tell others about your project.")
        @Size(min = 1, max = 2000)
        String description) {
}

