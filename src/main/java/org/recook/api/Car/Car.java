package org.recook.api.Car;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@Data
@Document("sample")
public class Car {
    @Id
    String Id;
    String carModel;
    String carMake;
    Number carModelYear;
}
