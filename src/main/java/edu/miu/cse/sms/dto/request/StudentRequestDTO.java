package edu.miu.cse.sms.dto.request;

public record StudentRequestDTO(
        String registerNumber,
        String name,
        String email,
        String phone
) {
}
