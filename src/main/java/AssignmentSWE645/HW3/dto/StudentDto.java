package AssignmentSWE645.HW3.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String streetAddress;
    private String city;
    private String state;
    private Integer postalCode;
    private Long telephoneNumber;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date surveyDate;
    private String interestCause;
    private String mostLiked;
    private String recommendation;
}
