package com.binnavigator.be.Bin;

import com.binnavigator.be.Bin.Data.BinAddRequest;
import com.binnavigator.be.Bin.Data.BinUpdateRequest;
import com.binnavigator.be.Bin.Data.BinDeleteRequest;
import com.binnavigator.be.Bin.Data.GetResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bin")
public class BinController {
    private final BinService binService;

    @PostMapping("/add")
    public void add(@RequestBody BinAddRequest binAddRequest) {
        binService.add(binAddRequest);
    }

    @PostMapping("/delete")
    public ResponseEntity<Boolean> delete(@RequestBody BinDeleteRequest binDeleteRequest) {
        return ResponseEntity.ok(binService.delete(binDeleteRequest));
    }

    @PutMapping("/update")
    public void update(@RequestBody BinUpdateRequest binUpdateRequest) {
        binService.update(binUpdateRequest);
    }

    @PutMapping("/report")
    public void report(@RequestParam long binId) {
        binService.report(binId);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<GetResponse>> getAll() {
        return ResponseEntity.ok(binService.getAll());
    }

    @GetMapping("/get")
    public ResponseEntity<List<GetResponse>> getByUserId(@RequestParam long userId) {
        return ResponseEntity.ok(binService.getByUserId(userId));
    }
}
