package com.schoolSystem.School.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Embeddable
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@AttributeOverrides(
        {
                @AttributeOverride(
                        name = "name",
                        column=@Column(name="guardian_name")
                ),
                @AttributeOverride(
                        name = "email",
                        column=@Column(name="guardian_Email")
                ),
                @AttributeOverride(
                        name = "mobileNo",
                        column=@Column(name="guardian_MobileNo")
                )
        }
)
public class Guardian {
    private  String name;
    private  String email;
    private  String mobileNo;
}
