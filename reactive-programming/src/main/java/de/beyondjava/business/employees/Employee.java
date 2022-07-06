package de.beyondjava.business.employees;

import lombok.*;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Value
@Builder
@RequiredArgsConstructor
public class Employee {
    @Id
    // @GeneratedValue
    private Long id;

    @NonNull
    @NotBlank(message = "You do have a first name, don't you?")
    @Size(min = 3, max = 20)
    private String firstName;

    @NonNull
    @NotBlank(message = "Don't be shy and tell us your last name.")
    @Size(min = 3, max = 20)
    private String lastName;

//    @NonNull
//    @OneToMany(cascade = CascadeType.ALL)
//    private List<Project> projects;
}
