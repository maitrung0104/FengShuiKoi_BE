package com.example.FengShuiKoi.model;

import com.example.FengShuiKoi.entity.Account;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmailDetail {
    Account receiver;
    String subject;
    String title;
    String link;
}
