package com.expedia.model.response;

import lombok.Data;

@Data
public class UserInfo {
    private Persona persona;
    private String userId;
}

@Data
class Persona {
    private String personaType;
}
