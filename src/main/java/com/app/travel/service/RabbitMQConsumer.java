package com.app.travel.service;

import com.app.travel.client.BookingClient;
import com.app.travel.client.CreatedBooking;
import com.app.travel.client.CreatedItineraries;
import com.app.travel.models.dto.BookingProducerDto;
import com.app.travel.util.BookingStatus;
import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

@Service
public class RabbitMQConsumer {

    @Autowired
    private PackageService packageService;
    @Autowired
    private BookingClient bookingClient;

    @RabbitListener(queues = {"${rabbitmq.queue.name}"})
    public void consume(
            Message message,
            Channel channel) throws IOException {
        var producerObj = new Gson().fromJson(new String(message.getBody()), BookingProducerDto.class);
        try {
            var package1 = packageService.get(producerObj.getBookingComponents().getPackageId());
            CreatedBooking newBooking = new CreatedBooking(
                null,
                package1.getPackageCode(),
                package1.getName(),
                package1.getDescription(),
                package1.getRegionRef().getNotes(),
                package1.getAgentId(),
                    package1.getId(),
                    0,
                    0,
                    0,
                    false,
                    LocalDate.now().plusDays(10),
                    LocalDate.now(),
                    null,
                    BookingStatus.Created,
                    package1.getImageUrl()
            );

            var createdItineraries = package1
                    .getServices()
                    .stream()
                    .filter(
                            it -> producerObj
                                    .getBookingComponents()
                                    .getServiceIds()
                                    .stream()
                                    .anyMatch(
                                            p -> Objects.equals(p, it.getId())))
                    .map(obj -> new CreatedItineraries(
                            null,
                            obj.getId(),
                            0,
                            0,
                            obj.getRegionRef().getNotes(),
                            obj.getName(),
                            obj.getDescription(),
                            obj.getServiceTypeRef().getName(),
                            obj.getAdditionalData(),
                            obj.getImageUrl()
                    ))
                    .toList();

            newBooking.setItineraries(createdItineraries);

            bookingClient.putBooking(producerObj.getBookingId(), newBooking);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
        }

    }
}
