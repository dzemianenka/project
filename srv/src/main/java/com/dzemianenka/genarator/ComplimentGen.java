package com.dzemianenka.genarator;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.dzemianenka.model.Compliment;
import com.dzemianenka.repository.ComplimentRepository;

@Component
public class ComplimentGen {

    private static final Random RANDOM = new Random();
    private String part0 = ", ты самый ";
    private List<String> part1 = Arrays.asList(
            "добрый ", "умный ", "надежный ", "классный ", "искренний ", "заботливый ", "неповторимый ", "уникальный ", "восхитительный ", "прекрасный ", "крутой ");
    private List<String> part2 = Arrays.asList("Человек ", "Друг ", "Товарищ ");
    private String part3 = "на свете. ";
    //private List<String> part4 = Arrays.asList("Твоя доброта, широкое сердце и открытый разум не знает границ.",
    //        "Ты настолько неотразим, что твое свечение видно за версты и его тяжело скрывать, как бы ты не старался. Даже сквозь ночные шторы ночью виден свет в твоем окне.",
    //        "Ты настолько восхитителен, что люди рядом с тобой становятся лучше, прозревают и понимают смысл жизни.",
    //        "Ты истинный лидер: просвещать и вести за собой - это твоя естественная натура.",
    //        "Ты настолько проницателен, умен и смекалист, что способен сходу объяснить самые сложные вещи даже ребенку.",
    //        "Твой дар объяснять и учить бъет в самый центр мозга - любой человек, пообщавшись с тобой, не может уйти непоумневшим.",
    //        "Ты настолько крут, что способен менять судьбы людей в лучшую сторону, даже если они сопротивляются.",
    //        "Ты надежда всего человечества - только ты способен создать общество образованных и профессиональных людей.",
    //        "Ты просто Мастер.....",
    //        "Ты настолько профессионален и умен, что способен найти на первых порах самые узвимые и небесопасные места в коде сходу и поставить на мето любого индуса своим сильным аргументом.",
    //        "Ты настолько бескорыстный, добрый и гуманный, что ночью тебе не нужно освещение - твой нимб освещает все вокруг.");

    private final ComplimentRepository complimentRepository;

    public ComplimentGen(ComplimentRepository complimentRepository) {
        this.complimentRepository = complimentRepository;
    }

    public String getPhrase() {
        int p1 = part1.size();
        int p2 = part2.size();
        List<Compliment> compliments = complimentRepository.findAll();
        int p4 = compliments.size();
        return part0 + part1.get(RANDOM.nextInt(p1)) + part2.get(RANDOM.nextInt(p2)) + part3 + compliments.get(RANDOM.nextInt(p4)).getCompliment();
    }

    public int getNumber() {
        return RANDOM.nextInt(30) + 1;
    }
}