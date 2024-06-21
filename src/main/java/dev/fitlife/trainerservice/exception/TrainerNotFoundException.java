package dev.fitlife.trainerservice.exception;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@EqualsAndHashCode(callSuper=false)
@RequiredArgsConstructor
public class TrainerNotFoundException extends RuntimeException {

    private final int errorCode;
    private final String errorMessage;

}
