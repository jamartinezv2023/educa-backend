package com.educa.backend.domain.model.AuthLog;

package com.educa.backend.domain.model;
import java.time.LocalDateTime;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthLog {
    private LocalDateTime timestamp;
    private String method;
    private String ip;
    private boolean success;
    private String failureReason;
}