package com.szmengran.chatgpt.infrastructure.openai.dto.edit;

import com.szmengran.chatgpt.infrastructure.openai.dto.Usage;
import lombok.Data;

import java.util.List;

/**
 * A list of edits generated by GPT-3
 *
 * https://beta.openai.com/docs/api-reference/edits/create
 */
@Data
public class EditCO {

    /**
     * The type of object returned, should be "edit"
     */
    private String object;

    /**
     * The creation time in epoch milliseconds.
     */
    private long created;

    /**
     * A list of generated edits.
     */
    private List<EditChoice> choices;

    /**
     * The API usage for this request
     */
    private Usage usage;
}
