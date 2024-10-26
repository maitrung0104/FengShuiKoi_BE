package com.example.FengShuiKoi.service;

import com.nlf.calendar.Lunar;
import com.nlf.calendar.Solar;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CanChiService {

    // Chuyển đổi ngày dương sang lịch âm
    public Lunar convertToLunar(LocalDate date) {
        Solar solar = new Solar(date.getYear(), date.getMonthValue(), date.getDayOfMonth());
        return solar.getLunar();
    }

    // Tính thiên can
    public String getCan(int lunarYear) {
        int canIndex = lunarYear % 10;
        switch (canIndex) {
            case 0: return "Canh";
            case 1: return "Tân";
            case 2: return "Nhâm";
            case 3: return "Quý";
            case 4: return "Giáp";
            case 5: return "Ất";
            case 6: return "Bính";
            case 7: return "Đinh";
            case 8: return "Mậu";
            case 9: return "Kỷ";
            default: return "";
        }
    }

    // Tính địa chi
    public String getChi(int lunarYear) {
        int chiIndex = lunarYear % 12;
        switch (chiIndex) {
            case 0: return "Thân";
            case 1: return "Dậu";
            case 2: return "Tuất";
            case 3: return "Hợi";
            case 4: return "Tý";
            case 5: return "Sửu";
            case 6: return "Dần";
            case 7: return "Mão";
            case 8: return "Thìn";
            case 9: return "Tị";
            case 10: return "Ngọ";
            case 11: return "Mùi";
            default: return "";
        }
    }

    // Tính mệnh từ ngày sinh
    public String calculateMenh(int lunarYear) {
//        Lunar lunar = convertToLunar(dateOfBirth); // Chuyển đổi sang âm lịch
//        int lunarYear = lunar.getYear(); // Lấy năm âm lịch

        String can = getCan(lunarYear);
        String chi = getChi(lunarYear);

        int canValue = getCanValue(can);
        int chiValue = getChiValue(chi);

        int total = canValue + chiValue;

        // Điều chỉnh theo quy tắc
        if (total > 5) {
            total -= 5;
        }

        return getMenh(total); // Trả về mệnh
    }

    // Tính giá trị của Can
    public int getCanValue(String can) {
        switch (can) {
            case "Giáp": case "Ất": return 1;
            case "Bính": case "Đinh": return 2;
            case "Mậu": case "Kỷ": return 3;
            case "Canh": case "Tân": return 4;
            case "Nhâm": case "Quý": return 5;
            default: return 0; // Giá trị không xác định
        }
    }

    // Tính giá trị của Chi
    public int getChiValue(String chi) {
        switch (chi) {
            case "Tý": case "Sửu": case "Ngọ": case "Mùi": return 0;
            case "Dần": case "Mão": case "Thân": case "Dậu": return 1;
            case "Thìn": case "Tị": case "Tuất": case "Hợi": return 2;
            default: return 0; // Giá trị không xác định
        }
    }

    // Lấy tên mệnh
    public String getMenh(int total) {
        switch (total) {
            case 1: return "Kim";
            case 2: return "Thủy";
            case 3: return "Hỏa";
            case 4: return "Thổ";
            case 5: return "Mộc";
            default: return "Không xác định";
        }    }

}