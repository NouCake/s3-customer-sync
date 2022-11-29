package de.kevfischer.s3customersync.service;

import de.kevfischer.s3customersync.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerCSVService {

    private final static String CSV_HEADER = String.join(
            ",",
            "Firma",
            "Strasse",
            "Strassenzusatz",
            "Ort",
            "Land",
            "PLZ",
            "Vorname",
            "Nachname",
            "Kunden-ID"
    );

    @Autowired private CustomerRepository customerRepo;

    public String allCustomerAsCsvString(boolean withHeader) {
        StringBuilder sb = new StringBuilder();

        if(withHeader) {
            sb.append(CSV_HEADER);
            sb.append("\n");
        }

        customerRepo.findAll().forEach(customer -> {
            sb.append(
                    String.join(
                            ",",
                            customer.getCompany(),
                            customer.getAddress(),
                            customer.getAddress2(),
                            customer.getCity(),
                            customer.getCountry(),
                            customer.getPostcode(),
                            customer.getName(),
                            customer.getLastName(),
                            String.valueOf(customer.getId())
                    )
            );
            sb.append("\n");
        });
        return sb.toString();
    }

    public String allCustomerAsCsvString() {
        return allCustomerAsCsvString(true);
    }

}
