package com.venkat.updatedPhonebook.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public @Data @NoArgsConstructor @AllArgsConstructor class ContactDTO {
     private int id;
     private String name;
     private String phone;
}
