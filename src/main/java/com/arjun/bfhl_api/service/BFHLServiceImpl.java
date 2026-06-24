package com.arjun.bfhl_api.service;

import com.arjun.bfhl_api.dto.BFHLRequestDTO;
import com.arjun.bfhl_api.dto.BFHLResponseDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BFHLServiceImpl implements BFHLService {

    @Override
    public BFHLResponseDTO processData(BFHLRequestDTO request) {

        List<String> oddNumbers = new ArrayList<>();
        List<String> evenNumbers = new ArrayList<>();
        List<String> alphabets = new ArrayList<>();
        List<String> specialCharacters = new ArrayList<>();

        long sum = 0;

        StringBuilder allLetters = new StringBuilder();

        for (String item : request.getData()) {

            if (item.matches("\\d+")) {

                long num = Long.parseLong(item);

                sum += num;

                if (num % 2 == 0)
                    evenNumbers.add(item);
                else
                    oddNumbers.add(item);

            } else if (item.matches("[a-zA-Z]+")) {

                alphabets.add(item.toUpperCase());

                allLetters.append(item);

            } else {

                specialCharacters.add(item);
            }
        }

        BFHLResponseDTO response = new BFHLResponseDTO();

        response.setIs_success(true);

        response.setUser_id("arjun_vashist_31102004"); // apni DOB daalna
        response.setEmail("arjunavashist@gmail.com");
        response.setRoll_number("2310990048");

        response.setOdd_numbers(oddNumbers);
        response.setEven_numbers(evenNumbers);
        response.setAlphabets(alphabets);
        response.setSpecial_characters(specialCharacters);

        response.setSum(String.valueOf(sum));

        response.setConcat_string(
                generateConcatString(allLetters.toString())
        );

        return response;
    }

    private String generateConcatString(String str) {

        String reversed =
                new StringBuilder(str)
                        .reverse()
                        .toString();

        StringBuilder result =
                new StringBuilder();

        for (int i = 0; i < reversed.length(); i++) {

            char ch = reversed.charAt(i);

            if (i % 2 == 0)
                result.append(Character.toUpperCase(ch));
            else
                result.append(Character.toLowerCase(ch));
        }

        return result.toString();
    }
}