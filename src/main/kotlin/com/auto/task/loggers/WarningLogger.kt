package com.auto.task.loggers

import java.util.logging.Logger

class WarningLogger {
    private val logger: Logger = Logger.getLogger(this.javaClass.name)

    fun log(message: String) {
        logger.warning("WARNING: $message")
    }
}