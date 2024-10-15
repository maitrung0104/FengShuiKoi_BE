package com.example.FengShuiKoi.model;


import com.example.FengShuiKoi.entity.Account;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmailDetail {
    Account receiver;
    String subject;
    String link;
}
