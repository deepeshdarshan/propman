package com.eh.propman.app.shared.modal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(setterPrefix = "with")
public class Result {

    private Long id;

    private Status status;
}
