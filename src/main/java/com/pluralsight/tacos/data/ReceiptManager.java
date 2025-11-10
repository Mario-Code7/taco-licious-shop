package com.pluralsight.tacos.data;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptManager {

    public void saveReceipt(String orderDetails) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-hhmmss");
        String fileName = "receipt-" + now.format(formatter) + ".txt";

        try
                (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(orderDetails);
            System.out.println("Receipt saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving receipt: " + e.getMessage());
        }
    }
}
