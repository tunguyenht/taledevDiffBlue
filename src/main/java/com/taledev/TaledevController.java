package com.taledev;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TaledevController {


    @GetMapping("/taledev")
    public List<Integer> fibonacci(
            @RequestParam(required = false, defaultValue = "0") int start,
            @RequestParam(required = false, defaultValue = "10") int count
    ) {
        List<Integer> sequence = sequenceToNth(start + count);

        return sequence.subList(start, sequence.size());
    }

    private List<Integer> sequenceToNth(int n) {
        if (n < 0) throw new IllegalArgumentException();

        List<Integer> sequence = new ArrayList<>(n);

        int prev = 0, next = 1;
        while (sequence.size() < n) {
            sequence.add(next);
            int sum = prev + next;
            prev = next;
            next = sum;
        }

        return sequence;
    }

}
