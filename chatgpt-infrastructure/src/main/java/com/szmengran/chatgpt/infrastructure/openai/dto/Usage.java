package com.szmengran.chatgpt.infrastructure.openai.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * The OpenAI resources used by a request
 */
@Data
public class Usage {
    /**
     * The number of prompt tokens used.
     */
    @JsonProperty("prompt_tokens")
    Integer promptTokens;

    /**
     * The number of completion tokens used.
     */
    @JsonProperty("completion_tokens")
    Integer completionTokens;

    /**
     * The number of total tokens used
     */
    @JsonProperty("total_tokens")
    Integer totalTokens;
}
