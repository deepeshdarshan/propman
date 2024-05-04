package com.eh.propman.app.common.modal;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder(setterPrefix = "with")
public class Result {

    private Long id;

    private Status status;
}
