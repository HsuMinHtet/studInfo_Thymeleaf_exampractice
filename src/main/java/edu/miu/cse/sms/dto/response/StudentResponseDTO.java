package edu.miu.cse.sms.dto.response;

public record StudentResponseDTO(
        String name,
        String registerNumber,
        String email,
        String phoneNumber
) {
}
