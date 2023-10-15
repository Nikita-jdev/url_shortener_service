package faang.school.urlshortenerservice.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.URL;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class UrlDTO {

    @URL(message = "Invalid URL format")
    @NotBlank(message = "URL can't be empty")
    private String url;
    private LocalDateTime createdAt;
}