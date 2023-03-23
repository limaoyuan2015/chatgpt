package com.szmengran.chatgpt.dto.chat;

import com.szmengran.chatgpt.dto.Usage;
import lombok.Data;

import java.util.List;

/**
 * Object containing a response from the chat completions api.
 */
@Data
public class ChatCompletionCO {

    /**
     * Unique id assigned to this chat completion.
     */
    private String id;

    /**
     * The type of object returned, should be "chat.completion"
     */
    private String object;

    /**
     * The creation time in epoch seconds.
     */
    private long created;
    
    /**
     * The GPT-3.5 model used.
     */
    private String model;

    /**
     * A list of all generated completions.
     */
    private List<ChatCompletionChoice> chatCompletionChoices;

    /**
     * The API usage for this request.
     */
    private Usage usage;

}
