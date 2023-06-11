package com.app.travel.client;

import com.app.travel.util.BookingStatus;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatedBooking {
    private Integer id;
    private String bookingCode;
    private String name;
    private String description;
    private String regionNote;
    private Integer userRef;
    private Integer packageRef;
    private Integer numberOfDays;
    private Integer cost;
    private Integer passengerNumber;
    private Boolean paid;
    private LocalDate startAt;
    private LocalDate createdAt;

    private List<CreatedItineraries> itineraries;

    private BookingStatus status;

    private String imageUrl;

}
