package com.statik.core.commands;

public interface CommandProcesor<R> {

    R doProcess(final CommandContext commandContext);

    default R process(final CommandContext commandContext) {
        return supports(commandContext) ? doProcess(commandContext) : null;
    }

    default boolean supports(final CommandContext commandContext) {
        return true;
    }
}
