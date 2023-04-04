package com.szmengran.chatgpt.dto.image;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.web.multipart.MultipartFile;

/**
 * A request for OpenAi to edit an image based on a prompt
 * All fields except prompt are optional
 *
 * https://beta.openai.com/docs/api-reference/images/create-edit
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
@Data
public class ImageCreateEditCmd {
    
    /**
     * The image to edit. Must be a valid PNG file, less than 4MB, and square. If mask is not provided, image must have transparency, which will be used as the mask.
     */
    private MultipartFile image;
    
    /**
     * An additional image whose fully transparent areas (e.g. where alpha is zero) indicate where image should be edited. Must be a valid PNG file, less than 4MB, and have the same dimensions as image.
     */
    private MultipartFile mask;

    /**
     * A text description of the desired image(s). The maximum length in 1000 characters.
     */
    @NonNull
    String prompt;

    /**
     * The number of images to generate. Must be between 1 and 10. Defaults to 1.
     */
    Integer n;

    /**
     * The size of the generated images. Must be one of "256x256", "512x512", or "1024x1024". Defaults to "1024x1024".
     */
    String size;

}
