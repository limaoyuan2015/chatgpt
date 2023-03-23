package com.szmengran.chatgpt.dto;

import lombok.Data;

/**
 * A response when deleting an object
 */
@Data
public class DeleteCO {
    /**
     * The id of the object.
     */
    String id;

    /**
     * The type of object deleted, for example "file" or "model"
     */
    String object;

    /**
     * True if successfully deleted
     */
    boolean deleted;
}
