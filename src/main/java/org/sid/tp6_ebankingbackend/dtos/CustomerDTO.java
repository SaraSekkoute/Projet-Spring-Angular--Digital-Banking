package org.sid.tp6_ebankingbackend.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class CustomerDTO {
 //qiue les attributs qui m'interesse
    private Long id;
    private String name;
   private String email;

}
