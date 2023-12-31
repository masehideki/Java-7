package com.example.ramenApplication.controller;

import com.example.ramenApplication.controller.request.RamenCreateRequest;
import com.example.ramenApplication.controller.request.RamenUpdateRequest;
import com.example.ramenApplication.controller.response.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;

@RequestMapping("/api/ramen")
@RestController
public class RamenController {

//    ラーメン一覧を取得する（今回はDBがないのでid0~3で返す）
    @GetMapping("/{id}")
    public RamenResponse getRamens(@PathVariable int id) {

        ArrayList<RamenResponse> ramens = new ArrayList<>();

        ramens.add(new RamenResponse("shirunasi", "rekishiwokizame", "jiro", "shimoshinjo", 3));
        ramens.add(new RamenResponse("tanrei", "zagin", "shio", "sumiyoshi", 2));
        ramens.add(new RamenResponse("aka", "hoshishirazu", "toripaitan", "nishinomiya", 3));
        return ramens.get(id);
    }

//    新しいラーメンを追加する（今回はDBがないのでパス変数のidにPostできたらレスポンスを返す）
    @PostMapping("/post/{id}")
    public ResponseEntity<RamenCreateResponse> createRamen(@PathVariable int id, @RequestBody @Validated RamenCreateRequest ramenCreateRequest, BindingResult bindingResult, UriComponentsBuilder uriComponentsBuilder) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(new RamenCreateResponse("A request is not collect"));
        }
        URI uri = uriComponentsBuilder.path("/api/ramen/{id}").buildAndExpand(id).toUri();
        String idString = Integer.toString(id);
        return ResponseEntity.created(uri).body(new RamenCreateResponse("A new ramen is created on id " + idString + " !"));
    }

//    ラーメンを更新する（今回はDBがないのでパス変数のidをPatchできたらラーメン名を含むレスポンスを返す）
    @PatchMapping("/patch/{id}")
    public RamenUpdateResponse updateRamen(@PathVariable int id, @RequestBody RamenUpdateRequest ramenUpdateRequest) {
        String ramenName = ramenUpdateRequest.getRamen();
        String idString = Integer.toString(id);
        return new RamenUpdateResponse("a id " + idString + "(" + ramenName + ") is updated!");
    }

//    ラーメンを削除する（今回はDBがないのでパス変数のidをDeleteできたらレスポンスを返す）
    @DeleteMapping("/delete/{id}")
    public RamenDeleteResponse deleteRamen(@PathVariable int id) {
        String idString = Integer.toString(id);
        return new RamenDeleteResponse("a id " + idString + " is deleted!");
    }

}
