package com.mahmoud.clinic2.response;

import com.mahmoud.clinic2.request.BaseDto;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientResponseDto extends BaseDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;
}
