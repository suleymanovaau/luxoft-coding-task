package com.self.company.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.csv.CSVRecord;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;

    private String name;

    private String description;

    @UpdateTimestamp
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTimeStamp;

    public User(CSVRecord csvRecord) {
        this.id = Integer.parseInt(csvRecord.get("PRIMARY_KEY"));
        this.name = csvRecord.get("NAME");
        this.description = csvRecord.get("DESCRIPTION");
        this.updateTimeStamp = LocalDateTime.parse(csvRecord.get("UPDATED_TIMESTAMP"),DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
