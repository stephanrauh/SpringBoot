package de.beyondjava.business.projects;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Project {
    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    @NotBlank(message = "Your project needs a name.")
    @Size(min = 3, max = 30)
    private String name;

    @NonNull
    @NotBlank(message = "Tell others about your project.")
    @Size(min = 1, max = 2000)
    private String description;
}
